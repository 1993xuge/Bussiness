package com.xuge.business.application;

import android.app.Application;

/**
 * 1、它是程序的入口
 * 2、完成初始化操作
 * 3、为整个应用的其他模块提供上下文
 */
public class MyApplication extends Application {

    private static MyApplication sApplication = null;

    @Override
    public void onCreate() {
        super.onCreate();
        sApplication = this;
    }

    public static MyApplication getInstance() {
        return sApplication;
    }
}
