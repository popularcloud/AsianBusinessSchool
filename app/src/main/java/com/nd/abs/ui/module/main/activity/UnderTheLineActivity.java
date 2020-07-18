package com.nd.abs.ui.module.main.activity;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.nd.abs.R;
import com.nd.abs.base.BaseActivity;
import com.nd.abs.base.BaseModel;
import com.nd.abs.ui.module.main.adpter.RecentCoursesAdapter;
import com.nd.abs.ui.module.main.bean.MBAInfo;
import com.nd.abs.ui.module.main.present.UnderTheLinePresenter;
import com.nd.abs.ui.module.main.view.UnderTheLineView;
import com.nd.abs.utils.IntentUtil;

import org.byteam.superadapter.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 *
 */
public class UnderTheLineActivity extends BaseActivity<UnderTheLinePresenter> implements UnderTheLineView {


    @BindView(R.id.rv_data)
    RecyclerView rv_data;

    private List<MBAInfo> datas = new ArrayList<>();

    RecentCoursesAdapter recentCoursesAdapter;

    @Override
    protected UnderTheLinePresenter createPresenter() {
        return new UnderTheLinePresenter(this);
    }

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
        mPresenter.getMBA();
    }

    @Override
    protected void widgetListener() {

    }

    @OnClick({R.id.ll_major_courses,R.id.ll_leader_training_camp,R.id.ll_president_training_course,R.id.ll_private_council})
    public void onBtnClick(View view){
        switch (view.getId()){
            case R.id.ll_major_courses:
                IntentUtil.gotoActivity(this,MajorCoursesActivity.class);
                break;
            case R.id.ll_leader_training_camp:
                IntentUtil.gotoActivity(this,MajorCoursesActivity.class);
                break;
            case R.id.ll_president_training_course:
                IntentUtil.gotoActivity(this,MajorCoursesActivity.class);
                break;
            case R.id.ll_private_council:
                IntentUtil.gotoActivity(this,MajorCoursesActivity.class);
                break;
        }
    }

    private void initRecycleView() {
        rv_data.setLayoutManager(new GridLayoutManager(this,2));
        recentCoursesAdapter = new RecentCoursesAdapter(this,datas,R.layout.item_recent_courses);
        rv_data.setAdapter(recentCoursesAdapter);
        recentCoursesAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View itemView, int viewType, int position) {
                IntentUtil.gotoActivity(UnderTheLineActivity.this,CoursesDetailActivity.class);
            }
        });
    }

    @Override
    public void onGetDateSuccess(BaseModel<List<MBAInfo>> data) {
        if(data != null && data.getData() != null && data.getData().size() > 0){
            datas = data.getData();
            recentCoursesAdapter.replaceAll(datas);
        }
    }

    @Override
    public void onGetDataFail() {

    }

}
