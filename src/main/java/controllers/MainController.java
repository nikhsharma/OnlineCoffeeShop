package controllers;


import models.users.Admin;
import models.users.Customer;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;

import static spark.Spark.get;
import static spark.SparkBase.staticFileLocation;

public class MainController {

    public static void main(String[] args) {

        Seeds.seedData();
        staticFileLocation("/public");

        CustomerController userController = new CustomerController();
        LoginController loginController = new LoginController();
        MiscController miscController = new MiscController();
        CoffeeController coffeeController = new CoffeeController();
        EquipmentController equipmentController = new EquipmentController();

        get("/", (req, res) -> {
            HashMap<String, Object> model = new HashMap<>();
            model.put("user", req.session().attribute("user"));
            model.put("customerClass", Customer.class);
            model.put("adminClass", Admin.class);
            model.put("template", "templates/main.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

    }
}
