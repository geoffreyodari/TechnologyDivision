package models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class StaffTest {
    @Test
    public void newStaff_instantiatesCorrectly(){
        Staff testStaff = newStaff();
        assertEquals(true, testStaff instanceof Staff);
    }


    @Test
    public void newStaff_getsName() {
        Staff testStaff = newStaff();
        assertEquals("james", testStaff.getName());
    }

    @Test
    public void newStaff_getsRole() {
        Staff testStaff = newStaff();
        assertEquals("Quality Analyst", testStaff.getRole());
    }

    public Staff newStaff(){
        return new Staff("james","Quality Analyst",1);
    }




}
