package com.xp.template.framework.config;

import android.app.Application;
import android.content.Context;

/**
 * describe
 * date 2018/5/15
 * author xugaopan
 */

public class XPConfig {

    public static Application application;

    /**
     * 获取application的上下文
     * @return
     */
    public static Context getAppCtx() {
        return application;
    }
}
