package com.nd.abs.ui.module.main.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.nd.abs.R;
import com.nd.abs.ui.module.main.adpter.RecentCoursesAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

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
