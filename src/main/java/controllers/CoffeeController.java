package controllers;

import db.DBHelper;
import models.stock.Stock;
import models.stock.StockType;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static spark.Spark.get;

public class CoffeeController {

    public CoffeeController() {
        setUpEndPoints();
    }

    private void setUpEndPoints() {
        get("/coffee", (req, res) -> {
            HashMap<String, Object> model = new HashMap<>();
            List<Stock> allStock = DBHelper.getAll(Stock.class);
            List<Stock> coffee = new ArrayList<>();
            for (Stock item : allStock) {
                if (item.getType() == StockType.COFFEE) {
                    coffee.add(item);
                }
            }
            model.put("coffee", coffee);
            model.put("template", "templates/coffee/index.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());
    }

}
