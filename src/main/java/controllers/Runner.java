package controllers;

import com.sun.tools.corba.se.idl.constExpr.Or;
import db.DBBasket;
import db.DBCustomer;
import db.DBHelper;
import db.DBOrder;
import models.basket.Basket;
import models.stock.Order;
import models.stock.Stock;
import models.stock.StockType;
import models.users.Admin;
import models.users.Customer;
import models.users.User;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Runner {


    public static void main(String[] args) {
        Customer customer1 = new Customer("Daniel", "User1");
        DBHelper.save(customer1);

        Admin admin1 = new Admin("bob", "808");
        DBHelper.save(admin1);

        Stock stock1 = new Stock("Java", "Coffee", StockType.COFFEE, 10.00, 5);
        Stock stock2 = new Stock("Stiff", "French Press", StockType.EQUIPMENT, 10.00, 5);
        DBHelper.save(stock1);
        DBHelper.save(stock2);



        List<Basket> allBaskets = DBHelper.getAll(Basket.class);
        List<Stock> allStock = DBHelper.getAll(Stock.class);
        List<User> allUsers = DBHelper.getAll(User.class);

        DBHelper.addStockToBasket(stock1, customer1, 2);
        DBHelper.addStockToBasket(stock2, customer1, 3);


        Basket foundBasket = DBHelper.find(Basket.class, customer1.getBasket().getId());
        List<Basket> allBaskets2 = DBHelper.getAll(Basket.class);
        List<Stock> basketContents = DBBasket.showStock(foundBasket);
        List<Stock> allStock2 = DBHelper.getAll(Stock.class);
        List<User> allUsers2 = DBHelper.getAll(User.class);


        customer1.purchase();
        DBHelper.save(customer1);


        List<Basket> allBaskets3 = DBHelper.getAll(Basket.class);
        List<Stock> basketContents2 = DBBasket.showStock(foundBasket);
        List<Stock> allStock3 = DBHelper.getAll(Stock.class);
        List<User> allUsers3 = DBHelper.getAll(User.class);
        List<Order> custOrders = DBCustomer.showPurchaseHistory(customer1);
        List<Stock> itemsInOrder = DBOrder.showItemsInOrder(custOrders.get(0));
        Set<Order> localcustpurchasehistory = customer1.getPurchaseHistory();

        DBHelper.addStockToBasket(stock1, customer1, 2);
        DBHelper.addStockToBasket(stock2, customer1, 2);
        customer1.removeFromBasket(stock1);
        customer1.purchase();
        DBHelper.save(customer1);



        List<Basket> allBaskets4 = DBHelper.getAll(Basket.class);
        List<Stock> basketContents4 = DBBasket.showStock(foundBasket);
        List<Stock> allStock4 = DBHelper.getAll(Stock.class);
        List<User> allUsers4 = DBHelper.getAll(User.class);
        List<Order> custOrder4 = DBCustomer.showPurchaseHistory(customer1);
        List<Stock> itemsInOrde4 = DBOrder.showItemsInOrder(DBHelper.find(Order.class, 2));
        Set<Order> localcustpurchasehistor4 = customer1.getPurchaseHistory();
        foundBasket.calculateTotal();

    }
}
