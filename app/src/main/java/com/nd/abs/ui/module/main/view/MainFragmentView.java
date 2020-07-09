package com.nd.abs.ui.module.main.view;


import com.nd.abs.base.BaseModel;
import com.nd.abs.base.BaseView;
import com.nd.abs.ui.module.login.LoginBean;
import com.nd.abs.ui.module.login.RegisterBean;
import com.nd.abs.ui.module.main.bean.BannerInfo;

import java.util.List;

/**
 * File descripition:
 *
 * @author lp
 * @date 2018/6/19
 */

public interface MainFragmentView extends BaseView {

    void onGetBannerSuccess(BaseModel<List<BannerInfo>> data);


    void onGetDataFail();
}
