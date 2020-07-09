package com.nd.abs.ui.module.login;

import com.nd.abs.base.BaseModel;
import com.nd.abs.base.BaseObserver;
import com.nd.abs.base.BasePresenter;
import com.nd.abs.net_works.ApiRetrofit;

public class LoginPresenter extends BasePresenter<LoginView> {

    public LoginPresenter(LoginView baseView) {
        super(baseView);
    }


    public void register(String phone, String psd) {
        addDisposable(ApiRetrofit.getInstance().getApiService().register(phone,psd), new BaseObserver(baseView) {
            @Override
            public void onSuccess(BaseModel o) {
                baseView.hideLoading();
                baseView.onRegisterSuccess((BaseModel<Object>) o);
            }

            @Override
            public void onError(String msg) {
                baseView.hideLoading();
                if (baseView != null) {
                    if("连接错误".equals(msg)){
                        baseView.onGetDataFail();
                    }else {
                        baseView.showError(msg);
                    }
                }
            }
        });
    }

    public void login(String phone, String psd) {
        addDisposable(ApiRetrofit.getInstance().getApiService().login(phone,psd), new BaseObserver(baseView) {
            @Override
            public void onSuccess(BaseModel o) {
                baseView.hideLoading();
                baseView.onLoginSuccess((BaseModel<LoginBean>) o);
            }

            @Override
            public void onError(String msg) {
                baseView.hideLoading();
                if (baseView != null) {
                    if("连接错误".equals(msg)){
                        baseView.onGetDataFail();
                    }else {
                        baseView.showError(msg);
                    }
                }
            }
        });
    }
}
