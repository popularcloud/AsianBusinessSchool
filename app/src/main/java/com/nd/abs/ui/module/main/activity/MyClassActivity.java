package com.nd.abs.ui.module.main.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.nd.abs.R;
import com.nd.abs.base.BaseActivity;
import com.nd.abs.base.BaseModel;
import com.nd.abs.ui.module.main.adpter.MyClassAdapter;
import com.nd.abs.ui.module.main.bean.MyClassInfo;
import com.nd.abs.ui.module.main.present.MyClassPresenter;
import com.nd.abs.ui.module.main.view.MyClassView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 我的班级
 */
public class MyClassActivity extends BaseActivity<MyClassPresenter> implements MyClassView {


    @BindView(R.id.rv_data)
    RecyclerView rv_data;

    List<MyClassInfo> datas = new ArrayList<>();

    private MyClassAdapter followAdapter;

    @Override
    protected MyClassPresenter createPresenter() {
        return new MyClassPresenter(this);
    }

    @Override
    protected int getContentViewId(Bundle savedInstanceState) {
        return R.layout.activity_follow;
    }

    @Override
    protected void init() {
        setTitle("我的班级");

        initRecycleView();
    }

    @Override
    protected void initGetData() {

    }

    @Override
    protected void widgetListener() {

    }

    private void initRecycleView() {

        /*datas.add(new LearnPlanBean());
        datas.add(new LearnPlanBean());
        datas.add(new LearnPlanBean());
        datas.add(new LearnPlanBean());*/

        rv_data.setLayoutManager(new LinearLayoutManager(this));
        followAdapter = new MyClassAdapter(this,datas,R.layout.item_my_class);
        rv_data.setAdapter(followAdapter);

        mPresenter.getMyClass();
    }

    @Override
    public void onGetDateSuccess(BaseModel<List<MyClassInfo>> data) {
        if(data != null && data.getData() != null && data.getData().size() > 0){
            datas = data.getData();
            followAdapter.replaceAll(datas);
        }

    }

    @Override
    public void onGetDataFail() {

    }
}
