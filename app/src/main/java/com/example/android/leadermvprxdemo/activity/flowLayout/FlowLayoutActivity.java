package com.example.android.leadermvprxdemo.activity.flowLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.android.leadermvprxdemo.R;
import com.example.pub.common.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Android on 2018/1/25.
 */

public class FlowLayoutActivity extends BaseActivity {
    @BindView(R.id.btn_one)
    Button btnOne;
    @BindView(R.id.btn_two)
    Button btnTwo;
    @BindView(R.id.btn_three)
    Button btnThree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flowlayout);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_one, R.id.btn_two, R.id.btn_three})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_one:
                openActivity(FlowLayout_1_Activity.class, null);
                break;
            case R.id.btn_two:
                openActivity(FlowLayout_2_Activity.class, null);
                break;
            case R.id.btn_three:
                openActivity(FlowLayout_3_Activity.class, null);
                break;
        }
    }
}
