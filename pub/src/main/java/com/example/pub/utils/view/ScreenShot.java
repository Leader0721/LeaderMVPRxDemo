package com.example.pub.utils.view;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.View;

import com.example.pub.utils.data.SDCardUtils;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Description: 截图工具类
 * 1.是否包含状态栏
 * 2.指定保存路径
 * @Prject:
 * @Package: com.example.pub.utils.view
 * @author: Leader
 * @date: 2017/11/16   15:55
 * @Copyright: 个人版权所有
 * @Company:bc
 * @version: 1.0.0
 * 注意:
 * 1.不能直接使用,要View完全显示才能实现,即最好通过"按钮"控件调用方法
 * 2.截取状态栏方法,不能截取时间,电量部分
 */
public class ScreenShot {
    //TODO 1.长截图实现 2.自定义区域截图 3.加一个Handler 输出执行状态(成功/失败) 3.建议调用系统自带截图
    //默认的保存路径
    private static String DefaultPath = SDCardUtils.getSDCardPath() + "ScreenShot.png";


    /**
     * 截图并保存到默认SD卡(包含状态栏)
     *
     * @param activity
     */
    public static void shoot(Activity activity, boolean isWithStatuBar) {
        if (isWithStatuBar) {
            savePic(captureWithStatusBar(activity), DefaultPath);
        } else {
            savePic(captureWithoutStatusBar(activity), DefaultPath);
        }
    }

    /**
     * 截图并保存到指定目录
     *
     * @param activity
     * @param strFileName 路径
     */
    public static void shoot(Activity activity, String strFileName, boolean isWithStatuBar) {
        if (isWithStatuBar) {
            savePic(captureWithStatusBar(activity), strFileName);
        } else {
            savePic(captureWithoutStatusBar(activity), strFileName);
        }

    }

    /**
     * 保存到sdcard
     */
    private static void savePic(Bitmap bitmap, String strFileName) {
        //使用此流读取
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        //压缩图片(第二个参数影响的是图片的质量，但是图片的宽度与高度是不会受影响)
        bitmap.compress(Bitmap.CompressFormat.PNG, 80, baos);
        //这个函数能够设定图片的宽度与高度
        //Bitmap map = Bitmap.createScaledBitmap(bitmap, 400, 400, true);
        //把数据转为为字节数组
        byte[] byteArray = baos.toByteArray();
        try { //输出文件
            FileOutputStream fos = new FileOutputStream(strFileName);
            fos.write(byteArray);
            fos.flush();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                baos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 获取当前屏幕截图，包含状态栏
     * <p>
     * 注意:
     * 这个方法 截不到电量,时间部分
     *
     * @param activity activity
     * @return Bitmap
     */
    private static Bitmap captureWithStatusBar(Activity activity) {
        View view = activity.getWindow().getDecorView();
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();
        Bitmap bmp = view.getDrawingCache();
        int width = ScreenUtils.getScreenWidth(activity);
        int height = ScreenUtils.getScreenHeight(activity);
        Bitmap ret = Bitmap.createBitmap(bmp, 0, 0, width, height);
        view.destroyDrawingCache();
        return ret;
    }

    /**
     * 获取当前屏幕截图，不包含状态栏
     * <p>需要用到上面获取状态栏高度getStatusBarHeight的方法</p>
     *
     * @param activity activity
     * @return Bitmap
     */
    private static Bitmap captureWithoutStatusBar(Activity activity) {
        View view = activity.getWindow().getDecorView();
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();
        Bitmap bmp = view.getDrawingCache();
        int statusBarHeight = ScreenUtils.getStatusBarHeight(activity);
        int width = ScreenUtils.getScreenWidth(activity);
        int height = ScreenUtils.getScreenHeight(activity);
        Bitmap ret = Bitmap.createBitmap(bmp, 0, statusBarHeight, width, height - statusBarHeight);
        view.destroyDrawingCache();
        return ret;
    }

}
