package com.miguan.pick.core.util;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import com.jess.arms.http.imageloader.ImageLoader;
import com.jess.arms.http.imageloader.glide.GlideArms;
import com.jess.arms.http.imageloader.glide.ImageConfigImpl;
import com.jess.arms.utils.ArmsUtils;
import com.miguan.pick.core.R;

import java.util.Locale;

/**
 * Desc:图片加载工具类
 * <p>
 * 图片具体加载策略
 * {@link MyGlideImageLoaderStrategy}
 * <p>
 * Author: QiuRonaC
 * Date: 2018-07-10
 * Copyright: Copyright (c) 2013-2018
 * Company: @米冠网络
 * Update Comments:
 */
public class IImageLoader {

    //region 服务器获取图片大小
    public static final String SUF_FORMAT = "?imageView2/1/w/%d/h/%d";
    public static final String SUF_S1 = "?imageView2/1/w/120/h/120";
    public static final String SUF_S2 = "?imageView2/1/w/240/h/240";
    public static final String SUF_S3 = "?imageView2/1/w/320/h/240";
    public static final String SUF_S4 = "?imageView2/1/w/640/h/480";
    public static final String SUF_L1 = "?imageView2/1/w/780/h/1020";
    public static final String SUF_L2 = "?imageView2/1/w/1200/h/800";
    public static final String SUF_L3 = "?imageView2/1/w/480/h/640";
    private static int defaultImage = 0;

    public static void init(int defaultImage) {
        IImageLoader.defaultImage = defaultImage;
    }

    public static void loadImage(ImageView imageView, String url,
                                 @DrawableRes int placeHolder, @DrawableRes int errorHolder) {
        // 适配其他没有指定尺寸的地方
        ViewGroup.LayoutParams params = imageView.getLayoutParams();
        if (params != null) {
            // 如果宽或高为零或者大于图片尺寸则还是原图
            int width = Math.max(0, params.width < 150 ? params.width : params.width / 2);
            int height = Math.max(0, params.height < 150 ? params.height : params.height / 2);
            url = getImageUrlOfSuffix(url, width, height);
        }
        Context context = imageView.getContext();
        ImageLoader imageLoader = ArmsUtils.obtainAppComponentFromContext(context).imageLoader();
        imageLoader.loadImage(context,
                ImageConfigImpl.builder()
                        .url(url)
                        .errorPic(errorHolder)
                        .placeholder(placeHolder)
                        .fallback(errorHolder)
                        .imageView(imageView)
                        .build());
    }

    public static void loadImage(ImageView imageView, String url, @DrawableRes int placeHolder) {
        loadImage(imageView, url, placeHolder, placeHolder);
    }

    public static void loadImage(ImageView imageView, String url) {
        loadImage(imageView, url, defaultImage);
    }

    //原图
    public static void loadOriginalImage(final ImageView imageView, String url) {
        GlideArms.with(imageView.getContext())
                .load(url)
                .error(defaultImage)
                .placeholder(defaultImage)
                .into(new SimpleTarget<Drawable>() {
                    @Override
                    public void onResourceReady(@NonNull Drawable resource, @Nullable Transition<? super Drawable> transition) {
                        //这里采用这种方式，不然PhotoView显示长截图时，会不清晰
                        imageView.setImageDrawable(resource);
                    }
                });
    }

    /**
     * Desc:限定缩略图的宽最少为<Width>，高最少为<Height>，进行等比缩放，居中裁剪。
     * <p>
     * Author: QiuRonaC
     * Date: 2018-08-14
     */
    public static void loadImage(int width, int height, ImageView imageView, String url) {
        loadImage(imageView, getImageUrlOfSuffix(url, width, height));
    }

    public static void loadAvatar(ImageView imageView, String url) {
        GlideArms.with(imageView.getContext())
                .load(getImageUrlOfSuffix(url, SUF_S1))
                .error(R.mipmap.common_ic_def_avatar)
                .centerCrop()
                .placeholder(R.mipmap.common_ic_def_avatar)
                .into(imageView);
    }

    public static void loadRoundEmptyImage(final ImageView imageView, String url, int rounds, final int failBackground) {
        imageView.setBackground(null);
        GlideArms.with(imageView.getContext())
                .load(getImageUrlOfSuffix(url, SUF_S2))
                .listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        imageView.setBackgroundResource(failBackground);
                        return true;
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                        return false;
                    }
                })
                .transforms(new CenterCrop(), new RoundedCorners(rounds))
                .into(imageView);
    }

    /**
     * Desc: 拼接后缀获取小图
     * <p>
     * Author: 廖培坤
     * Date: 2018-08-14
     *
     * @return string
     */
    public static String getImageUrlOfSuffix(String url, String suffix) {
        if (TextUtils.isEmpty(url) || TextUtils.isEmpty(suffix)) {
            return url;
        }
        if (url.endsWith(suffix) || url.contains("?imageView2/") || url.contains(".mp4")) {
            return url;
        }
        // 本地图片
        if (url.startsWith("file") || url.startsWith("content") || !url.startsWith("http")) {
            return url;
        }
        return url + suffix;
    }

    /**
     * Desc: 获取特定尺寸图片
     * <p>
     * Author: 廖培坤
     * Date: 2018-08-14
     *
     * @return string
     */
    public static String getImageUrlOfSuffix(String url, int width, int height) {
        return getImageUrlOfSuffix(url, String.format(Locale.CHINA, SUF_FORMAT, width, height));
    }
}
