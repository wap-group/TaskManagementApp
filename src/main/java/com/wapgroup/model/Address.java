package com.wapgroup.model;

public class Address {
    private String zipcode;
    private String street;
    private String city;
    private String state;
    private double lat;
    private double longtiude;

    public Address(String zipcode, String street, String city,
                   String state){
        this.zipcode = zipcode;
        this.street = street;
        this.city = city;
        this.state = state;

    }

    public Address(String zipcode, String street, String city,
                   String state, double lat, double longtiude)
    {
        this(zipcode, street, city, state);
        this.lat = lat;
        this.longtiude = longtiude;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
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

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLongtiude() {
        return longtiude;
    }

    public void setLongtiude(double longtiude) {
        this.longtiude = longtiude;
    }
}
