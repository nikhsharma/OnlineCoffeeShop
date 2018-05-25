package controllers;

import db.DBHelper;
import models.stock.Coffee;
import models.stock.CoffeeType;

import java.util.List;

public class MainController {

    public static void main(String[] args) {

        Coffee coffee = new Coffee(3.00, 1 ,CoffeeType.CHARRIER, 250);
        Coffee coffee2 = new Coffee(5.00, 1 ,CoffeeType.JAVA, 250);
        DBHelper.save(coffee);
        DBHelper.save(coffee2);
        List<Coffee> savedCoffee = DBHelper.getAll(Coffee.class);
    }
}
