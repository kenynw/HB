package com.santech.hongbao.module.main.ui.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.blankj.utilcode.util.ToastUtils;
import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.jess.arms.di.component.AppComponent;
import com.santech.hongbao.R;
import com.santech.hongbao.app.base.BaseActivity;
import com.santech.hongbao.module.main.MainContract;
import com.santech.hongbao.module.main.di.component.DaggerMainComponent;
import com.santech.hongbao.module.main.di.module.MainModule;
import com.santech.hongbao.module.main.preseinter.MainPresenter;

import java.util.ArrayList;

import butterknife.BindView;

public class MainActivity extends BaseActivity<MainPresenter> implements MainContract.View {

    @BindView(R.id.main_ctl_tab)
    CommonTabLayout mCtlTab;

    private long mBackPressTime;

    @Override
    public void setupActivityComponent(@NonNull AppComponent appComponent) {
        DaggerMainComponent
                .builder()
                .appComponent(appComponent)
                .mainModule(new MainModule(this))
                .build()
                .inject(this);
    }

    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return R.layout.main_activity;
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        initTab();
    }

    /**
     * Desc: 初始化底部Tab
     * <p>
     * Author: SonnyJack
     * Date: 2018-07-03
     */
    private void initTab() {
        String[] titles = {"首页", "动态", "消息", "我的"};
        String[] fragmentName = {};
        int[] iconUnselectIds = {R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher};
        int[] iconSelectIds = {R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher};
        ArrayList<Fragment> fragments = new ArrayList<>();
        ArrayList<CustomTabEntity> tabEntities = new ArrayList<>();
        for (int i = 0; i < titles.length; i++) {
            tabEntities.add(new TabEntity(titles[i], iconSelectIds[i], iconUnselectIds[i]));
//            fragments.add(Fragment.instantiate(this, fragmentName[i]));
        }
        mCtlTab.setTabData(tabEntities, this, R.id.main_rl_content, fragments);
        mCtlTab.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {

            }

            @Override
            public void onTabReselect(int position) {

            }
        });
    }

    @SuppressLint("MissingSuperCall")
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        //super.onSaveInstanceState(outState);
    }

    @Override
    public void onBackPressed() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - mBackPressTime < 2000) {
            super.onBackPressed();
        } else {
            ToastUtils.showLong("再按一次退出PICK语音");
            mBackPressTime = currentTimeMillis;
        }
    }

}
