package com.example.android.leadermvprxdemo.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.android.leadermvprxdemo.R;
import com.example.pub.common.BaseActivity;
import com.example.pub.utils.view.ToastUtils;
import com.example.pub.view.stepview.StepView;
import com.example.pub.view.stepview.bean.StepBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @Description:步骤
 * @Prject:
 * @Package: com.example.android.leadermvprxdemo.activity
 * @author: Leader
 * @date: 2017/11/23   17:37
 * @Copyright: 个人版权所有
 * @Company:bc
 * @version: 1.0.0
 */

public class StepViewActivity extends BaseActivity {
    @BindView(R.id.sv_stepview)
    StepView mStepView;
    private List<StepBean> stepsBeanList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stepview);
        ButterKnife.bind(this);
        initData();
        initView();
    }

    private void initData() {
        stepsBeanList = new ArrayList<>();
        stepsBeanList.add(new StepBean("借款人", 1));
        stepsBeanList.add(new StepBean("第一担保人", 1));
        stepsBeanList.add(new StepBean("第二担保人", 0));
        stepsBeanList.add(new StepBean("申请书", 0));
        stepsBeanList.add(new StepBean("上传附件", 0));
        mStepView.setmList(stepsBeanList);
    }


    private void initView() {
        mStepView.setItemClickListener(new StepView.OnStepViewItemClickListener() {
            @Override
            public void itemClickListener(int position) {
                ToastUtils.showShort("dfasdfasdf");
            }
        });
    }

}
