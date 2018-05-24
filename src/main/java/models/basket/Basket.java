package models.basket;

import models.stock.Stock;

import java.util.List;

public class Basket {
    private int id;
    private List<Stock> stock;

    public Basket() {
    }

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
}
