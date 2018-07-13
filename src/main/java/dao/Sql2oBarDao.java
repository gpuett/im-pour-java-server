package dao;

import models.Bar;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oBarDao implements BarDao {
    private final Sql2o sql2o;
    public Sql2oBarDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void add(Bar bar) {
        String sql = "INSERT INTO bars (name, address, phone, deal, happyHour) VALUES (:name, :address, :phone, :deal, :happyHour)";
        try (Connection con = sql2o.open()) {
            int id = (int) con.createQuery(sql, true)
                    .bind(bar)
                    .executeUpdate()
                    .getKey();
            bar.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public List<Bar> getAll() {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM bars")
                    .executeAndFetch(Bar.class);
        }
    }

    @Override
    public Bar findById(int id) {
        return null;
    }

    @Override
    public void update(int id, String name, String address, String phone, String deal, String happyHour) {

    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public void clearAll() {

    }
}
