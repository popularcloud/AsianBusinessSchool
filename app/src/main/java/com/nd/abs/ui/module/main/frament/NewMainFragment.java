package com.nd.abs.ui.module.main.frament;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.gyf.immersionbar.ImmersionBar;
import com.nd.abs.R;
import com.nd.abs.ui.module.main.adpter.MainContentAdapter;
import com.nd.abs.ui.module.main.bean.ADInfo;
import com.nd.abs.utils.BGARefreshLayoutUtils;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.bingoogolapple.refreshlayout.BGARefreshLayout;

public class NewMainFragment extends BaseFragment {


    @BindView(R.id.rv_main_content)
    RecyclerView rv_main_content;
    @BindView(R.id.mBGARefreshLayout)
    BGARefreshLayout mBGARefreshLayout;

    @BindView(R.id.img_back)
    ImageView img_back;

    int scrollDistance = 0;

    private MainContentAdapter mainContentAdapter;
    /**
     * 轮播图片集合
     */
    private ArrayList<ADInfo> infos;



    private Dialog dialog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_new_main, null);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init();
        if(getActivity() != null){
        }
    }

    @Override
    protected void lazyLoad() {
        if(getActivity() != null){

        }
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if(isVisibleToUser && getActivity() != null){
            ImmersionBar.with(getActivity())
                    .statusBarColor(R.color.white)
                    .statusBarDarkFont(true)
                    .navigationBarColor(R.color.white).init();
        }
    }


    @Override
    public void init() {
        initRecycleView();
    }

    /**
     * 初始化列表
     */
    private void initRecycleView() {
        BGARefreshLayoutUtils.initRefreshLayout(getContext(), mBGARefreshLayout, false);
        rv_main_content.setLayoutManager(new LinearLayoutManager(getContext()));
        rv_main_content.setItemViewCacheSize(6);
        mainContentAdapter = new MainContentAdapter(getContext());
        rv_main_content.setAdapter(mainContentAdapter);

        mBGARefreshLayout.setDelegate(new BGARefreshLayout.BGARefreshLayoutDelegate() {
            @Override
            public void onBGARefreshLayoutBeginRefreshing(BGARefreshLayout refreshLayout) {
                getWheelPic();
                mBGARefreshLayout.endRefreshing();
            }

            @Override
            public boolean onBGARefreshLayoutBeginLoadingMore(BGARefreshLayout refreshLayout) {
                return true;
            }
        });

        mBGARefreshLayout.beginRefreshing();

    }

    @Override
    public void initEngines(View view) {

    }

    @Override
    public void getIntentData() {

    }

    @Override
    public void setListener() {

    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    /**
     * 获取轮播图
     */
    public void getWheelPic() {

    }

    /**
     * 获取所有维修类型
     */
    public void getARepairType(){

    }


    /**
     * 获取租赁设备类型
     */
    public void getLeaseType() {

    }




    /**
     * 初始化状态栏
     */
   /* private void initStatusBar() {
        rv_main_content.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                scrollDistance = scrollDistance+dy;

               // Log.d("联网成功","scrollDistance===="+scrollDistance);
                    if(scrollDistance >= 88){
                        if(rl_title.getVisibility() == View.GONE){
                            rl_title.setVisibility(View.VISIBLE);
                            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) rl_title.getLayoutParams();
                            layoutParams.topMargin = DisplayUtil.getStatusBarHeight(getContext());
                            rl_title.setLayoutParams(layoutParams);

                            txtActionbarTitle.setText("首页");
                            img_back.setVisibility(View.GONE);
                            ImmersionBar.with(getActivity())
                                    .statusBarColor(R.color.white)
                                    .statusBarDarkFont(true)
                                    .navigationBarColor(R.color.white).init();
                        }

                    }else{
                        if(rl_title.getVisibility() == View.VISIBLE) {
                            rl_title.setVisibility(View.GONE);
                            ImmersionBar.with(getActivity())
                                    .transparentStatusBar()
                                    .statusBarDarkFont(false)
                                    .init();
                        }
                    }
            }
        });


        *//**
         * 切换时状态栏
         *//*
        if(scrollDistance >= 88){
            rl_title.setVisibility(View.VISIBLE);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) rl_title.getLayoutParams();
            layoutParams.topMargin = DisplayUtil.getStatusBarHeight(getContext());
            rl_title.setLayoutParams(layoutParams);

            txtActionbarTitle.setText("首页");
            img_back.setVisibility(View.GONE);
            ImmersionBar.with(getActivity())
                    .statusBarColor(R.color.white)
                    .statusBarDarkFont(true)
                    .navigationBarColor(R.color.white).init();
        }else{
            rl_title.setVisibility(View.GONE);
            ImmersionBar.with(getActivity())
                    .transparentStatusBar()
                    .statusBarDarkFont(false)
                    .init();
        }
    }*/
}
