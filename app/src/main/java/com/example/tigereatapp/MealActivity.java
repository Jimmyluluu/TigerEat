package com.example.tigereatapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.time.Instant;
import java.util.ArrayList;

public class MealActivity extends AppCompatActivity {
    private Button Home;
    private Button Shop;
    private Button Search;
    private Button Set;
    private String name;
    private String money;




    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal);
        Home = findViewById(R.id.Home);
        Shop = findViewById(R.id.Shopping);
        Search = findViewById(R.id.Search);
        Set = findViewById(R.id.Setting);

        String[] shopName =  {"鐵觀音奶茶", "冬瓜鐵觀音", "烏龍茶", "綠茶", "紅茶", "珍珠奶茶"};
        String[] shopMoney =  {"70", "65", "40", "40", "40", "60"};
        int[] shopImg =  {R.drawable.drink1, R.drawable.drink2,R.drawable.drink3,R.drawable.drink4, R.drawable.drink5, R.drawable.drink6};

        ListView listView = findViewById(R.id.lv);
        TextView txv = findViewById(R.id.shop_Title);
        ArrayList<Menu> menuArrayList = new ArrayList<Menu>();

        Intent intent = this.getIntent();
        int no = intent.getIntExtra(MainActivity.SHOP_NO, 0);

        switch (no){
            case 0:
                //先清空
                menuArrayList.clear();
                for (int i = 0; i < 6; i ++) {
                    menuArrayList.add(new Menu(shopImg[i], shopName[i], shopMoney[i]));
                    name = shopName[i];
                    money = shopMoney[i];
                }

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


        Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        MealActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        Shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        MealActivity.this, ShoppingcartActivity.class);
                startActivity(intent);
            }
        });
        Search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        MealActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        Set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        MealActivity.this, InfoActivity.class);
                startActivity(intent);
            }
        });

    }

    public void onClick(View view) {
        Intent it = new Intent(this, ShoppingcartActivity.class);
        it.putExtra("name1",name);
        it.putExtra("money1",money);
        startActivity(it);
    }

}