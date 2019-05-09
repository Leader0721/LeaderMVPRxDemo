package com.example.android.leadermvprxdemo.activity.countDownTextView;

import android.os.Bundle;

import com.example.android.leadermvprxdemo.R;
import com.example.android.leadermvprxdemo.activity.SmsEditText.CodeEditText;
import com.example.pub.common.BaseActivity;
import com.example.pub.utils.view.ToastUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CountDownViewActivity extends BaseActivity {
    @BindView(R.id.tv_skip)
    CountDownTextView mCountDownTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countdownview);
        ButterKnife.bind(this);
        mCountDownTextView.start();
        mCountDownTextView.setOnFinishListener(new CountDownTextView.OnFinishListener() {
            @Override
            public void onFinish() {
                ToastUtils.showShort("跳过去了");
                finish();
            }
        });
    }

}
