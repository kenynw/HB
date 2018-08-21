package com.lutech.hongbao.module.account.model;

import com.jess.arms.di.scope.ActivityScope;
import com.jess.arms.integration.IRepositoryManager;
import com.jess.arms.mvp.BaseModel;
import com.lutech.hongbao.app.DefaultTransform;
import com.lutech.hongbao.module.account.UserContract;
import com.lutech.hongbao.module.account.model.api.service.AccountService;
import com.lutech.hongbao.module.account.model.bean.User;
import com.lutech.hongbao.util.MimiUtils;

import javax.inject.Inject;

import io.reactivex.Observable;

@ActivityScope
public class LoginModel extends BaseModel implements UserContract.Model {

    @Inject
    public LoginModel(IRepositoryManager repositoryManager) {
        super(repositoryManager);
    }

    @Override
    public Observable<User> login(String mobile, String password, String deviceId) {
        return mRepositoryManager.obtainRetrofitService(AccountService.class)
                .login(mobile, password, deviceId)
                .compose(new DefaultTransform<>())
                .doOnNext(MimiUtils::setUser);
    }

}
