package com.nd.abs.ui.module.main.adpter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.nd.abs.R;
import com.nd.abs.ui.module.main.bean.LearnPlanBean;

import org.byteam.superadapter.SuperAdapter;
import org.byteam.superadapter.SuperViewHolder;

import java.util.List;

public class AdjustPlanAdapter extends SuperAdapter<LearnPlanBean> {

    private Context context;
    private int type;
    public AdjustPlanAdapter(Context context, List<LearnPlanBean> items, int layoutResId,int type) {
        super(context, items, layoutResId);
        this.context = context;
        this.type = type;
    }

    @Override
    public void onBind(SuperViewHolder holder, int viewType, int layoutPosition, LearnPlanBean item) {

        TextView btn01 = holder.itemView.findViewById(R.id.tv_btn01);
        TextView btn02 = holder.itemView.findViewById(R.id.tv_btn02);


        if(type == 0){

        }else{
            btn01.setVisibility(View.GONE);
            btn02.setText("加入");
        }

    }
}
