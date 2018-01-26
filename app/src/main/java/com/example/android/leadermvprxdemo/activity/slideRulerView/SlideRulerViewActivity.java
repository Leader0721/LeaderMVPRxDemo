package com.example.android.leadermvprxdemo.activity.slideRulerView;

import android.os.Bundle;

import com.example.android.leadermvprxdemo.R;
import com.example.pub.common.BaseActivity;
import com.example.pub.utils.view.ToastUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @Description:高仿京东金融的数值滚动尺
 * @Prject:
 * @Package: com.example.android.leadermvprxdemo.activity.slideRulerView
 * @author: Leader
 * @date: 2018/1/25   14:57
 * @Copyright: 个人版权所有
 * @Company:bc
 * @version: 1.0.0
 */

public class SlideRulerViewActivity extends BaseActivity {
    @BindView(R.id.slideruler)
    SlideRuler slideruler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slideruler);
        ButterKnife.bind(this);
        slideruler = (SlideRuler) findViewById(R.id.slideruler);
        slideruler.setSlideRulerDataInterface(new SlideRulerDataInterface() {
            @Override
            public void getText(String data) {
                ToastUtils.showShort(data + "");
            }
        });
    }
}
