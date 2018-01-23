package com.example.android.leadermvprxdemo.activity.wavePercentView;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.example.android.leadermvprxdemo.R;
import com.example.pub.common.BaseActivity;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @Description:带有百分比的波浪视图
 * @Prject:
 * @Package: com.example.android.leadermvprxdemo.activity.wavePercentView
 * @author: Leader
 * @date: 2018/1/23   10:18
 * @Copyright: 个人版权所有
 * @Company:bc
 * @version: 1.0.0
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 关于我
 * <p>
 * 简书 http://www.jianshu.com/users/18281bdb07ce/latest_articles
 * <p>
 * 博客 http://crazyandcoder.github.io/
 * <p>
 * github https://github.com/crazyandcoder
 * <p>
 * 参考资料
 * <p>
 * 1、http://blog.csdn.net/zhongkejingwang/article/details/38556891
 * <p>
 * 2、https://github.com/GcsSloop/AndroidNote/blob/master/CustomView/Advance/%5B06%5DPath_Bezier.md
 */

public class WavePercentActivity extends BaseActivity {
    private Timer timer;
    private Timer timerCircle;
    WaveView waveview;
    WaveView waveviewCicle;

    private MyTimerTask mTask;
    private MyTimerTaskCircle mTaskCircle;
    int i = 0;
    int j = 0;
    Handler updateHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {

            if (msg.what == 1) {
                waveview.setProgress((int) (msg.obj));
                waveview.start();
            } else if (msg.what == 2) {
                waveviewCicle.setProgress((int) (msg.obj));
                waveviewCicle.start();
            }
        }

    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wavepercent);

        waveview = (WaveView) findViewById(R.id.waveview);
        waveviewCicle = (WaveView) findViewById(R.id.waveview_circle);
        mTask = new MyTimerTask(updateHandler);
        mTaskCircle = new MyTimerTaskCircle(updateHandler);
        timer = new Timer();
        timerCircle = new Timer();
        timer.schedule(mTask, 0, 100);
        timerCircle.schedule(mTaskCircle, 0, 100);

    }

    class MyTimerTask extends TimerTask {
        Handler handler;

        public MyTimerTask(Handler handler) {
            this.handler = handler;
        }

        @Override
        public void run() {
            Message message = handler.obtainMessage();
            message.what = 1;
            message.obj = (i++) % 101;
            handler.sendMessage(message);
        }

    }

    class MyTimerTaskCircle extends TimerTask {
        Handler handler;

        public MyTimerTaskCircle(Handler handler) {
            this.handler = handler;
        }

        @Override
        public void run() {
            Message message = handler.obtainMessage();
            message.what = 2;
            message.obj = (j++) % 101;
            handler.sendMessage(message);
        }

    }

}
