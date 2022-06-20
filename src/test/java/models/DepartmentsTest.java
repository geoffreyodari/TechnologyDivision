package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DepartmentsTest {
    @Test
    public void newDepartment_instantiatesCorrectly(){
        Departments testDepartment = newDepartment();
        assertEquals(true,testDepartment instanceof  Departments);
    }

    @Test
    public void department_getsName(){
        Departments myDepartment = newDepartment();
        assertEquals("finance",myDepartment.getName());

    }

    @Test
    public void department_getsId(){
        Departments myDepartment = newDepartment();
        assertEquals(3,myDepartment.getId());

    }


    public Departments newDepartment(){
        return new Departments("finance");
    }


}
