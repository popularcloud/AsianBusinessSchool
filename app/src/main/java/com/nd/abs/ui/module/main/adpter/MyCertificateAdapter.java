package com.nd.abs.ui.module.main.adpter;

import android.content.Context;

import com.nd.abs.ui.module.main.bean.LearnPlanBean;
import com.nd.abs.ui.module.main.bean.MyCertificateBean;

import org.byteam.superadapter.SuperAdapter;
import org.byteam.superadapter.SuperViewHolder;

import java.util.List;

public class MyCertificateAdapter extends SuperAdapter<MyCertificateBean> {

    private Context context;
    public MyCertificateAdapter(Context context, List<MyCertificateBean> items, int layoutResId) {
        super(context, items, layoutResId);
        this.context = context;
    }

    @Override
    public void onBind(SuperViewHolder holder, int viewType, int layoutPosition, MyCertificateBean item) {

    }
}
