package com.example.tigereatapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class AllOrderListsActivity extends AppCompatActivity {

    private ListView listView;
    private String[] name = {"店家名稱"};
    private String[] time = {"2022/6/10"};
    private String[] total = {"總金額: 200 NT"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_order_lists);

        ArrayList<OrderListRughItem> orderListRughItems = new ArrayList<>();
        orderListRughItems.add(new OrderListRughItem(name[0], time[0], total[0]));

        listView = this.findViewById(R.id.lvAllOrderLists);
        listView.setAdapter(new ListViewAdapter(this, R.layout.order_list_rough_item, orderListRughItems));
    }
}