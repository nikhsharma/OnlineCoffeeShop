package models.stock;


public abstract class Stock {

    private int id;
    private double price;
    private int quantity;
    private Boolean available;


    public Stock() {
    }

    public Stock(double price, int quantity) {
        this.price = price;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuanity() {
        return quantity;
    }

    public void setQuanity(int quanity) {
        this.quantity = quanity;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }
}
