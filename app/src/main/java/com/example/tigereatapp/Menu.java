package com.example.tigereatapp;

public class Menu {
    private int img;
    //private int button;
    private String name;
    private String money;


    public Menu(int img, /*int button,*/String name, String money) {
        this.img = img;
        //this.button = button;
        this.name = name;
        this.money = money;
    }

    public int getImg() {
        return img;
    }

    /*public int getbutton() {
        return button;
    }*/

    public String getName() {
        return name;
    }

    public String getMoney() {
        return money;
    }
}
