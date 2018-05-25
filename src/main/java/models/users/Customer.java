package models.users;

import models.basket.Basket;
import models.stock.Misc;
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

    public Basket getBasket() {
        return basket;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }

    public int stockInBasketCount() {
        return this.basket.stockCount();
    }

    public void addToBasket(Stock stock) {
        this.basket.addStock(stock);
    }
}
