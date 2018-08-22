package com.santech.hongbao.app;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Desc:跳转统一入口
 * <p>
 * Author: 廖培坤
 * Date: 2018-06-27
 * Copyright: Copyright (c) 2013-2018
 * Company: @米冠网络
 * Update Comments:
 */
@Singleton
public class Navigator {

    private static Navigator sInstance;

    /**
     * Desc:
     * <p>
     * Author: SonnyJack
     * Date: 2018-06-28
     */
    @Inject
    public Navigator() {

    }

    /**
     * Desc:
     * <p>
     * Author: SonnyJack
     * Date: 2018-06-28
     *
     * @return navigator
     */
    public static Navigator getInstance() {
        if (null == sInstance) {
            synchronized (Navigator.class) {
                if (null == sInstance) {
                    sInstance = new Navigator();
                }
            }
        }
        return sInstance;
    }

}
