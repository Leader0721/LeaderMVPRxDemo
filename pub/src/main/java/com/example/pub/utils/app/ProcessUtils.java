package com.example.pub.utils.app;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.AppOpsManager;
import android.app.usage.UsageEvents;
import android.app.usage.UsageStats;
import android.app.usage.UsageStatsManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;

import com.example.pub.utils.function.LogUtils;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Description:进程相关工具类
 * @Prject:
 * @Package: com.example.pub.utils.app
 * @author: Leader
 * @date: 2017/11/16   15:25
 * @Copyright: 个人版权所有
 * @Company:bc
 * @version: 1.0.0
 */

public final class ProcessUtils {

    private ProcessUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    /**
     * 获取前台线程包名
     * <p>当不是查看当前App，且SDK大于21时，
     * 需添加权限 {@code <uses-permission android:name="android.permission.PACKAGE_USAGE_STATS"/>}</p>
     *
     * @return 前台应用包名
     */
    public static String getForegroundProcessName() {
        ActivityManager manager = (ActivityManager) Utils.getApp().getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningAppProcessInfo> pInfo = manager.getRunningAppProcesses();
        if (pInfo != null && pInfo.size() != 0) {
            for (ActivityManager.RunningAppProcessInfo aInfo : pInfo) {
                if (aInfo.importance == ActivityManager.RunningAppProcessInfo.IMPORTANCE_FOREGROUND) {
                    return aInfo.processName;
                }
            }
        }
        if (android.os.Build.VERSION.SDK_INT > android.os.Build.VERSION_CODES.LOLLIPOP) {
            PackageManager packageManager = Utils.getApp().getPackageManager();
            Intent intent = new Intent(Settings.ACTION_USAGE_ACCESS_SETTINGS);
            List<ResolveInfo> list = packageManager.queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
            System.out.println(list);
            if (list.size() > 0) {// 有"有权查看使用权限的应用"选项
                try {
                    ApplicationInfo info = packageManager.getApplicationInfo(Utils.getApp().getPackageName(), 0);
                    AppOpsManager aom = (AppOpsManager) Utils.getApp().getSystemService(Context.APP_OPS_SERVICE);
                    if (aom.checkOpNoThrow(AppOpsManager.OPSTR_GET_USAGE_STATS, info.uid, info.packageName) != AppOpsManager.MODE_ALLOWED) {
                        Utils.getApp().startActivity(intent);
                    }
                    if (aom.checkOpNoThrow(AppOpsManager.OPSTR_GET_USAGE_STATS, info.uid, info.packageName) != AppOpsManager.MODE_ALLOWED) {
                        LogUtils.d("getForegroundApp", "没有打开\"有权查看使用权限的应用\"选项");
                        return null;
                    }
                    UsageStatsManager usageStatsManager = (UsageStatsManager) Utils.getApp().getSystemService(Context.USAGE_STATS_SERVICE);
                    long endTime = System.currentTimeMillis();
                    long beginTime = endTime - 86400000 * 7;
                    List<UsageStats> usageStatses = usageStatsManager.queryUsageStats(UsageStatsManager.INTERVAL_BEST, beginTime, endTime);
                    if (usageStatses == null || usageStatses.isEmpty()) return null;
                    UsageStats recentStats = null;
                    for (UsageStats usageStats : usageStatses) {
                        if (recentStats == null || usageStats.getLastTimeUsed() > recentStats.getLastTimeUsed()) {
                            recentStats = usageStats;
                        }
                    }
                    return recentStats == null ? null : recentStats.getPackageName();
                } catch (PackageManager.NameNotFoundException e) {
                    e.printStackTrace();
                }
            } else {
                Log.d("ProcessUtils", "getForegroundProcessName() called" + ": 无\"有权查看使用权限的应用\"选项");
            }
        }
        return null;
    }

