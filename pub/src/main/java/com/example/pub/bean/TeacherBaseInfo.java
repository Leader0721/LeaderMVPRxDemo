package com.example.pub.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

import java.io.Serializable;

/**
 * description 教师基本资料
 * author hanlei
 * version 1.0
 * created at 2016/11/24 10:37
 */
@Entity
public class TeacherBaseInfo implements Serializable {

    @Id
    private Long id;
    private String uuid;

    /**
     * loginName : 1111111
     * userName : pad贾
     * headImg : /user/headimg/cb5d8730b90b42d5aba4af094f549487.png
     * provinceId : 110000
     * cityId : 110100
     * countyId : 110101
     * provinceName : 北京
     * cityName : 北京市
     * countyName : 东城区
     * schoolId : 078073b0a80d4d8caa8fdc6ae3f13d49
     * schoolName : 北京市东直门中学
     * subjectId : 01
     * subjectName : 语文
     * materialId : 070101
     * materialName : 人教版语文七年级上册
     * mobile : 18653024600
     * email :
     */

    private String loginName;
    private String userName;
    private String headImg;
    private String provinceId;
    private String cityId;
    private String countyId;
    private String provinceName;
    private String cityName;
    private String countyName;
    private String schoolId;
    private String schoolName;
    private String subjectId;
    private String subjectName;
    private String materialId;
    private String materialName;
    private String mobile;
    private String email;

    @Generated(hash = 225354359)
    public TeacherBaseInfo(Long id, String uuid, String loginName, String userName,
                           String headImg, String provinceId, String cityId, String countyId,
                           String provinceName, String cityName, String countyName,
                           String schoolId, String schoolName, String subjectId,
                           String subjectName, String materialId, String materialName,
                           String mobile, String email) {
        this.id = id;
        this.uuid = uuid;
        this.loginName = loginName;
        this.userName = userName;
        this.headImg = headImg;
        this.provinceId = provinceId;
        this.cityId = cityId;
        this.countyId = countyId;
        this.provinceName = provinceName;
        this.cityName = cityName;
        this.countyName = countyName;
        this.schoolId = schoolId;
        this.schoolName = schoolName;
        this.subjectId = subjectId;
        this.subjectName = subjectName;
        this.materialId = materialId;
        this.materialName = materialName;
        this.mobile = mobile;
        this.email = email;
    }

    @Generated(hash = 120401495)
    public TeacherBaseInfo() {
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public String getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getCountyId() {
        return countyId;
    }

    public void setCountyId(String countyId) {
        this.countyId = countyId;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCountyName() {
        return countyName;
    }

    public void setCountyName(String countyName) {
        this.countyName = countyName;
    }

    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getMaterialId() {
        return materialId;
    }

    public void setMaterialId(String materialId) {
        this.materialId = materialId;
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUuid() {
        return this.uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
