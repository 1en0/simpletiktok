package com.qxy.addd.simpletiktok.DAO;

public class User {
    private final String nickName;
    private final int imageId;
    private final Address address;
    private final Gender gender;
    public User(int imageId, String name, String country, String province, String city, Gender gender){
        this.nickName = name;
        this.imageId = imageId;
        this.address = new Address(country, province, city);
        this.gender = gender;
    }

    public User(int imageId, String name, Address address, Gender gender){
        this.imageId = imageId;
        this.nickName = name;
        this.address = address;
        this.gender = gender;
    }

    public Address getAddress() {
        return address;
    }

    public Gender getGender() {
        return gender;
    }

    public String getName() {
        return nickName;
    }

    public int getImageId() {
        return imageId;
    }
}
