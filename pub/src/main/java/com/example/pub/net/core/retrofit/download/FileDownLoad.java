package com.example.pub.net.core.retrofit.download;

import android.content.Context;

import com.example.pub.utils.data.FileUtil;

import java.io.File;
import java.io.IOException;

import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;

/**
 * 文件下载
 */

public class FileDownLoad {

    /**
     * 下载文件
     */
    public static File downLoadFile(Context context, ResponseBody response, String fileName) {

        BufferedSink bufferedSink = null;

        File file = FileUtil.getCacheFile(fileName);
        if(!file.getParentFile().exists()){

        }
        try {
            /*bufferedSink = Okio.buffer(Okio.sink(file));
            bufferedSink.writeAll(response.source());*/
            //1.第一种存储文件的方式
            BufferedSource source = response.source();
            bufferedSink = Okio.buffer(Okio.sink(file));
            Buffer buffer = new Buffer();
            while (!source.exhausted()) {
                long count = source.read(buffer, 1024);
                bufferedSink.write(buffer, count);
            }
           /*
           第二种存储文件的方式
           InputStream is = response.byteStream();
            FileOutputStream fos = new FileOutputStream(file);
            BufferedInputStream bis = new BufferedInputStream(is);
            byte[] buffer = new byte[2048];
            int len;
            while ((len = bis.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
                fos.flush();
            }
            fos.close();
            bis.close();
            is.close();*/
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != bufferedSink) bufferedSink.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return file;
    }
}
