package com.example.pub.utils.app;

import android.content.res.Resources;

/**
 * @Description:资源ID_工具类 获取资源ID
 * @Prject:
 * @Package: com.example.pub.utils.app
 * @author: Leader
 * @date: 2017/11/16   15:26
 * @Copyright: 个人版权所有
 * @Company:bc
 * @version: 1.0.0
 */
public class ResourceIDUtils {

    /**
     * 获取 Drawable  ID
     *
     * @param name 资源名字
     * @return Drawable  ID
     */
    public static int getDrawableId(String name) {
        Resources res = Utils.getApp().getResources();
        return res.getIdentifier(name, "drawable", Utils.getApp().getPackageName());
    }

    /**
     * 获取 Layout  ID
     *
     * @param name 资源名字
     * @return Layout  ID
     */
    public static int getLayoutId(String name) {
        Resources res = Utils.getApp().getResources();
        return res.getIdentifier(name, "layout", Utils.getApp().getPackageName());
    }


    /**
     * 获取 Strings  ID
     *
     * @param name 资源名字
     * @return Strings  ID
     */
    public static int getStringsId(String name) {
        Resources res = Utils.getApp().getResources();
        return res.getIdentifier(name, "string", Utils.getApp().getPackageName());
    }


    /**
     * 获取 Color  ID
     *
     * @param name 资源名字
     * @return Color  ID
     */
    public static int getColorId(String name) {
        Resources res = Utils.getApp().getResources();
        return res.getIdentifier(name, "color", Utils.getApp().getPackageName());
    }


    /**
     * 获取 Id  ID
     *
     * @param name 资源名字
     * @return Id  ID
     */
    public static int getIdId(String name) {
        Resources res = Utils.getApp().getResources();
        return res.getIdentifier(name, "id", Utils.getApp().getPackageName());
    }


    /**
     * 获取 Raw  ID
     *
     * @param name 资源名字
     * @return Raw  ID
     */
    public static int getRawId(String name) {
        Resources res = Utils.getApp().getResources();
        return res.getIdentifier(name, "raw", Utils.getApp().getPackageName());
    }


    /**
     * 获取 Anim  ID
     *
     * @param name 资源名字
     * @return Anim  ID
     */
    public static int getAnimId(String name) {
        Resources res = Utils.getApp().getResources();
        return res.getIdentifier(name, "anim", Utils.getApp().getPackageName());
    }


    /**
     * 获取 Style  ID
     *
     * @param name 资源名字
     * @return Style  ID
     */
    public static int getStyleId(String name) {
        Resources res = Utils.getApp().getResources();
        return res.getIdentifier(name, "style", Utils.getApp().getPackageName());
    }


    /**
     * 获取 Styleable  ID
     *
     * @param name 资源名字
     * @return Styleable  ID
     */
    public static int getStyleableId(String name) {
        Resources res = Utils.getApp().getResources();
        return res.getIdentifier(name, "styleable", Utils.getApp().getPackageName());
    }


    /**
     * 获取 Attr  ID
     *
     * @param name 资源名字
     * @return Attr  ID
     */
    public static int getAttrId(String name) {
        Resources res = Utils.getApp().getResources();
        return res.getIdentifier(name, "attr", Utils.getApp().getPackageName());
    }


    /**
     * 获取 Array  ID
     *
     * @param name 资源名字
     * @return Array  ID
     */
    public static int getArrayId(String name) {
        Resources res = Utils.getApp().getResources();
        return res.getIdentifier(name, "array", Utils.getApp().getPackageName());
    }
}
