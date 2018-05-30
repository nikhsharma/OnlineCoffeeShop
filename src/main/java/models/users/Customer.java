package models.users;

import db.DBCustomer;
import db.DBHelper;
import models.basket.Basket;
import models.stock.Order;
import models.stock.Stock;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "customers")
public class Customer extends User {
    private Set<Order> purchaseHistory;
    private Basket basket;

    public Customer(String name, String username) {
        super(name, username);
        this.basket = new Basket();
        DBHelper.save(basket);
        this.purchaseHistory = new HashSet<>();
    }

    public Customer() {
    }


    @OneToMany(mappedBy = "customer", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    public Set<Order> getPurchaseHistory() {
        return purchaseHistory;
    }

    public void setPurchaseHistory(Set<Order> purchaseHistory) {
        this.purchaseHistory = purchaseHistory;
    }

    @OneToOne(cascade = CascadeType.PERSIST)
    public Basket getBasket() {
        return basket;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }

    public int stockInBasketCount() {
        return this.basket.stockCount();
    }

    public void addToBasket(Stock stock, int quantity) {
        Stock stockToAdd = new Stock(stock.getName(), stock.getDescription(), stock.getType(), stock.getPrice(), quantity, stock.getImage());
        if (stock.getAvailability() == true) {
            stockToAdd.setBasket(this.basket);
            DBHelper.save(stockToAdd);
            this.basket.addStock(stockToAdd);
            stock.setQuantity(stock.getQuantity() - quantity);
        }
    }

    public void removeFromBasket(Stock stock) {
        this.basket.removeStock(stock);
    }

    public void purchase() {
        this.basket.sell(this);
    }

    public void addOrderToPurchaseHistory(Order order) {
        this.purchaseHistory.add(order);
        for (Stock stock : order.getPurchases()) {
            DBHelper.save(stock);
        }
    }
}
