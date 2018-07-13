package models;

import java.util.Objects;

public class Bar {

    private String name;
    private String address;
    private String phone;
    private String deal;
    private String happyHour;
    private int id;

    public Bar(String name, String address, String phone, String deal, String happyHour) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.deal = deal;
        this.happyHour = happyHour;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDeal() {
        return deal;
    }

    public String getHappyHour() {
        return happyHour;
    }

    public void setHappyHour(String happyHour) {
        this.happyHour = happyHour;
    }

    public void setDeal(String deal) {
        this.deal = deal;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bar bar = (Bar) o;
        return id == bar.id &&
                Objects.equals(name, bar.name) &&
                Objects.equals(address, bar.address) &&
                Objects.equals(phone, bar.phone) &&
                Objects.equals(deal, bar.deal);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, address, phone, deal, id);
    }
}
