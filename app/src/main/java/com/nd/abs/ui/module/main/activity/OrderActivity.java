package com.nd.abs.ui.module.main.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.nd.abs.R;
import com.nd.abs.ui.module.main.adpter.FollowAdapter;
import com.nd.abs.ui.module.main.bean.LearnPlanBean;
import com.nd.abs.utils.BGARefreshLayoutUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import cn.bingoogolapple.refreshlayout.BGARefreshLayout;

/**
 * 关注与被关注
 */
public class OrderActivity extends BaseActivity{


    @BindView(R.id.rv_data)
    RecyclerView rv_data;
    @BindView(R.id.bl_refresh)
    BGARefreshLayout bl_refresh;

    List<LearnPlanBean> datas = new ArrayList<>();
    @Override
    protected int getContentViewId(Bundle savedInstanceState) {
        return R.layout.activity_order;
    }

    @Override
    protected void init() {
        setTitle("订单列表");

        initRecycleView();
    }

    @Override
    protected void initGetData() {

    }

    @Override
    protected void widgetListener() {

    }

    private void initRecycleView() {

        BGARefreshLayoutUtils.initRefreshLayout(this,bl_refresh,true);

        bl_refresh.setDelegate(new BGARefreshLayout.BGARefreshLayoutDelegate() {
            @Override
            public void onBGARefreshLayoutBeginRefreshing(BGARefreshLayout refreshLayout) {
                bl_refresh.endRefreshing();
            }

            @Override
            public boolean onBGARefreshLayoutBeginLoadingMore(BGARefreshLayout refreshLayout) {
                bl_refresh.endLoadingMore();
                return false;
            }
        });


        datas.add(new LearnPlanBean());
        datas.add(new LearnPlanBean());
        datas.add(new LearnPlanBean());
        datas.add(new LearnPlanBean());

        rv_data.setLayoutManager(new LinearLayoutManager(this));
        FollowAdapter followAdapter = new FollowAdapter(this,datas,R.layout.item_order);
        rv_data.setAdapter(followAdapter);
    }
}
