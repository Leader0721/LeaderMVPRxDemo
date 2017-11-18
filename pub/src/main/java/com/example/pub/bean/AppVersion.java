package com.example.pub.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

/**
 * @Description:app版本迭代实体类必须加上注解
 * @Prject:
 * @Package: com.example.pub.bean
 * @author: Leader
 * @date: 2017/11/16   16:31
 * @Copyright: 个人版权所有
 * @Company:bc
 * @version: 1.0.0
 */
@Entity
public class AppVersion {


    /**
     * versionNo : 2
     * versionNo : 2
     * versionName : 12
     * updateReason : 12
     * isForce : 0
     * updateTime : 2017-05-04 18:42:54
     * downloadUrl : http://bos.bj.baidubce.com/v1/bc-admin/%E8%AF%AD%E6%96%87/201705/1493894555619_%E5%AD%A6%E7%94%9F%E7%AB%AF%E7%94%9F%E4%BA%A7%E7%8E%AF%E5%A2%830504.apk?authorization=bce-auth-v1%2F9b6a865549514d99bab82578610e550b%2F2017-05-04T10%3A51%3A18Z%2F-1%2F%2F08a3fbb83dfdd03ba3033c1d0abaa2b3708b7ec9f3c2e30ab7bc58c365b542ed
     * resFileId : 958d890b551b449d8b1d6206f642b2b4
     */


    private int versionNo = 0;
    private String versionName;
    private String updateReason;
    private String isForce;
    private String updateTime;
    private String downloadUrl;


    @Generated(hash = 423899208)
    public AppVersion(int versionNo, String versionName, String updateReason, String isForce, String updateTime, String downloadUrl) {
        this.versionNo = versionNo;
        this.versionName = versionName;
        this.updateReason = updateReason;
        this.isForce = isForce;
        this.updateTime = updateTime;
        this.downloadUrl = downloadUrl;
    }

    @Generated(hash = 1649400296)
    public AppVersion() {
    }


    public int getVersionNo() {
        return versionNo;
    }

    public void setVersionNo(int versionNo) {
        this.versionNo = versionNo;
    }

    public String getVersionName() {
        return versionName;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }

    public String getUpdateReason() {
        return updateReason;
    }

    public void setUpdateReason(String updateReason) {
        this.updateReason = updateReason;
    }

    public String getIsForce() {
        return isForce;
    }

    public void setIsForce(String isForce) {
        this.isForce = isForce;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }
}
