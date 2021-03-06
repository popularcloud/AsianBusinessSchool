package com.nd.abs.ui.module.main.frament;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gyf.immersionbar.ImmersionBar;
import com.nd.abs.R;
import com.nd.abs.ui.module.main.activity.AuditionHistoryActivity;
import com.nd.abs.ui.module.main.activity.DownLoadActivity;
import com.nd.abs.ui.module.main.activity.FollowActivity;
import com.nd.abs.ui.module.main.activity.MyCardCertificateActivity;
import com.nd.abs.ui.module.main.activity.MyCertificateActivity;
import com.nd.abs.ui.module.main.activity.MyClassActivity;
import com.nd.abs.ui.module.main.activity.MyCollectActivity;
import com.nd.abs.ui.module.main.activity.OrderActivity;
import com.nd.abs.ui.module.main.activity.PersonalMessageActivity;
import com.nd.abs.ui.module.main.activity.SettingActivity;
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
                    .statusBarDarkFont(true).init();
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

    @OnClick({R.id.iv_header,R.id.iv_setting,R.id.tv_me_follow,R.id.tv_follow_me,R.id.tv_order,R.id.tv_cardCertificate
    ,R.id.tv_my_class,R.id.tv_my_certificate,R.id.tv_audition_record,R.id.tv_download,R.id.tv_collect})
    public void onBtnClick(View view){
        switch (view.getId()){
            case R.id.iv_header:
                IntentUtil.gotoActivity(getActivity(), PersonalMessageActivity.class);
            break;
            case R.id.iv_setting:
                IntentUtil.gotoActivity(getActivity(), SettingActivity.class);
            break;
            case R.id.tv_me_follow:
                IntentUtil.gotoActivity(getActivity(), FollowActivity.class);
            break;
            case R.id.tv_follow_me:
                IntentUtil.gotoActivity(getActivity(), FollowActivity.class);
            break;
            case R.id.tv_order:
                IntentUtil.gotoActivity(getActivity(), OrderActivity.class);
            break;
            case R.id.tv_cardCertificate:
                IntentUtil.gotoActivity(getActivity(), MyCardCertificateActivity.class);
            break;
            case R.id.tv_my_class:
                IntentUtil.gotoActivity(getActivity(), MyClassActivity.class);
                break;
            case R.id.tv_my_certificate:
                IntentUtil.gotoActivity(getActivity(), MyCertificateActivity.class);//StudentIdCard
                break;
            case R.id.tv_audition_record:
                IntentUtil.gotoActivity(getActivity(), AuditionHistoryActivity.class);
                break;
            case R.id.tv_download:
                IntentUtil.gotoActivity(getActivity(), DownLoadActivity.class);//StudentIdCard
                break;
            case R.id.tv_collect:
                IntentUtil.gotoActivity(getActivity(), MyCollectActivity.class);//StudentIdCard
                break;
        }
    }
}
