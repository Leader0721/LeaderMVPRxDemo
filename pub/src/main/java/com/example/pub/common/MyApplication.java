package com.example.pub.common;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.example.pub.BuildConfig;
import com.example.pub.greendao.gen.GreenDaoManager;
import com.example.pub.utils.app.AppUtils;
import com.example.pub.utils.data.SPUtil;
import com.example.pub.utils.function.LogUtils;
import com.example.pub.utils.function.StringUtils;
import com.example.pub.view.headCrop.FileAccessor;
import com.example.pub.view.headCrop.ImageLoaderConfig;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

import org.greenrobot.greendao.query.QueryBuilder;


/**
 * description 主程序Application，伴随整个app生命周期
 * 将会在此配置一些第三方SDK，如百度地图，ORM等
 * author hanlei
 * version 1.0
 * created at 2016/11/14 10:26
 */
public class MyApplication extends Application {

    private static final String TAG = "MyApplication";

    private static MyApplication application;

    @Override
    public void onCreate() {
        super.onCreate();
        application = (MyApplication) getApplicationContext();
        getUUID();
        String channel = "test";
        Logger.addLogAdapter(new AndroidLogAdapter());
        if (!BuildConfig.DEBUG) {
            channel = "release";
        }
//        // 友盟统计
//        MobclickAgent.startWithConfigure(new MobclickAgent.UMAnalyticsConfig(this, "596ffe3ec8957676ec001c42"
//                , channel, MobclickAgent.EScenarioType.E_UM_NORMAL, true));

        // 初始化greendao数据库
        GreenDaoManager.getInstance();
        if (BuildConfig.DEBUG) {
            QueryBuilder.LOG_SQL = true;
            QueryBuilder.LOG_VALUES = true;
        }

//      ImageLoader先进性初始化，然后进行使用
        ImageLoaderConfig.initImageLoader(this);
        FileAccessor.initFileAccess();

//        // 初始化极光推送
//        JPushInterface.setDebugMode(BuildConfig.DEBUG);
//        JPushInterface.init(this);

    }


    public static MyApplication getInstance() {
        return application;
    }

    public void onLowMemory() {
        LogUtils.i("Application", "onLowMemory");
        super.onLowMemory();
    }

    // 适配5.x及以下系统超过65535方法的问题
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    private static String UUID = null;

    /**
     * 获取UUID
     *
     * @return
     */
    public static String getUUID() {

        if (StringUtils.isEmpty(UUID)) {
            UUID = (String) SPUtil.get(Keys.KEY_UUID, "");
            // 如果没有UUID则去获取
            if (StringUtils.isEmpty(UUID)) {
                UUID = AppUtils.getUUID();
                SPUtil.putAndApply(Keys.KEY_UUID, UUID);
            }
        }
        return UUID;
    }
}
