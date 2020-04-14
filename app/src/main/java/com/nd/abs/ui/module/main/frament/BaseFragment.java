package com.nd.abs.ui.module.main.frament;


import android.support.v4.app.Fragment;
import android.view.View;

import com.nd.abs.widget.MyTextView;


/**
 * activity的base类,用于基本数据的初始化
 *
 * @author yang
 */
public abstract class BaseFragment extends Fragment{

    public MyTextView txtActionbarTitle;

    protected boolean isVisible;

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (getUserVisibleHint()) {
            isVisible = true;
            onVisible();
        } else {
            isVisible = false;
            onInvisible();
        }
    }

    public void onVisible() {
        lazyLoad();
    }

    /**
     * 此方法在Base中已调用，在覆写的faragment中会执行，无需再调用一次
     */
    protected abstract void lazyLoad();

    /**
     * faragment隐藏时调用此方法
     */
    public void onInvisible() {
    }

    /**
     * 初始化view 和各种相关的数据
     */
    public abstract void init();

    /**
     * 初始化引擎
     */
    public abstract void initEngines(View view);

    /**
     * 获取Intent传过来的数据
     */
    public abstract void getIntentData();

    /**
     * 设置各种监听器
     */
    public abstract void setListener();

}
