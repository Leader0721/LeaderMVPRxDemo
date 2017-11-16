/**
 * Project Name:TestAndroid File Name: PasswordTextWatcher.java Package
 * Name:com. .yanbb.testandroid Date:2015-5-27 Copyright (c) 2015, www. .com All
 * Rights Reserved.
 */

package com.example.pub.utils.view;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Description:密码的验证类
 * @Prject:
 * @Package: com.example.pub.utils
 * @author: Leader
 * @date: 2017/11/14   20:00
 * @Copyright: 个人版权所有
 * @Company:bc
 * @version: 1.0.0
 */
public abstract class PasswordTextWatcher implements TextWatcher {
    private static final String LOG_TAG = PasswordTextWatcher.class
            .getSimpleName();
    // password match rule
    private static final String PASSWORD_REGEX = "[A-Z0-9a-z!@#$%^&*.~/\\{\\}|()'\"?><,.`\\+-=_\\[\\]:;]+";

    private boolean mIsMatch;
    private CharSequence mResult;
    private int mSelectionStart;
    private int mSelectionEnd;
    private EditText mPswEditText;

    public PasswordTextWatcher() {
    }

    ;

    public PasswordTextWatcher(EditText editText) {
        mPswEditText = editText;
    }

    ;

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count,
                                  int after) {
        // TODO Auto-generated method stub
        mSelectionStart = mPswEditText.getSelectionStart();
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        // TODO Auto-generated method stub
        CharSequence charSequence = "";
        if ((mSelectionStart + count) <= s.length()) {
            charSequence = s.subSequence(mSelectionStart, mSelectionStart
                    + count);
        }
        mIsMatch = pswFilter(charSequence);
        if (!mIsMatch) {
            String temp = s.toString();
            mResult = temp.replace(charSequence, "");
            mSelectionEnd = start;
        }
    }

    @Override
    public void afterTextChanged(Editable s) {
        // TODO Auto-generated method stub
        if (!mIsMatch) {
            mPswEditText.setText(mResult);
            mPswEditText.setSelection(mSelectionEnd);
        }
    }

    /**
     * pswFilter: if the param folow the password match rule<br/>
     *
     * @param s
     * @return
     * @author .yanbb
     * @since MT 1.0
     */
    private boolean pswFilter(CharSequence s) {
        if (TextUtils.isEmpty(s)) {
            return true;
        }
        Pattern pattern = Pattern.compile(PASSWORD_REGEX);
        Matcher matcher = pattern.matcher(s);
        if (matcher.matches()) {
            return true;
        }
        return false;
    }
}
