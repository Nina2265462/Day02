package com.bawei.day_02.mvp.home;

import com.bawei.day_02.mvp.user.UserContract;
import com.bawei.day_02.net.CallBackPost;

/*
 *@Auther:cln
 *@Date: 时间
 *@Description:功能
 * */
public class IHomeContract {
    public interface IHomeView {
        void showList(String result);
    }

    public interface IHomeModel {
        void requstList(String url, CallBackPost post);
    }

    public interface IHomePresent {
        void attach(IHomeView homeView);

        void dettach();

        void requstList(String surl);
    }
}
