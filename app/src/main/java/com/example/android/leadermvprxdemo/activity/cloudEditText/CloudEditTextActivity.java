package com.example.android.leadermvprxdemo.activity.cloudEditText;

import android.os.Bundle;

import com.example.android.leadermvprxdemo.R;
import com.example.pub.common.BaseActivity;

import butterknife.ButterKnife;

/**
 * @Description:可编辑的EditText
 * @Prject:
 * @Package: com.example.android.leadermvprxdemo.activity.cloudEditText
 * @author: Leader
 * @date: 2018/3/19 0019   上午 11:37
 * @Copyright: 个人版权所有
 * @Company:bc
 * @version: 1.0.0
 */
public class CloudEditTextActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editext);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {

    }
}
