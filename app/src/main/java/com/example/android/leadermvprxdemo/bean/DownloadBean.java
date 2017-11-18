package com.example.android.leadermvprxdemo.bean;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.app.NotificationCompat;

/**
 * Created by Android on 2017/11/16.
 */

public class DownloadBean implements Parcelable {
    public static final String TYPE_APP_VARSION = "TYPE_APP_VARSION"; // 版本下载
    public static final String TYPE_FILE_PPT = "TYPE_FILE_PPT"; // PPT下载
    public static final String TYPE_AUDIO = "TYPE_AUDIO"; // 批改界面的音频的下载
    public static final String TYPE_PIC = "TYPE_PIC"; // 批改界面的图片的下载

    private String url; // 下载地址
    private String name; // 文件名称
    private String fileName; // 文件名带拓展名
    private boolean isLoadSucess; // 下载成功
    private String filePath; // 下载到本地
    private int loadId = 1; // 下载ID
    private String id; // ID
    private boolean isShowNotification; // 是否显示在通知栏
    private String type; // 下载类型
    private NotificationCompat.Builder builder;

    public DownloadBean() {

    }


    public DownloadBean(String url, String id) {
        this.url = url;
        this.id = id;
    }

    public DownloadBean(String url) {
        this.url = url;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public boolean isLoadSucess() {
        return isLoadSucess;
    }

    public void setLoadSucess(boolean loadSucess) {
        isLoadSucess = loadSucess;
    }

    public int getLoadId() {
        return loadId;
    }

    public void setLoadId(int loadId) {
        this.loadId = loadId;
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

    public boolean isShowNotification() {
        return isShowNotification;
    }

    public void setShowNotification(boolean showNotification) {
        isShowNotification = showNotification;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public NotificationCompat.Builder getBuilder() {
        return builder;
    }

    public void setBuilder(NotificationCompat.Builder builder) {
        this.builder = builder;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.url);
        dest.writeString(this.name);
        dest.writeString(this.fileName);
        dest.writeByte(this.isLoadSucess ? (byte) 1 : (byte) 0);
        dest.writeString(this.filePath);
        dest.writeInt(this.loadId);
        dest.writeString(this.id);
        dest.writeByte(this.isShowNotification ? (byte) 1 : (byte) 0);
        dest.writeString(this.type);
    }

    protected DownloadBean(Parcel in) {
        this.url = in.readString();
        this.name = in.readString();
        this.fileName = in.readString();
        this.isLoadSucess = in.readByte() != 0;
        this.filePath = in.readString();
        this.loadId = in.readInt();
        this.id = in.readString();
        this.isShowNotification = in.readByte() != 0;
        this.type = in.readString();
    }

    public static final Parcelable.Creator<DownloadBean> CREATOR = new Parcelable.Creator<DownloadBean>() {
        @Override
        public DownloadBean createFromParcel(Parcel source) {
            return new DownloadBean(source);
        }

        @Override
        public DownloadBean[] newArray(int size) {
            return new DownloadBean[size];
        }
    };
}
