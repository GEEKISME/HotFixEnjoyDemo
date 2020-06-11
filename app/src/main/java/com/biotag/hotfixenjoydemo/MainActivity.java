package com.biotag.hotfixenjoydemo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import dalvik.system.DexClassLoader;
import dalvik.system.PathClassLoader;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG, "Activity:" + Activity.class.getClassLoader());
        Log.i(TAG, "mainactivity :" + MainActivity.class.getClassLoader());

        Log.i(TAG,"parent:"+MainActivity.class.getClassLoader().getParent());

        try {
            //默认的dexopt存放目录 /data/davlik-cache
            PathClassLoader c1 = new PathClassLoader("/sdcard/hack.dex",
                    getClassLoader());
            /**
             * 1.
             * 2.dexopt存放目录
             * 3:so路径
             */
            DexClassLoader c2 = new DexClassLoader("/sdcard/hack.dex",
                    getCodeCacheDir().getAbsolutePath(), null, getClassLoader());

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}