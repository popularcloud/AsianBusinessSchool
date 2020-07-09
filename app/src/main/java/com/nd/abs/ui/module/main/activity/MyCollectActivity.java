package com.nd.abs.ui.module.main.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.nd.abs.R;
import com.nd.abs.ui.module.main.adpter.FragmentsPagerAdapter;
import com.nd.abs.ui.module.main.frament.DownloadFragment;
import com.nd.abs.widget.CustomViewPager;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 下载
 */
public class MyCollectActivity extends BaseActivity{


    @BindView(R.id.cViewPager)
    CustomViewPager cViewPager;
    @BindView(R.id.img_back)
    ImageView img_back;
    @BindView(R.id.tv_course)
    TextView tv_course;
    @BindView(R.id.tv_good)
    TextView tv_good;
    @BindView(R.id.tv_dynamic)
    TextView tv_dynamic;

    private DownloadFragment downloadIngFragment;
    private DownloadFragment downloadedFragment;
    private DownloadFragment downloadedOtherFragment;
    private HashMap<Integer, Fragment> fragmentHashMap;

    @Override
    protected int getContentViewId(Bundle savedInstanceState) {
        return R.layout.activity_collect;
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
        downloadIngFragment = new DownloadFragment();
        downloadedFragment = new DownloadFragment();
        downloadedOtherFragment = new DownloadFragment();
        fragmentHashMap.put(0, downloadedFragment);
        fragmentHashMap.put(1, downloadIngFragment);
        fragmentHashMap.put(2, downloadedOtherFragment);
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

    @OnClick({R.id.tv_course, R.id.tv_good,R.id.tv_dynamic})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_course:
                cViewPager.setCurrentItem(0);
                changeTextItemColor(0);
                break;
            case R.id.tv_good:
                cViewPager.setCurrentItem(1);
                changeTextItemColor(1);
                break;
            case R.id.tv_dynamic:
                cViewPager.setCurrentItem(2);
                changeTextItemColor(2);
                break;
        }
    }

    private void changeTextItemColor(int type){
        if(type == 0){
            tv_course.setTextColor(getResources().getColor(R.color.btn_blue_d5));
            tv_good.setTextColor(getResources().getColor(R.color.gray_99));
            tv_dynamic.setTextColor(getResources().getColor(R.color.gray_99));
        }else if(type == 1){
            tv_good.setTextColor(getResources().getColor(R.color.btn_blue_d5));
            tv_dynamic.setTextColor(getResources().getColor(R.color.gray_99));
            tv_course.setTextColor(getResources().getColor(R.color.gray_99));
        }else{
            tv_dynamic.setTextColor(getResources().getColor(R.color.gray_99));
            tv_good.setTextColor(getResources().getColor(R.color.gray_99));
            tv_course.setTextColor(getResources().getColor(R.color.gray_99));
        }
    }
}
