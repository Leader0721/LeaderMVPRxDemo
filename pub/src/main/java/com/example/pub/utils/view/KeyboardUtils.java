package com.example.pub.utils.view;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.example.pub.utils.app.Utils;

/**
 * <pre>
 *     author: Blankj
 *     blog  : http://blankj.com
 *     time  : 2016/08/02
 *     desc  : 键盘相关工具类
 *
 *      1.动态隐藏软键盘
 *            2.动态显示软键盘
 *            3.切换键盘显示与否状态(EditText 切换软键盘显示)
 *            4.点击屏幕空白区域隐藏软键盘 (需要拷这个类里面的方法进去)
 *
 * </pre>
 */
public final class KeyboardUtils {
    /**
     * <--->
     *     android:windowSoftInputMode属性:
     *
     *     这个属性能影响两个事情:
     *     【一】当有焦点产生时，软键盘是隐藏还是显示
     *     【二】是否减少活动主窗口大小以便腾出空间放软键盘
     *
     *     他的设置必须是下面的一个值,或者"state...| adjust.."
     *     --------------------------------------------------
     *     【1】stateUnspecified：软键盘的状态并没有指定，系统将选择一个合适的状态或依赖于主题的设置
     *     【2】stateUnchanged：当这个activity出现时，软键盘将一直保持在上一个activity里的状态，无论是隐藏还是显示
     *     【3】stateHidden：用户选择activity时，软键盘总是被隐藏
     *     【4】stateAlwaysHidden：当该Activity主窗口获取焦点时，软键盘也总是被隐藏的
     *     【5】stateVisible：软键盘通常是可见的
     *     【6】stateAlwaysVisible：用户选择activity时，软键盘总是显示的状态
     *     【7】adjustUnspecified：默认设置，通常由系统自行决定是隐藏还是显示
     *     【8】adjustResize：该Activity总是调整屏幕的大小以便留出软键盘的空间
     *     【9】adjustPan：当前窗口的内容将自动移动以便当前焦点从不被键盘覆盖和用户能总是看到输入内容的部分

     *
     * </--->
     */

    /**
     * 避免输入法面板遮挡:(Android 1.5后的一个新特性)
     * 在manifest.xml中activity中设置:
     *       android:windowSoftInputMode="stateVisible|adjustResize"
     *
     * 让界面不被软键盘挤上去
     * 在manifest.xml中activity中设置:
     *       android:windowSoftInputMode="adjustPan"
     */

    /**
     * 动态隐藏软键盘
     * <p>
     * inputmanger.hideSoftInputFromWindow(windowToken, flags);
     * <p>
     * 参数:
     * windowToken 由窗口请求View.getWindowToken() 返回得到的令牌(token)
     * flags 提供额外的操作标志.(0 ; HIDE_IMPLICIT_ONLY )
     *
     */

    private KeyboardUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    /*
      避免输入法面板遮挡
      <p>在manifest.xml中activity中设置</p>
      <p>android:windowSoftInputMode="adjustPan"</p>
     */

    /**
     * 动态显示软键盘
     *
     * @param activity activity
     */
    public static void showSoftInput(final Activity activity) {
        View view = activity.getCurrentFocus();
        if (view == null) view = new View(activity);
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        if (imm == null) return;
        imm.showSoftInput(view, InputMethodManager.SHOW_FORCED);
    }

    /**
     * 动态显示软键盘
     *
     * @param view 视图
     */
    public static void showSoftInput(final View view) {
        view.setFocusable(true);
        view.setFocusableInTouchMode(true);
        view.requestFocus();
        InputMethodManager imm = (InputMethodManager) Utils.getApp().getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm == null) return;
        imm.showSoftInput(view, InputMethodManager.SHOW_FORCED);
    }

    /**
     * 动态隐藏软键盘
     *
     * @param activity activity
     */
    public static void hideSoftInput(final Activity activity) {
        View view = activity.getCurrentFocus();
        if (view == null) view = new View(activity);
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        if (imm == null) return;
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    /**
     * 动态隐藏软键盘
     *
     * @param view 视图
     */
    public static void hideSoftInput(final View view) {
        InputMethodManager imm = (InputMethodManager) Utils.getApp().getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm == null) return;
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    /**
     * 切换键盘显示与否状态
     */
    public static void toggleSoftInput() {
        InputMethodManager imm = (InputMethodManager) Utils.getApp().getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm == null) return;
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
    }

    /**
     * 点击屏幕空白区域隐藏软键盘
     * <p>根据EditText所在坐标和用户点击的坐标相对比，来判断是否隐藏键盘</p>
     * <p>需重写dispatchTouchEvent</p>
     * <p>参照以下注释代码</p>
     */
    public static void clickBlankArea2HideSoftInput() {
        Log.d("tips", "U should copy the following code.");
        /*
        @Override
        public boolean dispatchTouchEvent(MotionEvent ev) {
            if (ev.getAction() == MotionEvent.ACTION_DOWN) {
                View v = getCurrentFocus();
                if (isShouldHideKeyboard(v, ev)) {
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(v.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
                }
            }
            return super.dispatchTouchEvent(ev);
        }

        // 根据EditText所在坐标和用户点击的坐标相对比，来判断是否隐藏键盘
        private boolean isShouldHideKeyboard(View v, MotionEvent event) {
            if (v != null && (v instanceof EditText)) {
                int[] l = {0, 0};
                v.getLocationInWindow(l);
                int left = l[0],
                        top = l[1],
                        bottom = top + v.getHeight(),
                        right = left + v.getWidth();
                return !(event.getX() > left && event.getX() < right
                        && event.getY() > top && event.getY() < bottom);
            }
            return false;
        }
        */
    }
}
