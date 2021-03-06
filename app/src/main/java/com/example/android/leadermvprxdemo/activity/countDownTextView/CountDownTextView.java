package com.example.android.leadermvprxdemo.activity.countDownTextView;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;

import com.example.android.leadermvprxdemo.activity.SmsEditText.CodeEditText;

/**
 * 倒计时文本
 * Created by ChenRui on 2017/10/31 0031 23:01.
 */
public class CountDownTextView extends AppCompatTextView {

    // 倒计时
    private int duration = 5000;

    // 扫过的角度
    private int mSweepAngle = 360;
    private ValueAnimator animator;
    private final RectF mRect = new RectF();
    private Paint mBackgroundPaint;

    public CountDownTextView(Context context) {
        super(context);
        init();
    }

    public CountDownTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CountDownTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mBackgroundPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mBackgroundPaint.setColor(Color.WHITE);
        mBackgroundPaint.setStrokeWidth(dp2px(2));
        mBackgroundPaint.setStyle(Paint.Style.STROKE);
    }

    public interface OnFinishListener {
        void onFinish();
    }

    /**
     * 当角度是零的时候
     */
    private OnFinishListener mOnFinishListener;

    /**
     * 设置角度为零监听
     */
    public void setOnFinishListener(OnFinishListener onFinishListener) {
        this.mOnFinishListener = onFinishListener;
    }


    /**
     * 开始倒计时
     */
    public void start() {
        // 在动画中
        if (mSweepAngle != 360) return;

        mSweepAngle = 360;
        animator = ValueAnimator.ofInt(mSweepAngle).setDuration(duration);
        animator.setInterpolator(new LinearInterpolator());
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int value = (int) animation.getAnimatedValue();
                mSweepAngle = value;
                invalidate();
                if (value == 360) {
                    if (mOnFinishListener != null) {
                        mOnFinishListener.onFinish();
                    }
                }
            }
        });
        animator.start();
    }

    @Override
    protected void onDetachedFromWindow() {
        stop();
        super.onDetachedFromWindow();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        int padding = dp2px(4);
        mRect.top = padding;
        mRect.left = padding;
        mRect.right = canvas.getWidth() - padding;
        mRect.bottom = canvas.getHeight() - padding;

        // 画倒计时线内圆
        canvas.drawArc(mRect, //弧线所使用的矩形区域大小
                -90,  //开始角度
                mSweepAngle, //扫过的角度
                false, //是否使用中心
                mBackgroundPaint);

        super.onDraw(canvas);
    }

    private int dp2px(int dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, getResources().getDisplayMetrics());
    }

    public void reset() {
        mSweepAngle = 360;
        animator = null;
    }

    public void stop() {
        if (animator != null) {
            animator.cancel();
            animator = null;
        }
    }
}
