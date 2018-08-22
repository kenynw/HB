package com.santech.hongbao.app;

import android.os.Message;

import com.jess.arms.integration.AppManager;

/**
 * Desc: 全局事件处理，通过{@link com.jess.arms.integration.AppManager#post}发布事件
 * 通过 Message 对象中不同的 what 区分不同的方法和 Handler 同理
 * <p>
 * Author: 廖培坤
 * Date: 2018-07-04
 * Copyright: Copyright (c) 2013-2018
 * Company: @米冠网络
 * Update Comments:
 */
public class AppManagerHandlerListener implements AppManager.HandleListener {

    @Override
    public void handleMessage(AppManager appManager, Message message) {
        switch (message.what) {

        }
    }

}
