package com.example.tigereatapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ShopClosedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_closed);
    }
    public void backHome(View view) {
        Intent intent = new Intent();
        intent.setClass(this, HomeItem.class);
        startActivity(intent);
    }
    public void goForehandOrder(View view) {
        Intent intent = new Intent();
        intent.setClass(this, HomeItem.class);
        startActivity(intent);
    }

}