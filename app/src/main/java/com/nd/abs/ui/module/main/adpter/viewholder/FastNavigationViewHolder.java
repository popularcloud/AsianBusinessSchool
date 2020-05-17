package com.nd.abs.ui.module.main.adpter.viewholder;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;

import com.nd.abs.R;
import com.nd.abs.ui.module.main.activity.EntertainmentActivity;
import com.nd.abs.ui.module.main.activity.LiveClassActivity;
import com.nd.abs.ui.module.main.activity.MallActivity;
import com.nd.abs.ui.module.main.activity.UnderTheLineActivity;
import com.nd.abs.utils.IntentUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FastNavigationViewHolder extends BaseViewHolder{

    //对话框
    private Dialog dialog;

    private Context context;
    //轮播通知
    @BindView(R.id.ll_gb)
    LinearLayout ll_gb;

    //滚动通知是否滚动
    private boolean IS_NOTICE_START = false;
    private int number = 0;

    public FastNavigationViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }

    @Override
    public void bindViewHolder(Object data, Context context) {
        this.context = context;
    }

    @OnClick({R.id.ll_repairs,R.id.ll_meal,R.id.ll_integral,R.id.ll_lease})
    public void onBtnClick(View view){
        switch (view.getId()){
            case R.id.ll_repairs:

                IntentUtil.gotoActivity(context, UnderTheLineActivity.class);
                break;
            case R.id.ll_meal:
                IntentUtil.gotoActivity(context, MallActivity.class);
                break;
            case R.id.ll_integral:
                IntentUtil.gotoActivity(context, LiveClassActivity.class);
                break;
            case R.id.ll_lease:
                IntentUtil.gotoActivity(context, EntertainmentActivity.class);
                break;

        }
    }

}
