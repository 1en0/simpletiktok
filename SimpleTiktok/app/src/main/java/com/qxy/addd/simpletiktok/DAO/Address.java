package com.qxy.addd.simpletiktok.DAO;

public class Address {
    private final String country;
    private final String province;
    private final String city;
    public Address(String country, String province, String city){
        this.country = country;
        this.province = province;
        this.city = city;
    }

    @Override
    public String toString() {
        return country + province + city;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getProvince() {
        return province;
    }
}
