package models;

import java.util.ArrayList;
public class Staff {

    private String staffName;
    private String role;
    private int departmentId;

    private static ArrayList<Staff> mInstances = new ArrayList<>();

    public  Staff(String staffName,String role,int departmentId){
       this.staffName =  staffName;
       this.role = role;
       this.departmentId = departmentId;
       this.mInstances.add(this);

    }

    public static ArrayList<Staff> getAll() {
        return mInstances;
    }


    public String getName(){
        //returns the staff name
        return this.staffName;
    }

    public String getRole(){
        //returns the staff Role
        return this.role;
    }





}
