package com.example.pub.net;

/**
 * 配置项
 */
public class BaseConfig {

    public static final int DEV = 0; // 开发
    public static final int TEST = 1; // 测试
    public static final int RELEASE = 2;// 生产

    public static int ENVIRONMENT = RELEASE; // 环境 默认开发
    public static boolean PRENTF_LOG = false; // 是否打印
}
