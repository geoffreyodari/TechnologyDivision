package models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class StaffTest {
    @Test
    public void newStaff_instantiatesCorrectly(){
        Staff testStaff = new Staff("james","Quality Analyst","Dev","Technology");
        assertEquals(true, testStaff instanceof Staff);
    }


    @Test
    public void newStaff_getsName() {
        Staff testStaff = new Staff("james","Quality Analyst","Dev","Technology");
        assertEquals("james", testStaff.getName());
    }

    @Test
    public void newStaff_getsRole() {
        Staff testStaff = new Staff("james","Quality Analyst","Dev","Technology");
        assertEquals("Quality Analyst", testStaff.getRole());
    }

    @Test
    public void newStaff_getsDivision() {
        Staff testStaff = new Staff("james","Quality Analyst","Dev","Technology");
        assertEquals("Technology", testStaff.getDivision());
    }




}
