package com.example.pub.net.core.retrofit;

import android.content.Context;

import com.example.pub.net.BaseConfig;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Retrofit网络请求相关
 */
public class RetrofitSingleton {

    private Retrofit retrofit = null;
    private OkHttpClient okHttpClient = null;

    private String host;

    public RetrofitSingleton(String host, Context context) {
        this.host = host;
        initOkHttp();
        initRetrofit();
    }

    private void initOkHttp() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();

        if (BaseConfig.ENVIRONMENT != BaseConfig.RELEASE || BaseConfig.PRENTF_LOG) { // 如果不是发布，就可以打印
            //https://drakeet.me/retrofit-2-0-okhttp-3-0-config
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            builder.addInterceptor(loggingInterceptor).build();
        }

        if (okHttpClient == null) {
            synchronized (RetrofitSingleton.class) {
                if (okHttpClient == null) {
                    //设置超时
                    builder.connectTimeout(15, TimeUnit.SECONDS);
                    builder.readTimeout(20*3*5, TimeUnit.SECONDS);
                    builder.writeTimeout(20*3*5, TimeUnit.SECONDS);
                    //错误重连
                    builder.retryOnConnectionFailure(true);
                    okHttpClient = builder.build();
                }
            }
        }

    }

    private void initRetrofit() {
        retrofit = new Retrofit.Builder()
                .baseUrl(host)
                .client(okHttpClient)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }
}
