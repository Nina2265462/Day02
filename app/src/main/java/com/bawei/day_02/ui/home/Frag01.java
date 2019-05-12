package com.bawei.day_02.ui.home;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.bawei.day_02.R;
import com.bawei.day_02.adapter.MyAdapter;
import com.bawei.day_02.bean.Home;
import com.bawei.day_02.mvp.home.HomePresenterImple;
import com.bawei.day_02.mvp.home.IHomeContract;
import com.google.gson.Gson;

/*
 *@Auther:cln
 *@Date: 时间
 *@Description:功能
 * */
public class Frag01 extends Fragment implements IHomeContract.IHomeView {

    private ListView lv;
    private IHomeContract.IHomePresent presenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag01, container, false);
        lv = view.findViewById(R.id.lv);
        presenter = new HomePresenterImple();
        presenter.attach(this);
        String str = "http://172.17.8.100/small/commodity/v1/commodityList";
        presenter.requstList(str);
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.dettach();
    }

    @Override
    public void showList(String result) {
        //Toast.makeText(getActivity(), ""+result, Toast.LENGTH_SHORT).show();
        Gson gson = new Gson();
        Home home = gson.fromJson(result, Home.class);
        lv.setAdapter(new MyAdapter(getContext(), home));
    }
}
