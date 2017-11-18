package com.example.pub.net.core.retrofit.download;

import com.example.pub.bean.FileProgressEvent;

import org.simple.eventbus.EventBus;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;
import okio.Source;

/**
 * 带进度的下载
 */

public class ProgressResponseBody extends ResponseBody {

    private final Response responseBody;
    private BufferedSource bufferedSource;
    private String url;//下载路径

    public ProgressResponseBody(String url, Response responseBody) {
        this.responseBody = responseBody;
        this.url = url;
    }

    @Override
    public MediaType contentType() {
        return responseBody.body().contentType();
    }

    @Override
    public long contentLength() {
        return responseBody.body().contentLength();
    }

    @Override
    public BufferedSource source() {
        if (null == bufferedSource) {
            bufferedSource = Okio.buffer(source(responseBody.body().source()));
        }
        return bufferedSource;
    }

    private Source source(Source source) {
        return new ForwardingSource(source) {
            //当前读取字节数
            long totalBytesRead = 0L;
            //总字节长度，避免多次调用contentLength()方法
            long contentLength = 0L;

            @Override
            public long read(Buffer sink, long byteCount) throws IOException {
                if (contentLength == 0) {
                    //获得contentLength的值，后续不再调用
                    contentLength = contentLength();
                }
                long bytesRead = super.read(sink, byteCount);
                totalBytesRead += bytesRead != -1 ? bytesRead : 0;
                EventBus.getDefault().post(new FileProgressEvent(url,true, contentLength, totalBytesRead, bytesRead == -1));
                return bytesRead;
            }
        };
    }
}
