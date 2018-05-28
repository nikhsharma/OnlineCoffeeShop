package controllers;

import db.DBHelper;
import models.stock.Stock;
import models.stock.StockType;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.*;

import static spark.Spark.get;
import static spark.Spark.post;

public class AdminController {

    public AdminController() {
        setUpEndPoints();
    }

    private void setUpEndPoints() {
        get("/stock-management", (req, res) -> {
            List<Stock> stock = DBHelper.getAll(Stock.class);
            HashMap<String, Object> model = new HashMap<>();
            model.put("stock", stock);
            model.put("template", "templates/user/stock-management.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());


//    new
        get("stock-management/new", (req, res) -> {
        HashMap<String, Object> model = new HashMap<>();
        StockType arr[] = StockType.values();
        model.put("stockType", arr);
        model.put("template", "templates/user/create.vtl");
        return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

// create
        post("/stock-management",(req, res) -> {
            String description = req.queryParams("description");
            String typeDescription = req.queryParams("type");
            StockType stockType = StockType.valueOf(typeDescription);
            String type = req.queryParams("type");
            double price = Double.parseDouble(req.queryParams("price"));
            int quantity = Integer.parseInt(req.queryParams("quantity"));
            Stock stock = new Stock(description, stockType, price, quantity);
            DBHelper.save(stock);
            res.redirect("/stock-management");
            return null;
        }, new VelocityTemplateEngine());

        get("/stock-management/:id/edit", (req, res) -> {
        String strId = req.params(":id");
        Integer intId = Integer.parseInt(strId);
        Stock stock = DBHelper.find(Stock.class, intId);
        HashMap<String, Object> model = new HashMap<>();
        StockType arr[] = StockType.values();
        model.put("stockType", arr);
        model.put("stock", stock);
        model.put("template", "templates/user/update.vtl");
        return  new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        post("/stock-management/:id/edit", (req, res) -> {
            String strId = req.params(":id");
            Integer intId = Integer.parseInt(strId);
            Stock stock = DBHelper.find(Stock.class, intId);
            String description = req.queryParams("description");
            String typeDescription = req.queryParams("type");
            StockType stockType = StockType.valueOf(typeDescription);
            String type = req.queryParams("type");
            double price = Double.parseDouble(req.queryParams("price"));
            int quantity = Integer.parseInt(req.queryParams("quantity"));
            stock.setDescription(description);
            stock.setType(stockType);
            stock.setPrice(price);
            stock.setQuantity(quantity);
            DBHelper.save(stock);
            res.redirect("/stock-management");
            return null;
        }, new VelocityTemplateEngine());


        post("stock-management/:id/delete", (req, res) -> {
            int id = Integer.parseInt(req.params("id"));
            Stock stock = DBHelper.find(Stock.class, id);
            DBHelper.delete(stock);
            res.redirect("/stock-management");
            return null;
        }, new VelocityTemplateEngine());
//        create functions above this line
    }

}

