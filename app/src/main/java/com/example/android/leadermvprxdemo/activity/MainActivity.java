package com.example.android.leadermvprxdemo.activity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.android.leadermvprxdemo.R;
import com.example.android.leadermvprxdemo.adapter.MainAdapter;
import com.example.pub.common.BaseActivity;
import com.example.pub.utils.view.ToastUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends BaseActivity implements AdapterView.OnItemClickListener {
    @BindView(R.id.lv_content)
    ListView lvContent;
    private MainAdapter mainAdapter;
    private List<String> listString = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        listString.add("吐司验证");
        listString.add("吐司验证");
        listString.add("吐司验证");
        listString.add("吐司验证");
        listString.add("吐司验证");
        listString.add("吐司验证");
        listString.add("吐司验证");
        listString.add("吐司验证");
        listString.add("吐司验证");
        listString.add("吐司验证");
        initView();
    }


    private void initView() {
        mainAdapter = new MainAdapter(this, listString);
        lvContent.setAdapter(mainAdapter);
        lvContent.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position) {
            case 0:
                ToastUtils.setMsgColor(getResources().getColor(R.color.red));
//                ToastUtils.setBgColor(getResources().getColor(R.color.black));
                ToastUtils.setBgResource(R.drawable.bg_corner_tran);
                ToastUtils.setGravity(Gravity.TOP, 0, 0);
                ToastUtils.showShort("任统帅");
                break;
            case 1:
                ToastUtils.showWithPic("这个是带有图片的", R.mipmap.music_player_btn, 3000, Gravity.BOTTOM, 0, 0, R.drawable.bg_btn_ok_nomal);
                break;
            case 2:
                ToastUtils.setMsgColor(getResources().getColor(R.color.red));
                ToastUtils.setBgColor(getResources().getColor(R.color.black));
                ToastUtils.setGravity(Gravity.CENTER, 0, 0);
                ToastUtils.showShort("任统帅");
                break;
            case 3:
                ToastUtils.setMsgColor(getResources().getColor(R.color.red));
                ToastUtils.setBgColor(getResources().getColor(R.color.black));
                ToastUtils.showShort("任统帅");
                break;
            case 4:
                ToastUtils.setMsgColor(getResources().getColor(R.color.red));
                ToastUtils.setBgColor(getResources().getColor(R.color.black));
                ToastUtils.showShort("任统帅");
                break;
            case 5:
                ToastUtils.setMsgColor(getResources().getColor(R.color.red));
                ToastUtils.setBgColor(getResources().getColor(R.color.black));
                ToastUtils.showShort("任统帅");
                break;
        }
    }
}
