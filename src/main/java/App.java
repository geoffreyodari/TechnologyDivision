import models.Staff;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
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

            return new ModelAndView(new HashMap(), "index.hbs");

        }, new HandlebarsTemplateEngine());

        //form view
        get("/add", (request, response) -> {

            return new ModelAndView(new HashMap(), "index.hbs");

        }, new HandlebarsTemplateEngine());

    }
}
