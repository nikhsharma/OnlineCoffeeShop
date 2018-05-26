package models.users;

import db.DBHelper;
import models.basket.Basket;
import models.stock.Stock;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customers")
public class Customer extends User {
    private ArrayList<ArrayList<Stock>> purchaseHistory;
    private Basket basket;

    public Customer(String name, String username) {
        super(name, username);
        this.basket = new Basket();
        DBHelper.save(basket);
        this.purchaseHistory = new ArrayList<>();
    }

    public Customer() {
    }

    @Column(name = "purchaseHistory")
    public ArrayList<ArrayList<Stock>> getPurchaseHistory() {
        return purchaseHistory;
    }

    public void setPurchaseHistory(ArrayList<ArrayList<Stock>> purchaseHistory) {
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
        Stock stockToAdd = new Stock(stock.getDescription(), stock.getType(), stock.getPrice(), quantity);
        stockToAdd.setBasket(this.basket);
        DBHelper.save(stockToAdd);
        this.basket.addStock(stockToAdd);
        stock.setQuantity(stock.getQuantity() - quantity);
    }

    public void removeFromBasket(Stock stock) {
        this.basket.removeStock(stock);
    }

    public void purchase() {
        this.purchaseHistory.add(this.basket.sell());
    }





}
