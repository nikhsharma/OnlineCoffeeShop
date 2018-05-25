package models.users;

import models.basket.Basket;
import models.stock.Stock;

import java.util.ArrayList;
import java.util.List;

public class Customer extends User {
    private List<Stock> purchaseHistory;
    private Basket basket;

    public Customer(String name, String username) {
        super(name, username);
        this.basket = new Basket();
        this.purchaseHistory = new ArrayList<>();
    }

    public Customer() {
    }

    public List<Stock> getPurchaseHistory() {
        return purchaseHistory;
    }

    public void setPurchaseHistory(List<Stock> purchaseHistory) {
        this.purchaseHistory = purchaseHistory;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Basket getBasket() {
        return basket;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }
}
