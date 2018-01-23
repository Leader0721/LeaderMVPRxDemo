package com.example.android.leadermvprxdemo.activity.lockView;

import android.os.Bundle;

import com.example.android.leadermvprxdemo.R;
import com.example.pub.common.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @Description:锁屏的视图
 * @Prject:
 * @Package: com.example.android.leadermvprxdemo.activity.lockView
 * @author: Leader
 * @date: 2018/1/23   9:36
 * @Copyright: 个人版权所有
 * @Company:bc
 * @version: 1.0.0
 * <p>
 * Features
 * <p>
 * 小于4个点 代表错误 会红色高亮提示 2秒后移除 也可以手动重输
 * 连接过得点不能再次连接
 * 途径中间的点会自动连接（横、竖、斜的方向）
 * Blog
 * <p>
 * http://blog.csdn.net/u011507982/article/details/53221018
 */

public class LockViewActivity extends BaseActivity {
    @BindView(R.id.lockPatternView)
    LockPatternView lockPatternView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lockview);
        ButterKnife.bind(this);
    }
}
