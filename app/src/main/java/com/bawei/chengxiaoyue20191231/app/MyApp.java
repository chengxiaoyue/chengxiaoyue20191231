package com.bawei.chengxiaoyue20191231.app;

import android.app.Application;
import android.content.Context;

/**
 * date:2019/12/31
 * author:程小越
 * function:
 */
public class MyApp extends Application {
    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context=this;
    }
}
