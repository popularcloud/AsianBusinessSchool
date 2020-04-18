package com.nd.abs.ui.module.main.frament;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nd.abs.R;
import com.nd.abs.ui.module.main.adpter.LearnPlanAdapter;
import com.nd.abs.ui.module.main.bean.LearnPlanBean;
import com.nd.abs.utils.BGARefreshLayoutUtils;

import org.byteam.superadapter.OnItemClickListener;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.bingoogolapple.refreshlayout.BGARefreshLayout;

/**
 * @author 何栋
 * @version 1.0
 * @date 2017/3/9 18:01
 * @email 294663966@qq.com
 * 进行中
 */
public class LearnPlanFragment extends BaseFragment{

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.mBGARefreshLayout)
    BGARefreshLayout mBGARefreshLayout;
    private LearnPlanAdapter adapter;
    private List<LearnPlanBean> learnPlanBeans;
    //加载的page页
    private int page = 1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_learn_plan, null);
        ButterKnife.bind(this, view);
        BGARefreshLayoutUtils.initRefreshLayout(getContext(), mBGARefreshLayout);
        return view;
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initEngines(view);
        init();
        setListener();
        bindRecycleView();
    }

    @Override
    public void onResume() {
        super.onResume();
        mBGARefreshLayout.beginRefreshing();  //请求网络数据
    }

    private void bindRecycleView() {

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new LearnPlanAdapter(getContext(), learnPlanBeans, R.layout.item_learn_plan);
        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View itemView, int viewType, int position) {

            }
        });
        recyclerView.setAdapter(adapter);
    }


    @Override
    protected void lazyLoad() {

    }

    @Override
    public void init() {
    }

    @Override
    public void initEngines(View view) {
    }

    @Override
    public void getIntentData() {

    }

    @Override
    public void setListener() {

        //刷新控件监听器
        mBGARefreshLayout.setDelegate(new BGARefreshLayout.BGARefreshLayoutDelegate() {
            @Override
            public void onBGARefreshLayoutBeginRefreshing(BGARefreshLayout refreshLayout) {
                page = 1;
               // presenter.getOrders(1, 1);
            }

            @Override
            public boolean onBGARefreshLayoutBeginLoadingMore(BGARefreshLayout refreshLayout) {
                page++;
               // presenter.loadOrders(page, 1);
                return true;
            }
        });
    }
}
