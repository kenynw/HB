package com.santech.hongbao.module.account.model;

import com.jess.arms.di.scope.ActivityScope;
import com.jess.arms.integration.IRepositoryManager;
import com.jess.arms.mvp.BaseModel;
import com.santech.hongbao.app.DefaultTransform;
import com.santech.hongbao.module.account.UserContract;
import com.santech.hongbao.module.account.model.api.service.AccountService;
import com.santech.hongbao.module.account.model.bean.User;
import com.santech.hongbao.util.HBUtils;

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
                .doOnNext(HBUtils::setUser);
    }

}
