package com.nd.abs.ui.module.main.adpter;

import android.content.Context;

import com.nd.abs.ui.module.main.bean.LearnPlanBean;
import com.nd.abs.ui.module.main.bean.MyClassInfo;

import org.byteam.superadapter.SuperAdapter;
import org.byteam.superadapter.SuperViewHolder;

import java.util.List;

public class MyClassAdapter extends SuperAdapter<MyClassInfo> {

    private Context context;
    public MyClassAdapter(Context context, List<MyClassInfo> items, int layoutResId) {
        super(context, items, layoutResId);
        this.context = context;
    }

    @Override
    public void onBind(SuperViewHolder holder, int viewType, int layoutPosition, MyClassInfo item) {



    }
}
