package com.nd.abs.ui.module.main.activity;

import android.os.Bundle;

import com.nd.abs.R;

public class PersonalMessageActivity extends BaseActivity{

    @Override
    protected int getContentViewId(Bundle savedInstanceState) {
        return R.layout.activity_personal_message;
    }

    @Override
    protected void init() {
        setTitle("个人信息");
    }

    @Override
    protected void initGetData() {

    }

    @Override
    protected void widgetListener() {

    }
}
