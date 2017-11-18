package com.example.pub.bean;

/**
 * 文件上传下载进度 EventBus
 */

public class FileProgressEvent {

    private String url;//下载路径
    private boolean isDownload;
    private long contentLength;//文件总长度
    private long totalBytesRead;//已读、已写长度
    private boolean isDone;//是否完成
    private int progress;//进度

    public int getProgress() {
        return progress;
    }

    public FileProgressEvent(String url, boolean isDownload, long contentLength, long totalBytesRead, boolean isDone) {
        this.isDownload = isDownload;
        this.contentLength = contentLength;
        this.totalBytesRead = totalBytesRead;
        this.isDone = isDone;
        this.url = url;
        this.progress= (int) (((float) totalBytesRead*100) / contentLength);
    }

    public boolean isDownload() {
        return isDownload;
    }

    public void setDownload(boolean download) {
        isDownload = download;
    }

    public long getContentLength() {
        return contentLength;
    }

    public void setContentLength(long contentLength) {
        this.contentLength = contentLength;
    }

    public long getTotalBytesRead() {
        return totalBytesRead;
    }

    public void setTotalBytesRead(long totalBytesRead) {
        this.totalBytesRead = totalBytesRead;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "FileProgressEvent{" +
                "url='" + url + '\'' +
                ", isDownload=" + isDownload +
                ", contentLength=" + contentLength +
                ", totalBytesRead=" + totalBytesRead +
                ", isDone=" + isDone +
                '}';
    }
}
