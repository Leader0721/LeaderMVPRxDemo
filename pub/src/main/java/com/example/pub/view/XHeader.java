package com.example.pub.view;


import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.text.Html;
import android.text.Spanned;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.pub.R;
import com.example.pub.utils.function.StringUtils;


/**
 * description 自定义的一个相对布局，头部
 * author hanlei
 * version 1.0
 * created at 2016/11/14 10:07
 */
public class XHeader extends LinearLayout {

    private Context context;

    private RelativeLayout toolbar_layout;// 整体布局

    private TextView left_text; // 左侧文本
    private ImageView left_img;// 左边按钮

    private TextView title; // 文本中间标题
    private ProgressBar progressBar;

    private ImageView right_img; // 右侧图片
    private TextView right_text; // 右侧文本
    private TextView right2_text; // 右侧文本
    private TextView right3_text; // 右侧文本

    private View bottom_line;

    private String titleText = "Title";
    private Boolean isLeftBack = false; // 左键是否返回


    public XHeader(Context context) {
        this(context, null);
    }

    public XHeader(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context, attrs);
        this.context = context;
    }

    /**
     * 初始化视图
     *
     * @param context
     * @param attrs
     */
    private void initView(Context context, AttributeSet attrs) {

        if (attrs != null) {
            TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.XHeader, 0, 0);
            try {
                titleText = a.getString(R.styleable.XHeader_titleText);
                isLeftBack = a.getBoolean(R.styleable.XHeader_isLeftBack, false);
            } finally {
                a.recycle();
            }
        }

        LayoutParams lp = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        View rootView = LayoutInflater.from(context).inflate(R.layout.view_xhead, null);
        addView(rootView, lp);

        toolbar_layout = (RelativeLayout) findViewById(R.id.toolbar_layout);
        left_img = (ImageView) findViewById(R.id.toolbar_left_img);
        title = (TextView) findViewById(R.id.toolbar_title);
        right_img = (ImageView) findViewById(R.id.toolbar_right_img);
        right_text = (TextView) findViewById(R.id.toolbar_right_txt);
        right2_text = (TextView) findViewById(R.id.toolbar_right2_txt);
        right3_text = (TextView) findViewById(R.id.toolbar_right3_txt);
        progressBar = (ProgressBar) findViewById(R.id.toolbar_pro);
        left_text = (TextView) findViewById(R.id.toolbar_left_text);
        bottom_line = findViewById(R.id.bottom_line);

        left_img.setVisibility(View.GONE);
        right_img.setVisibility(View.GONE);
        left_text.setVisibility(View.GONE);
        right_text.setVisibility(View.GONE);
        right2_text.setVisibility(View.GONE);
        right3_text.setVisibility(View.GONE);
        progressBar.setVisibility(View.GONE);

        title.setText(titleText);
        if (isLeftBack) {
            setLeftAsBack();
        }
    }


    /**
     * 设置左键显示图片以及监听
     *
     * @param ResID
     * @param listener
     */
    public void setLeft(int ResID, OnClickListener listener) {
        if (ResID != 0) {
            left_img.setImageResource(ResID);
            left_img.setVisibility(View.VISIBLE);
        }
        left_img.setOnClickListener(listener);
    }

    /**
     * 设置左键文字
     *
     * @param text 文字
     */
    public void setLeftText(String text) {
        if (text != null) {
            left_text.setVisibility(VISIBLE);
            left_text.setText(text);
        }
    }

    /**
     * 设置右键文字
     *
     * @param text 右键文字
     */
    public void setRightText(String text) {
        if (text != null) {
            right_text.setVisibility(VISIBLE);
            right_text.setText(text);
            right_text.setOnClickListener(null);
        }
    }

    /**
     * 设置右键3文字
     *
     * @param text 右键文字
     */
    public void setRight3Text(String text) {
        if (text != null) {
            right3_text.setVisibility(VISIBLE);
            right3_text.setText(text);
        }
    }

    /**
     * 设置右键2文字
     *
     * @param text 右键文字
     */
    public void setRight2Text(String text) {
        if (text != null) {
            right2_text.setVisibility(VISIBLE);
            right2_text.setText(text);
        }
    }

    /**
     * 设置左键为返回
     */
    public void setLeftAsBack() {
        //setLeftAsBack(R.mipmap.back);
        setLeftAsBack("返回");
    }

    public void setLeftAsBack(String text) {

        if (!StringUtils.isEmpty(text)) {
            left_text.setVisibility(View.VISIBLE);
            left_text.setText(text);
            left_text.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (context instanceof Activity) {
                        Activity activity = (Activity) context;
                        activity.finish();
                    }
                }
            });
        }
    }


    /**
     * 设置左键为返回 并指定按钮
     *
     * @param ResID
     */
    public void setLeftAsBack(int ResID) {
        if (ResID != 0) {
            left_img.setImageResource(ResID);
            left_img.setVisibility(View.VISIBLE);
            left_img.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (context instanceof Activity) {
                        Activity activity = (Activity) context;
                        activity.finish();
                    }
                }
            });
        }
    }

    /**
     * @param text
     * @param listener
     */
    public void setRight3(String text, OnClickListener listener) {

        if (text != null && listener != null) {
            right3_text.setText(text);
            right3_text.setVisibility(View.VISIBLE);
            right3_text.setOnClickListener(listener);
        }

    }

    /**
     * @param text
     * @param listener
     */
    public void setRight2(String text, OnClickListener listener) {

        if (text != null) {
            right2_text.setText(text);
            right2_text.setVisibility(View.VISIBLE);
            right2_text.setOnClickListener(listener);
        }

    }

    /**
     * 设置右键显示以及监听
     *
     * @param img
     * @param listener
     */
    public void setRight2(Drawable img, String text, OnClickListener listener) {
        if (text != null) {
            right2_text.setText(text);
            right2_text.setVisibility(View.VISIBLE);
            right2_text.setOnClickListener(listener);
        }

        if (img != null) {
            img.setBounds(0, 0, img.getMinimumWidth(), img.getMinimumHeight());
            right2_text.setCompoundDrawables(img, null, null, null);
        }
    }

    /**
     * 设置右键仅图片显示以及监听
     *
     * @param ResID
     * @param listener
     */
    public void setRight(int ResID, OnClickListener listener) {
        setRight(ResID, null, listener);
    }

    /**
     * 设置右键仅文字显示以及监听
     *
     * @param
     * @param listener
     */
    public void setRight(String text, OnClickListener listener) {
        setRight(0, text, listener);
    }

    /**
     * 设置右键显示以及监听
     *
     * @param ResID
     * @param listener
     */
    private void setRight(int ResID, String text, OnClickListener listener) {

        if (ResID != 0) {
            right_img.setImageResource(ResID);
            right_img.setVisibility(View.VISIBLE);
            right_img.setOnClickListener(listener);
        }
        if (text != null) {
            right_text.setText(text);
            right_text.setVisibility(View.VISIBLE);
            right_text.setOnClickListener(listener);
        }

    }

    /**
     * 设置右键显示以及监听
     *
     * @param img
     * @param listener
     */
    public void setRight(Drawable img, String text, OnClickListener listener) {
        if (text != null) {
            right_text.setText(Html.fromHtml(text));
            right_text.setVisibility(View.VISIBLE);
            right_text.setOnClickListener(listener);
        }

        if (img != null) {
            img.setBounds(0, 0, img.getMinimumWidth(), img.getMinimumHeight());
            right_text.setCompoundDrawables(img, null, null, null);
        }
    }

    /**
     * 设置顶部标题
     *
     * @param text
     */
    public void setTitle(String text) {
        if (text != null) {
            title.setVisibility(View.VISIBLE);
            title.setText(text);
        }
    }

    /**
     * 设置顶部标题
     *
     * @param text
     */
    public void setTitle(Spanned text) {
        if (text != null) {
            title.setVisibility(View.VISIBLE);
            title.setText(text);
        }
    }

    /**
     * 设置标题，使用资源ID参数
     *
     * @param ResID
     */
    public void setTitle(int ResID) {
        if (ResID != 0) {
            title.setVisibility(View.VISIBLE);
            title.setText(ResID);
        }
    }

    /**
     * 设置顶部标题，并添加点击监听
     *
     * @param text
     * @param clickListener
     */
    public void setTitle(String text, OnClickListener clickListener) {
        if (text != null) {
            title.setVisibility(View.VISIBLE);
            title.setText(text);
            title.setOnClickListener(clickListener);
        }
    }

    public void setTitle(int resId, String text, OnClickListener listener) {

        if (text != null) {
            title.setText(text);
            title.setVisibility(View.VISIBLE);
        }
        if (null != listener) {
            title.setOnClickListener(listener);
        }

        title.setCompoundDrawablesWithIntrinsicBounds(0, 0, resId, 0);

    }


    /**
     * 设置标题颜色，使用资源参数
     *
     * @param color
     */
    public void setTitleColor(int color) {
        if (color != 0) {
            title.setTextColor(color);
        }
    }

    /**
     * 设置整体背景颜色，使用资源参数
     *
     * @param color
     */
    public void setToolbarColor(int color) {
        if (color != 0) {
            toolbar_layout.setBackgroundColor(color);
        }
    }

    /**
     * 设置底部分割线颜色，使用资源参数
     *
     * @param color
     */
    public void setBottomlineColor(int color) {
        if (color != 0) {
            bottom_line.setBackgroundColor(color);
        }
    }

    /**
     * 显示等待框
     */
    public void showProgressBar() {
        if (progressBar != null) {
            progressBar.setVisibility(VISIBLE);
        }
    }

    /**
     * 隐藏等待框
     */
    public void hideProgressBar() {
        progressBar.setVisibility(GONE);
    }

    public TextView getRightText() {
        return right_text;
    }

    public TextView getRight2Text() {
        return right2_text;
    }

    public TextView getRight3Text() {
        return right3_text;
    }

    /**
     * 隐藏
     */
    public void setRightTextHide() {
        right_text.setVisibility(View.GONE);
    }

    /**
     * 隐藏
     */
    public void setRight2TextHide(boolean isHide) {
        right2_text.setVisibility(isHide ? View.GONE : VISIBLE);
    }

    /**
     * 隐藏
     */
    public void setRight2TextHide() {
        right2_text.setVisibility(View.GONE);
    }

    /**
     * 设置头部右侧文本1信息
     *
     * @param drawableRes
     * @param text
     * @param colorRes
     * @param listener
     */
    public void setRightText(int drawableRes, String text, int colorRes, OnClickListener listener) {

        if (text != null) {
            right_text.setText(text);
            right_text.setVisibility(View.VISIBLE);
        }

        if (listener != null) {
            right_text.setOnClickListener(listener);
        }

        right_text.setCompoundDrawablesWithIntrinsicBounds(drawableRes, 0, 0, 0);

        if (colorRes != 0) {
            right_text.setTextColor(ContextCompat.getColor(context, colorRes));
        }
    }

    /**
     * 设置头部右侧文本2信息
     *
     * @param drawableRes
     * @param text
     * @param colorRes
     * @param listener
     */
    public void setRight2Text(int drawableRes, String text, int colorRes, OnClickListener listener) {

        if (text != null) {
            right2_text.setText(text);
            right2_text.setVisibility(View.VISIBLE);
        }

        if (listener != null) {
            right2_text.setOnClickListener(listener);
        }


        right2_text.setCompoundDrawablesWithIntrinsicBounds(drawableRes, 0, 0, 0);


        if (colorRes != 0) {
            right2_text.setTextColor(ContextCompat.getColor(context, colorRes));
        }
    }

    /**
     * 设置头部右侧文本1信息
     *
     * @param drawableRes
     * @param text
     * @param colorRes
     * @param listener
     */
    public void setRight3Text(int drawableRes, String text, int colorRes, OnClickListener listener) {

        if (text != null) {
            right3_text.setText(text);
            right3_text.setVisibility(View.VISIBLE);
        } else {
            right3_text.setVisibility(View.GONE);
        }

        if (listener != null) {
            right3_text.setOnClickListener(listener);
        }


        right3_text.setCompoundDrawablesWithIntrinsicBounds(drawableRes, 0, 0, 0);


        if (colorRes != 0) {
            right3_text.setTextColor(ContextCompat.getColor(context, colorRes));
        }
    }

    /**
     * 设置头部右侧文本1信息
     *
     * @param drawableRes
     * @param text
     * @param colorRes
     * @param listener
     */
    public void setLeftText(int drawableRes, String text, int colorRes, OnClickListener listener) {

        if (text != null) {
            left_text.setText(text);
            left_text.setVisibility(View.VISIBLE);
        }

        if (listener != null) {
            left_text.setOnClickListener(listener);
        }

        left_text.setCompoundDrawablesWithIntrinsicBounds(drawableRes, 0, 0, 0);

        if (colorRes != 0) {
            left_text.setTextColor(ContextCompat.getColor(context, colorRes));
        }
    }

    public void setTitleTextListener(OnClickListener listener) {
        title.setOnClickListener(listener);
    }


    public void setLeftTextListener(OnClickListener listener) {

        //if (listener != null) {
        left_text.setOnClickListener(listener);
        //}
    }
}
