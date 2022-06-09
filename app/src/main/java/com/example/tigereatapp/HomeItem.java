//用來get 主要餐廳layout的變數
package com.example.tigereatapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class HomeItem extends BaseAdapter {

    /*
    private int restImg;
    private String restName;
    private String restTime;
    private String restFee;
    private String restScore;

    public HomeItem(int restImg, String restName, String restTime, String restFee,
                    String restScore){
        this.restImg = restImg;
        this.restName = restName;
        this.restTime = restTime;
        this.restFee = restFee;
        this.restScore = restScore;
    }*/
    private String[][] ElementsData ;   //資料
    private LayoutInflater inflater;    //加載layout
    private int indentionBase;          //item缩排
    //優化Listview 避免重新加載
    //這邊宣告你會動到的Item元件
    static class ViewHolder{
        LinearLayout rlBorder;
        TextView restName;
        TextView restTime;
        TextView restFee;
        TextView restScore;
        ImageView restImg;
    }

    //初始化
    public void ViewAdapter(String[][] data, LayoutInflater inflater){
        this.ElementsData = data;
        this.inflater = inflater;
        indentionBase = 100;
    }

    @Override
    public int getCount() {
        return ElementsData.length;
    }

    @Override
    public Object getItem(int i) {
        return ElementsData[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        //當ListView被拖拉時會不斷觸發getView，為了避免重複加載必須加上這個判斷
        if (view == null) {
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.activity_main, null);
            holder.restName = (TextView) view.findViewById(R.id.Name);
            holder.restFee = (TextView) view.findViewById(R.id.restFee);
            holder.restTime = (TextView) view.findViewById(R.id.restTime);
            holder.restScore = (TextView) view.findViewById(R.id.Score);
            holder.restImg = (ImageView) view.findViewById(R.id.Img);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        //1=都市 2=政府所在地
        //不同類型用不同Style的表現方式
        /*if (ElementsData[i][0].equals("1")){
            holder.Local.setText("★");
            holder.Name.setText(ElementsData[i][1]);
            holder.rlBorder.setBackgroundColor(Color.parseColor("#FFDBC9"));

        }else{
            holder.Local.setText("");
            holder.Name.setText(ElementsData[i][1]);
            LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) holder.rlBorder.getLayoutParams();
            lp.setMargins(indentionBase,0, 0,0);//縮牌
        }*/
        return view;
    }
}
