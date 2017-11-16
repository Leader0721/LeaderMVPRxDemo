package com.example.pub.utils.app;

import android.util.Base64;

import com.example.pub.utils.function.EncryptUtils;


/**
 * @Description:签名验证工具类
 * @Prject:
 * @Package: com.example.pub.utils
 * @author: Leader
 * @date: 2017/11/14   20:00
 * @Copyright: 个人版权所有
 * @Company:bc
 * @version: 1.0.0
 */


public class SignUtils {


    private static String salt = "baichuantushu";
    /**
     * 请求时间不能大于当前时间10分钟
     */
    private static final long EXCEED_TIME_DIFFERENCE = 10 * 60 * 1000;
    /**
     * 请求时间不能小于当前时间10分钟
     */
    private static final long LOWER_TIME_DIFFERENCE = 10 * 60 * 1000 * -1;

    public static String getSign(String deviceId) throws Exception {
        return EncryptUtils.encryption(deviceId + salt);
    }

    /**
     * @param sign      签名
     * @param secret    密匙
     * @param method    方法
     * @param timestamp 时间戳
     * @return
     */
    @SuppressWarnings("Since15")
    public static boolean validation(String sign, String secret, String method, long timestamp) {

        //验证时间戳是否过期
        //误差不能大于10分钟
        long timeDifference = System.currentTimeMillis() - timestamp;
        if (timeDifference > EXCEED_TIME_DIFFERENCE || timeDifference < LOWER_TIME_DIFFERENCE) {
            return false;
        }
        //验证签名
        //按约定组合字符串
        StringBuilder sb = new StringBuilder().append(secret).append(method).append(timestamp).append(secret);
        String sbMed5 = EncryptUtils.encryption(sb.toString());
        //md5加密
        String buildSign = Base64.encodeToString(sbMed5.getBytes(), Base64.DEFAULT);
        //转为大写并进行比对
        if (sign.toUpperCase().equals(buildSign.toUpperCase())) {
            return true;
        }
        return false;

    }

    /**
     * 生成签名
     *
     * @param secret
     * @param method
     * @param timestamp
     * @return
     */
    @SuppressWarnings("Since15")
    public static String getSignText(String secret, String method, long timestamp) {

        //验证签名
        //按约定组合字符串
        StringBuilder sb = new StringBuilder().append(secret).append(method).append(timestamp).append(secret);
        String sbMed5 = EncryptUtils.encryption(sb.toString());
        //md5加密
        String buildSign = Base64.encodeToString(sbMed5.getBytes(), Base64.DEFAULT);
        //转为大写并进行比对

        //LogUtils.e("SignUtils","secret:"+secret+",method:"+method+",timestamp:"+timestamp);
        //LogUtils.e("SignUtils","str_before:"+sb.toString());
        //LogUtils.e("SignUtils","str_after:"+buildSign);

        return buildSign;

    }


    @SuppressWarnings("Since15")
    public static String md5(String text) {

        String sbMed5 = EncryptUtils.encryption(text);
        //md5加密
        //String buildSign = Base64.encodeToString(sbMed5.getBytes(),Base64.DEFAULT);
        //转为大写并进行比对
        return sbMed5;

    }

}
