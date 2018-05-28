package controllers;

import db.DBHelper;
import models.stock.Stock;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.List;

import static spark.Spark.get;

public class AdminController {

    public AdminController() {
        setUpEndPoints();
    }

    private void setUpEndPoints(){
        get("/stock-management", (req, res) -> {
            List<Stock> stock = DBHelper.getAll(Stock.class);
            HashMap<String, Object> model = new HashMap<>();
            model.put("stock", stock);
            model.put("template", "templates/user/stock-management.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());
    }

}

