package com.example.android.leadermvprxdemo.activity.seekBar;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.android.leadermvprxdemo.R;
import com.example.pub.common.BaseActivity;

import butterknife.ButterKnife;

public class SeekBarActivity extends BaseActivity {
    private TextView tvIndicator;
    private IndicatorSeekBar indicatorSeekBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seekbar1);
        ButterKnife.bind(this);
        tvIndicator = (TextView) findViewById(R.id.tv_indicator);
        indicatorSeekBar = (IndicatorSeekBar) findViewById(R.id.indicator_seek_bar);
        initData();
    }


    private void initData() {
        final LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) tvIndicator.getLayoutParams();
        indicatorSeekBar.setOnSeekBarChangeListener(new IndicatorSeekBar.OnIndicatorSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, float indicatorOffset) {
                String indicatorText = progress + "%";
                tvIndicator.setText(indicatorText);
                params.leftMargin = (int) indicatorOffset;
                tvIndicator.setLayoutParams(params);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                tvIndicator.setVisibility(View.VISIBLE);
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                tvIndicator.setVisibility(View.INVISIBLE);
            }
        });
    }
}
