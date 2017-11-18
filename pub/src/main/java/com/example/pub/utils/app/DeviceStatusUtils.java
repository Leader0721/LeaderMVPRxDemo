package com.example.pub.utils.app;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Service;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Build;
import android.os.Vibrator;
import android.provider.Settings;
import android.view.Window;
import android.view.WindowManager;

/**
 * @Description:包括蓝牙,屏幕亮度,飞行模式,音量,震动等
 * @Prject:
 * @Package: com.example.pub.utils.app
 * @author: Leader
 * @date: 2017/11/16   15:20
 * @Copyright: 个人版权所有
 * @Company:bc
 * @version: 1.0.0
 */

public class DeviceStatusUtils {

    /**
     * 获取系统屏幕亮度模式的状态，需要WRITE_SETTINGS权限
     *
     * @return System.SCREEN_BRIGHTNESS_MODE_AUTOMATIC：自动；System.
     * SCREEN_BRIGHTNESS_MODE_AUTOMATIC
     * ：手动；默认：System.SCREEN_BRIGHTNESS_MODE_AUTOMATIC
     */
    public static int getScreenBrightnessModeState() {
        return Settings.System.getInt(Utils.getApp().getContentResolver(),
                Settings.System.SCREEN_BRIGHTNESS_MODE,
                Settings.System.SCREEN_BRIGHTNESS_MODE_AUTOMATIC);
    }

    /**
     * 判断系统屏幕亮度模式是否是自动
     * <p>
     * 需要权限:
     * <uses-permission android:name="android.permission.WRITE_APN_SETTINGS"/>
     *
     * @return true：自动；false：手动；默认：true
     */
    public static boolean isScreenBrightnessModeAuto() {
        return getScreenBrightnessModeState() == Settings.System.SCREEN_BRIGHTNESS_MODE_AUTOMATIC;
    }

    /**
     * 设置系统屏幕亮度模式
     * <p>
     * 需要权限:
     * <uses-permission android:name="android.permission.WRITE_APN_SETTINGS"/>
     *
     * @param auto 自动
     * @return 是否设置成功
     */
    public static boolean setScreenBrightnessMode(boolean auto) {
        boolean result = true;
        if (isScreenBrightnessModeAuto() != auto) {
            result = Settings.System.putInt(Utils.getApp().getContentResolver(),
                    Settings.System.SCREEN_BRIGHTNESS_MODE,
                    auto ? Settings.System.SCREEN_BRIGHTNESS_MODE_AUTOMATIC
                            : Settings.System.SCREEN_BRIGHTNESS_MODE_MANUAL);
        }
        return result;
    }

    /**
     * 获取系统亮度
     * <p>
     * 需要权限:
     * <uses-permission android:name="android.permission.WRITE_APN_SETTINGS"/>
     *
     * @return 亮度，范围是0-255；默认255
     */
    public static int getScreenBrightness() {
        return Settings.System.getInt(Utils.getApp().getContentResolver(),
                Settings.System.SCREEN_BRIGHTNESS, 255);
    }

    /**
     * 设置系统亮度（此方法只是更改了系统的亮度属性，并不能看到效果。要想看到效果可以使用setWindowBrightness()方法设置窗口的亮度），
     * <p>
     * 需要权限:
     * <uses-permission android:name="android.permission.WRITE_APN_SETTINGS"/>
     *
     * @param screenBrightness 亮度，范围是0-255
     * @return 设置是否成功
     */
    public static boolean setScreenBrightness(
            int screenBrightness) {
        int brightness = screenBrightness;
        if (screenBrightness < 1) {
            brightness = 1;
        } else if (screenBrightness > 255) {
            brightness = screenBrightness % 255;
            if (brightness == 0) {
                brightness = 255;
            }
        }
        boolean result = Settings.System.putInt(Utils.getApp().getContentResolver(),
                Settings.System.SCREEN_BRIGHTNESS, brightness);
        return result;
    }

    /**
     * 设置给定Activity的窗口的亮度（可以看到效果，但系统的亮度属性不会改变）
     *
     * @param activity         要通过此Activity来设置窗口的亮度
     * @param screenBrightness 亮度，范围是0-255
     */
    public static void setWindowBrightness(Activity activity,
                                           float screenBrightness) {
        float brightness = screenBrightness;
        if (screenBrightness < 1) {
            brightness = 1;
        } else if (screenBrightness > 255) {
            brightness = screenBrightness % 255;
            if (brightness == 0) {
                brightness = 255;
            }
        }
        Window window = activity.getWindow();
        WindowManager.LayoutParams localLayoutParams = window.getAttributes();
        localLayoutParams.screenBrightness = brightness / 255;
        window.setAttributes(localLayoutParams);
    }

