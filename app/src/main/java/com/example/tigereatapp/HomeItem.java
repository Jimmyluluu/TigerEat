//用來get 主要餐廳layout的變數
package com.example.tigereatapp;

public class HomeItem {

    private int restImg;
    private String restName;
    private String restTime;
    private String restFee;
    private String restScore;

    public HomeItem(int restImg, String restName, String restTime, String restFee,
                    String restScore){
        this.restImg = restImg;
        this.restName = restName;
        this.restTime = restTime;
        this.restFee = restFee;
        this.restScore = restScore;
    }

    public int getRestImg() {
        return restImg;
    }

    public String getRestName() {
        return restName;
    }

    public String getRestTime() {
        return restTime;
    }

    public String getRestFee() {
        return restFee;
    }

    public String getRestScore() {
        return restScore;
    }
}
