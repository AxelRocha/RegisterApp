package com.example.registerapp.model;

import androidx.annotation.NonNull;

public class PersonalData{

    private String name;
    private int age;
    private String phone;
    private String cep;
    private String street;
    private String district;
    private String city;
    private String uf;


    public PersonalData(String name, int age, String phone, String cep, String street, String district, String city, String uf) {
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.cep = cep;
        this.street = street;
        this.district = district;
        this.city = city;
        this.uf = uf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }
}
