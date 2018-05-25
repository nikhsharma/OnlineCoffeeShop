package controllers;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;

import static spark.Spark.get;

public class EquipmentController {

    public EquipmentController() {
        setUpEndPoints();
    }

    private void setUpEndPoints() {

        get("/equipment", (req, res) -> {
            HashMap<String, Object> model = new HashMap<>();
            model.put("template", "templates/equipment/index.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());
    }
}
