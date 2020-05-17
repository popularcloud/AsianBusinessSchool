package com.nd.abs.ui.module.main.activity;

import android.os.Bundle;

import com.nd.abs.R;
import com.nd.abs.ui.module.main.bean.LearnPlanBean;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class MallDetailActivity extends BaseActivity{

    List<LearnPlanBean> datas = new ArrayList<>();

    @Override
    protected int getContentViewId(Bundle savedInstanceState) {
        return R.layout.activity_mall_detail;
    }

    @Override
    protected void init() {
        setTitle("商品详情");
        initRecycleView();
    }

    @Override
    protected void initGetData() {

    }

    @Override
    protected void widgetListener() {

    }

    private void initRecycleView() {

    }
}
