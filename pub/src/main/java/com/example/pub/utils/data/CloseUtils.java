package com.example.pub.utils.data;

import java.io.Closeable;
import java.io.IOException;


/**
 * @Description:关闭相关工具类
 * @Prject:
 * @Package: com.example.pub.utils.data
 * @author: Leader
 * @date: 2017/11/16   15:33
 * @Copyright: 个人版权所有
 * @Company:bc
 * @version: 1.0.0
 */
public final class CloseUtils {

    private CloseUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    /**
     * 关闭IO
     *
     * @param closeables closeables
     */
    public static void closeIO(final Closeable... closeables) {
        if (closeables == null) return;
        for (Closeable closeable : closeables) {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 安静关闭IO
     *
     * @param closeables closeables
     */
    public static void closeIOQuietly(final Closeable... closeables) {
        if (closeables == null) return;
        for (Closeable closeable : closeables) {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (IOException ignored) {
                }
            }
        }
    }
}
