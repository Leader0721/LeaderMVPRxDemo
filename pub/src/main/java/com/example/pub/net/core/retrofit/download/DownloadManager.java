package com.example.pub.net.core.retrofit.download;

import com.example.pub.net.core.retrofit.net.RxUtils;

import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import rx.Observable;

/**
 * 下载管理
 */
public class DownloadManager {

    private static DownloadManager mInstance;

    private Retrofit retrofit = null;
    private OkHttpClient okHttpClient = null;
    private final DownloadApi appInterface;
    private Interceptor downloadInterceptor;

    private String host;

    public DownloadManager(String host) {
        this.host = host;
        downloadInterceptor = new DownloadInterceptor();
        initOkHttp();
        initRetrofit();
        appInterface = retrofit.create(DownloadApi.class);
    }

    private void initOkHttp() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.addInterceptor(downloadInterceptor);
        builder.addNetworkInterceptor(downloadInterceptor);
        //设置超时
        builder.connectTimeout(30, TimeUnit.SECONDS);
        builder.readTimeout(10*60, TimeUnit.SECONDS);
        builder.writeTimeout(200, TimeUnit.SECONDS);
        //错误重连
        builder.retryOnConnectionFailure(true);
        okHttpClient = builder.build();
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

    public static DownloadManager getInstance(String host) {
        if (mInstance == null) {
            synchronized (DownloadManager.class) {
                if (mInstance == null) {
                    mInstance = new DownloadManager(host);
                }
            }
        }
        return mInstance;
    }


    /**
     * 下载文件
     */
    public Observable<ResponseBody> downLoad(String url) {
        return appInterface.downloadFile(url).compose(RxUtils.<ResponseBody>rxSchedulerHelper2()).compose(RxUtils.<ResponseBody>transformerDownLoadHelper());
    }
}
