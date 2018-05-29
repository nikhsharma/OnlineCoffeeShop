package controllers;

import db.DBHelper;
import models.stock.Stock;
import models.stock.StockType;
import models.users.Admin;
import models.users.Customer;

public class Seeds {

    public static void seedData(){
        Customer customer1 = new Customer("Daniel", "User1");
        DBHelper.save(customer1);

        Admin admin1 = new Admin("Bob", "808");
        DBHelper.save(admin1);

        Stock stock1 = new Stock("java", "Java beans", StockType.COFFEE, 10.00, 5, "image");
        DBHelper.save(stock1);

        Stock stock2 = new Stock("stiff", "French Press", StockType.EQUIPMENT, 15.00, 4, "image");
        DBHelper.save(stock2);

        Stock stock3 = new Stock("mug", "Mug", StockType.MISC, 5.00, 8, "image");
        DBHelper.save(stock3);
    }
}
