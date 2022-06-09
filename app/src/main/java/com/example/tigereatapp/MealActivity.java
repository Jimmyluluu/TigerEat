package com.example.tigereatapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MealActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal);

        ListView listView = findViewById(R.id.lv);
        TextView txv = findViewById(R.id.shop_Title);
        ArrayList<Menu> menuArrayList = new ArrayList<Menu>();

        Intent intent = this.getIntent();
        int no = intent.getIntExtra(MainActivity.SHOP_NO, 0);
        switch (no){
            case 0:
                //先清空
                menuArrayList.clear();
                menuArrayList.add(new Menu(R.drawable.drink1, "鐵觀音奶茶", "$70"));
                menuArrayList.add(new Menu(R.drawable.drink2, "冬瓜鐵觀音", "65"));
                menuArrayList.add(new Menu(R.drawable.drink3, "烏龍茶", "40"));
                menuArrayList.add(new Menu(R.drawable.drink4, "綠茶", "40"));
                menuArrayList.add(new Menu(R.drawable.drink5, "紅茶", "40"));
                menuArrayList.add(new Menu(R.drawable.drink6, "珍珠奶茶", "60"));

                txv.setText(" 茶湯會");
                break;
            case 1:
                menuArrayList.clear();
                menuArrayList.add(new Menu(R.drawable.food2, "薯條", "$45"));
                menuArrayList.add(new Menu(R.drawable.food3, "三明治", "$80"));
                menuArrayList.add(new Menu(R.drawable.food4, "巧克力吐司", "$65"));
                txv.setText(" 鼎王");
                break;
            case 2:
                menuArrayList.clear();
                menuArrayList.add(new Menu(R.drawable.food3, "三明治", "$80"));
                menuArrayList.add(new Menu(R.drawable.food4, "巧克力吐司", "$65"));
                menuArrayList.add(new Menu(R.drawable.food5, "蔥油餅", "$75"));
                txv.setText(" 瓦城");
                break;
            case 3:
                menuArrayList.clear();
                menuArrayList.add(new Menu(R.drawable.food4, "巧克力吐司", "$65"));
                menuArrayList.add(new Menu(R.drawable.food5, "蔥油餅", "$75"));
                menuArrayList.add(new Menu(R.drawable.food6, "豆漿", "$30"));
                txv.setText(" 烏龍麵所");
                break;
        }


        MenuArrayAdapter adapter = new MenuArrayAdapter(this, R.layout.shop_list_layout, menuArrayList);
        listView.setAdapter(adapter);

    }
}