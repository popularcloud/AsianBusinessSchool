package com.nd.abs.ui.module.login;


import com.nd.abs.base.BaseModel;
import com.nd.abs.base.BaseView;

/**
 * File descripition:
 *
 * @author lp
 * @date 2018/6/19
 */

public interface LoginView extends BaseView {

    void onLoginSuccess(BaseModel<LoginBean> data);

    void onRegisterSuccess(BaseModel<Object> data);

    void onGetDataFail();
}
