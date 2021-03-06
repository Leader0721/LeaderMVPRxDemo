package com.example.pub.utils.view;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.support.v4.widget.TextViewCompat;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pub.R;
import com.example.pub.utils.app.Utils;
import com.example.pub.utils.function.EmptyUtils;

import java.lang.ref.WeakReference;

/**
 * @Description:吐司相关工具类
 * @Prject:
 * @Package: com.example.pub.utils.view
 * @author: Leader
 * @date: 2017/11/16   15:58
 * @Copyright: 个人版权所有
 * @Company:bc
 * @version: 1.0.0
 */
public final class ToastUtils {

    private static final int DEFAULT_COLOR = 0xFEFFFFFF;
    private static final Handler HANDLER = new Handler(Looper.getMainLooper());

    private static Toast sToast;
    private static WeakReference<View> sViewWeakReference;
    private static int sLayoutId = -1;
    private static int gravity = Gravity.CENTER_HORIZONTAL | Gravity.BOTTOM;
    private static int xOffset = 0;
    private static int yOffset = (int) (64 * Utils.getApp().getResources().getDisplayMetrics().density + 0.5);
    private static int bgColor = DEFAULT_COLOR;
    private static int bgResource = -1;
    private static int msgColor = DEFAULT_COLOR;

    private ToastUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    /**
     * 设置吐司位置
     *
     * @param gravity 位置
     * @param xOffset x偏移
     * @param yOffset y偏移
     */
    public static void setGravity(final int gravity, final int xOffset, final int yOffset) {
        ToastUtils.gravity = gravity;
        ToastUtils.xOffset = xOffset;
        ToastUtils.yOffset = yOffset;
    }

    /**
     * 设置背景颜色
     *
     * @param backgroundColor 背景色
     */
    public static void setBgColor(@ColorInt final int backgroundColor) {
        ToastUtils.bgColor = backgroundColor;
    }

    /**
     * 设置背景资源
     *
     * @param bgResource 背景资源
     */
    public static void setBgResource(@DrawableRes final int bgResource) {
        ToastUtils.bgResource = bgResource;
    }

    /**
     * 设置消息颜色
     *
     * @param msgColor 颜色
     */
    public static void setMsgColor(@ColorInt final int msgColor) {
        ToastUtils.msgColor = msgColor;
    }


    /**
     * 安全地显示短时吐司
     *
     * @param text 文本
     */
    public static void showShortSafe(@NonNull final CharSequence text) {
        HANDLER.post(new Runnable() {
            @Override
            public void run() {
                show(text, Toast.LENGTH_SHORT);
            }
        });
    }

    /**
     * 安全地显示短时吐司
     *
     * @param resId 资源Id
     */
    public static void showShortSafe(@StringRes final int resId) {
        HANDLER.post(new Runnable() {
            @Override
            public void run() {
                show(resId, Toast.LENGTH_SHORT);
            }
        });
    }

    /**
     * 安全地显示短时吐司
     *
     * @param resId 资源Id
     * @param args  参数
     */
    public static void showShortSafe(@StringRes final int resId, final Object... args) {
        HANDLER.post(new Runnable() {
            @Override
            public void run() {
                show(resId, Toast.LENGTH_SHORT, args);
            }
        });
    }

    /**
     * 安全地显示短时吐司
     *
     * @param format 格式
     * @param args   参数
     */
    public static void showShortSafe(final String format, final Object... args) {
        HANDLER.post(new Runnable() {
            @Override
            public void run() {
                show(format, Toast.LENGTH_SHORT, args);
            }
        });
    }

    /**
     * 安全地显示长时吐司
     *
     * @param text 文本
     */
    public static void showLongSafe(@NonNull final CharSequence text) {
        HANDLER.post(new Runnable() {
            @Override
            public void run() {
                show(text, Toast.LENGTH_LONG);
            }
        });
    }

    /**
     * 安全地显示长时吐司
     *
     * @param resId 资源Id
     */
    public static void showLongSafe(@StringRes final int resId) {
        HANDLER.post(new Runnable() {
            @Override
            public void run() {
                show(resId, Toast.LENGTH_LONG);
            }
        });
    }

