package com.codedifferently.namazonshoping;

public class Address {
    private String street;
    private String unit;
    private String city;
    private String state;


    public Address(String unit, String street, String city, String state) {
        this.street = street;
        this.unit = unit;
        this.city = city;
        this.state = state;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }


    @Override
    public String toString() {
        return String.format("%s %s %s %s", unit, street, city, state);
    }
}
