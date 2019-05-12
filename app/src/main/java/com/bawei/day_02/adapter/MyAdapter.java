package com.bawei.day_02.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.day_02.R;
import com.bawei.day_02.bean.Home;
import com.bumptech.glide.Glide;

/*
 *@Auther:cln
 *@Date: 时间
 *@Description:功能
 * */
public class MyAdapter extends BaseAdapter {
    private Context context;
    private Home home;
    private int item01 = 1;
    private int item02 = 2;

    public MyAdapter(Context context, Home home) {
        this.context = context;
        this.home = home;
    }

    @Override
    public int getCount() {
        return home.result.pzsh.commodityList.size()
                + home.result.rxxp.commodityList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        switch (getItemViewType(position)) {
            case 1:
                ViewHolder01 holder01 = null;
                if (convertView == null) {
                    convertView = View.inflate(context, R.layout.item01, null);
                    holder01 = new ViewHolder01();
                    holder01.img01 = convertView.findViewById(R.id.img);
                    holder01.tv1 = convertView.findViewById(R.id.tv);
                    convertView.setTag(holder01);
                } else {
                    holder01 = (ViewHolder01) convertView.getTag();
                }
                Home.ShopInfo shopInfo01 = home.result.rxxp.commodityList.get(position);
                holder01.tv1.setText(shopInfo01.commodityName);
                Glide.with(context).load(shopInfo01.masterPic).into(holder01.img01);
                break;
            case 2:
                ViewHolder02 holder02 = null;
                if (convertView == null) {
                    convertView = View.inflate(context, R.layout.item02, null);
                    holder02 = new ViewHolder02();
                    holder02.img02 = convertView.findViewById(R.id.img);
                    holder02.tv2 = convertView.findViewById(R.id.tv);
                    convertView.setTag(holder02);
                } else {
                    holder02 = (ViewHolder02) convertView.getTag();
                }
                Home.ShopInfo shopInfo = home.result.pzsh.commodityList.get(position - 3);
                holder02.tv2.setText(shopInfo.commodityName);
                Glide.with(context).load(shopInfo.masterPic).into(holder02.img02);
                break;
        }
        return convertView;
    }

    class ViewHolder01 {
        TextView tv1;
        ImageView img01;
    }

    class ViewHolder02 {
        TextView tv2;
        ImageView img02;
    }

    @Override
    public int getItemViewType(int position) {
        if (position < home.result.rxxp.commodityList.size()) {
            return item01;
        } else {
            return item02;
        }
    }

    @Override
    public int getViewTypeCount() {
        return 3;
    }
}
