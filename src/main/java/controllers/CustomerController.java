package controllers;

import models.stock.Order;
import models.users.Admin;
import models.users.Customer;
import models.users.User;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

import static spark.Spark.get;

public class CustomerController {

    public CustomerController() {
        setUpEndPoints();
    }

    private void setUpEndPoints(){
        get("/account", (req, res) -> {
            HashMap<String, Object> model = new HashMap<>();
            LoginController.getLoggedInUserName(req, res);
            Customer loggedInUser = req.session().attribute("user");
            Set<Order> purchaseHistory = loggedInUser.getPurchaseHistory();
            model.put("user", loggedInUser);
            model.put("purchaseHistory", purchaseHistory);
            model.put("customerClass", Customer.class);
            model.put("adminClass", Admin.class);
            model.put("template", "templates/user/account.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());
    }
}
