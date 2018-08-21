package com.lutech.hongbao.module.main.model;

import android.app.Application;

import com.google.gson.Gson;
import com.jess.arms.integration.IRepositoryManager;
import com.jess.arms.mvp.BaseModel;
import com.lutech.hongbao.app.DefaultTransform;
import com.lutech.hongbao.module.account.model.bean.User;
import com.lutech.hongbao.module.main.MainContract;
import com.lutech.hongbao.module.main.model.api.service.MainService;

import javax.inject.Inject;

import io.reactivex.Observable;


public class MainModel extends BaseModel implements MainContract.Model {

    @Inject
    Gson mGson;
    @Inject
    Application mApplication;

    @Inject
    public MainModel(IRepositoryManager repositoryManager) {
        super(repositoryManager);
    }

    @Override
    public Observable<User> getUnreadMsg(String userId) {
        return mRepositoryManager.obtainRetrofitService(MainService.class)
                .getUnreadMsg(userId)
                .compose(new DefaultTransform<>());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mGson = null;
        this.mApplication = null;
    }

}