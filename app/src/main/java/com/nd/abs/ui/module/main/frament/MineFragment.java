package com.nd.abs.ui.module.main.frament;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gyf.immersionbar.ImmersionBar;
import com.nd.abs.R;
import com.nd.abs.ui.module.main.activity.PersonalMessageActivity;
import com.nd.abs.utils.IntentUtil;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MineFragment extends BaseFragment{


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mine, null);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if(isVisibleToUser && getActivity() != null){
            ImmersionBar.with(getActivity())
                    .statusBarColor(R.color.btn_blue_d5)
                    .statusBarDarkFont(true)
                    .navigationBarColor(R.color.white).init();
        }
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

    }

    @OnClick({R.id.iv_header})
    public void onBtnClick(View view){
        switch (view.getId()){
            case R.id.iv_header:
                IntentUtil.gotoActivity(getActivity(), PersonalMessageActivity.class);
            break;
        }
    }
}
