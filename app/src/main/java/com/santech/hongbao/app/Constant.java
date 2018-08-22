package com.santech.hongbao.app;

import com.santech.hongbao.BuildConfig;

/**
 * Copyright (c) 2018 Miguan Inc All rights reserved.
 * Created by Liaopeikun on 2018/6/14
 */
public interface Constant {

    boolean DEBUG = BuildConfig.DEBUG;

    String BASE_URL = "http://" + (DEBUG ? "beta." : "") + "api.91mmliao.com/";

    String BASE_API_URL = BASE_URL + "LiaoBanApi/";

}
