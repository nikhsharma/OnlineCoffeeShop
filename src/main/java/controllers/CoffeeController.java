package controllers;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;

import static spark.Spark.get;

public class CoffeeController {

    public CoffeeController() {
        setUpEndPoints();
    }

    private void setUpEndPoints() {
        get("/coffee", (req, res) -> {
            HashMap<String, Object> model = new HashMap<>();
            model.put("template", "templates/coffee/index.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());
    }

}
