package com.example.android.leadermvprxdemo.activity.PicsLayoutView.style_two;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.android.leadermvprxdemo.R;
import com.example.pub.common.BaseActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Android on 2018/1/25.
 */

public class PicsLayoutView2Activity extends BaseActivity {
    //点赞
    Button zanLayout, zanLayoutOne;
    //取消点赞
    Button cancelLayout, cancelLayoutOne;
    //流布局
    FlowLayout flowLayout, flowLayoutOne;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picslayoutview2);

        zanLayout = (Button) findViewById(R.id.zan_layout);
        cancelLayout = (Button) findViewById(R.id.cancel_layout);
        flowLayout = (FlowLayout) findViewById(R.id.flow_layout);

        zanLayoutOne = (Button) findViewById(R.id.zan_layout_one);
        cancelLayoutOne = (Button) findViewById(R.id.cancel_layout_one);
        flowLayoutOne = (FlowLayout) findViewById(R.id.flow_layout_one);

        initData();

        flowLayout.setUrls(approveList);

        flowLayoutOne.setUrls(approveList);

        cancelLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flowLayout.cancels("http://img2.imgtn.bdimg.com/it/u=1939271907,257307689&fm=21&gp=0.jpg");
            }
        });


        zanLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flowLayout.setOneUrls("http://img2.imgtn.bdimg.com/it/u=1939271907,257307689&fm=21&gp=0.jpg");
            }
        });


        zanLayoutOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //设置左边添加
                flowLayoutOne.setFlag(true);
                flowLayoutOne.setOneUrls("http://img2.imgtn.bdimg.com/it/u=1939271907,257307689&fm=21&gp=0.jpg");
            }
        });

        cancelLayoutOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flowLayoutOne.cancels("http://img2.imgtn.bdimg.com/it/u=1939271907,257307689&fm=21&gp=0.jpg");
            }
        });

    }

    private List<String> approveList;

    private void initData() {
        approveList = new ArrayList<>();
        approveList.add("http://img2.imgtn.bdimg.com/it/u=1939271907,257307689&fm=21&gp=0.jpg");
        approveList.add("http://img0.imgtn.bdimg.com/it/u=2263418180,3668836868&fm=206&gp=0.jpg");
        approveList.add("http://img0.imgtn.bdimg.com/it/u=2263418180,3668836868&fm=206&gp=0.jpg");
        approveList.add("http://img0.imgtn.bdimg.com/it/u=2263418180,3668836868&fm=206&gp=0.jpg");
        approveList.add("http://img2.imgtn.bdimg.com/it/u=1939271907,257307689&fm=21&gp=0.jpg");
        approveList.add("http://img0.imgtn.bdimg.com/it/u=2263418180,3668836868&fm=206&gp=0.jpg");
    }


}
