package com.wsg.cleannews.app;

import android.app.Application;
import android.content.Context;

/**
 * Created by Wangsg on 16/3/16.
 * Description:  应用application
 * UpdateUser:
 * UpdateDate:
 */
public class CleanNewsApplication extends Application {

    private static Context mApplicationContext;


    @Override
    public void onCreate() {
        super.onCreate();
//        SkinManager.getInstance().init(this);
        // 如果检测到某个 activity 有内存泄露，LeakCanary 就是自动地显示一个通知
//        mRefWatcher = LeakCanary.install(this);
//        setupDatabase();
        mApplicationContext = this;
//        KLog.init(BuildConfig.DEBUG);
    }

    // 获取ApplicationContext
    public static Context getContext() {
        return mApplicationContext;
    }
}
