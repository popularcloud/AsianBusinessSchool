package com.nd.abs.ui.module.online_mba.activity;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ExpandableListView;

import com.nd.abs.R;
import com.nd.abs.ui.module.main.activity.BaseActivity;
import com.nd.abs.ui.module.online_mba.adapter.LeftTypeAdapter;
import com.nd.abs.ui.module.online_mba.adapter.RightGoodsAdapter;
import com.nd.abs.ui.module.online_mba.bean.LeaseLeftBean;
import com.nd.abs.ui.module.online_mba.bean.LeaseRightBean;
import com.nd.abs.ui.module.online_mba.bean.LeftTypeBean;

import org.byteam.superadapter.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class OnlienMBATypeActivity extends BaseActivity {

    @BindView(R.id.rv_left_menu)
    RecyclerView rv_left_menu;
    @BindView(R.id.rv_right_goods)
    RecyclerView rv_right_goods;


    private List<LeaseLeftBean> leaseLeftBeans;
    private List<LeaseRightBean> leaseRightBeans;

    @Override
    protected int getContentViewId(Bundle savedInstanceState) {
        return R.layout.activity_online_mba_type;
    }

    @Override
    protected void init() {

        //rv_left_menu.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    protected void initGetData() {

        initLeftRecyclerView();
        initRightRecyclerView();

    }

    @Override
    protected void widgetListener() {

    }


    private void initLeftRecyclerView() {
        leaseLeftBeans = new ArrayList<>();
        leaseLeftBeans.add(new LeaseLeftBean(1,"推荐分类",true));
        leaseLeftBeans.add(new LeaseLeftBean(2,"电脑",false));
        leaseLeftBeans.add(new LeaseLeftBean(3,"显示器",false));
        leaseLeftBeans.add(new LeaseLeftBean(4,"打印机",false));

        final LeftTypeAdapter leftTypeAdapter = new LeftTypeAdapter(this,leaseLeftBeans,R.layout.item_lease_left_menu);
        rv_left_menu.setLayoutManager(new LinearLayoutManager(this));
        rv_left_menu.setAdapter(leftTypeAdapter);

        leftTypeAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View itemView, int viewType, int position) {
                leftTypeAdapter.setSelectPos(position);
                leftTypeAdapter.notifyDataSetChanged();
            }
        });
    }

    private void initRightRecyclerView() {

        leaseRightBeans = new ArrayList<>();
        leaseRightBeans.add(new LeaseRightBean(1,"笔记本","1"));
        leaseRightBeans.add(new LeaseRightBean(2,"台式","1"));
        leaseRightBeans.add(new LeaseRightBean(3,"主机","1"));
        leaseRightBeans.add(new LeaseRightBean(4,"平板电脑","1"));

        final RightGoodsAdapter rightGoodsAdapter = new RightGoodsAdapter(this,leaseRightBeans,R.layout.item_lease_right_goods);
        rv_right_goods.setLayoutManager(new LinearLayoutManager(OnlienMBATypeActivity.this));
        rv_right_goods.setAdapter(rightGoodsAdapter);

        rightGoodsAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View itemView, int viewType, int position) {
                //IntentUtil.gotoActivity(getActivity(), LeaseGoodsListActivity.class);
            }
        });
    }
}
