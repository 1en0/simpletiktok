package com.qxy.addd.simpletiktok.bean;

public class UserBean{
    private String city;
    private String country;
    private Integer gender;
    private String nickname;
    private String open_id;
    private String province;
    private String union_id;
    private String avatar;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getOpen_id() {
        return open_id;
    }

    public void setOpen_id(String open_id) {
        this.open_id = open_id;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getUnion_id() {
        return union_id;
    }

    public void setUnion_id(String union_id) {
        this.union_id = union_id;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Override
    public String toString() {
        return "UserBean{" +
                "city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", gender=" + gender +
                ", nickname='" + nickname + '\'' +
                ", open_id='" + open_id + '\'' +
                ", province='" + province + '\'' +
                ", union_id='" + union_id + '\'' +
                ", avatar='" + avatar + '\'' +
                '}';
    }
}

