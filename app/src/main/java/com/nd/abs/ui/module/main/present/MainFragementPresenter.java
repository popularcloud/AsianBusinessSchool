package com.nd.abs.ui.module.main.present;

import com.nd.abs.base.BaseModel;
import com.nd.abs.base.BaseObserver;
import com.nd.abs.base.BasePresenter;
import com.nd.abs.net_works.ApiRetrofit;
import com.nd.abs.ui.module.login.LoginBean;
import com.nd.abs.ui.module.login.LoginView;
import com.nd.abs.ui.module.login.RegisterBean;
import com.nd.abs.ui.module.main.bean.BannerInfo;
import com.nd.abs.ui.module.main.view.MainFragmentView;

import java.util.List;

public class MainFragementPresenter extends BasePresenter<MainFragmentView> {

    public MainFragementPresenter(MainFragmentView baseView) {
        super(baseView);
    }


    public void getBanner() {
        addDisposable(ApiRetrofit.getInstance().getApiService().getBanner("slideshow"), new BaseObserver(baseView) {
            @Override
            public void onSuccess(BaseModel o) {
                baseView.hideLoading();
                baseView.onGetBannerSuccess((BaseModel<List<BannerInfo>>) o);
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
