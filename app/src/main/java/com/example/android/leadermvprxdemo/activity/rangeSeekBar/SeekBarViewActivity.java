package com.example.android.leadermvprxdemo.activity.rangeSeekBar;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.android.leadermvprxdemo.R;
import com.example.android.leadermvprxdemo.activity.rangeSeekBar.style_one.RangeSeekBarActivity;
import com.example.android.leadermvprxdemo.activity.rangeSeekBar.style_two.SeekBarDemo01Activity;
import com.example.pub.common.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Android on 2018/1/26.
 */

public class SeekBarViewActivity extends BaseActivity {
    @BindView(R.id.btn_one)
    Button btnOne;
    @BindView(R.id.btn_two)
    Button btnTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seekbar);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_one, R.id.btn_two})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_one:
                openActivity(RangeSeekBarActivity.class, null);
                break;
            case R.id.btn_two:
                openActivity(SeekBarDemo01Activity.class, null);
                break;
        }
    }
}
