package com.example.pub.utils.app;

import android.content.Context;
import android.os.Vibrator;

/**
 * @Description:震动相关工具类
 * @Prject:
 * @Package: com.example.pub.utils.app
 * @author: Leader
 * @date: 2017/11/16   15:28
 * @Copyright: 个人版权所有
 * @Company:bc
 * @version: 1.0.0
 */

public final class VibrationUtils {

    private VibrationUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    /**
     * 震动
     * <p>需添加权限 {@code <uses-permission android:name="android.permission.VIBRATE"/>}</p>
     *
     * @param milliseconds 振动时长
     */
    public static void vibrate(final long milliseconds) {
        Vibrator vibrator = (Vibrator) Utils.getApp().getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(milliseconds);
    }

    /**
     * 指定手机以pattern模式振动
     *
     * @param pattern new long[]{400,800,1200,1600}，就是指定在400ms、800ms、1200ms、1600ms这些时间点交替启动、关闭手机振动器
     * @param repeat  指定pattern数组的索引，指定pattern数组中从repeat索引开始的振动进行循环。-1表示只振动一次，非-1表示从 pattern的指定下标开始重复振动。
     */
    public static void vibrate(final long[] pattern, final int repeat) {
        Vibrator vibrator = (Vibrator) Utils.getApp().getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(pattern, repeat);
    }

    /**
     * 取消振动
     */
    public static void cancel() {
        ((Vibrator) Utils.getApp().getSystemService(Context.VIBRATOR_SERVICE)).cancel();
    }
}
