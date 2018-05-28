package controllers;

import db.DBHelper;
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

        post("/login", (req, res) -> {
            String inputtedUsername = req.queryParams("username");
            List<User> users = DBHelper.getAll(User.class);
            for (User user : users) {
                if (user.getUsername().equals(inputtedUsername)) {
                    req.session().attribute("user", user);
                    res.redirect("/");
//                    req.session().attribute("username", inputtedUsername);
                }
            }
            res.redirect("/account");
            return null;
        }, new VelocityTemplateEngine());

        get("/login", (req, res) -> {
//            List<User> users = DBHelper.getAll(User.class);
            HashMap<String, Object> model = new HashMap<>();
//            model.put("users", users);
            model.put("template", "/templates/login.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());
    }

    public static User getLoggedInUserName(Request req, Response res) {
        User user = req.session().attribute("user");
//        String name = req.session().attribute("name");
//        List<User> users = DBHelper.getAll(User.class);
//        for (User user : users) {
//            if (user.getUsername().equals(username)) {
//
//            }
//        }
        if (user == null) {
            res.redirect("/login");
        }
        return user;
    }
}
