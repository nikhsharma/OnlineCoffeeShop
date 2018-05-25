package controllers;

import db.DBHelper;
import models.stock.Coffee;
import models.stock.CoffeeType;

public class MainController {

    public static void main(String[] args) {

        Coffee coffee = new Coffee(CoffeeType.CHARRIER, 250);
        DBHelper.save(coffee);
    }
}
