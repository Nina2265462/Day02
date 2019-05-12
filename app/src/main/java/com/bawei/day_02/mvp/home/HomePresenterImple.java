package com.bawei.day_02.mvp.home;

import android.util.Log;

import com.bawei.day_02.mvp.user.UserContract;
import com.bawei.day_02.net.CallBackPost;

/*
 *@Auther:cln
 *@Date: 时间
 *@Description:功能
 * */
public class HomePresenterImple implements IHomeContract.IHomePresent {

    private IHomeContract.IHomeView view;
    private IHomeContract.IHomeModel model;

    @Override
    public void attach(IHomeContract.IHomeView homeView) {
        this.view = homeView;
        model = new HomeModelImpl();
    }

    @Override
    public void dettach() {
        if (view != null) {
            view = null;
        }
        if (model != null) {
            model = null;
        }
    }

    @Override
    public void requstList(String surl) {
        model.requstList(surl, new CallBackPost() {
            @Override
            public void onSuccess(String result) {
                view.showList(result);
            }

            @Override
            public void onFail(String msg) {

            }
        });
    }
}
