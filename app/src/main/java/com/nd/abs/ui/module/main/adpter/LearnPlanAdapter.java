package com.nd.abs.ui.module.main.adpter;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;


import com.nd.abs.ui.module.main.bean.LearnPlanBean;

import org.byteam.superadapter.SuperAdapter;
import org.byteam.superadapter.SuperViewHolder;

import java.util.List;

public class LearnPlanAdapter extends SuperAdapter<LearnPlanBean> {

    private Context context;
    public LearnPlanAdapter(Context context, List<LearnPlanBean> items, int layoutResId) {
        super(context, items, layoutResId);
        this.context = context;
    }

    @Override
    public void onBind(SuperViewHolder holder, int viewType, int layoutPosition, LearnPlanBean item) {

    }
}
