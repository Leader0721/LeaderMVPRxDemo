package com.example.pub.utils.app;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import android.widget.Toast;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @Description:1.设置Badge数量 2.重置Badge数量
 * @Prject:
 * @Package: com.example.pub.utils.app
 * @author: Leader
 * @date: 2017/11/16   15:17
 * @Copyright: 个人版权所有
 * @Company:bc
 * @version: 1.0.0
 */

public class BadgeUtils {
    /**
     * 设置Badge 图标显示未读消息
     * <p>
     * 目前支持Launcher:
     * MIUI
     * Sony
     * Samsung
     * LG
     * HTC
     * Nova 需要这些权限
     *
     * @param count   count
     * @param icon    icon应用的图标
     */
  /*  <uses-permission android:name="com.android.launcher.permission.INSTALL_SHORTCUT"/>
    <uses-permission android:name="com.android.launcher.permission.UNINSTALL_SHORTCUT"/>
    <uses-permission android:name="com.android.launcher.permission.READ_SETTINGS"/>
    <uses-permission android:name="com.android.launcher.permission.WRITE_SETTINGS"/>
    <uses-permission android:name="com.android.launcher2.permission.READ_SETTINGS"/>
    <uses-permission android:name="com.android.launcher2.permission.WRITE_SETTINGS"/>
    <uses-permission android:name="com.android.launcher3.permission.READ_SETTINGS"/>
    <uses-permission android:name="com.android.launcher3.permission.WRITE_SETTINGS"/>
    <uses-permission android:name="org.adw.launcher.permission.READ_SETTINGS"/>
    <uses-permission android:name="org.adw.launcher.permission.WRITE_SETTINGS"/>
    <uses-permission android:name="com.htc.launcher.permission.READ_SETTINGS"/>
    <uses-permission android:name="com.htc.launcher.permission.WRITE_SETTINGS"/>
    <uses-permission android:name="com.qihoo360.launcher.permission.READ_SETTINGS"/>
    <uses-permission android:name="com.qihoo360.launcher.permission.WRITE_SETTINGS"/>
    <uses-permission android:name="com.lge.launcher.permission.READ_SETTINGS"/>
    <uses-permission android:name="com.lge.launcher.permission.WRITE_SETTINGS"/>
    <uses-permission android:name="net.qihoo.launcher.permission.READ_SETTINGS"/>
    <uses-permission android:name="net.qihoo.launcher.permission.WRITE_SETTINGS"/>
    <uses-permission android:name="org.adwfreak.launcher.permission.READ_SETTINGS"/>
    <uses-permission android:name="org.adwfreak.launcher.permission.WRITE_SETTINGS"/>
    <uses-permission android:name="org.adw.launcher_donut.permission.READ_SETTINGS"/>
    <uses-permission android:name="org.adw.launcher_donut.permission.WRITE_SETTINGS"/>
    <uses-permission android:name="com.huawei.launcher3.permission.READ_SETTINGS"/>
    <uses-permission android:name="com.huawei.launcher3.permission.WRITE_SETTINGS"/>
    <uses-permission android:name="com.fede.launcher.permission.READ_SETTINGS"/>
    <uses-permission android:name="com.fede.launcher.permission.WRITE_SETTINGS"/>
    <uses-permission android:name="com.sec.android.app.twlauncher.settings.READ_SETTINGS"/>
    <uses-permission android:name="com.sec.android.app.twlauncher.settings.WRITE_SETTINGS"/>
    <uses-permission android:name="com.anddoes.launcher.permission.READ_SETTINGS"/>
    <uses-permission android:name="com.anddoes.launcher.permission.WRITE_SETTINGS"/>
    <uses-permission android:name="com.tencent.qqlauncher.permission.READ_SETTINGS"/>
    <uses-permission android:name="com.tencent.qqlauncher.permission.WRITE_SETTINGS"/>
    <uses-permission android:name="com.huawei.launcher2.permission.READ_SETTINGS"/>
    <uses-permission android:name="com.huawei.launcher2.permission.WRITE_SETTINGS"/>
    <uses-permission android:name="com.android.mylauncher.permission.READ_SETTINGS"/>
    <uses-permission android:name="com.android.mylauncher.permission.WRITE_SETTINGS"/>
    <uses-permission android:name="com.ebproductions.android.launcher.permission.READ_SETTINGS"/>
    <uses-permission android:name="com.ebproductions.android.launcher.permission.WRITE_SETTINGS"/>
    <uses-permission android:name="com.oppo.launcher.permission.READ_SETTINGS"/>
    <uses-permission android:name="com.oppo.launcher.permission.WRITE_SETTINGS"/>
    <uses-permission android:name="com.miui.mihome2.permission.READ_SETTINGS"/>
    <uses-permission android:name="com.miui.mihome2.permission.WRITE_SETTINGS"/>
    <uses-permission android:name="com.huawei.android.launcher.permission.READ_SETTINGS"/>
    <uses-permission android:name="com.huawei.android.launcher.permission.WRITE_SETTINGS"/>
    <uses-permission android:name="telecom.mdesk.permission.READ_SETTINGS"/>
    <uses-permission android:name="telecom.mdesk.permission.WRITE_SETTINGS"/>
    <uses-permission android:name="dianxin.permission.ACCESS_LAUNCHER_DATA"/>
    <uses-permission android:name="android.hardware.sensor.accelerometer"/>*/
    public static void setBadgeCount(int count, int icon) {

        // TODO 生成器模式重构
        if (count <= 0) {
            count = 0;
        } else {
            count = Math.max(0, Math.min(count, 99));
        }
        if (Build.MANUFACTURER.equalsIgnoreCase("xiaomi")) {
            setBadgeOfMIUI(count, icon);
        } else if (Build.MANUFACTURER.equalsIgnoreCase("sony")) {
            setBadgeOfSony(count);
        } else if (Build.MANUFACTURER.toLowerCase().contains("samsung") ||
                Build.MANUFACTURER.toLowerCase().contains("lg")) {
            setBadgeOfSumsung(count);
        } else if (Build.MANUFACTURER.toLowerCase().contains("htc")) {
            setBadgeOfHTC(count);
        } else if (Build.MANUFACTURER.toLowerCase().contains("nova")) {
            setBadgeOfNova(count);
        } else {
            Toast.makeText(Utils.getApp(), "Not Found Support Launcher", Toast.LENGTH_LONG).show();
        }
    }

