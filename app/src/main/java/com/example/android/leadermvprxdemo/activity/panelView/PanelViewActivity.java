package com.example.android.leadermvprxdemo.activity.panelView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.android.leadermvprxdemo.R;
import com.example.pub.common.BaseActivity;

import junit.framework.Test;

/**
 * @Description:侧边栏的自定义view
 * @Prject:
 * @Package: com.example.android.leadermvprxdemo.activity.panelView
 * @author: Leader
 * @date: 2018/3/22 0022   上午 9:44
 * @Copyright: 个人版权所有
 * @Company:bc
 * @version: 1.0.0
 */

public class PanelViewActivity extends BaseActivity {
    Button btn;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panelview);

        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(btnClick);


    }

    View.OnClickListener btnClick = new View.OnClickListener() {

        public void onClick(View v) {
            Log.i("", "sjglsjglsjgl................click");

            Toast.makeText(PanelViewActivity.this, "button clicked", 100).show();
        }
    };
}
