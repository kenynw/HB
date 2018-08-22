package com.santech.hongbao.app;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.gyf.barlibrary.ImmersionBar;
import com.santech.hongbao.R;
import com.santech.hongbao.app.base.IViewConfig;
import com.santech.hongbao.app.base.ViewConfig;

/**
 * Copyright (c) 2018 Miguan Inc All rights reserved.
 * Created by Liaopeikun on 2018/6/15
 */
public class ActivityLifecycleCallbacksImp implements Application.ActivityLifecycleCallbacks {

    private static float sNoncompatDensity;
    private static float sNoncompatScaledDensity;

    @Override
    public void onActivityCreated(Activity activity, Bundle bundle) {
        activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT); // 设置强制竖屏
        setCustomDensity(activity, activity.getApplication());
    }

    private void setCustomDensity(@NonNull Activity activity, @NonNull final Application application) {
        final DisplayMetrics appDisplayMetrics = application.getResources().getDisplayMetrics();

        if (sNoncompatDensity == 0) {
            sNoncompatDensity = appDisplayMetrics.density;
            sNoncompatScaledDensity = appDisplayMetrics.scaledDensity;
            application.registerComponentCallbacks(new ComponentCallbacks() {
                @Override
                public void onConfigurationChanged(Configuration configuration) {
                    if (configuration != null && configuration.fontScale > 0) {
                        sNoncompatScaledDensity = application.getResources().getDisplayMetrics().scaledDensity;
                    }
                }

                @Override
                public void onLowMemory() {

                }
            });

            final float targetDensity = appDisplayMetrics.widthPixels / 360;
            final float targetScaledDensity = targetDensity * (sNoncompatScaledDensity / sNoncompatDensity);
            final int targetDensityDpi = (int) (160 * targetDensity);

            appDisplayMetrics.density = targetDensity;
            appDisplayMetrics.scaledDensity = targetScaledDensity;
            appDisplayMetrics.densityDpi = targetDensityDpi;

            final DisplayMetrics activityDisplayMetrics = activity.getResources().getDisplayMetrics();
            activityDisplayMetrics.density = targetDensity;
            activityDisplayMetrics.scaledDensity = targetScaledDensity;
            activityDisplayMetrics.densityDpi = targetDensityDpi;
        }
    }

    @Override
    public void onActivityStarted(Activity activity) {
        if (!activity.getIntent().getBooleanExtra(ExtraConstant.IS_ACTIVITY_INIT, false)) {
            activity.getIntent().putExtra(ExtraConstant.IS_ACTIVITY_INIT, true);
            ViewConfig viewConfig;
            if (activity instanceof IViewConfig) {
                viewConfig = ((IViewConfig) activity).getViewConfig();
            } else {
                viewConfig = ViewConfig.DEFAULT.clone();
            }
            initToolbar(activity, viewConfig);
            initStatusBar(activity, viewConfig);
            activity.getIntent().putExtra(ExtraConstant.ACTIVITY_CONFIG, viewConfig);
        }
    }

    private void initToolbar(Activity activity, ViewConfig viewConfig) {
        Toolbar toolbar = activity.findViewById(R.id.base_toolbar);
        if (toolbar != null) {
            if (activity instanceof AppCompatActivity) {
                ((AppCompatActivity) activity).setSupportActionBar(toolbar);
                ((AppCompatActivity) activity).getSupportActionBar().setDisplayShowTitleEnabled(false);
                ((AppCompatActivity) activity).getSupportActionBar().setDisplayHomeAsUpEnabled(false);
            }

            View.OnClickListener onBackClickListener = view -> activity.onBackPressed();
            ImageView ivBack = activity.findViewById(R.id.base_toolbar_back);
            if (ivBack != null) {
                if (viewConfig.mToolbarBackVisible) {
                    ivBack.setVisibility(View.VISIBLE);
                    ivBack.setOnClickListener(onBackClickListener);
                    if (viewConfig.mToolbarBackRes > 0) {
                        ivBack.setImageResource(viewConfig.mToolbarBackRes);
                    }
                } else {
                    ivBack.setVisibility(View.GONE);
                }
            } else {
                toolbar.setNavigationOnClickListener(onBackClickListener);
            }

            //Toolbar中间标题
            TextView tvTitle = activity.findViewById(R.id.base_toolbar_title);
            if (tvTitle != null) {
                //文本
                CharSequence title = TextUtils.isEmpty(viewConfig.mToolbarTitle) ? activity.getTitle() : viewConfig.mToolbarTitle;
                if (!TextUtils.isEmpty(title)) {
                    tvTitle.setText(title);
                }
                //文本颜色
                if (viewConfig.mToolbarTitleColor > 0) {
                    tvTitle.setTextColor(activity.getResources().getColor(viewConfig.mToolbarTitleColor));
                }
            }

            //Toolbar右边按钮
            ImageView right = activity.findViewById(R.id.base_toolbar_right);
            if (null != right) {
                if (viewConfig.mToolbarRightVisible || viewConfig.mToolbarRightRes > 0) {
                    right.setVisibility(View.VISIBLE);
                    if (viewConfig.mToolbarRightRes > 0) {
                        right.setImageResource(viewConfig.mToolbarRightRes);
                    }
                    if (viewConfig.mOnRightClickListener != null) {
                        right.setOnClickListener(viewConfig.mOnRightClickListener);
                    }
                } else {
                    right.setVisibility(View.GONE);
                }
            }

            //Toolbar右边文本
            TextView tvRight = activity.findViewById(R.id.base_toolbar_text_right);
            if (null != tvRight) {
                if (viewConfig.mToolbarRightTextVisible) {
                    tvRight.setVisibility(View.VISIBLE);
                    tvRight.setText(viewConfig.mToolbarRightText);
                }
            }
        }
    }

    private void initStatusBar(Activity activity, ViewConfig viewConfig) {
        ImmersionBar immersionBar = ImmersionBar.with(activity)
                .statusBarDarkFont(true, 0.2f)
                .navigationBarEnable(false);
        if (viewConfig.mStatusBarColor > 0) {
            immersionBar.statusBarColor(viewConfig.mStatusBarColor);
        } else {
            immersionBar.transparentBar();
        }

        Toolbar toolbar = activity.findViewById(R.id.base_toolbar);
        if (toolbar != null) {
            immersionBar.titleBar(toolbar);
        } else {
            View statusBar = activity.findViewById(R.id.base_status_bar);
            if (statusBar != null) {
                immersionBar.statusBarView(statusBar);
            }
        }
        immersionBar.keyboardEnable(viewConfig.mKeyboardEnable);
        immersionBar.init();
        viewConfig.setImmersionBar(immersionBar);
    }

    @Override
    public void onActivityResumed(Activity activity) {
//        MobclickAgent.onResume(activity);
//        JPushInterface.onResume(activity);
    }

    @Override
    public void onActivityPaused(Activity activity) {
//        MobclickAgent.onPause(activity); //统计时长
//        JPushInterface.onPause(activity);
    }

    @Override
    public void onActivityStopped(Activity activity) {

    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {

    }

    @Override
    public void onActivityDestroyed(Activity activity) {
        ViewConfig viewConfig = (ViewConfig) activity.getIntent().getSerializableExtra(ExtraConstant.ACTIVITY_CONFIG);
        if (viewConfig != null) {
            if (viewConfig.getImmersionBar() != null) {
                viewConfig.getImmersionBar().destroy();
            }
        }
    }

}
