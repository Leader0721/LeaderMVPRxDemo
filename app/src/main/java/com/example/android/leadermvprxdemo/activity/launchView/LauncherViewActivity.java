package com.example.android.leadermvprxdemo.activity.launchView;

import android.os.Bundle;
import android.view.View;

import com.example.android.leadermvprxdemo.R;
import com.example.pub.common.BaseActivity;

import butterknife.ButterKnife;

/**
 * @Description:启动页的动画效果
 * @Prject: 
 * @Package: com.example.android.leadermvprxdemo.activity.launchView
 * @author: Leader
 * @date: 2018/2/28   9:39
 * @Copyright: 个人版权所有
 * @Company:bc
 * @version: 1.0.0
 */

public class LauncherViewActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcherview);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        final LauncherView launcherView = (LauncherView) findViewById(R.id.load_view);

        findViewById(R.id.start).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launcherView.start();
            }
        });
    }
}
