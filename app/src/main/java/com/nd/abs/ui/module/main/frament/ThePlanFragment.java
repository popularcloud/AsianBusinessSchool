package com.nd.abs.ui.module.main.frament;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.gyf.immersionbar.ImmersionBar;
import com.nd.abs.R;
import com.nd.abs.ui.module.main.adpter.FragmentsPagerAdapter;
import com.nd.abs.widget.CustomViewPager;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ThePlanFragment extends BaseFragment {

    @BindView(R.id.txtActionbarTitle)
    TextView txtActionbarTitle;
    @BindView(R.id.img_back)
    ImageView imgBack;
    @BindView(R.id.imgRight)
    ImageView imgRight;
    @BindView(R.id.rBtnUnderway)
    RadioButton rBtnUnderway;
    @BindView(R.id.rBtnFinish)
    RadioButton rBtnFinish;
    @BindView(R.id.viewLine1)
    View viewLine1;
    @BindView(R.id.viewLine3)
    View viewLine3;
    @BindView(R.id.cViewPager)
    CustomViewPager cViewPager;
    private HashMap rButtonHashMap;
    private HashMap<Integer, Fragment> fragmentHashMap;

    private LearnPlanFragment learnPlanFragment;
    private AdjustmentPlanFragment adjustmentPlanFragment;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_this_plan, null);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init();
        txtActionbarTitle.setText("学习计划");
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
                    .statusBarDarkFont(true).init();
        }
    }

    @Override
    public void init() {

        addFragmenInList();
        addRadioButtonIdInList();
        bindViewPage(fragmentHashMap);
        cViewPager.setCurrentItem(0, false);
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



    @OnClick({R.id.rBtnUnderway, R.id.rBtnFinish})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rBtnUnderway:
                showLineView(1);
                cViewPager.setCurrentItem(0);
                break;
            case R.id.rBtnFinish:
                showLineView(2);
                cViewPager.setCurrentItem(1);
                break;
        }
    }

    /**
     * 往fragmentHashMap中添加 Fragment
     */
    private void addFragmenInList() {

        fragmentHashMap = new HashMap<>();
        learnPlanFragment = new LearnPlanFragment();
        adjustmentPlanFragment = new AdjustmentPlanFragment();
        fragmentHashMap.put(0, learnPlanFragment);
        fragmentHashMap.put(1, adjustmentPlanFragment);
    }

    /**
     * 往rButtonHashMap中添加 RadioButton Id
     */
    private void addRadioButtonIdInList() {
        rButtonHashMap = new HashMap<>();
        rButtonHashMap.put(0, rBtnUnderway);
        rButtonHashMap.put(1, rBtnFinish);
    }

    /**
     * 显示RadioButton线条
     *
     * @param num 1 ： 显示已发布下的线条  2 ： 显示未完成下的线条  3： 显示已完成下的线条  。未选中的线条将会被隐藏
     */
    private void showLineView(int num) {

        switch (num) {
            case 1:
                viewLine1.setVisibility(View.VISIBLE);
                viewLine3.setVisibility(View.INVISIBLE);
                break;
            case 2:
                viewLine3.setVisibility(View.VISIBLE);
                viewLine1.setVisibility(View.INVISIBLE);
                break;
        }
    }

    private void bindViewPage(HashMap<Integer, Fragment> fragmentList) {
        //是否滑动
        cViewPager.setPagingEnabled(true);
        cViewPager.setAdapter(new FragmentsPagerAdapter(getChildFragmentManager(), fragmentList));
        cViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                cViewPager.setChecked(rButtonHashMap, position);
                showLineView(position + 1);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
