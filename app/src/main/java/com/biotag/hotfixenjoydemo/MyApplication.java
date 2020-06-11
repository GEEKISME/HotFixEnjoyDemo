package com.biotag.hotfixenjoydemo;

import android.app.Application;
import android.content.Context;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        Fix.fix(getClassLoader(),"/sdcard/fix.dex");
    }
}
