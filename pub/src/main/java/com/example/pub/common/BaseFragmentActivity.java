package com.example.pub.common;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.example.pub.net.core.manager.ActivityManager;
import com.example.pub.utils.app.Utils;
import com.example.pub.view.dialog.ProgressDialog;

import org.simple.eventbus.EventBus;

import java.util.Iterator;
import java.util.List;

/**
 * description Fragment基类
 * author hanlei
 * version 1.0
 * created at 2017/7/26.
 */
public abstract class BaseFragmentActivity extends FragmentActivity {

    public static final String ARG_PARAM1 = "param1";
    public static final String ARG_PARAM2 = "param2";

    protected BaseFragmentActivity mActivity;
    //ProgressDialog
    public ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON, WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        EventBus.getDefault().register(this);
        ActivityManager.addActivity(this);
        //工具类要先在这里进行实例化
        Utils.init(getApplication());

        mActivity = this;
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }

    /**
     * 切换Fragment
     *
     * @param fragmentClass   Fragment的类
     * @param bundle          传递的参数
     * @param containerViewId 上一个视图的根视图
     * @param replace         是否替换模式，替换模式会重新加载
     * @param tag             Fragment视图的标记，fragmentClass同样的情况下，以此为区分
     */
    public void toggleFragment(Class<? extends Fragment> fragmentClass, Bundle bundle, int containerViewId, boolean replace, String tag) {

        FragmentManager manager = this.getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        Fragment fragment = manager.findFragmentByTag(tag);
        if (fragment == null) {
            try {
                fragment = fragmentClass.newInstance();
                if (bundle != null) {
                    fragment.setArguments(bundle);
                }
                if (replace) {//调用onDestoryView
                    transaction.replace(containerViewId, fragment, tag);
                } else {
                    transaction.add(containerViewId, fragment, tag);
                }
            } catch (Exception exception) {
            }
        }

        List fragments = manager.getFragments();

        if (fragments != null) {
            Iterator iterator = fragments.iterator();

            while (iterator.hasNext()) {
                Fragment fm = (Fragment) iterator.next();
                if (fm != null && !fm.equals(fragment)) {
                    transaction.hide(fm);
                }
            }
        }

        transaction.show(fragment);
        transaction.commit();
    }

    /**
     * 不区分tag,适用于每个选项的fragmentClass都不相同
     *
     * @param fragmentClass
     * @param bundle
     * @param containerViewId
     * @param replace
     */
    public void toggleFragment(Class<? extends Fragment> fragmentClass, Bundle bundle, int containerViewId, boolean replace) {
        toggleFragment(fragmentClass, bundle, containerViewId, replace, fragmentClass.getName());
    }

    /**
     * 不需要传递参数，适用于简单的跳转逻辑
     *
     * @param fragmentClass
     * @param containerViewId
     * @param replace
     */
    public void toggleFragment(Class<? extends Fragment> fragmentClass, int containerViewId, boolean replace) {

        toggleFragment(fragmentClass, null, containerViewId, replace);
    }


    /**
     * 显示等待框
     */
    public void setProgressText(String text) {

        if (progressDialog == null) {
            progressDialog = new ProgressDialog(this);
        }
        progressDialog.setText(text);
    }

    /**
     * 显示等待框
     */
    public void showProgress() {

        if (progressDialog == null) {
            progressDialog = new ProgressDialog(this);
        }
        if (!progressDialog.isShow()) {
            progressDialog.show();
        }

    }

    /**
     * 隐藏等待框
     */
    public void hideProgress() {

        if (progressDialog != null) {
            progressDialog.cancelImmediately();
        }
    }


    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        EventBus.getDefault().unregister(this);
        ActivityManager.removeActivity(this);
        super.onDestroy();
    }

    // 点击空白处隐藏软键盘
    // 获取点击事件
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            View view = getCurrentFocus();
            if (isHideInput(view, ev)) {
                HideSoftInput(view.getWindowToken());
            }
        }
        return super.dispatchTouchEvent(ev);
    }

    // 判定是否需要隐藏
    private boolean isHideInput(View v, MotionEvent ev) {
        if (v != null && (v instanceof EditText)) {
            int[] l = {0, 0};
            v.getLocationInWindow(l);
            int left = l[0], top = l[1], bottom = top + v.getHeight(), right = left
                    + v.getWidth();
            if (ev.getX() > left && ev.getX() < right && ev.getY() > top
                    && ev.getY() < bottom) {
                return false;
            } else {
                return true;
            }
        }
        return false;
    }

    // 隐藏软键盘
    private void HideSoftInput(IBinder token) {
        if (token != null) {
            InputMethodManager manager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            manager.hideSoftInputFromWindow(token,
                    InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }

    /**
     * 启动一个Activity
     *
     * @param pClass
     * @param pBundle
     */
    protected void openActivity(Class<?> pClass, Bundle pBundle) {
        Intent intent = new Intent(this, pClass);
        if (pBundle != null) {
            intent.putExtras(pBundle);
        }
        startActivity(intent);
    }
}
