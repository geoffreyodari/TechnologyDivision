import models.Staff;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner inputString = new Scanner(System.in);
        System.out.println("Please Enter Name");
        String  name = inputString.next();
        System.out.println("Please Enter Role");
        String  role = inputString.next();
        System.out.println("Please Enter Department");
        String  department = inputString.next();
        System.out.println("Please Enter Division");
        String  division = inputString.next();

        Staff staff = new Staff(name,role,department,division);

        System.out.println("Your name is "+ staff.getName()+"\n");
    }
}
