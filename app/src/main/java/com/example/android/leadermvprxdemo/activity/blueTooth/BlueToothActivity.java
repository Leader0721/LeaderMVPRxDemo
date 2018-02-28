package com.example.android.leadermvprxdemo.activity.blueTooth;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.android.leadermvprxdemo.R;
import com.example.pub.common.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @Description:蓝牙模块
 * @Prject:
 * @Package: com.example.android.leadermvprxdemo.activity.blueTooth
 * @author: Leader
 * @date: 2018/2/28   10:00
 * @Copyright: 个人版权所有
 * @Company:bc
 * @version: 1.0.0
 */

public class BlueToothActivity extends BaseActivity {

    @BindView(R.id.btn_one)
    Button btnOne;
    @BindView(R.id.btn_two)
    Button btnTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bluetooth);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {

    }

    @OnClick({R.id.btn_one, R.id.btn_two})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_one:
                openActivity(DeviceScanActivity.class, null);
                break;
            case R.id.btn_two:
                break;
        }
    }
}
