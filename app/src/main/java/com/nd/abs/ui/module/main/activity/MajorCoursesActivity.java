package com.nd.abs.ui.module.main.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.nd.abs.R;
import com.nd.abs.ui.module.main.adpter.RecentCoursesAdapter;
import com.nd.abs.ui.module.main.bean.MBAInfo;
import com.nd.abs.utils.IntentUtil;

import org.byteam.superadapter.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 主修课
 */
public class MajorCoursesActivity extends BaseActivity{

    @BindView(R.id.rv_main_content)
    RecyclerView rv_main_content;


    private List<MBAInfo> datas = new ArrayList<>();

    @Override
    protected int getContentViewId(Bundle savedInstanceState) {
        return R.layout.activity_major_courses;
    }

    @Override
    protected void init() {

        setTitle("主修课");
        rv_main_content.setLayoutManager(new LinearLayoutManager(this));
        RecentCoursesAdapter recentCoursesAdapter = new RecentCoursesAdapter(this,datas,R.layout.item_major_courses);
        rv_main_content.setAdapter(recentCoursesAdapter);

        recentCoursesAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View itemView, int viewType, int position) {
                IntentUtil.gotoActivity(MajorCoursesActivity.this,CoursesDetailActivity.class);
            }
        });
    }

    @Override
    protected void initGetData() {

    }

    @Override
    protected void widgetListener() {

    }
}
