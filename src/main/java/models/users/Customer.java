package models.users;

import models.basket.Basket;
import models.stock.Stock;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customer")
public class Customer extends User {
    private int id;
    private List<List<Stock>> purchaseHistory;
    private Basket basket;

    public Customer(String name, String username, Basket basket) {
        super(name, username);
        this.id = id;
        this.basket = new Basket();
        this.purchaseHistory = new ArrayList<>();
    }

    public Customer() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public List<List<Stock>> getPurchaseHistory() {
        return purchaseHistory;
    }

    public void setPurchaseHistory(List<List<Stock>> purchaseHistory) {
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
        this.basket.addStock(stock, quantity);
    }

    public void removeFromBasket(Stock stock) {
        this.basket.removeStock(stock);
    }

    public void purchase() {
        this.purchaseHistory.add(this.basket.sell());
    }





}
