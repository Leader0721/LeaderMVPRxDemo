package com.example.android.leadermvprxdemo.activity.delicateView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

import com.example.android.leadermvprxdemo.R;
import com.example.pub.common.BaseActivity;

import butterknife.ButterKnife;

/**
 * @Description:各种精致的小动画
 * @Prject:
 * @Package: com.example.android.leadermvprxdemo.activity.delicateView
 * @author: Leader
 * @date: 2018/1/26   15:32
 * @Copyright: 个人版权所有
 * @Company:bc
 * @version: 1.0.0
 */

public class DelicateViewActivity extends BaseActivity {
    private ENDownloadView downloadView;
    private Button btnStart;
    private Button btnReset;

    ENLoadingView loadingView;
    Button btnShow;
    Button btnHide;

    ENPlayView playView;
    Button btnPause;
    Button btnPlay;

    ENRefreshView refreshView;
    Button btnRefresh;

    ENScrollView scrollView;
    Button btnSwitch;

    ENSearchView searchView;
    Button btnStartSearch;

    ENVolumeView volumeView;
    SeekBar sbVolume;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delicateview);
        ButterKnife.bind(this);

        initDownload();

        initLoading();

        initPlay();

        initRefresh();

        initScroll();

        initSearch();

        initVolume();
    }

    private void initVolume() {
        volumeView = (ENVolumeView) findViewById(R.id.view_volume);
        sbVolume = (SeekBar) findViewById(R.id.sb_volume);

        sbVolume.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                volumeView.updateVolumeValue(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    private void initSearch() {
        searchView = (ENSearchView) findViewById(R.id.view_search);
        btnStartSearch = (Button) findViewById(R.id.btn_search);
        btnStartSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchView.start();
            }
        });
    }

    private void initScroll() {
        scrollView = (ENScrollView) findViewById(R.id.view_scroll);
        btnSwitch = (Button) findViewById(R.id.btn_switch);
        btnSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (scrollView.isSelected()) {
                    scrollView.unSelect();
                } else {
                    scrollView.select();
                }
            }
        });
    }

    private void initRefresh() {
        refreshView = (ENRefreshView) findViewById(R.id.view_refresh);
        btnRefresh = (Button) findViewById(R.id.btn_refresh);
        btnRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                refreshView.startRefresh();
            }
        });
    }

    private void initPlay() {
        playView = (ENPlayView) findViewById(R.id.view_play);
        btnPause = (Button) findViewById(R.id.btn_pause);
        btnPlay = (Button) findViewById(R.id.btn_play);
        btnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playView.pause();
            }
        });
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playView.play();
            }
        });
    }

    private void initLoading() {
        loadingView = (ENLoadingView) findViewById(R.id.view_loading);
        btnShow = (Button) findViewById(R.id.btn_show);
        btnHide = (Button) findViewById(R.id.btn_hide);
        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadingView.show();
            }
        });
        btnHide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadingView.hide();
            }
        });
    }

    private void initDownload() {
        downloadView = (ENDownloadView) findViewById(R.id.view_download);
        btnStart = (Button) findViewById(R.id.btn_start);
        btnReset = (Button) findViewById(R.id.btn_reset);

        downloadView.setDownloadConfig(2000, 20, ENDownloadView.DownloadUnit.MB);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                downloadView.start();
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                downloadView.reset();
            }
        });
    }
}
