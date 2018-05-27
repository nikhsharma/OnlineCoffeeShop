package controllers;


import db.DBHelper;
import models.users.User;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.List;

import static spark.Spark.get;
import static spark.SparkBase.staticFileLocation;

public class MainController {

    public static void main(String[] args) {

        Seeds.seedData();
        staticFileLocation("/public");

        LoginController loginController = new LoginController();
        MiscController miscController = new MiscController();
        CoffeeController coffeeController = new CoffeeController();
        EquipmentController equipmentController = new EquipmentController();

        get("/", (req, res) -> {
            HashMap<String, Object> model = new HashMap<>();
            List<User> users = DBHelper.getAll(User.class);
            model.put("template", "templates/main.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

    }
}
