package dao;

import models.Bar;

import java.util.List;


public interface BarDao {

    void add(Bar bar);

    List<Bar> getAll();

    Bar findById(int id);

    void update(int id, String name, String address, String phone, String deal, String happyHourStart, String happyHourEnd);

    void deleteById(int id);

    void clearAll();
}
