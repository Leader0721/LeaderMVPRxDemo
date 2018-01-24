package com.example.android.leadermvprxdemo.activity.diyKeyBorad;

import android.os.Bundle;
import android.widget.TextView;

import com.example.android.leadermvprxdemo.R;
import com.example.pub.common.BaseActivity;

/**
 * @Description:自定义软键盘
 * @Prject:
 * @Package: com.example.android.leadermvprxdemo.activity.diyKeyBorad
 * @author: Leader
 * @date: 2018/1/24   9:00
 * @Copyright: 个人版权所有
 * @Company:bc
 * @version: 1.0.0
 */

public class DiyKeyBoardActivity extends BaseActivity implements NumberKeyboardView.OnNumberClickListener {

    private NumberKeyboardView mNkvKeyboard;
    private TextView mTvText;
    private String str = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keyboard);

        initView();
    }

    private void initView() {
        mTvText = (TextView) findViewById(R.id.am_tv_text);
        mNkvKeyboard = (NumberKeyboardView) findViewById(R.id.am_nkv_keyboard);
        mNkvKeyboard.setOnNumberClickListener(this);
    }

    @Override
    public void onNumberReturn(String number) {
        str += number;
        setTextContent(str);
    }

    @Override
    public void onNumberDelete() {
        if (str.length() <= 1) {
            str = "";
        } else {
            str = str.substring(0, str.length() - 1);
        }
        setTextContent(str);
    }

    private void setTextContent(String content) {
        mTvText.setText(content);
    }
}
