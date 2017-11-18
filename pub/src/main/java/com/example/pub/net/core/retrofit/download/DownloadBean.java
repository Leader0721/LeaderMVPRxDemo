package com.example.pub.net.core.retrofit.download;

import android.support.v7.app.NotificationCompat;


public class DownloadBean {

    private int fileId;
    private String name;//文件名称
    private String url;//下载路径
    private String fileName;//文件名称带类型
    private boolean isShowNotification;//是否显示通知
    private NotificationCompat.Builder builder;

    public DownloadBean(int fileId, String name, String url, String fileName, boolean isShowNotification, NotificationCompat.Builder builder) {
        this.name = name;
        this.url = url;
        this.fileName = fileName;
        this.isShowNotification = isShowNotification;
        this.builder = builder;
        this.fileId = fileId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public boolean isShowNotification() {
        return isShowNotification;
    }

    public void setShowNotification(boolean showNotification) {
        isShowNotification = showNotification;
    }

    public NotificationCompat.Builder getBuilder() {
        return builder;
    }

    public void setBuilder(NotificationCompat.Builder builder) {
        this.builder = builder;
    }

    public int getFileId() {
        return fileId;
    }

    public void setFileId(int fileId) {
        this.fileId = fileId;
    }

    @Override
    public String toString() {
        return "DownloadBean{" +
                "fileId=" + fileId +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", fileName='" + fileName + '\'' +
                ", isShowNotification=" + isShowNotification +
                ", builder=" + builder +
                '}';
    }
}
