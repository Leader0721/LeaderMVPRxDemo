package com.example.android.leadermvprxdemo.activity.textSelectedableHelper;

import android.os.Bundle;
import android.widget.TextView;

import com.example.android.leadermvprxdemo.R;
import com.example.pub.common.BaseActivity;

/**
 * @Description:textView选择之后的操作
 * @Prject:
 * @Package: com.example.android.leadermvprxdemo.activity.textSelectedableHelper
 * @author: Leader
 * @date: 2018/1/31   9:13
 * @Copyright: 个人版权所有
 * @Company:bc
 * @version: 1.0.0
 */

public class TextSelectedHelperActivity extends BaseActivity {
    private TextView mTvTest;

    private SelectableTextHelper mSelectableTextHelper;
    private TextView tvTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_select);
        mTvTest = (TextView) findViewById(R.id.tv_test);
        //mTvTest.setTextIsSelectable(true);

        mSelectableTextHelper = new SelectableTextHelper.Builder(mTvTest)
                .setSelectedColor(getResources().getColor(R.color.selected_blue))
                .setCursorHandleSizeInDp(20)
                .setCursorHandleColor(getResources().getColor(R.color.cursor_handle_color))
                .build();

        mSelectableTextHelper.setSelectListener(new OnSelectListener() {
            @Override
            public void onTextSelected(CharSequence content) {

            }
        });
        initView();
    }

    private void initView() {
        tvTest = (TextView) findViewById(R.id.tv_test);
    }
}
