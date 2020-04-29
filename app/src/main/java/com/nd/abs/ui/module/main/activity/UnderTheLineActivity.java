package com.nd.abs.ui.module.main.activity;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.nd.abs.R;
import com.nd.abs.ui.module.main.adpter.RecentCoursesAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 *
 */
public class UnderTheLineActivity extends BaseActivity {


    @BindView(R.id.rv_data)
    RecyclerView rv_data;

    private List<String> datas = new ArrayList<>();

    @Override
    protected int getContentViewId(Bundle savedInstanceState) {
        return R.layout.activity_under_line;
    }

    @Override
    protected void init() {
        setTitle("终生学习俱乐部");

        initRecycleView();
    }

    @Override
    protected void initGetData() {

    }

    @Override
    protected void widgetListener() {

    }

    private void initRecycleView() {
        datas.add("");
        datas.add("");
        datas.add("");
        datas.add("");
        datas.add("");
        datas.add("");
        rv_data.setLayoutManager(new GridLayoutManager(this,2));
        rv_data.setAdapter(new RecentCoursesAdapter(this,datas,R.layout.item_recent_courses));
    }
}
