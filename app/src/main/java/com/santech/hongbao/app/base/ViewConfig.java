package com.santech.hongbao.app.base;

import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.view.View;

import com.gyf.barlibrary.ImmersionBar;

import java.io.Serializable;


/**
 * Desc:用于Activity/Fragment的配置，需要实现{@link IViewConfig}才能生效
 * 后根据具体使用业务进行扩展
 * <p>
 * Author: 廖培坤
 * Date: 2018-06-19
 * Copyright: Copyright (c) 2013-2018
 * Company: @米冠网络
 * Update Comments:
 * 1、add right image support and custom title by SonnyJack at 2018-06-28
 */
public class ViewConfig implements Serializable, Cloneable {

    public static ViewConfig DEFAULT = new ViewConfig();
    public @ColorRes
    int mStatusBarColor; // 任务栏颜色
    public boolean mKeyboardEnable = false;
    public boolean mToolbarBackVisible = true; // 返回图标是否可见
    public @DrawableRes
    int mToolbarBackRes; // 返回图标资源
    public boolean mToolbarRightVisible = false; // 右边图标是否可见
    public @DrawableRes
    int mToolbarRightRes; // 右边图标资源
    public View.OnClickListener mOnRightClickListener; // 右边单击
    public String mToolbarTitle; // 中间标题
    public @ColorRes
    int mToolbarTitleColor; // 中间标题颜色
    public boolean mToolbarRightTextVisible = false; // 右边文本是否可见
    public String mToolbarRightText; // 右边文本
    private ImmersionBar mImmersionBar; // 在Activity中传递用于销毁

    public ImmersionBar getImmersionBar() {
        return mImmersionBar;
    }

    public void setImmersionBar(ImmersionBar immersionBar) {
        mImmersionBar = immersionBar;
    }

    public ViewConfig setToolbarBackVisible(boolean visible) {
        mToolbarBackVisible = visible;
        return this;
    }

    public ViewConfig setToolbarBackRes(int res) {
        mToolbarBackRes = res;
        return this;
    }

    public ViewConfig setStatusBarColor(@ColorRes int res) {
        mStatusBarColor = res;
        return this;
    }

    public ViewConfig setToolbarRightVisible(boolean visible) {
        mToolbarRightVisible = visible;
        return this;
    }

    public ViewConfig setToolbarRightRes(int res) {
        mToolbarRightRes = res;
        return this;
    }

    /**
     * Desc: 设置Toolbar右边图标点击事件
     * <p>
     * Author: 廖培坤
     * Date: 2018-07-04
     *
     * @param listener
     * @return activity config
     */
    public ViewConfig setRightClickListener(View.OnClickListener listener) {
        mOnRightClickListener = listener;
        return this;
    }

    public ViewConfig setToolbarTitle(String toolbarTitle) {
        mToolbarTitle = toolbarTitle;
        return this;
    }

    public ViewConfig setToolbarTitleColor(@ColorRes int res) {
        mToolbarTitleColor = res;
        return this;
    }

    public ViewConfig setToolbarRightTextVisible(boolean toolbarRightTextVisible) {
        mToolbarRightTextVisible = toolbarRightTextVisible;
        return this;
    }

    public ViewConfig setToolbarRightText(String toolbarRightText) {
        mToolbarRightText = toolbarRightText;
        return this;
    }

    public ViewConfig setKeyboardEnable(boolean keyboardEnable) {
        mKeyboardEnable = keyboardEnable;
        return this;
    }

    @Override
    public ViewConfig clone() {
        try {
            return (ViewConfig) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return new ViewConfig();
    }

}
