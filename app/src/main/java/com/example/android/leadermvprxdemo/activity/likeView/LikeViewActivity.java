package com.example.android.leadermvprxdemo.activity.likeView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.android.leadermvprxdemo.R;
import com.example.pub.common.BaseActivity;

import butterknife.ButterKnife;

/**
 * Created by Android on 2018/2/25.
 */

public class LikeViewActivity extends BaseActivity {
    private LikeView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_likeview);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        lv = (LikeView) findViewById(R.id.lv);

        lv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("LikeView", "onClick" + lv.getState());
            }
        });
    }
}
