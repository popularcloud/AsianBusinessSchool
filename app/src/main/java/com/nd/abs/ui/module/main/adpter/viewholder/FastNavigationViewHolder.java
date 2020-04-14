package com.nd.abs.ui.module.main.adpter.viewholder;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;

import com.nd.abs.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FastNavigationViewHolder extends BaseViewHolder{

    //对话框
    private Dialog dialog;

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
    }

    @OnClick({R.id.ll_repairs,R.id.ll_meal,R.id.ll_integral,R.id.ll_lease})
    public void onBtnClick(View view){
        switch (view.getId()){
            case R.id.ll_repairs:
                break;
            case R.id.ll_meal:

                break;
            case R.id.ll_integral:

                break;
            case R.id.ll_lease:
                break;

        }
    }

}