    /**
     * 设置MIUI的Badge
     *
     * @param count count
     * @param icon  icon
     */
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    private static void setBadgeOfMIUI(int count, int icon) {

        Log.d("xys", "Launcher : MIUI");
        NotificationManager mNotificationManager = (NotificationManager) Utils.getApp()
                .getSystemService(Context.NOTIFICATION_SERVICE);
        Notification.Builder builder = new Notification.Builder(Utils.getApp())
                .setContentTitle("title").setContentText("text").setSmallIcon(icon);
        Notification notification = builder.build();
        try {
            Field field = notification.getClass().getDeclaredField("extraNotification");
            Object extraNotification = field.get(notification);
            Method method = extraNotification.getClass().getDeclaredMethod("setMessageCount", int.class);
            method.invoke(extraNotification, count);
        } catch (Exception e) {
            e.printStackTrace();
        }
        mNotificationManager.notify(0, notification);
    }

    /**
     * 设置索尼的Badge
     * <p/>
     * 需添加权限：<uses-permission android:name="com.sonyericsson.home.permission.BROADCAST_BADGE" />
     *
     * @param count count
     */
    private static void setBadgeOfSony(int count) {
        String launcherClassName = getLauncherClassName();
        if (launcherClassName == null) {
            return;
        }
        boolean isShow = true;
        if (count == 0) {
            isShow = false;
        }
        Intent localIntent = new Intent();
        localIntent.setAction("com.sonyericsson.home.action.UPDATE_BADGE");
        localIntent.putExtra("com.sonyericsson.home.intent.extra.badge.SHOW_MESSAGE", isShow);//是否显示
        localIntent.putExtra("com.sonyericsson.home.intent.extra.badge.ACTIVITY_NAME", launcherClassName);//启动页
        localIntent.putExtra("com.sonyericsson.home.intent.extra.badge.MESSAGE", String
                .valueOf(count));//数字
        localIntent.putExtra("com.sonyericsson.home.intent.extra.badge.PACKAGE_NAME", Utils.getApp().getPackageName());//包名
        Utils.getApp().sendBroadcast(localIntent);
    }

