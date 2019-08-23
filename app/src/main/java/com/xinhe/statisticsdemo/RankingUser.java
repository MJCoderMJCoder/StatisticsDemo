package com.xinhe.statisticsdemo;

/**
 * Created by Administrator on 2017-05-05.
 */

public class RankingUser {
    private int num;
    private String avatar;
    private String gender;
    private String name;
    private String valueHeat;
    private String valuePound;
    private String valuePace;


    public RankingUser() {
    }

    public RankingUser(int num, String avatar, String gender, String name, String valueHeat, String valuePound, String valuePace) {
        this.num = num;
        this.avatar = avatar;
        this.gender = gender;
        this.name = name;
        this.valueHeat = valueHeat;
        this.valuePound = valuePound;
        this.valuePace = valuePace;
    }

    public void setValuePound(String valuePound) {
        this.valuePound = valuePound;
    }

    public void setValuePace(String valuePace) {
        this.valuePace = valuePace;
    }

    public String getValuePound() {
        return valuePound;
    }

    public String getValuePace() {
        return valuePace;
    }

    public int getNum() {
        return num;
    }

    public String getAvatar() {
        return avatar;
    }

    public String getGender() {
        return gender;
    }

    public String getName() {
        return name;
    }

    public String getValueHeat() {
        return valueHeat;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValueHeat(String valueHeat) {
        this.valueHeat = valueHeat;
    }
}
