package com.nd.abs.ui.module.main.adpter.viewholder;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.nd.abs.R;
import com.nd.abs.ui.module.main.activity.MainActivity;
import com.nd.abs.ui.module.main.bean.ADInfo;
import com.nd.abs.utils.ImageLoaderUtil;
import com.nd.abs.widget.ImageCycleView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ImageWheelViewHolder extends BaseViewHolder{

    @BindView(R.id.ad_view)
    ImageCycleView mAdView;

    public ImageWheelViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }

    @Override
    public void bindViewHolder(Object data, Context context) {
        ArrayList<ADInfo> adInfos = (ArrayList<ADInfo>) data;
        mAdView.setImageResources(adInfos, mAdCycleViewListener);
        mAdView.startImageCycle();
    }


    private ImageCycleView.ImageCycleViewListener mAdCycleViewListener = new ImageCycleView.ImageCycleViewListener() {
        @Override
        public void onImageClick(ADInfo info, int position, View imageView) {
        }

        @Override
        public void displayImage(final String imageURL, final ImageView imageView) {
            ImageLoaderUtil.getInstance().displayFromNetD(MainActivity.activity, imageURL, imageView,R.mipmap.image_default_picture);// 使用ImageLoader对图片进行加装！
        }
    };
}
