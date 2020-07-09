package com.nd.abs.ui.module.main.activity;

import android.os.Bundle;

import com.nd.abs.R;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class CoursesDetailActivity extends BaseActivity{

    private List<String> datas = new ArrayList<>();

    @Override
    protected int getContentViewId(Bundle savedInstanceState) {
        return R.layout.activity_courses_detail;
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
