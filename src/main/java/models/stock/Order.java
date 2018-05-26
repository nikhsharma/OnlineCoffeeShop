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

    public Order(Set<Stock> purchases) {
        this.purchases = purchases;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public HashSet<Stock> getPurchases() {
        HashSet<Stock> copy = new HashSet<>(purchases);
        return copy;
    }

    public void setPurchases(Set<Stock> purchases) {
        this.purchases = purchases;
    }

    @ManyToOne
    @JoinColumn(name = "Customer_id", nullable = false)
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
