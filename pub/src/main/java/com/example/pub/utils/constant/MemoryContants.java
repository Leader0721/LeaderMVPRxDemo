package com.example.pub.utils.constant;


/**
 * @Description:内存相关_常量类
 * @Prject:
 * @Package: com.example.pub.utils.constant
 * @author: Leader
 * @date: 2017/11/16   15:29
 * @Copyright: 个人版权所有
 * @Company:bc
 * @version: 1.0.0
 */
public class MemoryContants {
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

    /**
     * 创建这样一个枚举,在调用的时候可以直接传枚举用作自定义的参:
     * <p>
     * 例:
     * public static double byte2Size(long byteNum, MemoryContants.MemoryUnit unit) {
     * if (byteNum < 0)
     * return -1;
     * switch (unit) {
     * default:
     * case BYTE:
     * return (double) byteNum / BYTE;
     * case KB:
     * return (double) byteNum / KB;
     * case MB:
     * return (double) byteNum / MB;
     * case GB:
     * return (double) byteNum / GB;
     * }
     * }
     */
    public enum MemoryUnit {
        BYTE,
        KB,
        MB,
        GB
    }

}
