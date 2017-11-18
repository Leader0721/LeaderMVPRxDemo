package com.example.pub.net.core.retrofit.net;

import com.example.pub.net.core.retrofit.netError.ApiException;

/**
 * 网络请求回调接口
 */

public interface NetCancelListener {

    //请求开始
    void onStart(String url);

    //请求成功
    void onSuccess(String url, Object t);

    //请求错误
    void onError(String url, ApiException e);
}
