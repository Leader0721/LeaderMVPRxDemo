package com.example.android.leadermvprxdemo.activity.horizontalExpandMenu;

import android.os.Bundle;

import com.example.android.leadermvprxdemo.R;
import com.example.pub.common.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @Description:教程博客：Android自定义View——从零开始实现可展开收起的水平菜单栏 https://www.jianshu.com/p/045da19ca6ea 简介：继承ViewGroup（RelativeLayout）实现可展开收起的水平菜单栏控件
 * @Prject:
 * @Package: com.example.android.leadermvprxdemo.activity.horizontalExpandMenu
 * @author: Leader
 * @date: 2018/1/24   11:57
 * @Copyright: 个人版权所有
 * @Company:bc
 * @version: 1.0.0
 */

public class HorizontalExpandMenuActivity extends BaseActivity {
    @BindView(R.id.hemv_one)
    HorizontalExpandMenuView hemvOne;
    @BindView(R.id.hemv_two)
    HorizontalExpandMenuView hemvTwo;
    @BindView(R.id.hemv_three)
    HorizontalExpandMenuView hemvThree;
    @BindView(R.id.hemv_four)
    HorizontalExpandMenuView hemvFour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horizontal_expand_menu);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
    }
}
