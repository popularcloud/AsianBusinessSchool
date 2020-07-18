package com.nd.abs.ui.module.main.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.nd.abs.R;
import com.nd.abs.ui.module.main.adpter.RecentCoursesAdapter;
import com.nd.abs.ui.module.main.bean.MBAInfo;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 直播课
 */
public class LiveClassActivity extends BaseActivity{

    @BindView(R.id.rv_main_content)
    RecyclerView rv_main_content;


    private List<MBAInfo> datas = new ArrayList<>();

    @Override
    protected int getContentViewId(Bundle savedInstanceState) {
        return R.layout.activity_major_courses;
    }

    @Override
    protected void init() {

        setTitle("直播");
        rv_main_content.setLayoutManager(new LinearLayoutManager(this));
        rv_main_content.setAdapter(new RecentCoursesAdapter(this,datas,R.layout.item_live_class));
    }

    @Override
    protected void initGetData() {

    }

    @Override
    protected void widgetListener() {

    }
}
