package com.example.pub.common;

/**
 * Created by Android on 2017/7/27.
 */

public class EventCustom {

    //需要传递的内容
    private Object obj;
    //传递的tag 对应KeyEvent中的值
    private String tag;
    private String content1;
    private String content2;
    private String content3;
    private String content4;
    private String content5;

    public EventCustom() {

    }

    public EventCustom(String tag) {
        this.tag = tag;
    }

    public EventCustom(Object obj, String tag) {
        this.obj = obj;
        this.tag = tag;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getContent1() {
        return content1;
    }

    public void setContent1(String content1) {
        this.content1 = content1;
    }

    public String getContent2() {
        return content2;
    }

    public void setContent2(String content2) {
        this.content2 = content2;
    }


    public String getContent3() {
        return content3;
    }

    public void setContent3(String content3) {
        this.content3 = content3;
    }


    public String getContent4() {
        return content4;
    }

    public void setContent4(String content4) {
        this.content4 = content4;
    }

    public String getContent5() {
        return content5;
    }

    public void setContent5(String content5) {
        this.content5 = content5;
    }
}
