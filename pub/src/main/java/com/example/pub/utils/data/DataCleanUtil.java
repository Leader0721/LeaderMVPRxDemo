package com.example.pub.utils.data;

import android.annotation.SuppressLint;
import android.os.Environment;

import com.example.pub.utils.app.Utils;
import com.example.pub.utils.function.LogUtils;

import java.io.File;
import java.text.DecimalFormat;

/**
 * @Description:提供App数据清理工作的类
 * @Prject:
 * @Package: com.example.pub.utils.data
 * @author: Leader
 * @date: 2017/11/16   15:34
 * @Copyright: 个人版权所有
 * @Company:bc
 * @version: 1.0.0
 */


@SuppressLint("SdCardPath")
public class DataCleanUtil {

    /**
     * 清除本应用内部缓存数据(/data/data/com.xxx.xxx/cache)
     *
     * @return void
     */
    public static void cleanInternalCache() {
        FileUtil.deleteFilesByDirectory(Utils.getApp().getCacheDir());
        LogUtils.i("DataCleanUtil->>cleanInternalCache", "清除本应用内部缓存(/data/data/" + Utils.getApp().getPackageName() + "/cache)");
    }


    /**
     * 清除本应用外部缓存数据(/mnt/sdcard/android/data/com.xxx.xxx/cache)
     *
     * @return void
     */
    public static void cleanExternalCache() {
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            FileUtil.deleteFilesByDirectory(Utils.getApp().getExternalCacheDir());
            LogUtils.i("DataCleanUtil->>cleanExternalCache", "清除本应用外部缓存数据(/mnt/sdcard/android/data/" + Utils.getApp().getPackageName() + "/cache)");
        }
    }


    /**
     * 清除本应用所有数据库(/data/data/com.xxx.xxx/databases)
     *
     * @return void
     */
    public static void cleanDatabases() {
        FileUtil.deleteFilesByDirectory(new File("/data/data/" + Utils.getApp().getPackageName() + "/databases"));
        LogUtils.i("DataCleanUtil->>cleanDatabases", "清除本应用所有数据库");
    }


    /**
     * 清除本应用SharedPreference(/data/data/com.xxx.xxx/shared_prefs)
     *
     * @return void
     */
    public static void cleanSharedPreference() {
        FileUtil.deleteFilesByDirectory(new File("/data/data/" + Utils.getApp().getPackageName() + "/shared_prefs"));
        LogUtils.i("DataCleanUtil->>cleanSharedPreference", "清除本应用cleanSharedPreference数据信息");
    }


    /**
     * 根据名字清除本应用数据库
     *
     * @param dbName
     * @return void
     */
    public static void cleanDatabaseByName(String dbName) {
        Utils.getApp().deleteDatabase(dbName);
        LogUtils.i("DataCleanUtil->>cleanDatabaseByName", "根据名字清除本应用数据库");
    }


    /**
     * 清除本应用files文件(/data/data/com.xxx.xxx/files)
     *
     * @return void
     */
    public static void cleanFiles() {
        FileUtil.deleteFilesByDirectory(Utils.getApp().getFilesDir());
        LogUtils.i("DataCleanUtil->>cleanFiles", "清除data/data/" + Utils.getApp().getPackageName() + "/files下的内容信息");
    }


    /**
     * 清除本应用所有的数据
     *
     * @return int
     */
    public static int cleanApplicationData() {
        //清除本应用内部缓存数据
        cleanInternalCache();
        //清除本应用外部缓存数据
        cleanExternalCache();
        //清除本应用SharedPreference
        cleanSharedPreference();
        //清除本应用files文件
        cleanFiles();
        LogUtils.i("DataCleanUtil->>cleanApplicationData", "清除本应用所有的数据");
        return 1;
    }


    /**
     * 获取App应用缓存的大小
     *
     * @return String
     */
    public static String getAppClearSize() {
        long clearSize = 0;
        String fileSizeStr = "";
        DecimalFormat df = new DecimalFormat("0.00");
        //获得应用内部缓存大小
        clearSize = FileUtil.getFileSize(Utils.getApp().getCacheDir());
        //获得应用SharedPreference缓存数据大小
        clearSize += FileUtil.getFileSize(new File("/data/data/" + Utils.getApp().getPackageName() + "/shared_prefs"));
        //获得应用data/data/com.xxx.xxx/files下的内容文件大小
        clearSize += FileUtil.getFileSize(Utils.getApp().getFilesDir());
        //获取应用外部缓存大小
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            clearSize += FileUtil.getFileSize(Utils.getApp().getExternalCacheDir());
        }
        if (clearSize > 5000) {
            //转换缓存大小Byte为MB
            fileSizeStr = df.format((double) clearSize / 1048576) + "MB";
        }
        LogUtils.i("DataCleanUtil->>getAppClearSize", "获取App应用缓存的大小");
        return fileSizeStr;
    }


}
