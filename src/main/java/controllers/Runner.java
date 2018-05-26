package controllers;

import db.DBHelper;
import models.basket.Basket;
import models.stock.Stock;
import models.stock.StockType;
import models.users.Customer;
import models.users.User;

import java.util.List;

public class Runner {


    public static void main(String[] args) {
        Customer customer1 = new Customer("Daniel", "User1");
        DBHelper.save(customer1);

        Stock stock1 = new Stock ("Coffee",StockType.COFFEE, 10.00, 5);
        Stock stock2 = new Stock ("French Press",StockType.EQUIPMENT, 10.00, 5);
        DBHelper.save(stock1);
        DBHelper.save(stock2);
        DBHelper.addStockToBasket(stock1, customer1, 3);
        DBHelper.addStockToBasket(stock2, customer1, 2);

        List<Customer> allCustomers = DBHelper.getAll(Customer.class);
        List<Basket> allBaskets = DBHelper.getAll(Basket.class);
        List<Stock> allStock = DBHelper.getAll(Stock.class);
        List<Stock> allUsers = DBHelper.getAll(User.class);
    }
}
