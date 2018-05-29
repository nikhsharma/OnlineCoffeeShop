package models.stock;

import models.users.Customer;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order {
    private int id;
    private Set<Stock> purchases;
    private Customer customer;

    public Order(Customer customer) {
        this.purchases = null;
        this.customer = customer;
    }

    public Order() {
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


    @OneToMany(mappedBy = "order", fetch = FetchType.EAGER)
    public Set<Stock> getPurchases() {
        Set<Stock> copy = new HashSet<>(purchases);
        return copy;
    }

    public String calculateTotal() {
        double total = 0;
        for (Stock item : purchases) {
            total += item.getQuantity() * item.getPrice();
        }
        if (total >= 100.00) {
            total = total * 0.9;
        }
        return String.format("£" + "%.2f", total);
    }


    public void setPurchases(Set<Stock> purchases) {
        this.purchases = purchases;
    }

    @ManyToOne
    @JoinColumn(name = "Customer_id")
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
