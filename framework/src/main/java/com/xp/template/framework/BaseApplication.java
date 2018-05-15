package com.xp.template.framework;

import android.app.Application;

import com.xp.template.framework.config.XPConfig;

/**
 * describe
 * date 2018/5/15
 * author xugaopan
 */

public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        XPConfig.application = this;
    }

}
