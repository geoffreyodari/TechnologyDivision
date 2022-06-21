package dao;

import models.Staff;
import org.junit.jupiter.api.*;
import org.sql2o.*;
import static org.junit.jupiter.api.Assertions.*;


public class Sql2oStaffDaoTest {
    private Sql2oStaffDao staffDao;
    private Connection conn;


    @BeforeEach
    public void setUp(){
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        staffDao = new Sql2oStaffDao(sql2o);
        conn = sql2o.open();

    }

    @AfterEach
    public void tearDown(){
        conn.close();
    }


    @Test
    public void addingStaffSetsId() {
        Staff staff = new Staff("geoffrey","manager","project manager",1);
        int originalStaffId = staff.getId();
        staffDao.add(staff);
        assertNotEquals(originalStaffId,staff.getId());
    }

    @Test
    public void existingStaffCanBeFoundById() throws Exception {
        Staff staff = new Staff("geoffrey","manager","project manager",1);
        staffDao.add(staff); //add to dao (takes care of saving)
        Staff foundStaff = staffDao.findById(staff.getId()); //retrieve
        assertEquals(staff, foundStaff); //should be the same
    }

    @Test
    public void addedStaffCanBeRetrievedByGetAll() throws Exception {
        Staff staff = new Staff("geoffrey","manager","project manager",1);
        staffDao.add(staff); //add to dao (takes care of saving)
        assertEquals(1, staffDao.getAll().size()); //should be the same
    }

    @Test
    public void noStaffReturnsEmptyList() throws Exception {
        assertEquals(0, staffDao.getAll().size());
    }



}
