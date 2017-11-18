package com.example.pub.net;

import com.example.pub.common.Keys;
import com.example.pub.utils.app.AppUtils;
import com.example.pub.utils.app.SignUtils;
import com.example.pub.utils.data.SPUtil;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;


/**
 * 暂不使用
 * description api鉴权
 * author hanlei
 * version 1.0
 * created at 2016/11/15 9:36
 */
public class ApiSign {

    public SimpleDateFormat mFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public String UUID = "";// UUID
    public String secret = "12345678"; // 秘钥

    public Map<String, String> headerMap = new HashMap<String, String>();


    public ApiSign() {
        init();
    }

    /**
     * 初始数据
     */
    private void init() {

        UUID = (String) SPUtil.get(Keys.KEY_UUID, UUID);
        secret = (String) SPUtil.get(Keys.KEY_SECRET, secret);

        // 如果没有UUID则去获取
        if (UUID.equals("") || UUID == "") {
            UUID = AppUtils.getUUID();
            SPUtil.putAndApply(Keys.KEY_UUID, UUID);
        }

    }

    /**
     * 初始化头部信息
     *
     * @param url
     */
    public synchronized void initSignHeader(String url) {

        long timestamp = getTimestamp();

        headerMap.clear();
        //headerMap.put("time",mFormatter.format(new Date()));
        headerMap.put("UUID", UUID);
        headerMap.put("timestamp", "" + timestamp);

        sign(url, timestamp);
    }

    /**
     * 进行签名
     *
     * @param url
     * @param timestamp
     */
    public void sign(String url, long timestamp) {

        if (url.startsWith("api")) {
            url = url.substring(3);
        }

        // md5加密
        String signText = SignUtils.getSignText(secret, url, timestamp);
        // 添加到头部
        headerMap.put("sign", signText.toString().trim());
    }

    /**
     * 获取当前时间戳
     *
     * @return 时间戳
     */
    private static long getTimestamp() {
        return System.currentTimeMillis();
    }

}
