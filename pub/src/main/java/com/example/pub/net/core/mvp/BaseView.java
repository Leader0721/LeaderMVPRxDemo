package com.example.pub.net.core.mvp;


import com.example.pub.net.core.retrofit.netError.ApiException;

/**
 * MVP--V
 */

public interface BaseView {

    //请求开始
    void start(String url);
    //请求成功
    void success(String url, Object t);
    //请求错误
    void error(String url, ApiException e);

}
