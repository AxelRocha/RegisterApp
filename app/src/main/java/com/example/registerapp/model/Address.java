package com.example.registerapp.model;

import com.google.gson.annotations.SerializedName;

public class Address {

    @SerializedName("cep")
    private String cep;

    @SerializedName("logradouro")
    private String street;

    @SerializedName("bairro")
    private String district;

    @SerializedName("localidade")
    private String city;

    @SerializedName("uf")
    private String uf;

    public Address(String cep, String street, String district, String city, String uf) {
        this.cep = cep;
        this.street = street;
        this.district = district;
        this.city = city;
        this.uf = uf;
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