    /**
     * 安全地显示长时吐司
     *
     * @param resId 资源Id
     * @param args  参数
     */
    public static void showLongSafe(@StringRes final int resId, final Object... args) {
        HANDLER.post(new Runnable() {
            @Override
            public void run() {
                show(resId, Toast.LENGTH_LONG, args);
            }
        });
    }

    /**
     * 安全地显示长时吐司
     *
     * @param format 格式
     * @param args   参数
     */
    public static void showLongSafe(final String format, final Object... args) {
        HANDLER.post(new Runnable() {
            @Override
            public void run() {
                show(format, Toast.LENGTH_LONG, args);
            }
        });
    }

    /**
     * 显示短时吐司
     *
     * @param text 文本
     */
    public static void showShort(@NonNull final CharSequence text) {
        show(text, Toast.LENGTH_SHORT);
    }

    /**
     * 显示短时吐司
     *
     * @param resId 资源Id
     */
    public static void showShort(@StringRes final int resId) {
        show(resId, Toast.LENGTH_SHORT);
    }

    /**
     * 显示短时吐司
     *
     * @param resId 资源Id
     * @param args  参数
     */
    public static void showShort(@StringRes final int resId, final Object... args) {
        show(resId, Toast.LENGTH_SHORT, args);
    }

    /**
     * 显示短时吐司
     *
     * @param format 格式
     * @param args   参数
     */
    public static void showShort(final String format, final Object... args) {
        show(format, Toast.LENGTH_SHORT, args);
    }

    /**
     * 显示长时吐司
     *
     * @param text 文本
     */
    public static void showLong(@NonNull final CharSequence text) {
        show(text, Toast.LENGTH_LONG);
    }

    /**
     * 显示长时吐司
     *
     * @param resId 资源Id
     */
    public static void showLong(@StringRes final int resId) {
        show(resId, Toast.LENGTH_LONG);
    }

    /**
     * 显示长时吐司
     *
     * @param resId 资源Id
     * @param args  参数
     */
    public static void showLong(@StringRes final int resId, final Object... args) {
        show(resId, Toast.LENGTH_LONG, args);
    }

    /**
     * 显示长时吐司
     *
     * @param format 格式
     * @param args   参数
     */
    public static void showLong(final String format, final Object... args) {
        show(format, Toast.LENGTH_LONG, args);
    }

    /**
     * 安全地显示短时自定义吐司
     */
    public static View showCustomShortSafe(@LayoutRes final int layoutId) {
        final View view = getView(layoutId);
        HANDLER.post(new Runnable() {
            @Override
            public void run() {
                show(view, Toast.LENGTH_SHORT);
            }
        });
        return view;
    }

    /**
     * 安全地显示长时自定义吐司
     */
    public static View showCustomLongSafe(@LayoutRes final int layoutId) {
        final View view = getView(layoutId);
        HANDLER.post(new Runnable() {
            @Override
            public void run() {
                show(view, Toast.LENGTH_LONG);
            }
        });
        return view;
    }

    /**
     * 显示短时自定义吐司
     */
    public static View showCustomShort(@LayoutRes final int layoutId) {
        final View view = getView(layoutId);
        show(view, Toast.LENGTH_SHORT);
        return view;
    }

    /**
     * 显示长时自定义吐司
     */
    public static View showCustomLong(@LayoutRes final int layoutId) {
        final View view = getView(layoutId);
        show(view, Toast.LENGTH_LONG);
        return view;
    }

    /**
     * 取消吐司显示
     */
    public static void cancel() {
        if (sToast != null) {
            sToast.cancel();
            sToast = null;
        }
    }


    private static void show(@StringRes final int resId, final int duration) {
        show(Utils.getApp().getResources().getText(resId).toString(), duration);
    }

    private static void show(@StringRes final int resId, final int duration, final Object... args) {
        show(String.format(Utils.getApp().getResources().getString(resId), args), duration);
    }

