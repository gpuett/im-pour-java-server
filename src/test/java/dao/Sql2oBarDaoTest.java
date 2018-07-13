package dao;

import models.Bar;
import org.junit.*;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.Assert.*;

public class Sql2oBarDaoTest {
    private static Connection conn;
    private static Sql2oBarDao barDao;

    @BeforeClass
    public static void setUp() throws Exception {
        String connectionString = "jdbc:postgresql://localhost:5432/pour_bar_test";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        barDao = new Sql2oBarDao(sql2o);
        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("clearing database");
        barDao.clearAll();
    }

    @AfterClass
    public static void shutDown() throws Exception {
        conn.close();
        System.out.println("connection closed");
    }

    @Test
    public void add() {
        Bar bar = setupBar();
        assertEquals(1, barDao.getAll().size());
    }

    @Test
    public void getAll() {
    }

    @Test
    public void findById() {
    }

    @Test
    public void update() {
    }

    @Test
    public void deleteById() {
    }

    @Test
    public void clearAll() {
    }

    //helper model
    public Bar setupBar() {
        Bar bar =  new Bar("Kelly's Olympian", "426 SW Washington St, Portland, OR 97204", "503-228-3669", "$1 off draft beer, well drinks and wine", "4pm-7pm");
        barDao.add(bar);
        return bar;
    }
}