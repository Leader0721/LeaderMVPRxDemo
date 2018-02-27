package com.example.pub.view;

import android.content.Context;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

/**
 * @Description:图片点击加深效果
 * @Prject:
 * @Package: cn.bcbook.pad.student.ui.views
 * @author: Leader
 * @date: 2018/2/26   16:25
 * @Copyright: 个人版权所有
 * @Company:bc
 * @version: 1.0.0
 */


public class ClickImageView extends ImageView {
    public ClickImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public ClickImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ClickImageView(Context context) {
        super(context);
        init();
    }

    private void init() {
        setOnTouchListener(onTouchListener);
    }

    private OnTouchListener onTouchListener = new OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_UP:
                    setColorFilter(null);
                    break;
                case MotionEvent.ACTION_DOWN:
                    changeLight();
                    break;
                case MotionEvent.ACTION_MOVE:
                    break;
                case MotionEvent.ACTION_CANCEL:
                    setColorFilter(null);
                    break;
                default:
                    break;
            }
            return true;
        }
    };

    private void changeLight() {
        int brightness = -80;
        ColorMatrix matrix = new ColorMatrix();
        matrix.set(new float[]{1, 0, 0, 0, brightness, 0, 1, 0, 0, brightness, 0, 0, 1, 0, brightness, 0, 0, 0, 1, 0});
        setColorFilter(new ColorMatrixColorFilter(matrix));
    }
}
