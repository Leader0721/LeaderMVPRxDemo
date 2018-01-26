package com.example.android.leadermvprxdemo.activity.progressRunView;

import android.os.Bundle;

import com.example.android.leadermvprxdemo.R;
import com.example.pub.common.BaseActivity;

/**
 * @Description:弧形流量条控件
 * @Prject:
 * @Package: com.example.android.leadermvprxdemo.activity.progressRunView
 * @author: Leader
 * @date: 2018/1/26   9:44
 * @Copyright: 个人版权所有
 * @Company:bc
 * @version: 1.0.0
 */
public class ProgressRunViewActivity extends BaseActivity {
    private ArcBarView arcBar;

    private float result = 0;//剩余流量
    private String totalData = "2371.00";//可用流量
    private String usedData = "276.99";//已用流量

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progressrun);
        arcBar = (ArcBarView) findViewById(R.id.arc_bar);

        result = Float.parseFloat(totalData) - Float.parseFloat(usedData);

        arcBar.setTotalData(totalData+"M");
        arcBar.setUsedData(usedData+"M");
        arcBar.setResult(result);
    }
}
