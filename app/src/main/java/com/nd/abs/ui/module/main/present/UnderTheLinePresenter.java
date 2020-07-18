package com.nd.abs.ui.module.main.present;

import com.nd.abs.base.BaseModel;
import com.nd.abs.base.BaseObserver;
import com.nd.abs.base.BasePresenter;
import com.nd.abs.net_works.ApiRetrofit;
import com.nd.abs.ui.module.main.bean.MBAInfo;
import com.nd.abs.ui.module.main.bean.MyClassInfo;
import com.nd.abs.ui.module.main.view.MyClassView;
import com.nd.abs.ui.module.main.view.UnderTheLineView;

import java.util.List;

public class UnderTheLinePresenter extends BasePresenter<UnderTheLineView> {

    public UnderTheLinePresenter(UnderTheLineView baseView) {
        super(baseView);
    }


    public void getMBA() {
        addDisposable(ApiRetrofit.getInstance().getApiService().getMBA(""), new BaseObserver(baseView) {
            @Override
            public void onSuccess(BaseModel o) {
                baseView.hideLoading();
                baseView.onGetDateSuccess((BaseModel<List<MBAInfo>>) o);
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
