package com.example.android.leadermvprxdemo.activity.rangeSeekBar.style_one;

import android.os.Bundle;
import android.widget.TextView;

import com.example.android.leadermvprxdemo.R;
import com.example.pub.common.BaseActivity;

import java.text.DecimalFormat;

/**
 * @Description:进度相关的视图
 * @Prject:
 * @Package: com.example.android.leadermvprxdemo.activity.rangeSeekBar
 * @author: Leader
 * @date: 2018/1/23   17:32
 * @Copyright: 个人版权所有
 * @Company:bc
 * @version: 1.0.0
 */

public class RangeSeekBarActivity extends BaseActivity {

    private RangeSeekBar seekbar1;
    private RangeSeekBar seekbar2;
    private TextView tv2;
    private DecimalFormat df = new DecimalFormat("0.00");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rangeseekbar);

        seekbar1 = (RangeSeekBar) findViewById(R.id.seekbar1);
        seekbar2 = (RangeSeekBar) findViewById(R.id.seekbar2);
        tv2 = (TextView) findViewById(R.id.progress2_tv);

        seekbar1.setValue(90);
        seekbar2.setValue(-0.5f, 0.8f);
        seekbar1.setOnRangeChangedListener(new RangeSeekBar.OnRangeChangedListener() {
            @Override
            public void onRangeChanged(RangeSeekBar view, float min, float max, boolean isFromUser) {
                seekbar1.setProgressDescription((int) min + "%");
            }

            @Override
            public void onStartTrackingTouch(RangeSeekBar view, boolean isLeft) {
                //do what you want!!
            }

            @Override
            public void onStopTrackingTouch(RangeSeekBar view, boolean isLeft) {
                //do what you want!!
            }
        });

        seekbar2.setOnRangeChangedListener(new RangeSeekBar.OnRangeChangedListener() {
            @Override
            public void onRangeChanged(RangeSeekBar view, float min, float max, boolean isFromUser) {
                if (isFromUser) {
                    tv2.setText(min + "-" + max);
                    seekbar2.setLeftProgressDescription(df.format(min));
                    seekbar2.setRightProgressDescription(df.format(max));
                }
            }

            @Override
            public void onStartTrackingTouch(RangeSeekBar view, boolean isLeft) {
                //do what you want!!
            }

            @Override
            public void onStopTrackingTouch(RangeSeekBar view, boolean isLeft) {
                //do what you want!!
            }
        });

    }
}
