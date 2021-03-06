package controllers;

import db.DBHelper;
import models.users.Admin;
import models.users.Customer;
import models.users.User;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.List;

import static spark.Spark.get;
import static spark.Spark.post;

public class LoginController {

    public LoginController() {
        setUpEndPoints();
    }

    private void setUpEndPoints() {

        get("/login", (req, res) -> {
            HashMap<String, Object> model = new HashMap<>();
            model.put("customerClass", Customer.class);
            model.put("adminClass", Admin.class);
            model.put("template", "/templates/login.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());


        post("/login", (req, res) -> {
            String inputtedUsername = req.queryParams("username");
            List<User> users = DBHelper.getAll(User.class);
            for (User user : users) {
                if (user.getUsername().equals(inputtedUsername)) {
                    req.session().attribute("user", user);
                }
            }
            res.redirect("/");
            return null;
        }, new VelocityTemplateEngine());

        get("/logout", (req, res) -> {
            req.session().removeAttribute("user");
            res.redirect("/");
            return null;
        }, new VelocityTemplateEngine());

        post("/sign-up", (req, res) -> {
            String name = req.queryParams("name");
            String userName = req.queryParams("username");
            Customer customer = new Customer(name, userName);
            DBHelper.save(customer);
            req.session().attribute("user", customer);
            res.redirect("/");
            return null;
        });

    }

    public static User getLoggedInUserName(Request req, Response res) {
        User user = req.session().attribute("user");
        if (user == null) {
            res.redirect("/login");
        }
        return user;
    }
}
