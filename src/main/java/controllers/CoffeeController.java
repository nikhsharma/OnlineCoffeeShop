package controllers;

import db.DBHelper;
import models.stock.Stock;
import models.stock.StockType;
import models.users.Admin;
import models.users.Customer;
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
                if ((item.getType() == StockType.COFFEE) && (item.getBasket() == null) && (item.getOrder() == null)) {
                    coffee.add(item);
                }
            }
            model.put("coffee", coffee);
            model.put("user", req.session().attribute("user"));
            model.put("customerClass", Customer.class);
            model.put("adminClass", Admin.class);
            model.put("template", "templates/coffee/index.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        get("/coffee/:id", (req, res) -> {
            int id = Integer.parseInt(req.params("id"));
            Stock item = DBHelper.find(Stock.class, id);
            HashMap<String, Object> model = new HashMap<>();
            model.put("user", req.session().attribute("user"));
            model.put("item", item);
            model.put("customerClass", Customer.class);
            model.put("adminClass", Admin.class);
            model.put("template", "templates/show.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());
    }

}
