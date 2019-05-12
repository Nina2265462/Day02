package com.bawei.day_02.mvp.user;

import com.bawei.day_02.net.CallBackPost;

/*
 *@Auther:cln
 *@Date: 时间
 *@Description:功能
 * */
public class UserPresentImpl implements UserContract.IUserPresenter {

    private UserContract.IUserView view;
    private UserModelImpl model;

    @Override
    public void attach(UserContract.IUserView userView) {
        view = userView;
        model = new UserModelImpl();
    }

    @Override
    public void dattach() {
        if (view != null) {
            view = null;
        }
        if (model != null) {
            model = null;
        }
    }

    @Override
    public void regist(String phone, String pwd) {
        model.regist(phone, pwd, new CallBackPost() {
            @Override
            public void onSuccess(String result) {
                view.onRegistSuccess(result);
            }

            @Override
            public void onFail(String msg) {
            }
        });
    }

    @Override
    public void login(String phone, String pwd) {
        model.login(phone, pwd, new CallBackPost() {
            @Override
            public void onSuccess(String result) {
                view.onLoginSuccess(result);
            }

            @Override
            public void onFail(String msg) {

            }
        });
    }
}
