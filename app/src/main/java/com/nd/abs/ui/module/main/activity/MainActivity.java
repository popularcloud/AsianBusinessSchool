package com.nd.abs.ui.module.main.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

import com.gyf.immersionbar.ImmersionBar;
import com.nd.abs.R;
import com.nd.abs.ui.module.main.adpter.FragmentsPagerAdapter;
import com.nd.abs.ui.module.main.frament.DynamicFragment;
import com.nd.abs.ui.module.main.frament.LearnPlanFragment;
import com.nd.abs.ui.module.main.frament.MainFragment;
import com.nd.abs.ui.module.main.frament.MineFragment;
import com.nd.abs.ui.module.main.frament.NewMainFragment;
import com.nd.abs.ui.module.main.frament.OnLineMBAFragment;
import com.nd.abs.ui.module.main.frament.ThePlanFragment;
import com.nd.abs.widget.CustomViewPager;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 *
 */
public class MainActivity extends BaseFragmentActivity {

    @BindView(R.id.cViewPager)
    CustomViewPager cViewPager;
    @BindView(R.id.radio_home)
    RadioButton radioHome;
    @BindView(R.id.radio_mba)
    RadioButton radioMBA;
    @BindView(R.id.radio_order)
    RadioButton radioOrder;
    @BindView(R.id.radio_news)
    RadioButton radioNews;
    @BindView(R.id.radio_mine)
    RadioButton radioMine;
    @BindView(R.id.group_tab)
    RadioGroup groupTab;
    @BindView(R.id.my_content_view)
    RelativeLayout myContentView;


    /**
     * fragment相关
     */
    private HashMap<Integer, Fragment> fragmentHashMap;
    private HashMap rButtonHashMap;

    /**
     * 获取当前实例
     */
    public static MainActivity activity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        activity = this;

        initView();

        openDoubleClickToExit();

        addFragmenInList();
        addRadioButtonIdInList();

        bindViewPage(fragmentHashMap);

        cViewPager.setCurrentItem(0, false);
        radioHome.setChecked(true);
    }


    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    /**
     * 往rButtonHashMap中添加 RadioButton Id
     */
    private void addRadioButtonIdInList() {
        rButtonHashMap = new HashMap<>();
        rButtonHashMap.put(0, radioHome);
        rButtonHashMap.put(1, radioMBA);
        rButtonHashMap.put(2, radioNews);
        rButtonHashMap.put(3, radioOrder);
        rButtonHashMap.put(4, radioMine);
    }

    /**
     * 往fragmentHashMap中添加 Fragment
     */
    private void addFragmenInList() {
        fragmentHashMap = new HashMap<>();
        fragmentHashMap.put(0, new NewMainFragment());
        fragmentHashMap.put(1, new OnLineMBAFragment());
        fragmentHashMap.put(2, new DynamicFragment());
        fragmentHashMap.put(3, new ThePlanFragment());
        fragmentHashMap.put(4,new MineFragment());
    }

    private void bindViewPage(HashMap<Integer, Fragment> fragmentList) {
        //是否滑动
        cViewPager.setPagingEnabled(false);
        cViewPager.setOffscreenPageLimit(5);//最多缓存4个页面
        cViewPager.setAdapter(new FragmentsPagerAdapter(getSupportFragmentManager(), fragmentList));
        cViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                cViewPager.setChecked(rButtonHashMap, position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }



    @OnClick({R.id.radio_home, R.id.radio_order, R.id.radio_news, R.id.radio_mine,R.id.radio_mba})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.radio_home:
                cViewPager.setCurrentItem(0, false);
                break;
            case R.id.radio_mba:
                cViewPager.setCurrentItem(1, false);
                break;
            case R.id.radio_news:
                cViewPager.setCurrentItem(2, false);
                break;
            case R.id.radio_order:
                cViewPager.setCurrentItem(3, false);
                break;
            case R.id.radio_mine:
                cViewPager.setCurrentItem(4, false);
                break;
        }
    }

    @Override
    public void initView() {
        ImmersionBar.with(this)
                .statusBarColor(R.color.white)
                .statusBarDarkFont(true).init();
    }

    @Override
    public void initEngines() {
    }

    @Override
    public void getIntentData() {
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
