package models.users;

import models.basket.Basket;
import models.stock.Stock;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private List<Stock> purchaseHistory;
    private String username;
    private Basket basket;

    public Customer(String username) {
        this.username = username;
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
