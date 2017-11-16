package com.example.pub.utils.constant;


/**
 * @Description:内存相关_常量类
 * @Prject:
 * @Package: com.example.pub.utils.constant
 * @author: Leader
 * @date: 2017/11/16   15:31
 * @Copyright: 个人版权所有
 * @Company:bc
 * @version: 1.0.0
 */
public class TimeContants {
    /**
     * 秒与毫秒的倍数
     */
    public static final int SEC = 1000;
    /**
     * 分与毫秒的倍数
     */
    public static final int MIN = 60000;
    /**
     * 时与毫秒的倍数
     */
    public static final int HOUR = 3600000;
    /**
     * 天与毫秒的倍数
     */
    public static final int DAY = 86400000;

    public enum TimeUnit {
        MSEC,
        SEC,
        MIN,
        HOUR,
        DAY
    }
}
