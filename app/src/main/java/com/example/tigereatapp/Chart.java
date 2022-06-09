package com.example.tigereatapp;

public class Chart {
    private int img;
    private String name;
    private String score;

    public Chart(int img, String name, String score) {
        this.img = img;
        this.name = name;
        this.score = score;
    }

    public int getImg() {
        return img;
    }

    public String getName() {
        return name;
    }

    public String getScore() {
        return score;
    }
}
