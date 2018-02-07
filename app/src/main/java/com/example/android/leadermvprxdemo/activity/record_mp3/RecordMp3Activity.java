package com.example.android.leadermvprxdemo.activity.record_mp3;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;

import com.czt.mp3recorder.MP3Recorder;
import com.example.android.leadermvprxdemo.R;
import com.example.pub.common.BaseActivity;

import java.io.File;
import java.io.IOException;

/**
 * @Description:录音成mp3格式
 * @Prject:
 * @Package: com.example.android.leadermvprxdemo.activity.record_mp3
 * @author: Leader
 * @date: 2018/1/29   9:33
 * @Copyright: 个人版权所有
 * @Company:bc
 * @version: 1.0.0
 */
public class RecordMp3Activity extends BaseActivity {
    private MP3Recorder mRecorder = new MP3Recorder(new File(Environment.getExternalStorageDirectory(), "leader.mp3"));

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record_mp3);
        Button startButton = (Button) findViewById(R.id.StartButton);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    mRecorder.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        Button stopButton = (Button) findViewById(R.id.StopButton);
        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mRecorder.stop();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mRecorder.stop();
    }
}
