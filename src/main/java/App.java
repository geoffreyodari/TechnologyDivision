import models.Departments;
import models.Staff;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");


        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("myStaff", request.session().attribute("myStaffList"));
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());


        //departments view
        get("/add_department", (request, response) -> {
            return new ModelAndView(new HashMap(), "departmentForm.hbs");
        }, new HandlebarsTemplateEngine());

        //staff view
        get("/add_staff", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("myDepartments", request.session().attribute("myDepartments"));
            return new ModelAndView(model, "form.hbs");
        }, new HandlebarsTemplateEngine());


        //departments view
        get("/departments", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("myDepartments", request.session().attribute("myDepartments"));
            return new ModelAndView(model, "departments.hbs");
        }, new HandlebarsTemplateEngine());




        //save staff
        get("/save_staff", (request, response) -> {
            String name = request.queryParams("name");
            String role = request.queryParams("role");
            int categoryId = Integer.parseInt(request.queryParams("id"));

            Staff staff = new Staff(name,role,categoryId);
            Map<String, ArrayList<Staff>> model = new HashMap<>();
            ArrayList myStaffArrayList = Staff.getAll();
            request.session().attribute("myStaffList",myStaffArrayList);
            model.put("myStaff", request.session().attribute("myStaffList") );
            return new ModelAndView(model, "success.hbs");

        }, new HandlebarsTemplateEngine());


        //form view
        get("/save_department", (request, response) -> {
            String name = request.queryParams("name");
            Departments departments = new Departments(name);
            Map<String, ArrayList<Departments>> model = new HashMap<>();
            ArrayList myDepartmentsArrayList = departments.getAll();
            request.session().attribute("myDepartments",myDepartmentsArrayList);
            model.put("myDepartments", request.session().attribute("myDepartments") );
            return new ModelAndView(model, "departments.hbs");
        }, new HandlebarsTemplateEngine());

    }
}
