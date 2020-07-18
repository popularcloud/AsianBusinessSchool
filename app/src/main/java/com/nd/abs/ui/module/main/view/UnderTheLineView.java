package com.nd.abs.ui.module.main.view;


import com.nd.abs.base.BaseModel;
import com.nd.abs.base.BaseView;
import com.nd.abs.ui.module.main.bean.MBAInfo;
import com.nd.abs.ui.module.main.bean.MyClassInfo;

import java.util.List;

/**
 * File descripition:
 *
 * @author lp
 * @date 2018/6/19
 */

public interface UnderTheLineView extends BaseView {

    void onGetDateSuccess(BaseModel<List<MBAInfo>> data);

    void onGetDataFail();
}
