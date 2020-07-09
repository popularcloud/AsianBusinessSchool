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
import com.nd.abs.base.BaseFragment;
import com.nd.abs.base.BaseModel;
import com.nd.abs.ui.module.main.adpter.MainContentAdapter;
import com.nd.abs.ui.module.main.bean.ADInfo;
import com.nd.abs.ui.module.main.bean.BannerInfo;
import com.nd.abs.ui.module.main.present.MainFragementPresenter;
import com.nd.abs.ui.module.main.view.MainFragmentView;
import com.nd.abs.utils.BGARefreshLayoutUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.bingoogolapple.refreshlayout.BGARefreshLayout;

public class NewMainFragment extends BaseFragment<MainFragementPresenter> implements MainFragmentView {


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

        mPresenter = createPresenter();
        initRecycleView();
        img_back.setVisibility(View.GONE);
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if(isVisibleToUser && getActivity() != null){
            ImmersionBar.with(getActivity())
                    .statusBarColor(R.color.white)
                    .statusBarDarkFont(true).init();
        }
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
        mPresenter.getBanner();
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

    @Override
    protected MainFragementPresenter createPresenter() {
        return new MainFragementPresenter(this);
    }

    @Override
    public void onGetBannerSuccess(BaseModel<List<BannerInfo>> data) {
        if(data != null && data.getData() != null && data.getData().size() > 0){

            List<ADInfo> adInfos = new ArrayList<>();
            for(int i = 0; i < data.getData().size(); i ++){
                ADInfo adInfo = new ADInfo();
                adInfo.setAdvertisingImageUrl(data.getData().get(i).getSlideshowUrl());
                adInfo.setAdvertisingTitle("title");
                //adInfo.setAdvertisingId();
                adInfos.add(adInfo);
            }
            if(mainContentAdapter != null){
                mainContentAdapter.setImageWheelData(adInfos);
            }
        }

    }

    @Override
    public void onGetDataFail() {

    }
}
