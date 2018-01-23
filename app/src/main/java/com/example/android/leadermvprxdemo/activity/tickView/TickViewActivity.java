package com.example.android.leadermvprxdemo.activity.tickView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.android.leadermvprxdemo.R;
import com.example.android.leadermvprxdemo.activity.tickView.lib.OnCheckedChangeListener;
import com.example.android.leadermvprxdemo.activity.tickView.lib.TickAnimatorListener;
import com.example.android.leadermvprxdemo.activity.tickView.lib.TickView;
import com.example.pub.common.BaseActivity;

/**
 * @Description:打对勾的一个动画
 * @Prject:
 * @Package: com.example.android.leadermvprxdemo.activity.tickView
 * @author: Leader
 * @date: 2018/1/23   9:22
 * @Copyright: 个人版权所有
 * @Company:bc
 * @version: 1.0.0
 * 思路实现
 * 简书，http://www.jianshu.com/p/673e3b3715a2
 * 掘金，https://juejin.im/post/59ebe2b75188250989513b1b
 * 优化思路
 * 简书，http://www.jianshu.com/p/1ff14c0156b0
 * 掘金，https://juejin.im/post/59f5609851882534af2538c0
 */

public class TickViewActivity extends BaseActivity {
    private static final String TAG = TickViewActivity.class.getSimpleName();

    TickView tickView;
    TickView tickViewAccent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tickview);
        tickView = (TickView) findViewById(R.id.tick_view);
//        tickView.toggle();//这个是模拟控件的点击
        tickView.getConfig().setOnCheckedChangeListener(new OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(TickView tickView, boolean isCheck) {
                Toast.makeText(getApplicationContext(), "dfasd", Toast.LENGTH_LONG).show();
                ;
            }
        }).setTickAnimatorListener(new TickAnimatorListener.TickAnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(TickView tickView) {
                super.onAnimationStart(tickView);
            }
        });


        tickViewAccent = (TickView) findViewById(R.id.tick_view_accent);
        findViewById(R.id.check_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tickView.setChecked(true);
                tickViewAccent.setChecked(true);
            }
        });
        findViewById(R.id.uncheck_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tickView.setChecked(false);
                tickViewAccent.setChecked(false);
            }
        });
    }
}
