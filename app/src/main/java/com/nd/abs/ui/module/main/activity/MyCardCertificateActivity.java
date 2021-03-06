package com.nd.abs.ui.module.main.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.nd.abs.R;
import com.nd.abs.ui.module.main.adpter.FollowAdapter;
import com.nd.abs.ui.module.main.bean.LearnPlanBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 我的卡券
 */
public class MyCardCertificateActivity extends BaseActivity{


    @BindView(R.id.rv_data)
    RecyclerView rv_data;

    List<LearnPlanBean> datas = new ArrayList<>();
    @Override
    protected int getContentViewId(Bundle savedInstanceState) {
        return R.layout.activity_order;
    }

    @Override
    protected void init() {
        setTitle("我的卡券");
        setRight("获取更多卡券");
        initRecycleView();
    }

    @Override
    protected void initGetData() {

    }

    @Override
    protected void widgetListener() {

    }

    private void initRecycleView() {

        datas.add(new LearnPlanBean());
        datas.add(new LearnPlanBean());
        datas.add(new LearnPlanBean());
        datas.add(new LearnPlanBean());

        rv_data.setLayoutManager(new LinearLayoutManager(this));
        FollowAdapter followAdapter = new FollowAdapter(this,datas,R.layout.item_card_certificate);
        rv_data.setAdapter(followAdapter);
    }
}
