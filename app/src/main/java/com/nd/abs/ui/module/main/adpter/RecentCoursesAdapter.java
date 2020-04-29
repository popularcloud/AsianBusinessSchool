package com.nd.abs.ui.module.main.adpter;

import android.content.Context;

import org.byteam.superadapter.SuperAdapter;
import org.byteam.superadapter.SuperViewHolder;

import java.util.List;

public class RecentCoursesAdapter extends SuperAdapter<String> {

    private Context context;
    private int pageType = 0;
    public RecentCoursesAdapter(Context context, List<String> items, int layoutResId) {
        super(context, items, layoutResId);
        this.context = context;
    }

    @Override
    public void onBind(SuperViewHolder holder, int viewType, int layoutPosition, String item) {

    }
}
