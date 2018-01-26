package com.example.android.leadermvprxdemo.activity.miClickView;

import android.os.Bundle;

import com.example.android.leadermvprxdemo.R;
import com.example.pub.common.BaseActivity;

import butterknife.ButterKnife;

/**
 * Created by Android on 2018/1/25.
 */

public class MiClockViewActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_miclock);
        ButterKnife.bind(this);
    }
}
