package com.example.pub.utils.data;

import android.annotation.SuppressLint;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.provider.DocumentsContract;
import android.provider.MediaStore;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
/**
 * TODO
 * @Description:文件相关的处理类，有待优化
 * @Prject:
 * @Package: com.example.pub.utils
 * @author: Leader
 * @date: 2017/11/14   20:03
 * @Copyright: 个人版权所有
 * @Company:bc
 * @version: 1.0.0
 */
public class FileUtils1 {

    /**
     * 是否存在外部存储
     */
    public static final boolean isExternalMemoryAvailable() {
        return "mounted".equals(Environment.getExternalStorageState()) && Environment.getExternalStorageState() != null && "mounted_ro" != Environment.getExternalStorageState();
    }

    /**
     * 获取外部存储路径
     */
    public static final String getExternalMemoryPath() {
        return isExternalMemoryAvailable() ? Environment.getExternalStorageDirectory().getPath() : null;
    }

    /**
     * 获取临时缓存目录
     * getCacheDir()方法用于获取/data/data//cache目录
     */
    public static final String getCacheDir(Context context) {
        if (isExternalMemoryAvailable()) {
            File file = context.getExternalCacheDir();
            if (file != null) {
                return file.getPath() + "/";
            }
        }

        return context.getCacheDir().getPath() + "/";
    }

    /**
     * 获取临时文件路径
     * getFilesDir()方法用于获取/data/data//files目录
     */
    public static final String getFilesDir(Context context) {
        String path = isExternalMemoryAvailable() ? context.getExternalFilesDir((String) null).getPath() + "/" : context.getFilesDir().getPath() + "/";
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }

