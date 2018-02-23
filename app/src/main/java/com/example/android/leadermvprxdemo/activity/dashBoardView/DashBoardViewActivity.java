package com.example.android.leadermvprxdemo.activity.dashBoardView;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.android.leadermvprxdemo.R;
import com.example.pub.common.BaseActivity;

/**
 * @Description:汽车刻度盘的一个自定义视图
 * @Prject:
 * @Package: com.example.android.leadermvprxdemo.activity.dashBoardView
 * @author: Leader
 * @date: 2018/2/1   11:29
 * @Copyright: 个人版权所有
 * @Company:bc
 * @version: 1.0.0
 */

public class DashBoardViewActivity extends BaseActivity {

    private static final String TAG = "MainActivity";
    private DashBoardView dashView;
    private boolean isChangeColor = true;
    private SeekBar sbChangeCurrentvalue, sbChangeMaxValue;
    private TextView tv1, tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboardview);
        tv1 = (TextView) this.findViewById(R.id.tv1);
        tv2 = (TextView) this.findViewById(R.id.tv2);

        sbChangeCurrentvalue = (SeekBar) this.findViewById(R.id.sb_change_currentvalue);
        sbChangeMaxValue = (SeekBar) this.findViewById(R.id.sb_change_maxValue);

        dashView = (DashBoardView) this.findViewById(R.id.dashview);
        sbChangeMaxValue.setMax(300);
        sbChangeCurrentvalue.setMax((int) (dashView.getmMax()));
        this.findViewById(R.id.bt_change_color).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isChangeColor) {
                    dashView.setDashColor(Color.parseColor("#39B54A"));
                    isChangeColor = false;
                } else {
                    dashView.setDashColor(Color.parseColor("#DA6858"));
                    isChangeColor = true;
                }
            }
        });

        sbChangeCurrentvalue.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                int currentValue = seekBar.getProgress();
                dashView.setCurrentValue(currentValue);
                tv1.setText("当前值:" + currentValue + "/" + seekBar.getMax());
                Log.d(TAG, "    --------currentValue---------   " + currentValue);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        sbChangeMaxValue.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                int value = seekBar.getProgress() + 100;
                dashView.setmMax(value);
                tv2.setText("最大值:" + value + "/" + seekBar.getMax());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}
