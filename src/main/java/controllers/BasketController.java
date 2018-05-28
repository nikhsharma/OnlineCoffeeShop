package controllers;

import db.DBCustomer;
import db.DBHelper;
import models.basket.Basket;
import models.users.Customer;
import models.users.User;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;

import static spark.Spark.get;

public class BasketController {

    public BasketController() {
        setUpEndPoints();
    }

    private void setUpEndPoints() {

        get("/basket", (req, res) -> {
            User currentUser = LoginController.getLoggedInUserName(req, res);
            Basket basket = DBCustomer.showCustomersBasket((Customer)currentUser);
            HashMap<String, Object> model = new HashMap<>();
            model.put("basket", basket);
            model.put("template", "templates/basket.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());
    }
}
