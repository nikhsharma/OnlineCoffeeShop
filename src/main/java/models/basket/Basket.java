package models.basket;

import com.sun.org.apache.bcel.internal.generic.NEW;
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

    public void addStock(Stock stock, int quantity) {
        this.stock.add(new Stock(stock.getDescription(), stock.getType(), stock.getPrice(), quantity));
        stock.setQuantity(stock.getQuantity() - quantity);
    }

    public void removeStock(Stock originalStock) {
        int quantity = 0;
        ArrayList<Stock> copiedStock = new ArrayList<>(stock);
        for (Stock item : copiedStock) {
            if (originalStock.getDescription() == item.getDescription()) {
                quantity =  item.getQuantity();
                stock.remove(item);
            }
        }
        originalStock.setQuantity(originalStock.getQuantity() + quantity);
    }

    public List<Stock> sell() {
        List<Stock> copy = new ArrayList<>(stock);
        this.stock.clear();
        return copy;
    }
}
