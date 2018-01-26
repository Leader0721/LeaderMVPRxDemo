package com.example.android.leadermvprxdemo.activity.rangeSeekBar.style_two;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.android.leadermvprxdemo.R;
import com.example.pub.common.BaseActivity;

/**
 * Created by Android on 2018/1/26.
 */

public class SeekBarDemo01Activity extends BaseActivity implements View.OnClickListener {
    private String mTag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seekbar01);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        findViewById(R.id.main_tab_btn_1).setOnClickListener(this);
        findViewById(R.id.main_tab_btn_2).setOnClickListener(this);
        findViewById(R.id.main_tab_btn_3).setOnClickListener(this);
        findViewById(R.id.main_tab_btn_4).setOnClickListener(this);

        if (savedInstanceState == null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.add(R.id.container, DemoFragment1.newInstance(), "demo1");
            ft.commit();
            mTag = "demo1";
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.main_tab_btn_1:
                switchContent("demo1");
                break;
            case R.id.main_tab_btn_2:
                switchContent("demo2");
                break;
            case R.id.main_tab_btn_3:
                switchContent("demo3");
                break;
            case R.id.main_tab_btn_4:
                switchContent("demo4");
                break;
        }
    }

    public void switchContent(String toTag) {
        if (mTag.equals(toTag))
            return;

        FragmentManager fm = getSupportFragmentManager();
        Fragment from = fm.findFragmentByTag(mTag);
        Fragment to = fm.findFragmentByTag(toTag);

        FragmentTransaction ft = fm.beginTransaction();
        if (to == null) {
            if ("demo1".equals(toTag)) {
                to = DemoFragment1.newInstance();
            } else if ("demo2".equals(toTag)) {
                to = DemoFragment2.newInstance();
            } else if ("demo3".equals(toTag)) {
                to = DemoFragment3.newInstance();
            } else {
                to = DemoFragment4.newInstance();
            }
        }
        if (!to.isAdded()) {
            ft.hide(from).add(R.id.container, to, toTag);
        } else {
            ft.hide(from).show(to);
        }
        ft.commit();

        mTag = toTag;
    }
}
