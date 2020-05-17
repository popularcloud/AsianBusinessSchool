package com.nd.abs.ui.module.main.activity;

import android.os.Bundle;

import com.nd.abs.R;
import com.nd.abs.ui.module.main.bean.LearnPlanBean;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class ListenAudioActivity extends BaseActivity{

    List<LearnPlanBean> datas = new ArrayList<>();
    @Override
    protected int getContentViewId(Bundle savedInstanceState) {
        return R.layout.activity_listen_audio;
    }

    @Override
    protected void init() {
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
