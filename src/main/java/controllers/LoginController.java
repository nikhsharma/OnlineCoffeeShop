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
                if (user.getUsername() == inputtedUsername) {
                    req.session().attribute("name", user.getName());
                    req.session().attribute("username", inputtedUsername);
                }
            }
            res.redirect("/");
            return null;
        }, new VelocityTemplateEngine());

        get("/login", (req, res) -> {
            HashMap<String, Object> model = new HashMap<>();
            model.put("template", "/templates/login.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());
    }

    public static String getLoggedInUserName(Request req, Response res) {
        String username = req.session().attribute("username");
        if (username == null || username.isEmpty()) {
            res.redirect("/login");
        }
        return username;
    }
}
