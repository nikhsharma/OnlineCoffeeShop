package controllers;


import db.DBHelper;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;

import static spark.Spark.get;

public class MainController {

    public static void main(String[] args) {

        MiscController miscController = new MiscController();
        CoffeeController coffeeController = new CoffeeController();
        EquipmentController equipmentController = new EquipmentController();

        get("/", (req, res) -> {
            HashMap<String, Object> model = new HashMap<>();
            model.put("template", "templates/main.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

    }
}
