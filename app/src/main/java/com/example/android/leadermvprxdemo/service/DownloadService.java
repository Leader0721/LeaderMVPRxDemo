package com.example.android.leadermvprxdemo.service;

import android.app.Notification;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.IBinder;
import android.support.v4.content.FileProvider;
import android.support.v7.app.NotificationCompat;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import android.widget.Toast;

import com.example.android.leadermvprxdemo.R;
import com.example.android.leadermvprxdemo.bean.DownloadBean;
import com.example.pub.bean.FileProgressEvent;
import com.example.pub.net.API;
import com.example.pub.net.core.retrofit.download.DownloadManager;
import com.example.pub.net.core.retrofit.download.FileDownLoad;
import com.example.pub.net.core.retrofit.net.NetCancelListener;
import com.example.pub.net.core.retrofit.net.NetSubscriber;
import com.example.pub.net.core.retrofit.netError.ApiException;
import com.example.pub.utils.function.LogUtils;

import org.simple.eventbus.EventBus;
import org.simple.eventbus.Subscriber;

import java.io.File;
import java.util.HashMap;

import okhttp3.ResponseBody;

/**
 * 下载服务程序
 */
public class DownloadService extends Service implements NetCancelListener {

    public final static String KEY_DOWNBEAN = "DownloadBean";

    private String TAG = "DownloadService";
    private HashMap<String, DownloadBean> files = new HashMap<>();//下载任务，名称键值对

    @Override
    public void onCreate() {
        super.onCreate();

        LogUtils.e(TAG, "onCreate");

        EventBus.getDefault().register(this);
    }

    @Override
    public IBinder onBind(Intent intent) {

        LogUtils.e(TAG, "onBind");

        return null;
    }

    /**
     * 接收到下载任务
     */
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        LogUtils.e(TAG, "onStartCommand");

        if (intent == null || !intent.hasExtra(KEY_DOWNBEAN)) {
            return super.onStartCommand(intent, flags, startId);
        }
        DownloadBean customDownLoadBean = intent.getParcelableExtra(KEY_DOWNBEAN);

        String host = API.HOST;
        String url = customDownLoadBean.getUrl();
        String fileName = customDownLoadBean.getFileName();
        String name = customDownLoadBean.getName();
        boolean isShowNotification = customDownLoadBean.isShowNotification();

        if (TextUtils.isEmpty(url) || TextUtils.isEmpty(fileName) || TextUtils.isEmpty(host)) {
            LogUtils.e(TAG, "下载参数无效无效");
            return super.onStartCommand(intent, flags, startId);
        }

        if (files.containsKey(url)) {
            LogUtils.e(TAG, "当前文件正在下载中");
            return super.onStartCommand(intent, flags, startId);
        }
        if (TextUtils.isEmpty(name)) {
            name = fileName;
            String[] files = fileName.split("\\.");
            if (files.length > 0) {
                name = files[0];
            }
        }
        int fileId = (int) System.currentTimeMillis();
        NotificationCompat.Builder builder = null;
        if (isShowNotification) {
            builder = setForeground(fileId, name);
        }
        customDownLoadBean.setBuilder(builder);

