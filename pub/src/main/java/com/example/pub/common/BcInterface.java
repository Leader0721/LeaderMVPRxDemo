package com.example.pub.common;

import android.content.Context;
import android.webkit.JavascriptInterface;

import com.example.pub.utils.function.LogUtils;
import com.just.library.AgentWeb;



/**
 * description Android和H5交互的接口 别名为bc
 * author hanlei
 * version 1.0
 * created at 2017/7/29.
 */
public class BcInterface {

    public static final String className = "bc";

    private AgentWeb agent;
    private Context context;

    public BcInterface(AgentWeb agent, Context context) {
        this.agent = agent;
        this.context = context;
    }


    @JavascriptInterface
    public void showBigImg(int index) {

        LogUtils.e("BcInterface", "showBigImg()");
//
//        EventCustom eventCustom = new EventCustom();
//        eventCustom.setTag(CommonKey.SHOW_BIG_IMG);
//        eventCustom.setObj(index);
//        EventBus.getDefault().post(eventCustom);
    }


}
