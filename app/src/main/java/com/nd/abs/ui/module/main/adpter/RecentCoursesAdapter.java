package com.nd.abs.ui.module.main.adpter;

import android.content.Context;
import android.widget.ImageView;

import com.nd.abs.R;
import com.nd.abs.ui.module.main.bean.MBAInfo;
import com.nd.abs.utils.ImageLoaderUtil;

import org.byteam.superadapter.SuperAdapter;
import org.byteam.superadapter.SuperViewHolder;

import java.util.List;

public class RecentCoursesAdapter extends SuperAdapter<MBAInfo> {

    private Context context;
    private int pageType = 0;
    public RecentCoursesAdapter(Context context, List<MBAInfo> items, int layoutResId) {
        super(context, items, layoutResId);
        this.context = context;
    }

    @Override
    public void onBind(SuperViewHolder holder, int viewType, int layoutPosition, MBAInfo item) {

        ImageView iv_header = holder.itemView.findViewById(R.id.iv_header);
        ImageLoaderUtil.getInstance().displayFromNet(context,item.getPicturePath(),iv_header);

        holder.setText(R.id.tv_title,item.getCreateUser());
        holder.setText(R.id.tv_spece,item.getLastUpdatedTxStamp());
    }
}
