//排行榜
package com.example.tigereatapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ChartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);

        ListView listView = findViewById(R.id.lsv);
        ArrayList<Chart> chartList = new ArrayList<>();

        Intent intent = this.getIntent();
        chartList.add(new Chart(R.drawable.rest1, "茶湯會", "5.0"));
        chartList.add(new Chart(R.drawable.rest2, "鼎王", "4.8"));
        chartList.add(new Chart(R.drawable.rest3, "瓦城", "4.9"));
        chartList.add(new Chart(R.drawable.rest4, "烏龍麵所", "4.5"));
        chartList.add(new Chart(R.drawable.rest5, "鼎泰豐", "4.7"));


        ChartArrayAdapter adapter = new ChartArrayAdapter(this, R.layout.chart_layout, chartList);
        listView.setAdapter(adapter);
    }


}