    /**
     * 获取后台服务进程
     * <p>需添加权限 {@code <uses-permission android:name="android.permission.KILL_BACKGROUND_PROCESSES"/>}</p>
     *
     * @return 后台服务进程
     */
    public static Set<String> getAllBackgroundProcesses() {
        ActivityManager am = (ActivityManager) Utils.getApp().getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningAppProcessInfo> info = am.getRunningAppProcesses();
        Set<String> set = new HashSet<>();
        for (ActivityManager.RunningAppProcessInfo aInfo : info) {
            Collections.addAll(set, aInfo.pkgList);
        }
        return set;
    }

    /**
     * 杀死所有的后台服务进程
     * <p>需添加权限 {@code <uses-permission android:name="android.permission.KILL_BACKGROUND_PROCESSES"/>}</p>
     *
     * @return 被暂时杀死的服务集合
     */
    public static Set<String> killAllBackgroundProcesses() {
        ActivityManager am = (ActivityManager) Utils.getApp().getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningAppProcessInfo> info = am.getRunningAppProcesses();
        Set<String> set = new HashSet<>();
        for (ActivityManager.RunningAppProcessInfo aInfo : info) {
            for (String pkg : aInfo.pkgList) {
                am.killBackgroundProcesses(pkg);
                set.add(pkg);
            }
        }
        info = am.getRunningAppProcesses();
        for (ActivityManager.RunningAppProcessInfo aInfo : info) {
            for (String pkg : aInfo.pkgList) {
                set.remove(pkg);
            }
        }
        return set;
    }

    /**
     * 杀死后台服务进程
     * <p>需添加权限 {@code <uses-permission android:name="android.permission.KILL_BACKGROUND_PROCESSES"/>}</p>
     *
     * @param packageName 包名
     * @return {@code true}: 杀死成功<br>{@code false}: 杀死失败
     */
    public static boolean killBackgroundProcesses(@NonNull final String packageName) {
        ActivityManager am = (ActivityManager) Utils.getApp().getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningAppProcessInfo> info = am.getRunningAppProcesses();
        if (info == null || info.size() == 0) return true;
        for (ActivityManager.RunningAppProcessInfo aInfo : info) {
            if (Arrays.asList(aInfo.pkgList).contains(packageName)) {
                am.killBackgroundProcesses(packageName);
            }
        }
        info = am.getRunningAppProcesses();
        if (info == null || info.size() == 0) return true;
        for (ActivityManager.RunningAppProcessInfo aInfo : info) {
            if (Arrays.asList(aInfo.pkgList).contains(packageName)) {
                return false;
            }
        }
        return true;
    }


    private static UsageStats recentStats;
    private static String result;

    /**
     * 判断应用是否处于前台
     *
     * @param context
     * @return
     */
    public static boolean isAppForeground(Context context) {
        ActivityManager manager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningAppProcessInfo> runningAppProcessInfos = manager.getRunningAppProcesses();
        if (runningAppProcessInfos == null || runningAppProcessInfos.size() == 0) {
            return false;
        }
        for (ActivityManager.RunningAppProcessInfo ra : runningAppProcessInfos) {
            if (ra.importance == ActivityManager.RunningAppProcessInfo.IMPORTANCE_FOREGROUND
                    && Arrays.asList(ra.pkgList).contains(context.getPackageName())) {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断某个应用是否处于前台（系统应用调用）
     * <p>API < 21，需要添加 {@code <uses-permission android:name="android.permission.GET_TASKS"/>} 权限</p>
     * <p>API >= 22，需要添加　{@code <uses-permission android:name="android.permission.PACKAGE_USAGE_STATS"/>} 权限</p>
     *
     * @param packageName
     * @return
     */
    public static boolean isAppForeground(String packageName) {
        return TextUtils.equals(packageName, getForegroundPackage( ));
    }

    /**
     * 获取前台应用包名（系统应用调用）
     * <p>API < 21，需要添加 {@code <uses-permission android:name="android.permission.GET_TASKS"/>} 权限</p>
     * <p>API >= 22，需要添加　{@code <uses-permission android:name="android.permission.PACKAGE_USAGE_STATS"/>} 权限</p>
     *
     * @return
     */
    public static String getForegroundPackage() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            return getForegroundPackage1();
        } else if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP_MR1) {
            return getForegroundPackage2();
        } else {
            return getForegroundPackage3();
        }
    }


