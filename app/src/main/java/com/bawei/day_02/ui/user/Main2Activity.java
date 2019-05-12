package com.bawei.day_02.ui.user;

import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bawei.day_02.R;
import com.bawei.day_02.ui.home.Frag01;
import com.bawei.day_02.ui.home.Frag02;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    private ArrayList<Fragment> fragments;
    private ArrayList<String> slist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ViewPager pager = findViewById(R.id.pager);
        TabLayout tab = findViewById(R.id.tab);
        slist = new ArrayList<>();
        slist.add("首页");
        slist.add("我的");
        tab.addTab(tab.newTab().setText(slist.get(0)));
        tab.addTab(tab.newTab().setText(slist.get(1)));
        fragments = new ArrayList<>();
        fragments.add(new Frag01());
        fragments.add(new Frag02());
        pager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return fragments.get(i);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return slist.get(position);
            }
        });
        tab.setupWithViewPager(pager);
    }
}
