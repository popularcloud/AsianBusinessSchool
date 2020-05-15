package com.nd.abs.ui.module.main.activity;

import android.os.Bundle;

import com.nd.abs.R;

public class SettingActivity extends BaseActivity{
    @Override
    protected int getContentViewId(Bundle savedInstanceState) {
        return R.layout.activity_setting;
    }

    @Override
    protected void init() {

        setTitle("设置");
    }

    @Override
    protected void initGetData() {

    }

    @Override
    protected void widgetListener() {

    }
}
