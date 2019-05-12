package com.bawei.day_02.mvp.user;

import com.bawei.day_02.net.CallBackPost;
import com.bawei.day_02.net.HttpUntil;

/*
 *@Auther:cln
 *@Date: 时间
 *@Description:功能
 * */
public class UserModelImpl implements UserContract.IUserModel {

    private final HttpUntil httpUntil;

    public UserModelImpl() {
        httpUntil = HttpUntil.getInstance();
    }

    @Override
    public void regist(String phone, String pwd, CallBackPost post) {
        String registUrl = "http://172.17.8.100/small/user/v1/register";
        httpUntil.doHttpPost(registUrl, phone, pwd, post);
    }

    @Override
    public void login(String phone, String pwd, CallBackPost post) {
        String loginUrl = "http://172.17.8.100/small/user/v1/login";
        httpUntil.doHttpPost(loginUrl, phone, pwd, post);
    }
}