    /**
     * 设置系统亮度并实时可以看到效果
     * <p>
     * 需要权限:
     * <uses-permission android:name="android.permission.WRITE_APN_SETTINGS"/>
     *
     * @param activity         要通过此Activity来设置窗口的亮度
     * @param screenBrightness 亮度，范围是0-255
     * @return 设置是否成功
     */
    public static boolean setScreenBrightnessAndApply(Activity activity,
                                                      int screenBrightness) {
        boolean result = true;
        result = setScreenBrightness(screenBrightness);
        if (result) {
            setWindowBrightness(activity, screenBrightness);
        }
        return result;
    }

    /**
     * 获取屏幕休眠时间
     * <p>
     * 需要权限:
     * <uses-permission android:name="android.permission.WRITE_APN_SETTINGS"/>
     *
     * @return 屏幕休眠时间，单位毫秒，默认30000
     */
    public static int getScreenDormantTime() {
        return Settings.System.getInt(Utils.getApp().getContentResolver(),
                Settings.System.SCREEN_OFF_TIMEOUT, 30000);
    }

    /**
     * 设置屏幕休眠时间
     * <p>
     * 需要权限:
     * <uses-permission android:name="android.permission.WRITE_APN_SETTINGS"/>
     *
     * @return 设置是否成功
     */
    public static boolean setScreenDormantTime(int millis) {
        return Settings.System.putInt(Utils.getApp().getContentResolver(),
                Settings.System.SCREEN_OFF_TIMEOUT, millis);
    }