        files.put(url, customDownLoadBean);
        DownloadManager.getInstance(host).downLoad(url).subscribe(new NetSubscriber<>(url, this));
        return super.onStartCommand(intent, flags, startId);
    }


    @Subscriber
    public void onEventMainThread(FileProgressEvent event) {
        freshProgress(event.getUrl(), event.getProgress());
    }

    @Subscriber
    public void onEventMainThread(DownloadBean event) {

        if (event.getType() == null) {
            return;
        }

        if (DownloadBean.TYPE_APP_VARSION.equals(event.getType())) {

            LogUtils.e(TAG, "====" + event.getFilePath());

            File file = new File(event.getFilePath());
            if (file.exists()) {
                openFile(file, getApplication());
            }

        }


        //stopSelf();

    }


    public void openFile(File var0, Context var1) {
        Intent var2 = new Intent();
        var2.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        var2.setAction(Intent.ACTION_VIEW);
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.M) {
            Uri uriForFile = FileProvider.getUriForFile(var1, var1.getApplicationContext().getPackageName() + ".provider", var0);
            var2.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            //var2.setDataAndType(uriForFile, var1.getContentResolver().getType(uriForFile)); // "application/vnd.android.package-archive");//
            var2.setDataAndType(Uri.fromFile(var0), var1.getContentResolver().getType(uriForFile)); // "application/vnd.android.package-archive");//
        } else {
            var2.setDataAndType(Uri.fromFile(var0), getMIMEType(var0));
        }
        try {
            var1.startActivity(var2);
        } catch (Exception var5) {
            var5.printStackTrace();
            LogUtils.e("DownloadService", var5);
            Toast.makeText(var1, "没有找到打开此类文件的程序", Toast.LENGTH_SHORT).show();
        }
    }

    public String getMIMEType(File var0) {
        String var1 = "";
        String var2 = var0.getName();
        String var3 = var2.substring(var2.lastIndexOf(".") + 1, var2.length()).toLowerCase();
        var1 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(var3);
        return var1;
    }


    @Override
    public void onStart(String url) {
        LogUtils.e(TAG, "onStart url:" + url);
    }

    /**
     * 下载成功
     *
     * @param url
     * @param t
     */
    @Override
    public void onSuccess(String url, Object t) {

        LogUtils.e(TAG, "onSuccess url:" + url);

        DownloadBean bean = files.get(url);
        File file = FileDownLoad.downLoadFile(getBaseContext(), (ResponseBody) t, bean.getFileName());

        if (!file.exists()) {
            bean.setLoadSucess(false);
        } else {
            bean.setLoadSucess(true);
            bean.setFilePath(file.getAbsolutePath());
        }

        switch (bean.getType()) {

            case DownloadBean.TYPE_APP_VARSION: {// 如果是版本更新
                EventBus.getDefault().post(bean);
            }
            break;

            case DownloadBean.TYPE_FILE_PPT: {// 如果是下载PPT
                EventBus.getDefault().post(bean);
            }
            break;
            case DownloadBean.TYPE_AUDIO: {// 如果是下载音频
//                EventBus.getDefault().post(bean);
//                EventBus.getDefault().post(new EventCustom(bean, CommonKey.CORRECT_DOWNLOAD_AUDIO));
            }
            break;
            case DownloadBean.TYPE_PIC: {// 如果是下载图片
//                EventBus.getDefault().post(bean);
//                EventBus.getDefault().post(new EventCustom(bean, CommonKey.CORRECT_DOWNLOAD_AUDIO));
            }
            break;
        }

        stopSelf();

    }

    /**
     * 下载失败
     *
     * @param url 下载路径
     * @param e   异常
     */
    @Override
    public void onError(String url, ApiException e) {

        LogUtils.e(TAG, "onCompleted url:" + url + ", e:" + e.toString());

        removeTask(url);
    }


    /**
     * 由下载任务中删除
     *
     * @param url 下载路径
     */
    private void removeTask(String url) {
        if (files == null) return;
        files.remove(url);
        if (files.isEmpty()) {
            stopSelf();
        }
    }

    /**
     * 设置为前台服务，显示通知
     *
     * @param fileId
     * @param name   需要下载的文件名称
     * @return
     */
    private NotificationCompat.Builder setForeground(int fileId, String name) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher));
        //禁止用户点击删除按钮删除
        builder.setAutoCancel(true);
        //取消右上角的时间显示
        builder.setShowWhen(true);
        builder.setPriority(NotificationCompat.PRIORITY_MAX);
        builder.setContentTitle(name);
        builder.setProgress(100, 0, false).setContentTitle("下载进度" + 0 + "%");
        Notification notification = builder.build();
        notification.defaults = Notification.DEFAULT_LIGHTS;
        notification.flags |= Notification.FLAG_AUTO_CANCEL;
        startForeground(fileId, notification);
        return builder;
    }

    /**
     * 销毁
     */
    @Override
    public void onDestroy() {
        EventBus.getDefault().unregister(this);
        stopForeground(true);
        super.onDestroy();
    }

    /**
     * 刷新下载进度
     *
     * @param url      下载路径
     * @param progress 下载进度
     */
    private void freshProgress(String url, int progress) {
        DownloadBean downloadBean = files.get(url);
        if (downloadBean == null) {
            return;
        }
        if (downloadBean.isShowNotification()) {
            NotificationCompat.Builder builder = downloadBean.getBuilder();
            builder.setProgress(100, progress, false).setContentTitle("下载进度" + progress + "%");
            startForeground(downloadBean.getLoadId(), builder.build());
        }
    }

}