package com.nd.abs.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;

import java.io.File;

/**
 * 图片加载的引擎
 *
 * Created by 何栋 on 2017/10/15.
 * 294663966@qq.com
 */
public class ImageLoaderUtil implements ImageLoaderInterface {

    private static ImageLoaderUtil loader = null;

    public static ImageLoaderUtil getInstance() {
        if (loader == null) {
            synchronized (ImageLoaderUtil.class) {
                if (loader == null)
                    loader = new ImageLoaderUtil();
            }
        }
        return loader;
    }
    public void displayFromNetD(Context context, String url, ImageView imageView) {
        if (context != null && imageView != null) {
            RequestOptions mRequestOptions = RequestOptions.fitCenterTransform()
                    .fitCenter()
                    .diskCacheStrategy(DiskCacheStrategy.NONE)//不做磁盘缓存
                    .skipMemoryCache(true);//不做内存缓存
            Glide.with(context).load(url)
                    .thumbnail(0.8f)
                    .apply(mRequestOptions)
                    .into(imageView);
        }
    }

    public void displayFromNetD(Context context, String url, ImageView imageView, int defaultImg) {
        if (context != null && imageView != null) {
            RequestOptions mRequestOptions = RequestOptions.fitCenterTransform()
                    .fitCenter()
                    .error(defaultImg)
                    .diskCacheStrategy(DiskCacheStrategy.NONE)//不做磁盘缓存
                    .skipMemoryCache(true);//不做内存缓存
            Glide.with(context).load(url)
                    .thumbnail(0.8f)
                    .apply(mRequestOptions)
                    .into(imageView);
        }
    }
    @Override
    public void displayFromNet(Context context, String url, ImageView imageView) {
        if (context != null && imageView != null) {
            RequestOptions mRequestOptions = RequestOptions.fitCenterTransform()
                    .override(140,140)
                    .fitCenter()
                    .diskCacheStrategy(DiskCacheStrategy.NONE)//不做磁盘缓存
                    .skipMemoryCache(true);//不做内存缓存
            Glide.with(context).load(url)
                    .apply(mRequestOptions)
                    .thumbnail(0.5f)
                    .into(imageView);
        }
    }

    public void displayFromNet(Context context, String url, ImageView imageView, int defaultImg) {
        if (context != null && imageView != null) {
            RequestOptions mRequestOptions = RequestOptions.fitCenterTransform()
                    .override(140,140)
                    .fitCenter()
                    .error(defaultImg)
                    .diskCacheStrategy(DiskCacheStrategy.NONE)//不做磁盘缓存
                    .skipMemoryCache(true);//不做内存缓存
            Glide.with(context).load(url)
                    .apply(mRequestOptions)
                    .thumbnail(0.5f)
                    .into(imageView);
        }
    }

    public void displayFromNetNoWidth(Context context, String url, ImageView imageView, int defaultImg) {
        if (context != null && imageView != null) {
            RequestOptions mRequestOptions = RequestOptions.fitCenterTransform()
                    .error(defaultImg)
                    .diskCacheStrategy(DiskCacheStrategy.NONE)//不做磁盘缓存
                    .skipMemoryCache(true);//不做内存缓存
            Glide.with(context).load(url)
                    .apply(mRequestOptions)
                    .into(imageView);
        }
    }

    @Override
    public void displayFromNet6(Context context, String url, ImageView imageView) {
        if (context != null && imageView != null) {
            RequestOptions mRequestOptions = RequestOptions.fitCenterTransform()
                    .override(140,140)
                    .priority(Priority.HIGH)
                    .fitCenter()
                    .diskCacheStrategy(DiskCacheStrategy.NONE)//不做磁盘缓存
                    .skipMemoryCache(true);//不做内存缓存
            Glide.with(context).load(url).apply(mRequestOptions).thumbnail(0.5f)
                    .into(imageView);
        }
    }

    @Override
    public void displayFromLocal(Context context, ImageView imageView,
                                 int resourceId) {
        if (context != null && imageView != null) {
            RequestOptions mRequestOptions = RequestOptions.fitCenterTransform()
                    .fitCenter()
                    .diskCacheStrategy(DiskCacheStrategy.NONE)//不做磁盘缓存
                    .skipMemoryCache(true);//不做内存缓存
            Glide.with(context).load(resourceId).apply(mRequestOptions).into(imageView);
        }
    }

    @Override
    public void displayFromLocal(Context context, ImageView imageView, String path) {
        if (context != null) {
            RequestOptions mRequestOptions = RequestOptions.fitCenterTransform()
                    .fitCenter()
                    .diskCacheStrategy(DiskCacheStrategy.NONE)//不做磁盘缓存
                    .skipMemoryCache(true);//不做内存缓存
            Glide.with(context).load(new File(path)).apply(mRequestOptions).into(imageView);
        }
    }

    @Override
    public void displayFromLocal(Context context, ImageView imageView, String path, int width, int height) {
        if (context != null) {
            RequestOptions mRequestOptions = RequestOptions.fitCenterTransform()
                    .fitCenter()
                    .override(width,height)
                    .diskCacheStrategy(DiskCacheStrategy.NONE)//不做磁盘缓存
                    .skipMemoryCache(true);//不做内存缓存
            Glide.with(context).load(new File(path)).apply(mRequestOptions).into(imageView);
        }
    }

    public void displayFromLocal(Context context, ImageView imageView, int resId, int width, int height) {
        if (context != null) {
            RequestOptions mRequestOptions = RequestOptions.fitCenterTransform()
                    .fitCenter()
                    .override(width,height)
                    .diskCacheStrategy(DiskCacheStrategy.NONE)//不做磁盘缓存
                    .skipMemoryCache(true);//不做内存缓存
            Glide.with(context).load(resId).apply(mRequestOptions).into(imageView);
        }
    }

    @Override
    public void displayFromFile(Context context, ImageView imageView, File file) {
        if (context != null) {
            RequestOptions mRequestOptions = RequestOptions.fitCenterTransform()
                    .fitCenter()
                    .diskCacheStrategy(DiskCacheStrategy.NONE)//不做磁盘缓存
                    .skipMemoryCache(true);//不做内存缓存
            Glide.with(context).load(file).apply(mRequestOptions).into(imageView);
        }
    }

    public void displayFromNetDCircular(Context context, String url, ImageView imageView, int defaultImg) {
        if (context != null && imageView != null) {
            //圆角头像
            RequestOptions mRequestOptions = RequestOptions.bitmapTransform(new RoundedCorners(8))
                    .error(defaultImg)
                    .placeholder(defaultImg);
            Glide.with(context).load(url)
                    .apply(mRequestOptions)//圆角半径
                    .thumbnail(0.8f)
                    .into(imageView);
        }
    }

    public void displayFromNetDCircularT(Context context, String url, ImageView imageView, int defaultImg) {
        if (context != null && imageView != null) {
            //圆角头像
            RequestOptions mRequestOptions = RequestOptions.circleCropTransform()
                    .error(defaultImg)
                    .diskCacheStrategy(DiskCacheStrategy.NONE)//不做磁盘缓存
                    .skipMemoryCache(false);//不做内存缓存
            Glide.with(context).load(url)
                    .apply(mRequestOptions)//圆角半径
                    .thumbnail(0.8f)
                    .into(imageView);
        }
    }
}
