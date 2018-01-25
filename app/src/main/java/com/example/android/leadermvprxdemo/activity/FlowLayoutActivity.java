package com.example.android.leadermvprxdemo.activity;

import android.os.Bundle;

import com.example.android.leadermvprxdemo.R;
import com.example.pub.common.BaseActivity;
import com.example.pub.utils.view.ToastUtils;
import com.example.pub.view.flowlayout.FlowAdapter;
import com.example.pub.view.flowlayout.FlowLayout;
import com.example.pub.view.flowlayout.OnTagSelectListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @Description:流式布局
 * @Prject:
 * @Package: com.example.android.leadermvprxdemo.activity
 * @author: Leader
 * @date: 2017/11/22   19:50
 * @Copyright: 个人版权所有
 * @Company:bc
 * @version: 1.0.0
 */

public class FlowLayoutActivity extends BaseActivity {
    @BindView(R.id.fl_content)
    FlowLayout flContent;
    private FlowAdapter flowAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flowlayout);
        ButterKnife.bind(this);

        initData();
    }

    private void initData() {
        // 选项集合
        List<String> optionList = new ArrayList<>();
        optionList.add("白茫茫白茫茫白茫茫");
        optionList.add("雾白茫茫");
        optionList.add("铁路");
        optionList.add("公路白茫茫");
        optionList.add("大雪");
        optionList.add("白茫茫");
        optionList.add("雾");
        optionList.add("铁白茫茫");
        optionList.add("公路");
        optionList.add("大雪");
        optionList.add("白茫茫");
        optionList.add("雾蒙蒙");
        optionList.add("铁路");
        optionList.add("公路白茫茫");
        optionList.add("大雪");
        optionList.add("白茫茫");
        optionList.add("雾白茫茫");
        optionList.add("铁路白茫茫");
        optionList.add("公路");
        optionList.add("大雪白茫茫");
        optionList.add("白茫茫");
        optionList.add("雾蒙蒙");
        optionList.add("铁路");
        optionList.add("公路");
        optionList.add("大雪");
        flowAdapter = new FlowAdapter<>(this, R.layout.item_grid_flowlayout, R.id.tv_flowlayout);
        flContent.setTagCheckedMode(FlowLayout.FLOW_TAG_CHECKED_MULTI);
        flContent.setAdapter(flowAdapter);
        flContent.setOnTagSelectListener(new OnTagSelectListener() {
            @Override
            public void onItemSelect(FlowLayout parent, List<Integer> selectedList) {
                ToastUtils.showShort("dasdfasdfasdfas");
            }
        });
        flowAdapter.onlyAddAll(optionList);

    }
}
