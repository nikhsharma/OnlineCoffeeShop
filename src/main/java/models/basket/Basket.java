package models.basket;

import models.stock.Misc;
import models.stock.Stock;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    private int id;
    private List<Stock> stock;

    public Basket() {
        this.stock = new ArrayList<>();
    }
//    Might need for Hibernate
//    public Basket() {
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Stock> getStock() {
        return stock;
    }

    public void setStock(List<Stock> stock) {
        this.stock = stock;
    }

    public int stockCount() {
        return stock.size();
    }

    public void addStock(Stock stock) {
        this.stock.add(stock);
    }

    public void removeStock(Stock stock) {
        this.stock.remove(stock);
    }
}
