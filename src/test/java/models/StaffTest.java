package models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class StaffTest {
    @Test
    public void newStaff_instantiatesCorrectly(){
        Staff testStaff = new Staff();
        assertEquals(true, testStaff instanceof Staff);
    }


}
