//用來get 主要餐廳layout的變數
package com.example.tigereatapp;

<<<<<<< HEAD
import android.content.Context;
=======
>>>>>>> ebfd5de03afe4faab2287ba92c11eafe3823764a
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class HomeItem extends BaseAdapter {

    private final Context context;

    private final String[] resName;
    private final String[] resTime;
    private final String[] resFee;
    private final String[] resScore;
    private final int[] resImg;



    //初始化
    public HomeItem(Context context , String[] resName, String[] resTime, String[] resFee, String[] resScore, int[] resImg){
        this.context = context;
        this.resName = resName;
        this.resTime = resTime;
        this.resFee = resFee;
        this.resScore = resScore;
        this.resImg = resImg;
    }

    @Override
    public int getCount() {
        return resName.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View holder;
        LayoutInflater layoutInflater =
                (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //當ListView被拖拉時會不斷觸發getView，為了避免重複加載必須加上這個判斷
<<<<<<< HEAD
        if (convertView == null) {
            holder = new View(context);
            holder = layoutInflater.inflate(R.layout.home_layout, null);
            TextView reName = (TextView) holder.findViewById(R.id.restName);
            TextView reFee = (TextView) holder.findViewById(R.id.restFee);
            TextView reTime = (TextView) holder.findViewById(R.id.restTime);
            TextView reScore = (TextView) holder.findViewById(R.id.restScore);
            ImageView reImg = (ImageView) holder.findViewById(R.id.restImg);
            reName.setText(resName[position]);
            reFee.setText(resFee[position]);
            reTime.setText(resTime[position]);
            reScore.setText(resScore[position]);
            reImg.setImageResource(resImg[position]);
=======
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
>>>>>>> ebfd5de03afe4faab2287ba92c11eafe3823764a

        } else {
            holder = (View) convertView;
        }
        return holder;
    }
}
