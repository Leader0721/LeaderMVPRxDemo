package com.example.android.leadermvprxdemo.activity.flowLayout;

import android.os.Bundle;
import android.util.TypedValue;
import android.widget.TextView;

import com.example.android.leadermvprxdemo.R;
import com.example.android.leadermvprxdemo.activity.flowLayout.lib.FlowLayout;
import com.example.pub.common.BaseActivity;

/**
 * @Description:流式布局
 * @Prject:
 * @Package: com.example.android.leadermvprxdemo.activity.flowLayout
 * @author: Leader
 * @date: 2018/1/25   11:08
 * @Copyright: 个人版权所有
 * @Company:bc
 * @version: 1.0.0
 */
public class FlowLayout_2_Activity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flowlayout_2);
        fillAutoSpacingLayout();
    }


    private void fillAutoSpacingLayout() {
        FlowLayout flowLayout = (FlowLayout) findViewById(R.id.flow);
        String[] dummyTexts = getResources().getStringArray(R.array.flowLayoutArray);

        for (String text : dummyTexts) {
            TextView textView = buildLabel(text);
            flowLayout.addView(textView);
        }
    }

    private TextView buildLabel(String text) {
        TextView textView = new TextView(this);
        textView.setText(text);
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);
        textView.setPadding((int) dpToPx(16), (int) dpToPx(8), (int) dpToPx(16), (int) dpToPx(8));
        textView.setBackgroundResource(R.drawable.bg_blue);

        return textView;
    }

    private float dpToPx(float dp) {
        return TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, dp, getResources().getDisplayMetrics());
    }
}
