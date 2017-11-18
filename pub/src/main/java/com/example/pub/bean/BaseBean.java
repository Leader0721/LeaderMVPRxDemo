package com.example.pub.bean;

import java.io.Serializable;


/**
 * description 基本数据结构
 * author hanlei
 * version 1.0
 * created at 2016/11/14 10:31
 */
public class BaseBean<T> implements Serializable {

    private String retMsg;
    private T retData;
    private String retCode;
    private String retGold;

    public String getRetMsg() {
        return retMsg;
    }

    public void setRetMsg(String retMsg) {
        this.retMsg = retMsg;
    }

    public T getRetData() {
        return retData;
    }

    public void setRetData(T retData) {
        this.retData = retData;
    }

    public String getRetCode() {
        return retCode;
    }

    public void setRetCode(String retCode) {
        this.retCode = retCode;
    }

    public String getRetGold() {
        return retGold;
    }

    public void setRetGold(String retGold) {
        this.retGold = retGold;
    }

    @Override
    public String toString() {
        return "BaseBean{" +
                "retMsg='" + retMsg + '\'' +
                ", retData=" + retData +
                ", retCode=" + retCode +
                ", retGold=" + retGold +
                '}';
    }
}
