package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DepartmentsTest {
    @Test
    public void newDepartment_instantiatesCorrectly(){
        Departments testDepartment = new Departments("Testing");
        assertEquals(true,testDepartment instanceof  Departments);
    }

    @Test
    public void department_getsName(){
        Departments myDepartment = new Departments("finance");
        assertEquals("finance",myDepartment.getName());

    }

}
