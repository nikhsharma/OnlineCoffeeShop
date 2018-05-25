package controllers;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;

import static spark.Spark.get;

public class MiscController {

    public MiscController() {
        setUpEndPoints();
    }

    private void setUpEndPoints() {

        get("/misc", (req, res) -> {
            HashMap<String, Object> model = new HashMap<>();
            model.put("template", "templates/misc/index.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());
    }
}
