package controllers;

import db.DBHelper;
import models.basket.Basket;
import models.stock.Stock;
import models.stock.StockType;
import models.users.Customer;

public class Runner {


    public static void main(String[] args) {
        Basket basket1 = new Basket();
        DBHelper.save(basket1);
        Customer customer1 = new Customer("Daniel", "User1", basket1);
        DBHelper.save(customer1);
        customer1.setBasket(basket1);

        Stock stock1 = new Stock ("Coffee",StockType.COFFEE, 10.00, 1);
        Stock stock2 = new Stock ("French Press",StockType.EQUIPMENT, 10.00, 1);
        DBHelper.save(stock1);
        DBHelper.save(stock2);
        basket1.addStock(stock1, 1);
        basket1.addStock(stock2, 1);

    }
}
