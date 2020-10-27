package com.example.lab3;

public class Europe {
    private String country;
    private  String capital;
    private int image;

    Europe(String country, String capital, int image){
        this.country = country;
        this.capital = capital;
        this.image = image;
    }

    public String getCountry() {
        return this.country;
    }

    public String getCapital() {
        return this.capital;
    }

    public int getImage() {
        return this.image;
    }
}
