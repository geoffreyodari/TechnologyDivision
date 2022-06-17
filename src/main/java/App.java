import models.Staff;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");


        //home page
        get("/", (request, response) -> {

            return new ModelAndView(new HashMap(), "index.hbs");

        }, new HandlebarsTemplateEngine());


        //departments view
        get("/departments", (request, response) -> {

            return new ModelAndView(new HashMap(), "departments.hbs");

        }, new HandlebarsTemplateEngine());

        //departments view
        get("/department", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            String name = request.queryParams("name");
            String role = request.queryParams("role");
            model.put("name", name);
            model.put("role", role);
            return new ModelAndView(model, "department.hbs");
        }, new HandlebarsTemplateEngine());

        //form view
        get("/add", (request, response) -> {

            return new ModelAndView(new HashMap(), "form.hbs");

        }, new HandlebarsTemplateEngine());

    }
}
