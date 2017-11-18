package com.example.pub.net.core.retrofit.net;

import com.example.pub.net.core.retrofit.netError.ApiException;
import com.example.pub.net.core.retrofit.netError.ServerException;
import com.example.pub.utils.function.LogUtils;

import rx.Subscriber;

/**
 * 用来集成网络请求，仅支持主线程操作（其他线程，代码中自主操作）
 * 网络请求的前期处理这里进行，App端网络请求的Subscriber采用或继承NetSubscriber
 */

public class NetSubscriber<T> extends Subscriber<T> {

    private String url;//用来分辨是哪个网络请求的返回
    private NetCancelListener netCancelListener;//网络请求回调

    public NetSubscriber(String url, NetCancelListener netCancelListener) {
        super();
        this.url = url;
        this.netCancelListener = netCancelListener;
    }

    public NetSubscriber(NetCancelListener netCancelListener) {
        super();
        this.url = "";
        this.netCancelListener = netCancelListener;
    }

    @Override
    public void onStart() {
        netCancelListener.onStart(url);
    }

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {

        if (e instanceof ServerException) {

            ServerException se = (ServerException) e;
            netCancelListener.onError(url, new ApiException(se.getCode(), se.getMessage()));

            LogUtils.e("Retrofit error", se.toString());
        } else if (e instanceof ApiException) {
            netCancelListener.onError(url, (ApiException) e);

            LogUtils.e("Retrofit error", ((ApiException) e).toString());

        } else {
            netCancelListener.onError(url, new ApiException("100000", "网络错误"));
            LogUtils.e("Retrofit error", "" + e.toString());

        }

        //此处判断是否是由于token失效导致的问题
        //保存失败的网络请求
        //自动登录获取新的Token
    }

    @Override
    public void onNext(T t) {
        netCancelListener.onSuccess(url, t);
        //判断是否是自动登录
        //如果是自动登录，保存Token,执行之前失败的网络请求
    }
}
