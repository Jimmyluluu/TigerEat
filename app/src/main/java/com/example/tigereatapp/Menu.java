package com.example.tigereatapp;

public class Menu {
    private int img;
    private String name;
    private String money;

    public Menu(int img, String name, String money) {
        this.img = img;
        this.name = name;
        this.money = money;
    }

    public int getImg() {
        return img;
    }

    public String getName() {
        return name;
    }

    public String getMoney() {
        return money;
    }
}
