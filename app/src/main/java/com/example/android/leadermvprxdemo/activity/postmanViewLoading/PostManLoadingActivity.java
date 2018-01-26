package com.example.android.leadermvprxdemo.activity.postmanViewLoading;

import android.os.Bundle;

import com.example.android.leadermvprxdemo.R;
import com.example.pub.common.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @Description:postman的一个加载动画
 * @Prject:
 * @Package: com.example.android.leadermvprxdemo.activity.postmanViewLoading
 * @author: Leader
 * @date: 2018/1/25   11:33
 * @Copyright: 个人版权所有
 * @Company:bc
 * @version: 1.0.0
 * <p>
 * https://www.jianshu.com/p/c1e17e52e113
 */

public class PostManLoadingActivity extends BaseActivity {
    @BindView(R.id.pml_view)
    PostManLoadingView pmlView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postman);
        ButterKnife.bind(this);
        pmlView.start();
    }

}
