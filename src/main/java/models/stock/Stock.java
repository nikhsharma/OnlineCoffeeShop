package models.stock;


public abstract class Stock {

    private int id;
    private double price;
    private int quanity;
    private Boolean available;

    public Stock() {
    }

    public Stock(double price, int quanity) {
        this.price = price;
        this.quanity = quanity;
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
        return quanity;
    }

    public void setQuanity(int quanity) {
        this.quanity = quanity;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }
}
