package com.example.pub.net.core.retrofit.download;

import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Streaming;
import retrofit2.http.Url;
import rx.Observable;


public interface DownloadApi {

    @Streaming
    @GET
    Observable<ResponseBody> downloadFile(@Url String fileUrl);


}
