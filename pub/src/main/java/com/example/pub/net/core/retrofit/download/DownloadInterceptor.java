package com.example.pub.net.core.retrofit.download;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class DownloadInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        String url = request.url().url().toString();
        Response orginalResponse = chain.proceed(request);
        //注意进度的监听发生在子线程中，要切记
        return orginalResponse.newBuilder()
                .body(new ProgressResponseBody(url, orginalResponse))
                .build();
    }
}
