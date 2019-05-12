package com.bawei.day_02.mvp.home;

import com.bawei.day_02.net.CallBackPost;
import com.bawei.day_02.net.HttpUntil;

/*
 *@Auther:cln
 *@Date: 时间
 *@Description:功能
 * */
public class HomeModelImpl implements IHomeContract.IHomeModel {

    private final HttpUntil httpUntil;

    public HomeModelImpl() {
        httpUntil = HttpUntil.getInstance();
    }

    @Override
    public void requstList(String url, CallBackPost post) {
        httpUntil.doHttpGet(url, post);
    }
}
