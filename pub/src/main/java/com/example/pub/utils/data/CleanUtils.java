package com.example.pub.utils.data;

import com.example.pub.utils.app.Utils;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;

/**
 * @Description:1.清除手机内部缓存 2.清除手机内部文件
 * 3.清除手机内部数据库
 * 4.根据数据库名,删除数据库
 * 5.清除SP
 * 6.清除SDK缓存
 * 7.清楚自定义目录下的文件(根据文件/文件路径)
 * 8.关闭IO流
 * @Prject:
 * @Package: com.example.pub.utils.data
 * @author: Leader
 * @date: 2017/11/16   15:32
 * @Copyright: 个人版权所有
 * @Company:bc
 * @version: 1.0.0
 */
public class CleanUtils {

    /**
     * 清除手机内部缓存
     * 一般是 /data/data/com.xxx.xxx/cache
     *
     * @return {@code true}: 清除成功<br>{@code false}: 清除失败
     */
    public static boolean cleanInternalCache() {
        return FileUtils.deleteFilesInDir(Utils.getApp().getCacheDir());
    }

    /**
     * 清除手机内部文件
     * <p>/data/data/com.xxx.xxx/files</p>
     *
     * @return {@code true}: 清除成功<br>{@code false}: 清除失败
     */
    public static boolean cleanInternalFiles() {
        return FileUtils.deleteFilesInDir(Utils.getApp().getFilesDir());
    }

    /**
     * 清除手机内部数据库
     * <p>/data/data/com.xxx.xxx/databases</p>
     *
     * @return {@code true}: 清除成功<br>{@code false}: 清除失败
     */
    public static boolean cleanInternalDbs() {
        return FileUtils.deleteFilesInDir(Utils.getApp().getFilesDir().getParent() + File.separator + "databases");
    }

    /**
     * 根据名称清除数据库
     * <p>/data/data/com.xxx.xxx/databases/dbName</p>
     *
     * @param dbName 数据库名称
     * @return {@code true}: 清除成功<br>{@code false}: 清除失败
     */
    public static boolean cleanInternalDbByName(String dbName) {
        return Utils.getApp().deleteDatabase(dbName);
    }

    /**
     * 清除内部SP
     * <p>/data/data/com.xxx.xxx/shared_prefs</p>
     *
     * @return {@code true}: 清除成功<br>{@code false}: 清除失败
     */
    public static boolean cleanInternalSP() {
        return FileUtils.deleteFilesInDir(Utils.getApp().getFilesDir().getParent() + File.separator + "shared_prefs");
    }

    /**
     * 清除sd卡缓存
     * <p>/storage/emulated/0/android/data/com.xxx.xxx/cache<p/>
     *
     * @return {@code true}: 清除成功<br>{@code false}: 清除失败
     */
    public static boolean cleanExternalCache() {
        return SDCardUtils.isSDCardEnable() && FileUtils.deleteFilesInDir(Utils.getApp().getExternalCacheDir());
    }

    /**
     * 清除自定义目录下的文件
     *
     * @param dirPath 目录路径
     * @return {@code true}: 清除成功<br>{@code false}: 清除失败
     */
    public static boolean cleanCustomCache(String dirPath) {
        return FileUtils.deleteFilesInDir(dirPath);
    }

    /**
     * 清除自定义目录下的文件
     *
     * @param dir 目录
     * @return {@code true}: 清除成功<br>{@code false}: 清除失败
     */
    public static boolean cleanCustomCache(File dir) {
        return FileUtils.deleteFilesInDir(dir);
    }

    /**
     * 关闭IO
     *
     * @param closeables closeable
     */
    public static void closeIO(Closeable... closeables) {
        if (closeables == null)
            return;
        try {
            for (Closeable closeable : closeables) {
                if (closeable != null) {
                    closeable.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 安静关闭IO
     *
     * @param closeables closeable
     */
    public static void closeIOQuietly(Closeable... closeables) {
        if (closeables == null)
            return;
        for (Closeable closeable : closeables) {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (IOException ignored) {
                }
            }
        }
    }

}
