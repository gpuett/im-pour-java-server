package models;

import java.util.Objects;

public class Bar {

    private String name;
    private String address;
    private String phone;
    private String deal;
    private String happyHourStart;
    private String happyHourEnd;
    private int id;

    public Bar(String name, String address, String phone, String deal, String happyHourStart, String happyHourEnd) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.deal = deal;
        this.happyHourStart = happyHourStart;
        this.happyHourEnd = happyHourEnd;
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


    public void setDeal(String deal) {
        this.deal = deal;
    }

    public String getHappyHourStart() {
        return happyHourStart;
    }

    public void setHappyHourStart(String happyHourStart) {
        this.happyHourStart = happyHourStart;
    }

    public String getHappyHourEnd() {
        return happyHourEnd;
    }

    public void setHappyHourEnd(String happyHourEnd) {
        this.happyHourEnd = happyHourEnd;
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

        if (id != bar.id) return false;
        if (name != null ? !name.equals(bar.name) : bar.name != null) return false;
        if (address != null ? !address.equals(bar.address) : bar.address != null) return false;
        if (phone != null ? !phone.equals(bar.phone) : bar.phone != null) return false;
        if (deal != null ? !deal.equals(bar.deal) : bar.deal != null) return false;
        if (happyHourStart != null ? !happyHourStart.equals(bar.happyHourStart) : bar.happyHourStart != null)
            return false;
        return happyHourEnd != null ? happyHourEnd.equals(bar.happyHourEnd) : bar.happyHourEnd == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (deal != null ? deal.hashCode() : 0);
        result = 31 * result + (happyHourStart != null ? happyHourStart.hashCode() : 0);
        result = 31 * result + (happyHourEnd != null ? happyHourEnd.hashCode() : 0);
        result = 31 * result + id;
        return result;
    }
}
