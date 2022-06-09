package com.example.tigereatapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.Calendar;

public class ArrriveTimeActivity extends AppCompatActivity {


    TextView showTime;
    Calendar mCal = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arrrive_time);
        showTime = findViewById(R.id.showTime);


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
    }
}