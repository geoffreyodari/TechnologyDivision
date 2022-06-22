import dao.Sql2oStaffDao;
import models.Departments;
import models.Staff;
import org.sql2o.Sql2o;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.*;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");
        String connectionString = "jdbc:h2:~/departments.db;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        Sql2oStaffDao staffDao = new Sql2oStaffDao(sql2o);

        //get: show all tasks in all categories and show all categories
        get("/", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Staff> staff = staffDao.getAll();
            model.put("myStaff", staff);
            return new ModelAndView(model, "read-staff.hbs");
        }, new HandlebarsTemplateEngine());

        //get: show a form to create a new category
        //  /categories/new
        get("/categories/new",(req,res)->{
            return new ModelAndView(new HashMap<>(),"create-department-form.hbs");
        },new HandlebarsTemplateEngine());

    }
}
