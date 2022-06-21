package models;

import java.util.ArrayList;
public class Staff {

    private String staffName;
    private String role;
    private String responsibility;

    private int id;
    private int departmentId;

    private static ArrayList<Staff> mInstances = new ArrayList<>();

    public  Staff(String staffName,String role,String responsibility ,int departmentId){
       this.staffName =  staffName;
       this.role = role;
       this.responsibility = responsibility;
       this.departmentId = departmentId;
       this.mInstances.add(this);
       this.id = this.mInstances.size();

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

    public String getResponsibility(){
        //returns the staff responsibility
        return this.responsibility;
    }




}
