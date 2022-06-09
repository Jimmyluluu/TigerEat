package com.example.tigereatapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Calendar;

public class ArrriveTimeActivity extends AppCompatActivity {

    private Button Home;
    private Button Shop;
    private Button Search;
    private Button Set;

    TextView showTime;
    Calendar mCal = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arrrive_time);
        showTime = findViewById(R.id.showTime);
        Home = findViewById(R.id.Home);
        Shop = findViewById(R.id.Shopping);
        Search = findViewById(R.id.Search);
        Set = findViewById(R.id.Setting);
        Home = findViewById(R.id.Home);

        int nowHour = mCal.get(Calendar.HOUR);
        int nowMin = mCal.get(Calendar.MINUTE);
        nowMin = nowMin + 15;
        if (nowMin > 60) {
            nowHour = nowHour + 1;
            nowMin = nowMin - 60;
            if (nowHour == 24) {
                nowHour = 0;
            }
        }

        showTime.setText(String.valueOf(nowHour) + "點" + String.valueOf(nowMin) + "分" );
        Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        ArrriveTimeActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        Shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        ArrriveTimeActivity.this, ShoppingcartActivity.class);
                startActivity(intent);
            }
        });
        Search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        ArrriveTimeActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        Set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        ArrriveTimeActivity.this, InfoActivity.class);
                startActivity(intent);
            }
        });
    }
}