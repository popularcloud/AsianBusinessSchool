package com.nd.abs.ui.module.main.adpter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nd.abs.R;
import com.nd.abs.ui.module.main.adpter.viewholder.BaseViewHolder;
import com.nd.abs.ui.module.main.adpter.viewholder.DriedGoodViewHolder;
import com.nd.abs.ui.module.main.adpter.viewholder.FastNavigationViewHolder;
import com.nd.abs.ui.module.main.adpter.viewholder.ImageWheelViewHolder;
import com.nd.abs.ui.module.main.bean.ADInfo;

import java.util.ArrayList;
import java.util.List;

public class MainContentAdapter extends RecyclerView.Adapter {

    private Context mContext;
    private List<ADInfo> adInfos; //轮播图片集合


    public MainContentAdapter(Context context) {
        mContext = context;

        adInfos = new ArrayList<>();
        adInfos.add(new ADInfo());
        adInfos.add(new ADInfo());
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    /**
     * 设置轮播图数据
     */
    public void setImageWheelData(List<ADInfo> adInfos){
        this.adInfos = adInfos;
        notifyItemChanged(0);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View presentView;
        BaseViewHolder presentViewHolder = null;
        switch (viewType){
            case 0:
             presentView = LayoutInflater.from(mContext).inflate(R.layout.item_main_image_wheel,parent,false);
             presentViewHolder = new ImageWheelViewHolder(presentView);
             presentViewHolder.bindViewHolder(adInfos,mContext);
            break;
            case 1:
                presentView = LayoutInflater.from(mContext).inflate(R.layout.item_main_fast_navigation,parent,false);
                presentViewHolder = new FastNavigationViewHolder(presentView);
                presentViewHolder.bindViewHolder(null,mContext);
                break;
            case 2:
                presentView = LayoutInflater.from(mContext).inflate(R.layout.item_main_dried_good,parent,false);
                presentViewHolder = new DriedGoodViewHolder(presentView);
                presentViewHolder.bindViewHolder(null,mContext);
                break;
        }
        return presentViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        BaseViewHolder baseViewHolder = (BaseViewHolder) holder;
        /*switch (position) {
            case 0:
                if (adInfos != null && adInfos.size() > 0) {
                    baseViewHolder.itemView.getRootView().setVisibility(View.VISIBLE);
                    baseViewHolder.bindViewHolder(adInfos, mContext);
                } else {
          *//*          RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) baseViewHolder.itemView.getLayoutParams();
                    layoutParams.height = 0;
                    baseViewHolder.itemView.setLayoutParams(layoutParams);
                    baseViewHolder.itemView.getRootView().setVisibility(View.GONE);*//*
                }
                break;
            case 1:
                    baseViewHolder.itemView.getRootView().setVisibility(View.VISIBLE);
                    baseViewHolder.bindViewHolder(noticeBeanList, mContext);
                break;
            case 2:
                if (repairsList != null && repairsList.size() > 0) {
                    baseViewHolder.itemView.getRootView().setVisibility(View.VISIBLE);
                    baseViewHolder.bindViewHolder(repairsList, mContext);
                } else {
                *//*    RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) baseViewHolder.itemView.getLayoutParams();
                    layoutParams.height = 0;
                    baseViewHolder.itemView.setLayoutParams(layoutParams);
                    baseViewHolder.itemView.getRootView().setVisibility(View.GONE);*//*
                }
                break;
            case 3:
                if (leaseTypeData != null && leaseTypeData.size() > 0) {
                    baseViewHolder.bindViewHolder(leaseTypeData, mContext);

                    RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) baseViewHolder.itemView.getLayoutParams();
                    layoutParams.height = RecyclerView.LayoutParams.WRAP_CONTENT;
                    baseViewHolder.itemView.setLayoutParams(layoutParams);
                    baseViewHolder.itemView.getRootView().setVisibility(View.VISIBLE);
                } else {
                    RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) baseViewHolder.itemView.getLayoutParams();
                    layoutParams.height = 0;
                    baseViewHolder.itemView.setLayoutParams(layoutParams);
                    baseViewHolder.itemView.getRootView().setVisibility(View.GONE);
                }
                break;
            case 4:
                if (indexAdBeanList != null && indexAdBeanList.size() > 0) {
                    baseViewHolder.bindViewHolder(indexAdBeanList, mContext);
                    RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) baseViewHolder.itemView.getLayoutParams();
                    layoutParams.height = RecyclerView.LayoutParams.WRAP_CONTENT;
                    baseViewHolder.itemView.setLayoutParams(layoutParams);
                    baseViewHolder.itemView.getRootView().setVisibility(View.VISIBLE);
                }else{
                    RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) baseViewHolder.itemView.getLayoutParams();
                    layoutParams.height = 0;
                    baseViewHolder.itemView.setLayoutParams(layoutParams);
                    baseViewHolder.itemView.getRootView().setVisibility(View.GONE);
                }
                break;
            case 5:
                if (packageBeanList != null && packageBeanList.size() > 0) {
                    baseViewHolder.bindViewHolder(packageBeanList, mContext);
                    RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) baseViewHolder.itemView.getLayoutParams();
                    layoutParams.height = RecyclerView.LayoutParams.WRAP_CONTENT;
                    baseViewHolder.itemView.setLayoutParams(layoutParams);
                    baseViewHolder.itemView.getRootView().setVisibility(View.VISIBLE);
                } else {
                    RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) baseViewHolder.itemView.getLayoutParams();
                    layoutParams.height = 0;
                    baseViewHolder.itemView.setLayoutParams(layoutParams);
                    baseViewHolder.itemView.getRootView().setVisibility(View.GONE);
                }
                break;
        }*/
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
