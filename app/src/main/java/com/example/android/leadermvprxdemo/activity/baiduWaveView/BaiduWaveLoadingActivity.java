package com.example.android.leadermvprxdemo.activity.baiduWaveView;

import android.os.Bundle;

import com.example.android.leadermvprxdemo.R;
import com.example.pub.common.BaseActivity;

import butterknife.ButterKnife;

/**
 * @Description:百度波浪纹的加载动画
 * @Prject:
 * @Package: com.example.android.leadermvprxdemo.activity.baiduWaveView
 * @author: Leader
 * @date: 2018/4/2 0002   下午 13:40
 * @Copyright: 个人版权所有
 * @Company:bc
 * @version: 1.0.0
 */
public class BaiduWaveLoadingActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baiduwave);
        ButterKnife.bind(this);
    }

}
