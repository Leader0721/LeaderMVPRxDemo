package com.example.android.leadermvprxdemo.activity.circleCounter;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;

import com.example.android.leadermvprxdemo.R;
import com.example.pub.common.BaseActivity;

/**
 * @Description:多层圆计数自定义视图
 * @Prject:
 * @Package: com.example.android.leadermvprxdemo.activity.circleCounter
 * @author: Leader
 * @date: 2018/3/22 0022   上午 9:58
 * @Copyright: 个人版权所有
 * @Company:bc
 * @version: 1.0.0
 */

public class CircularCounterActivity extends BaseActivity {
    private CircularCounter meter;

    private String[] colors;

    private Handler handler;

    private Runnable r;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circlecounter);

        colors = getResources().getStringArray(R.array.colors);

        meter = (CircularCounter) findViewById(R.id.meter);

        meter.setFirstWidth(getResources().getDimension(R.dimen.v10))
                .setFirstColor(Color.parseColor(colors[0]))
                .setSecondWidth(getResources().getDimension(R.dimen.v15))
                .setSecondColor(Color.parseColor(colors[1]))
                .setThirdWidth(getResources().getDimension(R.dimen.v20))
                .setThirdColor(Color.parseColor(colors[2]))
                .setBackgroundColor(-14606047);


        handler = new Handler();
        r = new Runnable() {
            int currV = 0;
            boolean go = true;

            public void run() {
                if (currV == 60 && go)
                    go = false;
                else if (currV == -60 && !go)
                    go = true;

                if (go)
                    currV++;
                else
                    currV--;

                meter.setValues(currV, currV * 2, currV * 3);
                handler.postDelayed(this, 50);
            }
        };


    }

    @Override
    protected void onResume() {
        super.onResume();
        handler.postDelayed(r, 500);
    }

    @Override
    protected void onPause() {
        super.onPause();
        handler.removeCallbacks(r);
    }
}
