package models;

import java.util.ArrayList;

public class Departments {
    private String name;
    private static ArrayList<Departments> mInstances = new ArrayList<>();

    public Departments(String name){
        this.name = name;
        this.mInstances.add(this);
    }

    public static ArrayList<Departments> getAll(){
        return mInstances;
    }

    public String getName(){
        return this.name;
    }


}
