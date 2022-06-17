import models.Staff;

import java.util.Scanner;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");

        //get("/",(request,response)->"hello");

        //Staff staff = new Staff(name,role,department,division);


    }
}
