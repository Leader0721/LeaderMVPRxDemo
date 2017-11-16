package com.example.pub.utils.constant;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @Description:存储相关常量
 * @Prject:
 * @Package: com.example.pub.utils.constant
 * @author: Leader
 * @date: 2017/11/16   15:29
 * @Copyright: 个人版权所有
 * @Company:bc
 * @version: 1.0.0
 */

public final class MemoryConstants {

    /**
     * Byte与Byte的倍数
     */
    public static final int BYTE = 1;
    /**
     * KB与Byte的倍数
     */
    public static final int KB = 1024;
    /**
     * MB与Byte的倍数
     */
    public static final int MB = 1048576;
    /**
     * GB与Byte的倍数
     */
    public static final int GB = 1073741824;

    @IntDef({BYTE, KB, MB, GB})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Unit {
    }
}
