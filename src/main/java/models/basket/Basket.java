package models.basket;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.sun.tools.javah.Gen;
import db.DBHelper;
import models.stock.Order;
import models.stock.Stock;

import models.users.Customer;
import org.hibernate.Hibernate;
import org.hibernate.annotations.Tables;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="baskets")
public class Basket {

    private int id;
    private Set<Stock> stock;
    private Customer customer;
    private double total;

    public Basket() {
        this.total = 0;
        this.stock = new HashSet<>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name="total")
    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @OneToMany(mappedBy = "basket", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    public Set<Stock> getStock() {
        return stock;
    }

    public void setStock(Set<Stock> stock) {
        this.stock = stock;
    }

    public int stockCount() {
        return stock.size();
    }

    public void addStock(Stock stock) {
        this.stock.add(stock);
        calculateTotal();
    }

    public void removeStock(Stock originalStock) {
        int quantity = 0;
        ArrayList<Stock> copiedStock = new ArrayList<>(stock);
        for (Stock item : copiedStock) {
            if (originalStock.getDescription().equals(item.getDescription())){
                quantity =  item.getQuantity();
                item.setBasket(null);
                DBHelper.save(item);
                stock.remove(item);
            }
        }
        originalStock.setQuantity(originalStock.getQuantity() + quantity);
        DBHelper.save(originalStock);
        calculateTotal();
    }

    public void sell(Customer customer) {
        Set<Stock> copy = new HashSet<>(stock);
        Order newOrder = new Order(customer);


        this.stock.clear();

        for (Stock item : copy) {
            item.setBasket(null);
            item.setOrder(newOrder);
        }

        newOrder.setPurchases(copy);
        DBHelper.save(newOrder);
        customer.addOrderToPurchaseHistory(newOrder);
    }

    @OneToOne(mappedBy = "basket", cascade = CascadeType.PERSIST )
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public double calculateTotal() {
        setTotal(0);
        for (Stock item : stock) {
            total = (item.getPrice() * item.getQuantity()) + this.total;
        }
        setTotal(total);
        applyTenPercentDiscount();
        DBHelper.save(this);
        return getTotal();
    }

    public boolean checkIfDiscountOnTotalCanBeOffered() {
        if (this.total >= 100.00) {
            return true;
        }
        return false;
    }

    public void applyTenPercentDiscount() {
        if (checkIfDiscountOnTotalCanBeOffered()) {
            total = total * 0.9;
        }
    }

    public void applyBuyOneGetOneFree(Stock stock) {
        for (Stock item : this.stock) {
            if (item.getQuantity() % 2 == 0) {
                total = item.getPrice() / 2;
            }
        }

    }
}