    /**
     * 设置三星的Badge\设置LG的Badge
     *
     * @param count count
     */
    private static void setBadgeOfSumsung(int count) {
        // 获取你当前的应用
        String launcherClassName = getLauncherClassName();
        if (launcherClassName == null) {
            return;
        }
        Intent intent = new Intent("android.intent.action.BADGE_COUNT_UPDATE");
        intent.putExtra("badge_count", count);
        intent.putExtra("badge_count_package_name", Utils.getApp().getPackageName());
        intent.putExtra("badge_count_class_name", launcherClassName);
        Utils.getApp().sendBroadcast(intent);
    }

    /**
     * 设置HTC的Badge
     *
     * @param count count
     */
    private static void setBadgeOfHTC(int count) {
        Intent intentNotification = new Intent("com.htc.launcher.action.SET_NOTIFICATION");
        ComponentName localComponentName = new ComponentName(Utils.getApp().getPackageName(),
                getLauncherClassName());
        intentNotification.putExtra("com.htc.launcher.extra.COMPONENT", localComponentName.flattenToShortString());
        intentNotification.putExtra("com.htc.launcher.extra.COUNT", count);
        Utils.getApp().sendBroadcast(intentNotification);

        Intent intentShortcut = new Intent("com.htc.launcher.action.UPDATE_SHORTCUT");
        intentShortcut.putExtra("packagename", Utils.getApp().getPackageName());
        intentShortcut.putExtra("count", count);
        Utils.getApp().sendBroadcast(intentShortcut);
    }

    /**
     * 设置Nova的Badge
     *
     * @param count count
     */
    private static void setBadgeOfNova(int count) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("tag", Utils.getApp().getPackageName() + "/" +
                getLauncherClassName());
        contentValues.put("count", count);
        Utils.getApp().getContentResolver().insert(Uri.parse("content://com.teslacoilsw.notifier/unread_count"),
                contentValues);
    }

    public static void setBadgeOfMadMode(int count, String packageName, String className) {
        Intent intent = new Intent("android.intent.action.BADGE_COUNT_UPDATE");
        intent.putExtra("badge_count", count);
        intent.putExtra("badge_count_package_name", packageName);
        intent.putExtra("badge_count_class_name", className);
        Utils.getApp().sendBroadcast(intent);
    }

    /**
     * 重置Badge
     *
     * @param icon icon
     */
    public static void resetBadgeCount(int icon) {

        setBadgeCount(0, icon);
    }

    public static String getLauncherClassName() {
        PackageManager packageManager = Utils.getApp().getPackageManager();
        Intent intent = new Intent(Intent.ACTION_MAIN);
        // To limit the components this Intent will resolve to, by setting an
        // explicit package name.
        intent.setPackage(Utils.getApp().getPackageName());
        intent.addCategory(Intent.CATEGORY_LAUNCHER);
        // All Application must have 1 Activity at least.
        // Launcher activity must be found!
        ResolveInfo info = packageManager
                .resolveActivity(intent, PackageManager.MATCH_DEFAULT_ONLY);
        // get a ResolveInfo containing ACTION_MAIN, CATEGORY_LAUNCHER
        // if there is no Activity which has filtered by CATEGORY_DEFAULT
        if (info == null) {
            info = packageManager.resolveActivity(intent, 0);
        }
        //////////////////////另一种实现方式//////////////////////
        // ComponentName componentName = context.getPackageManager().getLaunchIntentForPackage(mContext
        // .getPackageName()).getComponent();
        // return componentName.getClassName();
        //////////////////////另一种实现方式//////////////////////
        return info.activityInfo.name;
    }
}
