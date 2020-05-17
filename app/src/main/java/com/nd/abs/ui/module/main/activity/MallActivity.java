package com.nd.abs.ui.module.main.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;

import com.nd.abs.R;
import com.nd.abs.ui.module.main.adpter.FragmentsPagerAdapter;
import com.nd.abs.ui.module.main.frament.MallMainFragment;
import com.nd.abs.widget.CustomViewPager;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 校友商城
 */
public class MallActivity extends BaseActivity{


    @BindView(R.id.tv_new)
    TextView tv_new;
    @BindView(R.id.tv_entity)
    TextView tv_entity;
    @BindView(R.id.tv_virtualization)
    TextView tv_virtualization;
    @BindView(R.id.cViewPager)
    CustomViewPager cViewPager;

    private MallMainFragment mallMainFragment01;
    private MallMainFragment mallMainFragment02;
    private MallMainFragment mallMainFragment03;

    private HashMap<Integer, Fragment> fragmentHashMap;


    @Override
    protected int getContentViewId(Bundle savedInstanceState) {
        return R.layout.activity_mall;
    }

    @Override
    protected void init() {
        addFragmenInList();
        bindViewPage();
    }

    @Override
    protected void initGetData() {

    }

    @Override
    protected void widgetListener() {

    }

    /**
     * 往fragmentHashMap中添加 Fragment
     */
    private void addFragmenInList() {

        fragmentHashMap = new HashMap<>();
        mallMainFragment01 = new MallMainFragment();
        mallMainFragment02 = new MallMainFragment();
        mallMainFragment03 = new MallMainFragment();
        fragmentHashMap.put(0, mallMainFragment01);
        fragmentHashMap.put(1, mallMainFragment02);
        fragmentHashMap.put(2, mallMainFragment03);
    }

    private void bindViewPage() {
        //是否滑动
        cViewPager.setPagingEnabled(true);
        cViewPager.setAdapter(new FragmentsPagerAdapter(getSupportFragmentManager(), fragmentHashMap));
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

    @OnClick({R.id.tv_new, R.id.tv_entity,R.id.tv_virtualization})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_new:
                cViewPager.setCurrentItem(0);
                changeTextItemColor(0);
                break;
            case R.id.tv_entity:
                cViewPager.setCurrentItem(1);
                changeTextItemColor(1);
                break;
            case R.id.tv_virtualization:
                cViewPager.setCurrentItem(2);
                changeTextItemColor(2);
                break;
        }
    }

    private void changeTextItemColor(int type){
        if(type == 0){
            tv_new.setTextColor(getResources().getColor(R.color.black_33));
            tv_entity.setTextColor(getResources().getColor(R.color.gray_99));
            tv_virtualization.setTextColor(getResources().getColor(R.color.gray_99));
        }  else if(type == 1){
            tv_new.setTextColor(getResources().getColor(R.color.gray_99));
            tv_entity.setTextColor(getResources().getColor(R.color.black_33));
            tv_virtualization.setTextColor(getResources().getColor(R.color.gray_99));
        }else{
            tv_new.setTextColor(getResources().getColor(R.color.gray_99));
            tv_entity.setTextColor(getResources().getColor(R.color.gray_99));
            tv_virtualization.setTextColor(getResources().getColor(R.color.black_33));
        }
    }


}
