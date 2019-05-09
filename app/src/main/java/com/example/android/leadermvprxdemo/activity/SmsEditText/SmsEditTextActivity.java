package com.example.android.leadermvprxdemo.activity.SmsEditText;

import android.os.Bundle;

import com.example.android.leadermvprxdemo.R;
import com.example.pub.common.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SmsEditTextActivity extends BaseActivity implements CodeEditText.OnTextFinishListener {
    @BindView(R.id.et_sms_code)
    CodeEditText mCodeEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms_edittext);
        ButterKnife.bind(this);
        mCodeEditText.setOnTextFinishListener(this);
    }

    @Override
    public void onTextFinish(CharSequence text, int length) {

    }
}
