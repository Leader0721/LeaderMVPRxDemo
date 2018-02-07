package com.example.android.leadermvprxdemo.activity.radarCycleView;

import android.os.Bundle;

import com.example.android.leadermvprxdemo.R;
import com.example.pub.common.BaseActivity;

/**
 * Created by Android on 2018/1/27.
 */

public class RadarCycleViewActivity extends BaseActivity {
    private RadarWaveView radarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radarcycle);

        radarView = (RadarWaveView) findViewById(R.id.radar_view);
    }

    @Override
    protected void onResume() {
        super.onResume();
        radarView.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        radarView.pause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        radarView.stop();
    }
}