    /**
     * 获取飞行模式的状态
     * <p>
     * 需要权限:
     * <uses-permission android:name="android.permission.WRITE_APN_SETTINGS"/>
     *
     * @return 1：打开；0：关闭；默认：关闭
     */
    @SuppressWarnings("deprecation")
    public static int getAirplaneModeState() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN_MR1) {
            return Settings.System.getInt(Utils.getApp().getContentResolver(),
                    Settings.System.AIRPLANE_MODE_ON, 0);
        } else {
            return Settings.Global.getInt(Utils.getApp().getContentResolver(),
                    Settings.Global.AIRPLANE_MODE_ON, 0);
        }
    }

    /**
     * 判断飞行模式是否打开
     * <p>
     * 需要权限:
     * <uses-permission android:name="android.permission.WRITE_APN_SETTINGS"/>
     *
     * @param context 上下文
     * @return true：打开；false：关闭；默认关闭
     */
    public static boolean isAirplaneModeOpen(Context context) {
        return getAirplaneModeState() == 1;
    }

    /**
     * 设置飞行模式的状态
     * <p>
     * 需要权限:
     * <uses-permission android:name="android.permission.WRITE_APN_SETTINGS"/>
     *
     * @param enable 飞行模式的状态
     * @return 设置是否成功
     */
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    @SuppressWarnings("deprecation")
    public static boolean setAirplaneMode(boolean enable) {
        boolean result = true;
        // 如果飞行模式当前的状态与要设置的状态不一样
        if (isAirplaneModeOpen(Utils.getApp()) != enable) {
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN_MR1) {
                result = Settings.System.putInt(Utils.getApp().getContentResolver(),
                        Settings.System.AIRPLANE_MODE_ON, enable ? 1 : 0);
            } else {
                result = Settings.Global.putInt(Utils.getApp().getContentResolver(),
                        Settings.Global.AIRPLANE_MODE_ON, enable ? 1 : 0);
            }
            // 发送飞行模式已经改变广播
            Utils.getApp().sendBroadcast(new Intent(
                    Intent.ACTION_AIRPLANE_MODE_CHANGED));
        }
        return result;
    }

    /**
     * 获取蓝牙的状态
     * <p>
     * 需要权限:
     * <uses-permission android:name="android.permission.BLUETOOTH_ADMIN"/>
     *
     * @return 取值为BluetoothAdapter的四个静态字段：STATE_OFF, STATE_TURNING_OFF,
     * STATE_ON, STATE_TURNING_ON
     * @throws Exception 没有找到蓝牙设备
     */
    public static int getBluetoothState() throws Exception {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter
                .getDefaultAdapter();
        if (bluetoothAdapter == null) {
            throw new Exception("bluetooth device not found!");
        } else {
            return bluetoothAdapter.getState();
        }
    }

    /**
     * 判断蓝牙是否打开
     * <p>
     * 需要权限:
     * <uses-permission android:name="android.permission.BLUETOOTH_ADMIN"/>
     *
     * @return true：已经打开或者正在打开；false：已经关闭或者正在关闭
     * 没有找到蓝牙设备
     */
    public static boolean isBluetoothOpen() throws Exception {
        int bluetoothStateCode = getBluetoothState();
        return bluetoothStateCode == BluetoothAdapter.STATE_ON
                || bluetoothStateCode == BluetoothAdapter.STATE_TURNING_ON;
    }

    /**
     * 设置蓝牙状态
     *
     * @param enable 打开
     *               没有找到蓝牙设备
     */
    public static void setBluetooth(boolean enable) throws Exception {
        // 如果当前蓝牙的状态与要设置的状态不一样
        if (isBluetoothOpen() != enable) {
            // 如果是要打开就打开，否则关闭
            if (enable) {
                BluetoothAdapter.getDefaultAdapter().enable();
            } else {
                BluetoothAdapter.getDefaultAdapter().disable();
            }
        }
    }

    /**
     * 获取媒体音量
     *
     * 需要权限:
     *   <uses-permission android:name="android.permission.WRITE_APN_SETTINGS"/>
     *
     * @param context
     *            上下文
     * @return 媒体音量，取值范围为0-15；默认0
     */
    //	public static int getMediaVolume(Context context) {
    //		return Settings.System.getInt(context.getContentResolver(),
    //				Settings.System.VOLUME_MUSIC, 0);
    //	}

    /**
     * 获取媒体音量
     *
     *  需要权限:
     *   <uses-permission android:name="android.permission.WRITE_APN_SETTINGS"/>
     *
     * @param context
     *            上下文
     * @return 媒体音量，取值范围为0-15
     */
    //	public static boolean setMediaVolume(Context context, int mediaVloume) {
    //		if (mediaVloume < 0) {
    //			mediaVloume = 0;
    //		} else if (mediaVloume > 15) {
    //			mediaVloume = mediaVloume % 15;
    //			if (mediaVloume == 0) {
    //				mediaVloume = 15;
    //			}
    //		}
    //		return Settings.System.putInt(context.getContentResolver(),
    //				Settings.System.VOLUME_MUSIC, mediaVloume);
    //	}

    /**
     * 获取铃声音量
     * <p>
     * 需要权限:
     * <uses-permission android:name="android.permission.WRITE_APN_SETTINGS"/>
     *
     * @return 铃声音量，取值范围为0-7；默认为0
     */
    public static int getRingVolume() {
        return ((AudioManager) Utils.getApp().getSystemService(Context.AUDIO_SERVICE)).getStreamVolume(AudioManager
                .STREAM_RING);
    }

    /**
     * 获取媒体音量
     * <p>
     * 需要权限:
     * <uses-permission android:name="android.permission.WRITE_APN_SETTINGS"/>
     *
     * @return 媒体音量，取值范围为0-7
     */
    public static void setRingVolume(int ringVloume) {
        if (ringVloume < 0) {
            ringVloume = 0;
        } else if (ringVloume > 7) {
            ringVloume = ringVloume % 7;
            if (ringVloume == 0) {
                ringVloume = 7;
            }
        }

        ((AudioManager) Utils.getApp().getSystemService(Context.AUDIO_SERVICE)).setStreamVolume(AudioManager.STREAM_RING,
                ringVloume, AudioManager.FLAG_PLAY_SOUND);
    }

    /**
     * 时长震动
     *
     * @param milliseconds 震动的时长，单位是毫秒
     */
    public static void Vibrate(long milliseconds, boolean isVibrate) {
        if (isVibrate) {
            Vibrator vib = (Vibrator) Utils.getApp().getSystemService(Service.VIBRATOR_SERVICE);
            vib.vibrate(milliseconds);
        }
    }


    /**
     * 自定义震动模式
     *
     * @param activity
     * @param pattern  数组中数字的含义依次是静止的时长，震动时长，静止时长，震动时长。 单位是毫秒
     * @param isRepeat 是否反复震动，如果是true，反复震动，如果是false，只震动一次
     */
    public static void Vibrate(final Activity activity, long[] pattern, boolean isRepeat) {
        Vibrator vib = (Vibrator) activity.getSystemService(Service.VIBRATOR_SERVICE);
        vib.vibrate(pattern, isRepeat ? 1 : -1);
    }


}

