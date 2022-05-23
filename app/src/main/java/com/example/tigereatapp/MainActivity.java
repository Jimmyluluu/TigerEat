package com.example.tigereatapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);


        //clear();

        // 記錄使用者的登錄資料，讓使用者只須登入一次
        // 目前能執行，但若要再更新程式至虛擬機，便要先登出，
        // 或將sharePreferences相關程式註解後執行clear()
        SharedPreferences sharedPreferences =
                getSharedPreferences("login", Context.MODE_PRIVATE);
        if (sharedPreferences.getString("login", null) == null) {
            Intent intent = new Intent(MainActivity.this, WelcomeActivity.class);
            startActivity(intent);
        }

        /*Intent intent = new Intent(MainActivity.this, WelcomeActivity.class);
            startActivity(intent);*/

        btnInfo = findViewById(R.id.btnInfo);
        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        MainActivity.this, InfoActivity.class);
                startActivity(intent);
            }
        });


    }

    public void clear() {
        SharedPreferences sharedPreferences =
                getSharedPreferences("login", Context.MODE_PRIVATE);
        sharedPreferences.edit().clear().commit();
    }
}