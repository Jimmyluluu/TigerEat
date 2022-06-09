package com.example.tigereatapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

/**
 * 撰寫一個ArrayAdapter，
 * 用來存要放進ListView的資訊.
 */
public class ListViewAdapter extends ArrayAdapter<OrderListRughItem> {

  private Context context;
  private List<OrderListRughItem> orderListRughItem;

  /**
   * constructor.
   * @ param context00000
   * @ param resource
   * @ param mealItems
   */
  public ListViewAdapter(
          @NonNull Context context, int resource, @NonNull List<OrderListRughItem> orderListRughItem) {
    super(context, resource, orderListRughItem);

    this.context = context;
    this.orderListRughItem = orderListRughItem;
  }

  /**
   * 填寫GridView的圖示和標題等控制元件的來源，
   * 來自於menu_list_item這個佈局檔案，
   * 把控制元件所在的佈局檔案載入到當前類中.
   * @ param position
   * @ param convertView
   * @ param parent
   * @ return
   */
  @NonNull
  @Override
  public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

    LayoutInflater inflater = LayoutInflater.from(this.context);
    LinearLayout itemLayout;

    if (convertView == null) {
      itemLayout = (LinearLayout) inflater.inflate(R.layout.order_list_rough_item, null);
    } else {
      itemLayout = (LinearLayout) convertView;
    }

    OrderListRughItem item = orderListRughItem.get(position);

    TextView tvName = itemLayout.findViewById(R.id.tvName);
    tvName.setText(item.getStoreName());

    TextView tvTime = itemLayout.findViewById(R.id.tvTime);
    tvTime.setText(item.getDate());

    TextView tvTotal = itemLayout.findViewById(R.id.tvTotal);
    tvTotal.setText(item.getTotal());

    return itemLayout;
  }
}
