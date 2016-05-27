package com.chengchikeji_util;

import android.app.Application;

import com.activeandroid.ActiveAndroid;

import org.xutils.BuildConfig;
import org.xutils.x;

/**
 * Created by Administrator on 2016/5/26.
 * 初始化
 */
public class AppContext extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        x.Ext.setDebug(BuildConfig.DEBUG);
        ActiveAndroid.initialize(this);
    }
}
