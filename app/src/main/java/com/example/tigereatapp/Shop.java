package com.example.tigereatapp;

public class Shop {
    private int img;
    private String name;
    private String serving;
    private String money;
    public Shop(String name,String serving, String money ) {

        this.name = name;
        this.serving = serving;
        this.money = money;
    }
    public String getName() {
        return name;
    }
    public String getServing() {
        return name;
    }
    public String getMoney() {
        return money;
    }
}
