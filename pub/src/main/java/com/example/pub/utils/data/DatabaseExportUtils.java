package com.example.pub.utils.data;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;

import com.example.pub.utils.function.LogUtils;

/**
 * @Description:1.DEBUG 属性决定是否导出
 * 2.启动导出数据库方法
 * @Prject:
 * @Package: com.example.pub.utils.data
 * @author: Leader
 * @date: 2017/11/16   15:34
 * @Copyright: 个人版权所有
 * @Company:bc
 * @version: 1.0.0
 */
public class DatabaseExportUtils {
    private static final boolean DEBUG = true;
    private static final String TAG = "DatabaseExportUtils";

    /**
     * Don't let anyone instantiate this class.
     */
    private DatabaseExportUtils() {
        throw new Error("Do not need instantiate!");
    }

    /**
     * 开始导出数据 此操作比较耗时,建议在线程中进行
     *
     * @param context      上下文
     * @param targetFile   目标文件
     * @param databaseName 要拷贝的数据库文件名
     * @return 是否倒出成功
     */
    public boolean startExportDatabase(Context context, String targetFile,
                                       String databaseName) {
        if (DEBUG) {
            LogUtils.d(TAG, "start export ...");
        }
        if (!Environment.MEDIA_MOUNTED.equals(Environment
                .getExternalStorageState())) {
            if (DEBUG) {
                LogUtils.w(TAG, "cannot find SDCard");
            }
            return false;
        }
        String sourceFilePath = Environment.getDataDirectory() + "/data/"
                + context.getPackageName() + "/databases/" + databaseName;
        String destFilePath = Environment.getExternalStorageDirectory()
                + (TextUtils.isEmpty(targetFile) ? (context.getPackageName() + ".db")
                : targetFile);
        boolean isCopySuccess = FileUtils
                .copyFile(sourceFilePath, destFilePath);
        if (DEBUG) {
            if (isCopySuccess) {
                LogUtils.d(TAG, "copy database file success. target file : "
                        + destFilePath);
            } else {
                LogUtils.w(TAG, "copy database file failure");
            }
        }
        return isCopySuccess;
    }
}
