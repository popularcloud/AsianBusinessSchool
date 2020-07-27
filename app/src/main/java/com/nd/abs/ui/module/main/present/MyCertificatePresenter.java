package com.nd.abs.ui.module.main.present;

import com.nd.abs.base.BaseModel;
import com.nd.abs.base.BaseObserver;
import com.nd.abs.base.BasePresenter;
import com.nd.abs.net_works.ApiRetrofit;
import com.nd.abs.ui.module.main.bean.MyCertificateBean;
import com.nd.abs.ui.module.main.bean.MyClassInfo;
import com.nd.abs.ui.module.main.view.MyCertificateView;
import com.nd.abs.ui.module.main.view.MyClassView;

import java.util.List;

import okhttp3.MultipartBody;

public class MyCertificatePresenter extends BasePresenter<MyCertificateView> {

    public MyCertificatePresenter(MyCertificateView baseView) {
        super(baseView);
    }


    public void uploadPicToService(MultipartBody.Part file) {
        addDisposable(ApiRetrofit.getInstance().getApiService().uploadPicToService(file), new BaseObserver(baseView) {
            @Override
            public void onSuccess(BaseModel o) {
                baseView.hideLoading();
                baseView.onGetDateSuccess((BaseModel<Object>) o);
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

    public void getCertificate(String userId) {
        addDisposable(ApiRetrofit.getInstance().getApiService().getCertificate(userId), new BaseObserver(baseView) {
            @Override
            public void onSuccess(BaseModel o) {
                baseView.hideLoading();
                baseView.onGetMyCertificate((BaseModel<List<MyCertificateBean>>) o);
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
