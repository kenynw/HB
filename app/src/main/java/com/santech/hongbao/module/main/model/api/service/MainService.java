package com.santech.hongbao.module.main.model.api.service;

import com.santech.hongbao.module.account.model.bean.User;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Copyright (c) 2018 Miguan Inc All rights reserved.
 * Created by Liaopeikun on 2018/6/21
 */
public interface MainService {

    /**
     * 获取最新访客和未读消息
     *
     * @return
     */
    @GET("user/notice_status")
    Observable<User> getUnreadMsg(
            @Query("persion_id") String persionId
    );

}