    /**
     * 获取前台应用包名（API < 21，已被遗弃，不能使用）
     * <p>需要添加　{@code <uses-permission android:name="android.permission.GET_TASKS"/>} 权限</p>
     *
     * @return
     */
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private static String getForegroundPackage1() {
        ActivityManager manager = (ActivityManager) Utils.getApp().getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningTaskInfo> runningTaskInfos = manager.getRunningTasks(1);
        if (runningTaskInfos == null || runningTaskInfos.size() == 0
                || runningTaskInfos.get(0) == null) {
            return null;
        }

        return runningTaskInfos.get(0).topActivity.getPackageName();
    }

    /**
     * 获取前台应用包名（在 API 22 开始仅可以获取自己的应用，其他应用位于前台时获取到为 null，但可以通过此方式判断自己的应用是否处于前台）
     *
     * @return
     */
    @TargetApi(Build.VERSION_CODES.LOLLIPOP_MR1)
    private static String getForegroundPackage2() {
        ActivityManager manager = (ActivityManager) Utils.getApp().getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningAppProcessInfo> runningAppProcessInfos = manager.getRunningAppProcesses();
        if (runningAppProcessInfos == null || runningAppProcessInfos.size() == 0) {
            return null;
        }
        for (ActivityManager.RunningAppProcessInfo ra : runningAppProcessInfos) {
            if (ra.importance == ActivityManager.RunningAppProcessInfo.IMPORTANCE_FOREGROUND) {
                return ra.processName;
            }
        }
        return null;
    }

    /**
     * 获取前台应用包名（API >= 22）
     * <p>需要添加　{@code <uses-permission android:name="android.permission.PACKAGE_USAGE_STATS"/>} 权限</p>
     *
     * @return
     */
    @TargetApi(Build.VERSION_CODES.LOLLIPOP_MR1)
    public static String getForegroundPackage3() {
        UsageStatsManager usageStatsManager = (UsageStatsManager) Utils.getApp().getSystemService(Context.USAGE_STATS_SERVICE);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        long endTime = calendar.getTimeInMillis();// 结束时间
        calendar.add(Calendar.DAY_OF_MONTH, -1);// 时间间隔为一个月
        long beginTime = calendar.getTimeInMillis();// 开始时间
        // 获取一个月内的信息
        List<UsageStats> usageStatses = usageStatsManager.queryUsageStats(UsageStatsManager.INTERVAL_MONTHLY,
                beginTime, endTime);
        if (usageStatses == null || usageStatses.size() == 0) {
            return null;
        }
        for (UsageStats usageStats : usageStatses) {
            if (recentStats == null || usageStats.getLastTimeUsed() > recentStats.getLastTimeUsed()) {
                recentStats = usageStats;
            }
        }

        return recentStats.getPackageName();
    }

    /**
     * 获取前台应用包名（API >= 22）
     * <p>需要添加　{@code <uses-permission android:name="android.permission.PACKAGE_USAGE_STATS"/>} 权限</p>
     *
     * @return
     */
    @TargetApi(Build.VERSION_CODES.LOLLIPOP_MR1)
    private static String getForegroundPackage4( ) {
        UsageStatsManager usageStatsManager = (UsageStatsManager) Utils.getApp().getSystemService(Context.USAGE_STATS_SERVICE);

        long endTime = System.currentTimeMillis();
        long beginTime = endTime - 10 * 1000;
        UsageEvents.Event event = new UsageEvents.Event();
        UsageEvents usageEvents = usageStatsManager.queryEvents(beginTime, endTime);
        while (usageEvents.hasNextEvent()) {
            usageEvents.getNextEvent(event);
            if (event.getEventType() == UsageEvents.Event.MOVE_TO_FOREGROUND) {
                result = event.getPackageName();
            }
        }

        return result;
    }


}
