package dao;

import models.Departments;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.jupiter.api.Assertions.*;

public class Sql2oDepartmentsDaoTest {
    private Sql2oDepartmentsDao departmentsDao;
    private Connection conn;

    @BeforeEach
    public void setUp(){
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        departmentsDao = new Sql2oDepartmentsDao(sql2o);
        conn = sql2o.open();
    }

    @AfterEach
    public void tearDown(){
        conn.close();
    }


    @Test
    public void addingDepartmentsSetsId() {
        Departments departments = new Departments("Finance");
        int originalDepartmentsId = departments.getId();
        departmentsDao.add(departments);
        assertNotEquals(originalDepartmentsId,departments.getId());
    }


    @Test
    public void existingDepartmentsCanBeFoundById() throws Exception {
        Departments departments = new Departments("Finance");
        departmentsDao.add(departments); //add to dao (takes care of saving)
        Departments foundDepartments = departmentsDao.findById(departments.getId()); //retrieve
        assertEquals(departments, foundDepartments); //should be the same
    }

    @Test
    public void addedDepartmentsCanBeRetrievedByGetAll() throws Exception {
        Departments departments = new Departments("Finance");
        departmentsDao.add(departments); //add to dao (takes care of saving)
        assertEquals(1, departmentsDao.getAll().size()); //should be the same
    }

    @Test
    public void noDepartmentsReturnsEmptyList() throws Exception {
        assertEquals(0, departmentsDao.getAll().size());
    }


    @Test
    public void updateChangesDepartmentTitle() throws Exception {
        String dept = "Accounting";
        Departments departments = new Departments(dept);
        departmentsDao.add(departments);

        departmentsDao.update(departments.getId(),"Audit");
        Departments updatedDepartments= departmentsDao.findById(departments.getId()); //why do I need to refind this?
        assertNotEquals(dept, updatedDepartments.getName());
    }

    @Test
    public void deleteByIdDeletesCorrectDepartment() throws Exception {
        Departments departments = new Departments("Finance");
        departmentsDao.add(departments);
        departmentsDao.deleteById(departments.getId());
        assertEquals(0, departmentsDao.getAll().size());
    }

    @Test
    public void deleteAllClearsAll() throws Exception {
        Departments departments = new Departments("Accounting");
        Departments otherDepartments= new Departments("Finance");
        departmentsDao.add(departments);
        departmentsDao.add(otherDepartments);
        int daoSize = departmentsDao.getAll().size();
        departmentsDao.deleteAllDepartments();
        assertTrue(daoSize > 0 && daoSize > departmentsDao.getAll().size());
    }
}
