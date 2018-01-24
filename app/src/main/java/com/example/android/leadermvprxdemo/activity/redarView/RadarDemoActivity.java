package com.example.android.leadermvprxdemo.activity.redarView;

import android.os.Bundle;

import com.example.android.leadermvprxdemo.R;
import com.example.pub.common.BaseActivity;

/**
 * Created by Android on 2018/1/24.
 */

public class RadarDemoActivity extends BaseActivity {
    RadarView xRadarView1;
    String[] titles = new String[]{"击杀", "金钱", "防御", "魔法", "物理", "助攻", "生存"};
    double[] percents = new double[]{1.0, 0.46, 0.63, 0.75, 0.5, 0.9, 0.26};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radar_demo);

        xRadarView1 = (RadarView) this.findViewById(R.id.radarView1);
        xRadarView1.setTitles(titles);
        xRadarView1.setPercents(percents);
    }
}
