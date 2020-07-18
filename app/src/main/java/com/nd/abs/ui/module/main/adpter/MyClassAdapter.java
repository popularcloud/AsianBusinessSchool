package com.nd.abs.ui.module.main.adpter;

import android.content.Context;

import com.nd.abs.R;
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

        holder.setText(R.id.tv_name,item.getUserName());
        holder.setText(R.id.tv_class_position,item.getClassPosition());
        holder.setText(R.id.tv_work_unit,item.getJobUnit());
        holder.setText(R.id.tv_post,item.getPosition());
        holder.setText(R.id.tv_phone,item.getContactNumber());

    }
}
