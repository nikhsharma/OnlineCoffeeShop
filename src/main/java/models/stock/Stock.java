package models.stock;


import models.basket.Basket;

import javax.persistence.*;

@Entity
@Table(name="stock")
public class Stock {

    private int id;
    private String description;
    private StockType type;
    private double price;
    private int quantity;
    private Boolean available;
    private Basket basket;


    public Stock() {
    }

    public Stock(String description, StockType type, double price, int quantity) {
        this.description = description;
        this.type = type;
        this.price = price;
        this.quantity = quantity;
        this.basket = new Basket();

    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public StockType getType() {
        return type;
    }

    public void setType(StockType type) {
        this.type = type;
    }

    @Column(name="price")
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
//    @ManyToMany(cascade = CascadeType.PERSIST)
//    @JoinTable(name = "basket_stock",
//            inverseJoinColumns = {@JoinColumn(name = "stock_id", nullable = false, updatable = false)},
//            joinColumns = {@JoinColumn(name = "basket_id", nullable = false, updatable = false)})
    @ManyToOne
    @JoinColumn(name="basket_id", nullable = true)
    public Basket getBasket() {
        return basket;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }
}
