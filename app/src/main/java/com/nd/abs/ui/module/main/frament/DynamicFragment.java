package com.nd.abs.ui.module.main.frament;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gyf.immersionbar.ImmersionBar;
import com.nd.abs.R;
import com.nd.abs.ui.module.main.adpter.FragmentsPagerAdapter;
import com.nd.abs.widget.CustomViewPager;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DynamicFragment extends BaseFragment {

    @BindView(R.id.tv_follow)
    TextView tv_follow;
    @BindView(R.id.tv_recommend)
    TextView tv_recommend;
    @BindView(R.id.cViewPager)
    CustomViewPager cViewPager;

    private DynamicMainFragment dymicMainFragmentFollow;
    private DynamicMainFragment dymicMainFragmentRecommend;
    private HashMap<Integer, Fragment> fragmentHashMap;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dynamic, null);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init();

    }

    @Override
    protected void lazyLoad() {

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

        addFragmenInList();
        bindViewPage();
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

    /**
     * 往fragmentHashMap中添加 Fragment
     */
    private void addFragmenInList() {

        fragmentHashMap = new HashMap<>();
        dymicMainFragmentFollow = new DynamicMainFragment();
        dymicMainFragmentRecommend = new DynamicMainFragment();
        fragmentHashMap.put(0, dymicMainFragmentFollow);
        fragmentHashMap.put(1, dymicMainFragmentRecommend);
    }

    private void bindViewPage() {
        //是否滑动
        cViewPager.setPagingEnabled(true);
        cViewPager.setAdapter(new FragmentsPagerAdapter(getChildFragmentManager(), fragmentHashMap));
        cViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                changeTextItemColor(0);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @OnClick({R.id.tv_follow, R.id.tv_recommend})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_follow:
                cViewPager.setCurrentItem(0);
                changeTextItemColor(0);
                break;
            case R.id.tv_recommend:
                cViewPager.setCurrentItem(1);
                changeTextItemColor(1);
                break;
        }
    }

    private void changeTextItemColor(int type){
        if(type == 0){
            tv_follow.setTextColor(getContext().getResources().getColor(R.color.black_33));
            tv_recommend.setTextColor(getContext().getResources().getColor(R.color.gray_99));
        }  else{
            tv_follow.setTextColor(getContext().getResources().getColor(R.color.gray_99));
            tv_recommend.setTextColor(getContext().getResources().getColor(R.color.black_33));
        }
    }

}
