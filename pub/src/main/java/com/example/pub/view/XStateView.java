package com.example.pub.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.pub.R;
import com.example.pub.utils.function.StringUtils;


/**
 * 状态视图
 * <p>
 * <p>
 * <p>
 * stateView.showEmptyView("没有内容啊", R.mipmap.ic_launcher);
 * <p>
 * stateView.showLoadingView("拼命加载中...");
 * <p>
 * stateView.showErrorView("网络加载错误了",R.mipmap.ic_launcher, new View.OnClickListener() {
 *
 * @Override public void onClick(View v) {
 * stateView.showLoadingView("拼命加载中...");
 * }
 * });
 */
public class XStateView extends RelativeLayout {

    private String emptyText = "";
    private Drawable iconRes = null;
    private int viewType = EMPTY;

    private ProgressBar progressBar;
    private TextView empty_view;
    private Button empty_operation;


    private static final int EMPTY = 1;
    private static final int ERROR = 2;
    private static final int LOAD = 3;
    private int contentTextColor;
    private int contentTextSize;

    public XStateView(Context context) {
        super(context);
        initView(context);
    }

    public XStateView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public XStateView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.XStateView, defStyleAttr, 0);
        try {
            emptyText = a.getString(R.styleable.XStateView_empty_text);
            iconRes = a.getDrawable(R.styleable.XStateView_iconRes);
            viewType = a.getInt(R.styleable.XStateView_state, EMPTY);
            //字体的颜色
            contentTextColor = a.getColor(R.styleable.XStateView_color, getResources().getColor(R.color.tvc6));
            //字体的大小
            contentTextSize = a.getDimensionPixelSize(R.styleable.XStateView_size, 20);
        } finally {
            a.recycle();
        }

        initView(context);

    }

    /**
     * 初始化视图
     *
     * @param context
     */
    private void initView(Context context) {

        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        View rootView = LayoutInflater.from(context).inflate(R.layout.view_xstate, null);
        addView(rootView, lp);

        progressBar = (ProgressBar) rootView.findViewById(R.id.progressBar);
        empty_view = (TextView) rootView.findViewById(R.id.empty_view);
        empty_operation = (Button) rootView.findViewById(R.id.empty_operation);

        if (!StringUtils.isEmpty(emptyText)) {
            empty_view.setText(emptyText);
            empty_view.setTextColor(contentTextColor);
            empty_view.setTextSize(contentTextSize);
        }

        if (iconRes != null) {
            iconRes.setBounds(0, 0, iconRes.getMinimumWidth(), iconRes.getMinimumHeight()); //设置边界
            empty_view.setCompoundDrawables(null, iconRes, null, null);
        } else {
            empty_view.setCompoundDrawables(null, null, null, null);
        }

        if (LOAD == viewType) {
            showLoadingView();
        } else if (ERROR == viewType) {
            showErrorView();
        } else {
            // 默认为空视图
            showEmptyView();
        }

    }

    /**
     * 暂无数据
     */
    public void showEmptyView() {


        showEmptyView("暂时没有数据", R.mipmap.ic_launcher);
    }

    /**
     * 加载中
     */
    public void showLoadingView() {
        showLoadingView("数据加载中...");
    }

    /**
     * 加载错误
     */
    public void showErrorView() {
        showErrorView("数据加载错误", R.mipmap.ic_launcher, null);
    }

    /**
     * 加载错误
     *
     * @param onClickListener
     */
    public void showErrorView(OnClickListener onClickListener) {
        showErrorView("数据加载错误", R.mipmap.ic_launcher, onClickListener);
    }

    /**
     * 数据异常视图 仅显示图标和文本
     *
     * @param text
     * @param resId
     */
    public void showEmptyView(String text, int resId) {

        progressBar.setVisibility(GONE);
        empty_view.setVisibility(VISIBLE);
        empty_operation.setVisibility(GONE);

        if (!StringUtils.isEmpty(text)) {
            empty_view.setTextColor(contentTextColor);
            empty_view.setTextSize(contentTextSize);
            empty_view.setText(text);
        }

        empty_view.setCompoundDrawablesWithIntrinsicBounds(0, resId, 0, 0);

    }

    /**
     * 加载视图 显示进度条和文本
     *
     * @param text
     */
    public void showLoadingView(String text) {

        progressBar.setVisibility(VISIBLE);
        empty_view.setVisibility(VISIBLE);
        empty_operation.setVisibility(GONE);

        empty_view.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        if (!StringUtils.isEmpty(text)) {
            empty_view.setTextColor(contentTextColor);
            empty_view.setTextSize(contentTextSize);
            empty_view.setText(text);
        }

    }


    /**
     * 错误视图
     *
     * @param text
     * @param resId
     * @param onClickListener
     */
    public void showErrorView(String text, int resId, OnClickListener onClickListener) {

        progressBar.setVisibility(GONE);
        empty_view.setVisibility(VISIBLE);
        empty_operation.setVisibility(VISIBLE);

        if (!StringUtils.isEmpty(text)) {
            empty_view.setTextColor(contentTextColor);
            empty_view.setTextSize(contentTextSize);
            empty_view.setText(text);
        }

        if (resId != -1) {
            empty_view.setCompoundDrawablesWithIntrinsicBounds(0, resId, 0, 0);
        } else {
            empty_view.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }

        if (onClickListener != null) {
            empty_operation.setVisibility(GONE);
            empty_operation.setOnClickListener(onClickListener);
        }

    }

}
