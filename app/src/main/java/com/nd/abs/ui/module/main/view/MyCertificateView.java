package com.nd.abs.ui.module.main.view;


import com.nd.abs.base.BaseModel;
import com.nd.abs.base.BaseView;
import com.nd.abs.ui.module.main.bean.MyCertificateBean;
import com.nd.abs.ui.module.main.bean.MyClassInfo;

import java.util.List;

/**
 * File descripition:
 *
 * @author lp
 * @date 2018/6/19
 */

public interface MyCertificateView extends BaseView {

    void onGetDateSuccess(BaseModel<Object> data);

    void onGetMyCertificate(BaseModel<List<MyCertificateBean>> data);


    void onGetDataFail();
}
