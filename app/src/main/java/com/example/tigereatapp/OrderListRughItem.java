package com.example.tigereatapp;

public class OrderListRughItem {

    private String storeName;
    private String date;
    private String total;

    public OrderListRughItem(String name, String date, String total) {
        this.storeName = name;
        this.date = date;
        this.total = total;
    }

    public String getStoreName() {
        return storeName;
    }

    public String getDate() {
        return date;
    }

    public String getTotal() {
        return total;
    }
}
