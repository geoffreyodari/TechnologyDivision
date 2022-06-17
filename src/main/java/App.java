import models.Staff;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");


        //home page
//        get("/", (request, response) -> {
//
//            return new ModelAndView(new HashMap(), "index.hbs");
//
//        }, new HandlebarsTemplateEngine());

        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("myStaff", request.session().attribute("myStaffList"));
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());


        //departments view
        get("/departments", (request, response) -> {

            return new ModelAndView(new HashMap(), "success.hbs");

        }, new HandlebarsTemplateEngine());

        //save contact
        get("/save", (request, response) -> {

            String name = request.queryParams("name");
            String role = request.queryParams("role");
            String department = request.queryParams("department");
            String division = request.queryParams("division");

            Staff staff = new Staff(name,role,department,division);
            Map<String, ArrayList<Staff>> model = new HashMap<>();
            ArrayList myStaffArrayList = Staff.getAll();

            request.session().attribute("myStaffList",myStaffArrayList);

            model.put("myStaff", request.session().attribute("myStaffList") );
            return new ModelAndView(model, "success.hbs");

        }, new HandlebarsTemplateEngine());


        //form view
        get("/add", (request, response) -> {

            return new ModelAndView(new HashMap(), "form.hbs");

        }, new HandlebarsTemplateEngine());

    }
}
