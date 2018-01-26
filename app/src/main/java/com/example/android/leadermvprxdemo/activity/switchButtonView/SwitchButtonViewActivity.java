package com.example.android.leadermvprxdemo.activity.switchButtonView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.android.leadermvprxdemo.R;
import com.example.pub.common.BaseActivity;

/**
 * @Description:
 * @Prject:
 * @Package: com.example.android.leadermvprxdemo.activity.switchButtonView
 * @author: Leader
 * @date: 2018/1/26   14:47
 * @Copyright: 个人版权所有
 * @Company:bc
 * @version: 1.0.0
 */

public class SwitchButtonViewActivity extends BaseActivity {
    private String[] tabTexts1 = {"才子", "帅哥", "大湿", "猛将兄"};
    private String[] tabTexts4 = {"已经", "在家", "等你"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switchbutton);

        ((SwitchMultiButton) findViewById(R.id.switchmultibutton1)).setText(tabTexts1).setOnSwitchListener(onSwitchListener);
        ((SwitchMultiButton) findViewById(R.id.switchmultibutton2)).setText("点个Star", "狠心拒绝").setOnSwitchListener(onSwitchListener);
        ((SwitchMultiButton) findViewById(R.id.switchmultibutton3)).setOnSwitchListener(onSwitchListener).setSelectedTab(1);
        ((SwitchMultiButton) findViewById(R.id.switchmultibutton4)).setText(tabTexts4).setOnSwitchListener(onSwitchListener);
    }

    private SwitchMultiButton.OnSwitchListener onSwitchListener = new SwitchMultiButton.OnSwitchListener() {
        @Override
        public void onSwitch(int position, String tabText) {
            Toast.makeText(SwitchButtonViewActivity.this, tabText, Toast.LENGTH_SHORT).show();
        }
    };
}
