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
        Bar bar1 = setupBar();
        Bar bar2 = setupBar();
        assertEquals(2, barDao.getAll().size());
    }

    @Test
    public void findById() {
        Bar bar1 = setupBar();
        Bar bar2 = setupBar();
        assertEquals(bar1, barDao.findById(bar1.getId()));
    }

    @Test
    public void update() {
        Bar bar = setupBar();
        barDao.update(bar.getId(), "C-Bar", "666 SE Grand", "503-666-6666", "free drinks", "11pm-1am");
        Bar foundBar = barDao.findById(bar.getId());
        assertNotEquals("Kelly's Olympian", foundBar.getName());
    }

    @Test
    public void deleteById() {
        Bar bar1 = setupBar();
        Bar bar2 = setupBar();
        barDao.deleteById(bar2.getId());
        assertEquals(1, barDao.getAll().size());
    }

    @Test
    public void clearAll() {
        Bar bar1 = setupBar();
        Bar bar2 = setupBar();
        barDao.clearAll();
        assertEquals(0, barDao.getAll().size());
    }

    //helper model
    public Bar setupBar() {
        Bar bar =  new Bar("Kelly's Olympian", "426 SW Washington St, Portland, OR 97204", "503-228-3669", "$1 off draft beer, well drinks and wine", "4pm-7pm");
        barDao.add(bar);
        return bar;
    }
}