    private static void show(final String format, final int duration, final Object... args) {
        show(String.format(format, args), duration);
    }

    private static void show(final CharSequence text, final int duration) {
        cancel();
        sToast = Toast.makeText(Utils.getApp(), text, duration);
        // solve the font of toast
        TextView tvMessage = (TextView) sToast.getView().findViewById(android.R.id.message);
        TextViewCompat.setTextAppearance(tvMessage, android.R.style.TextAppearance);
        tvMessage.setTextColor(msgColor);
        setBgAndGravity();
        sToast.show();
    }

    private static void show(final View view, final int duration) {
        cancel();
        sToast = new Toast(Utils.getApp());
        sToast.setView(view);
        sToast.setDuration(duration);
        setBgAndGravity();
        sToast.show();
    }

    private static void setBgAndGravity() {
        View toastView = sToast.getView();
        if (bgResource != -1) {
            toastView.setBackgroundResource(bgResource);
        } else if (bgColor != DEFAULT_COLOR) {
            Drawable background = toastView.getBackground();
            background.setColorFilter(new PorterDuffColorFilter(bgColor, PorterDuff.Mode.SRC_IN));
        }
        sToast.setGravity(gravity, xOffset, yOffset);
    }

    private static View getView(@LayoutRes final int layoutId) {
        if (sLayoutId == layoutId) {
            if (sViewWeakReference != null) {
                final View toastView = sViewWeakReference.get();
                if (toastView != null) {
                    return toastView;
                }
            }
        }
        LayoutInflater inflate = (LayoutInflater) Utils.getApp().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View toastView = inflate.inflate(layoutId, null);
        sViewWeakReference = new WeakReference<>(toastView);
        sLayoutId = layoutId;
        return toastView;
    }

    /**
     * 短时间显示带有图片的toast
     *
     * @param str
     * @param imageId
     */
    public static void showWithPicShort(String str, int imageId) {
        showWithPic(str, imageId, R.color.white, Toast.LENGTH_SHORT, 0, 0, 0, 0);
    }

    /**
     * 短时间显示带有图片的toast
     *
     * @param str
     * @param imageId
     */
    public static void showWithPicLong(String str, int imageId) {
        showWithPic(str, imageId, R.color.white, Toast.LENGTH_LONG, 0, 0, 0, 0);
    }


    /**
     * 显示带有图片的toast 属性比较全
     *
     * @param str
     * @param imageId
     * @param duration
     * @param gravity
     * @param offX
     * @param offY
     * @param bgResourceId
     */
    public static void showWithPic(String str, int imageId, int textColor, int duration, int gravity, int offX, int offY, int bgResourceId) {
        cancel();
        View view = LayoutInflater.from(Utils.getApp()).inflate(R.layout.view_toast, null);
        TextView text = (TextView) view.findViewById(R.id.tv_toast);
        ImageView image = (ImageView) view.findViewById(R.id.iv_toast);
        if (EmptyUtils.isEmpty(str)) {// 设置显示文字
            text.setText(str);
        } else {
            text.setText(str);
            text.setTextColor(Utils.getApp().getColor(textColor));
            if (imageId == 0) {
                image.setVisibility(View.GONE);
            } else {
                image.setVisibility(View.VISIBLE);
                image.setImageResource(imageId);
            }
            if (bgResourceId != 0) {//设置背景
                view.setBackgroundResource(bgResourceId);
            } else {
                view.setBackgroundResource(R.drawable.bg_corner_tran);
            }
            sToast = new Toast(Utils.getApp());
            if (gravity != 0 || offX != 0 || offY != 0) {// Toast显示的位置
                sToast.setGravity(gravity, offX, offY);
            } else {
                sToast.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.BOTTOM, 0, 0);
            }
            if (duration != Toast.LENGTH_LONG) {
                sToast.setDuration(Toast.LENGTH_SHORT); // Toast显示的时间
            } else {
                sToast.setDuration(Toast.LENGTH_LONG); // Toast显示的时间
            }
            sToast.setView(view);
            sToast.show();
        }
    }

}