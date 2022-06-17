package models;

import java.util.ArrayList;
public class Staff {

    private String staffName;
    private String role;
    private String department;
    private String division;
    private static ArrayList<Staff> mInstances = new ArrayList<>();

    public  Staff(String staffName,String role, String department,String division){
       this.staffName =  staffName;
       this.role = role;
       this.department = department;
       this.division = division;
       this.mInstances.add(this);
    }

    public static ArrayList<Staff> getAll() {
        return mInstances;
    }

    public boolean notEmpty(){
        return mInstances.size() >0;
    }


    public String getName(){
        //returns the staff name
        return this.staffName;
    }

    public String getRole(){
        //returns the staff Role
        return this.role;
    }

    public String getDepartment(){
        //returns the staff Department
        return this.department;
    }

    public String getDivision(){
        //returns the staff Division
        return this.division;
    }



}
