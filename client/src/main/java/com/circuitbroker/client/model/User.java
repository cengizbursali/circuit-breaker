package com.circuitbroker.client.model;


import com.circuitbroker.client.model.enums.Profession;

public class User {

    private Integer userId;
    private String name;
    private String surname;
    private Profession profession;

    public User() {
    }

    public User(Integer userId, String name, String surname, Profession profession) {
        this.userId = userId;
        this.name = name;
        this.surname = surname;
        this.profession = profession;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Profession getProfession() {
        return profession;
    }

    public void setProfession(Profession profession) {
        this.profession = profession;
    }
}
