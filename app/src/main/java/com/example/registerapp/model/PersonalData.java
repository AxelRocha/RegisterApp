package com.example.registerapp.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "personal_data")
public class PersonalData implements Serializable {

    @PrimaryKey(autoGenerate = true)
    public int uid;

    @NonNull
    @ColumnInfo(name = "name")
    private String name;

    @NonNull
    @ColumnInfo(name = "age")
    private int age;

    @NonNull
    @ColumnInfo(name = "phone")
    private String phone;

    @NonNull
    @ColumnInfo(name = "cep")
    private String cep;

    @NonNull
    @ColumnInfo(name = "street")
    private String street;

    @NonNull
    @ColumnInfo(name = "number")
    private String number;

    @NonNull
    @ColumnInfo(name = "district")
    private String district;

    @NonNull
    @ColumnInfo(name = "city")
    private String city;

    @NonNull
    @ColumnInfo(name = "uf")
    private String uf;

    @Ignore
    public PersonalData() {
        this.name = "";
        this.age = 0;
        this.phone = "";
        this.cep = "";
        this.street = "";
        this.number = "";
        this.district = "";
        this.city = "";
        this.uf = "";
    }


    public PersonalData(@NonNull String name, int age, @NonNull String phone, @NonNull String cep, @NonNull String street, @NonNull String number, @NonNull String district, @NonNull String city, @NonNull String uf) {
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.cep = cep;
        this.street = street;
        this.number = number;
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

    @NonNull
    public String getCep() {
        return cep;
    }

    public void setCep(@NonNull String cep) {
        this.cep = cep;
    }

    @NonNull
    public String getStreet() {
        return street;
    }

    public void setStreet(@NonNull String street) {
        this.street = street;
    }

    @NonNull
    public String getNumber() {
        return number;
    }

    public void setNumber(@NonNull String number) {
        this.number = number;
    }

    @NonNull
    public String getDistrict() {
        return district;
    }

    public void setDistrict(@NonNull String district) {
        this.district = district;
    }

    @NonNull
    public String getCity() {
        return city;
    }

    public void setCity(@NonNull String city) {
        this.city = city;
    }

    @NonNull
    public String getUf() {
        return uf;
    }

    public void setUf(@NonNull String uf) {
        this.uf = uf;
    }
}