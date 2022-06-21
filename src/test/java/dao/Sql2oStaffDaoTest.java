package dao;

import org.junit.*;
import org.sql2o.*;


public class Sql2oStaffDaoTest {
    private Sql2oStaffDao staffDao; //ignore me for now. We'll create this soon.
    private Connection conn; //must be sql2o class conn


    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        staffDao = new Sql2oStaffDao(sql2o); //ignore me for now
        conn = sql2o.open(); //keep connection open through entire test so it does not get erased
    }





    @After
    public void tearDown() throws Exception {
        conn.close();
    }

}
