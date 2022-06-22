import dao.Sql2oDepartmentsDao;
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
        Sql2oDepartmentsDao departmentsDao = new Sql2oDepartmentsDao(sql2o);

        //get: show all staff in all departments and show all departments
        get("/", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Staff> staff = staffDao.getAll();
            List<Departments> departments = departmentsDao.getAll();
            model.put("myStaff", staff);
            model.put("myDepartments",departments);
            return new ModelAndView(model, "read-staff.hbs");
        }, new HandlebarsTemplateEngine());

        //get: show a form to create a new department
        //  /departments/new
        get("/departments/new",(req,res)->{
            return new ModelAndView(new HashMap<>(),"create-department-form.hbs");
        },new HandlebarsTemplateEngine());

        //post: process a form to create a new department
        //  /departments
        post("/departments",(req, res) -> {
            String name = req.queryParams("name");
            System.out.println(name);
            Departments newDepartment = new Departments(name);
            departmentsDao.add(newDepartment);
            return new ModelAndView(new HashMap<>(),"create-department-success.hbs");
        },new HandlebarsTemplateEngine());

        //get: get all departments
        get("/departments",(req,res)->{
            Map <String,Object> model = new HashMap<String,Object>();
            List<Departments> departments = departmentsDao.getAll();
            model.put("myDepartments",departments);
            return new ModelAndView(model,"read-departments.hbs");
        },new HandlebarsTemplateEngine());

        //get: update department form
        get("/departments/update",(req,res)->{
            int myId = Integer.parseInt(req.queryParams("id"));
            System.out.println(myId);
            Map <String,Object> model = new HashMap<String,Object>();
            model.put("myDepartment",departmentsDao.findById(myId));
            return new ModelAndView(model,"edit-department-form.hbs");
        },new HandlebarsTemplateEngine());

        //post: update department
        post("/departments/save",(req,res)->{
            int departmentId = Integer.parseInt(req.queryParams("id"));
            String departmentName = req.queryParams("name");
            departmentsDao.update(departmentId,departmentName);
            res.redirect("/departments");
            return null;
        },new HandlebarsTemplateEngine());

        //get: delete department
        get("/departments/delete",(req,res)->{
            int departmentId = Integer.parseInt(req.queryParams("id"));
            departmentsDao.deleteById(departmentId);
            res.redirect("/departments");
            return null;
        },new HandlebarsTemplateEngine());

        //get: add new staff form
        get("/staff/new",(req,res)->{
            Map<String, Object> model = new HashMap<>();
            List<Departments> departments = departmentsDao.getAll();
            model.put("myDepartments",departments);
            return new ModelAndView(model,"create-staff-form.hbs");
        },new HandlebarsTemplateEngine());

        //post: add new staff
        post("/staff/new",(req,res)->{
            String name = req.queryParams("name");
            String role = req.queryParams("role");
            int departmentId = Integer.parseInt(req.queryParams("department"));
            String responsibility = req.queryParams("responsibility");
            System.out.println(responsibility);
            Staff staff = new Staff(name,role,responsibility,departmentId);
            staffDao.add(staff);
            res.redirect("/");
            return null;
        },new HandlebarsTemplateEngine());

        //get: update staff form
        get("/staff/update",(req,resp)->{
            int id = Integer.parseInt(req.queryParams("id"));
            Map<String,Object> model = new HashMap<String,Object>();
            model.put("myStaff",staffDao.findById(id));
            model.put("myDepartments",departmentsDao.getAll());
            return new ModelAndView(model,"edit-staff-form.hbs");
        },new HandlebarsTemplateEngine());





    }
}
