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

public class MiscController {

    public MiscController() {
        setUpEndPoints();
    }

    private void setUpEndPoints() {

        get("/misc", (req, res) -> {
            HashMap<String, Object> model = new HashMap<>();
            List<Stock> allStock = DBHelper.getAll(Stock.class);
            List<Stock> misc = new ArrayList<>();
            for (Stock item : allStock) {
                if (item.getType() == StockType.MISC) {
                    misc.add(item);
                }
            }
            model.put("misc", misc);
            model.put("template", "templates/misc/index.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        get("/misc/:id", (req, res) -> {
            int id = Integer.parseInt(req.params("id"));
            Stock item = DBHelper.find(Stock.class, id);
            HashMap<String, Object> model = new HashMap<>();
            model.put("item", item);
            model.put("template", "templates/misc/show.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());
    }
}
