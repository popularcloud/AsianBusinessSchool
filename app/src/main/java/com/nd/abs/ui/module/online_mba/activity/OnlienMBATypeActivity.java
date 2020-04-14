package com.nd.abs.ui.module.online_mba.activity;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.nd.abs.R;
import com.nd.abs.ui.module.main.activity.BaseActivity;

import butterknife.BindView;

public class OnlienMBATypeActivity extends BaseActivity {

    @BindView(R.id.main_left_rv)
    RecyclerView main_left_rv;
    @BindView(R.id.main_left_rv)
    RecyclerView main_right_rv;

    @Override
    protected int getContentViewId(Bundle savedInstanceState) {
        return R.layout.activity_online_mba_type;
    }

    @Override
    protected void init() {

    }

    @Override
    protected void initGetData() {

    }

    @Override
    protected void widgetListener() {

    }
}
