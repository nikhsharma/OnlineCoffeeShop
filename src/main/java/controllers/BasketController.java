package controllers;

import db.DBBasket;
import db.DBCustomer;
import db.DBHelper;
import models.basket.Basket;
import models.stock.Stock;
import models.users.Admin;
import models.users.Customer;
import models.users.User;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;

import static spark.Spark.get;
import static spark.Spark.post;

public class BasketController {

    public BasketController() {
        setUpEndPoints();
    }

    private void setUpEndPoints() {

        get("/basket", (req, res) -> {
            Customer currentUser = req.session().attribute("user");
            LoginController.getLoggedInUserName(req, res);
            Basket basket = DBCustomer.showCustomersBasket(currentUser);
            HashMap<String, Object> model = new HashMap<>();
            model.put("user", req.session().attribute("user"));
            model.put("customerClass", Customer.class);
            model.put("adminClass", Admin.class);
            model.put("basket", basket);
            model.put("discountedPrettyPrice", String.format("£" + "%.2f", basket.getDiscountedTotal()));
            model.put("prettyPrice", String.format("£" + "%.2f", basket.calculateTotal()));
            model.put("template", "templates/basket.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());



        post("/basket/remove/:id", (req, res) -> {
            int id = Integer.parseInt(req.params("id"));
            Stock item = DBHelper.find(Stock.class, id);
            Stock itemToRemove = DBBasket.findStockToRemove(item);
            Customer currentUser = req.session().attribute("user");
            Basket basket = DBCustomer.showCustomersBasket(currentUser);
//            currentUser.removeFromBasket(item);
            DBHelper.removeStockFromBasket(itemToRemove, currentUser);
            DBHelper.save(currentUser);
            DBHelper.save(itemToRemove);
            DBHelper.delete(item);
            basket.calculateTotal();
            DBHelper.save(basket);
            res.redirect("/basket");
            return null;
        });

        post("/basket/purchase", (req, res) -> {
            Customer currentUser = req.session().attribute("user");
            currentUser.purchase();
            res.redirect("/account");
            return null;
        });

        post("/basket/:id", (req, res) -> {
            int id = Integer.parseInt(req.params("id"));
            int quantity = Integer.parseInt(req.queryParams("quantity"));
            Stock item = DBHelper.find(Stock.class, id);
            Customer customer = (Customer)LoginController.getLoggedInUserName(req, res);
            DBHelper.addStockToBasket(item, customer, quantity);
            res.redirect("/basket");
            return null;
        });

    }
}