        return path;
    }

    /**
     * 删除临时文件
     *
     * @param context
     */
    public static final void deleteFile(Context context) {
        File cacheDir = new File(getFilesDir(context));
        if (cacheDir.exists()) {
            File[] files = cacheDir.listFiles();
            for (int i = 0; i < files.length; ++i) {
                files[i].delete();
            }
        }
    }

    /**
     * 删除临时缓存文件
     *
     * @param context
     */
    public static final void deleteCacheDir(Context context) {
        File cacheDir = new File(getCacheDir(context));
        if (cacheDir.exists()) {
            File[] files = cacheDir.listFiles();
            for (int i = 0; i < files.length; ++i) {
                files[i].delete();
            }
        }
    }


    /**
     * 获取文件名称
     *
     * @return
     */
    public static final String getFileName() {
        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault());
        return dateFormat.format(date);
    }


    /**
     * 获取文件
     */
    public static File getTempFile(Context context) {
        String savedir = getCacheDir(context);
        File dir = new File(savedir);
        if (!dir.exists())
            dir.mkdirs();
        String tempPath = savedir + getFileName() + ".png";// 保存路径
        File file = new File(tempPath);
        try {
            file.createNewFile();
        } catch (IOException e) {
        }
        return file;
    }

    /**
     * 获取文件
     */
    public static File getFile(Context context) {
        String savedir = getFilesDir(context);
        File dir = new File(savedir);
        if (!dir.exists())
            dir.mkdirs();
        String tempPath = savedir + getFileName() + ".png";// 保存路径
        File file = new File(tempPath);
        try {
            file.createNewFile();
        } catch (IOException e) {
        }
        return file;
    }
            /*String[] filePathColumns = {MediaStore.Images.Media.DATA};
            Cursor c = getContentResolver().query(selectedImage, filePathColumns, null, null, null);
            c.moveToFirst();
            int columnIndex = c.getColumnIndex(filePathColumns[0]);
            String imagePath = c.getString(columnIndex);
            c.close();*/

    /**
     * 根据URI获取文件路径
     */
    @SuppressLint("NewApi")
    public static String getPath(final Context context, final Uri uri) {
        final boolean isKitKat = Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT;

        // DocumentProvider
        if (isKitKat && DocumentsContract.isDocumentUri(context, uri)) {
            // ExternalStorageProvider
            if (isExternalStorageDocument(uri)) {
                final String docId = DocumentsContract.getDocumentId(uri);
                final String[] split = docId.split(":");
                final String type = split[0];

                if ("primary".equalsIgnoreCase(type)) {
                    return Environment.getExternalStorageDirectory() + "/" + split[1];
                }
            }
            // DownloadsProvider
            else if (isDownloadsDocument(uri)) {

                final String id = DocumentsContract.getDocumentId(uri);
                final Uri contentUri = ContentUris.withAppendedId(
                        Uri.parse("content://downloads/public_downloads"), Long.valueOf(id));

                return getDataColumn(context, contentUri, null, null);
            }
            // MediaProvider
            else if (isMediaDocument(uri)) {
                final String docId = DocumentsContract.getDocumentId(uri);
                final String[] split = docId.split(":");
                final String type = split[0];

                Uri contentUri = null;
                if ("image".equals(type)) {
                    contentUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                } else if ("video".equals(type)) {
                    contentUri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                } else if ("audio".equals(type)) {
                    contentUri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                }

                final String selection = "_id=?";
                final String[] selectionArgs = new String[]{split[1]};

                return getDataColumn(context, contentUri, selection, selectionArgs);
            }
        }
        // MediaStore (and general)
        else if ("content".equalsIgnoreCase(uri.getScheme())) {
            return getDataColumn(context, uri, null, null);
        }
        // File
        else if ("file".equalsIgnoreCase(uri.getScheme())) {
            return uri.getPath();
        }

        return null;
    }

    public static String getDataColumn(Context context, Uri uri, String selection,
                                       String[] selectionArgs) {

        Cursor cursor = null;
        final String column = "_data";
        final String[] projection = {column};

        try {
            cursor = context.getContentResolver().query(uri, projection, selection, selectionArgs,
                    null);
            if (cursor != null && cursor.moveToFirst()) {
                final int column_index = cursor.getColumnIndexOrThrow(column);
                return cursor.getString(column_index);
            }
        } finally {
            if (cursor != null)
                cursor.close();
        }
        return null;
    }

    /**
     * @param uri The Uri to check.
     * @return Whether the Uri authority is ExternalStorageProvider.
     */
    public static boolean isExternalStorageDocument(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    /**
     * @param uri The Uri to check.
     * @return Whether the Uri authority is DownloadsProvider.
     */
    public static boolean isDownloadsDocument(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    /**
     * @param uri The Uri to check.
     * @return Whether the Uri authority is MediaProvider.
     */
    public static boolean isMediaDocument(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }

    public static boolean copy(String filePath, String savePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            return false;
        } else {
            BufferedInputStream inBuff = null;
            BufferedOutputStream outBuff = null;
            try {
                inBuff = new BufferedInputStream(new FileInputStream(file));
                File e = new File(savePath);
                if (!e.exists()) {
                    File b = e.getParentFile();
                    if (!b.exists()) {
                        b.mkdirs();
                    }
                    e.createNewFile();
                }
                outBuff = new BufferedOutputStream(new FileOutputStream(e));
                byte[] b1 = new byte[5120];
                int len;
                while ((len = inBuff.read(b1)) != -1) {
                    outBuff.write(b1, 0, len);
                }
                outBuff.flush();
                return true;
            } catch (Exception var16) {
            } finally {
                try {
                    if (inBuff != null) {
                        inBuff.close();
                    }

                    if (outBuff != null) {
                        outBuff.close();
                    }
                } catch (IOException var15) {
                }
            }
            return false;
        }
    }


    /**
     * 判断SDCard是否可用
     *
     * @return
     */
    public static boolean isSDCardEnable() {
        return Environment.getExternalStorageState().equals(
                Environment.MEDIA_MOUNTED);

    }

    /**
     * 获取SD卡路径
     *
     * @return
     */
    public static String getSDCardPath() {
        return Environment.getExternalStorageDirectory().getAbsolutePath()
                + File.separator;
    }

    /**
     * 获取SD卡的剩余容量 单位byte
     *
     * @return
     */
    public static long getSDCardAllSize() {
        if (isSDCardEnable()) {
            StatFs stat = new StatFs(getSDCardPath());
            // 获取空闲的数据块的数量
            long availableBlocks = (long) stat.getAvailableBlocks() - 4;
            // 获取单个数据块的大小（byte）
            long freeBlocks = stat.getAvailableBlocks();
            return freeBlocks * availableBlocks;
        }
        return 0;
    }

    /**
     * 获取指定路径所在空间的剩余可用容量字节数，单位byte
     *
     * @param filePath
     * @return 容量字节 SDCard可用空间，内部存储可用空间
     */
    public static long getFreeBytes(String filePath) {
        // 如果是sd卡的下的路径，则获取sd卡可用容量
        if (filePath.startsWith(getSDCardPath())) {
            filePath = getSDCardPath();
        } else {// 如果是内部存储的路径，则获取内存存储的可用容量
            filePath = Environment.getDataDirectory().getAbsolutePath();
        }
        StatFs stat = new StatFs(filePath);
        long availableBlocks = (long) stat.getAvailableBlocks() - 4;
        return stat.getBlockSize() * availableBlocks;
    }

    /**
     * 获取系统存储路径
     *
     * @return
     */
    public static String getRootDirectoryPath() {
        return Environment.getRootDirectory().getAbsolutePath();
    }

    /**
     * 检测SD卡是否挂载(也就是是否可用)
     *
     * @return
     */
    public static boolean isSDIsMounted() {
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            return true;
        }
        return false;
    }

    /**
     * 获取缓存大小
     *
     * @param context
     * @return
     */
    public static String getCacheSize(Context context) {

        String cacheDirPath = getCacheDir(context);
        File cacheDir = new File(cacheDirPath);

        if (cacheDir.exists()) {
            try {
                long size = getFileDirSize(cacheDir);
                String sizeStr = formatFileSize(size);

                return sizeStr;
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return "0KB";
    }

    /**
     * 获取文件大小
     *
     * @param path
     * @return
     */
    public static long getFileSize(String path) {
        if (isBlank(path)) {
            return -1;
        }

        File file = new File(path);
        return (file.exists() && file.isFile() ? file.length() : -1);
    }

    public static long getFileDirSize(File f) throws Exception {
        long size = 0;
        File flist[] = f.listFiles();
        for (int i = 0; i < flist.length; i++) {
            if (flist[i].isDirectory()) {
                size = size + getFileDirSize(flist[i]);
            } else {
                size = size + flist[i].length();
            }
        }
        return size;
    }

    /**
     * 转换文件大小
     *
     * @param fileS
     * @return B/KB/MB/GB
     */
    public static String formatFileSize(long fileS) {
        java.text.DecimalFormat df = new java.text.DecimalFormat("#.00");
        String fileSizeString = "";
        if (fileS < 1024) {
            fileSizeString = df.format((double) fileS) + "B";
        } else if (fileS < 1048576) {
            fileSizeString = df.format((double) fileS / 1024) + "KB";
        } else if (fileS < 1073741824) {
            fileSizeString = df.format((double) fileS / 1048576) + "MB";
        } else {
            fileSizeString = df.format((double) fileS / 1073741824) + "G";
        }

        if (fileSizeString.equals(".00B")) {
            return "0KB";
        }

        return fileSizeString;
    }

    /**
     * 获取文件大小
     *
     * @param size 字节
     * @return
     */
    public static String getFileSize(long size) {
        if (size <= 0) return "0";
        java.text.DecimalFormat df = new java.text.DecimalFormat("##.##");
        float temp = (float) size / 1024;
        if (temp >= 1024) {
            return df.format(temp / 1024) + "M";
        } else {
            return df.format(temp) + "K";
        }
    }

    public static boolean isBlank(String str) {
        return (str == null || str.trim().length() == 0);
    }


    public static void deleteFile(String fileName) {
        File file = new File(fileName);
        if (file.exists()) {
            file.delete();
        }
    }

    /**
     * 下载文件
     */
    public static File downLoadFile(Context context, ResponseBody response, String fileName) {
        BufferedSink bufferedSink = null;
        String filePath = FileUtils1.getFilesDir(context) + fileName;
        //String filePath = FileUtils1.getExternalMemoryPath() + fileName;

        File file = new File(filePath);
        if (!file.getParentFile().exists()) {
            return null;
        }
        try {
            /*bufferedSink = Okio.buffer(Okio.sink(file));
            bufferedSink.writeAll(response.source());*/
            //1.第一种存储文件的方式
            BufferedSource source = response.source();
            bufferedSink = Okio.buffer(Okio.sink(file));
            Buffer buffer = new Buffer();
            while (!source.exhausted()) {
                long count = source.read(buffer, 1024);
                bufferedSink.write(buffer, count);
            }
           /*
           第二种存储文件的方式
           InputStream is = response.byteStream();
            FileOutputStream fos = new FileOutputStream(file);
            BufferedInputStream bis = new BufferedInputStream(is);
            byte[] buffer = new byte[2048];
            int len;
            while ((len = bis.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
                fos.flush();
            }
            fos.close();
            bis.close();
            is.close();*/
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != bufferedSink) bufferedSink.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        /*Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setDataAndType(Uri.fromFile(file),
                "application/vnd.android.package-archive");
        context.startActivity(intent);*/
        return file;
    }
}
