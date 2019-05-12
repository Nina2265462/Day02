package com.bawei.day_02.mvp.user;

import com.bawei.day_02.net.CallBackPost;

/*
 *@Auther:cln
 *@Date: 时间
 *@Description:功能
 * */
public interface UserContract {
    public interface IUserView {
        void onRegistSuccess(String result);

        void onLoginSuccess(String result);
    }

    public interface IUserModel {
        void regist(String phone, String pwd, CallBackPost post);

        void login(String phone, String pwd, CallBackPost backPost);
    }

    public interface IUserPresenter {
        void attach(IUserView userView);

        void dattach();

        void regist(String phone, String pwd);

        void login(String phone, String pwd);

    }
}
