package com.bawei.day_02.ui.home;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bawei.day_02.R;

/*
 *@Auther:cln
 *@Date: 时间
 *@Description:功能
 * */
public class Frag02 extends Fragment {

    private TextView tv;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag02, container, false);
        tv = view.findViewById(R.id.tv);
        SharedPreferences sp = getActivity().getSharedPreferences("what", Context.MODE_PRIVATE);
        String phone = sp.getString("phone", "");
        tv.setText(phone);
        return view;
    }
}
