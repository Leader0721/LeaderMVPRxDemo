package com.example.android.leadermvprxdemo.activity.numberAnimView;

import android.os.Bundle;
import android.view.View;

import com.example.android.leadermvprxdemo.R;
import com.example.pub.common.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @Description:数字变化跳动动画
 * @Prject:
 * @Package: com.example.android.leadermvprxdemo.activity.numberAnimView
 * @author: Leader
 * @date: 2018/1/25   14:53
 * @Copyright: 个人版权所有
 * @Company:bc
 * @version: 1.0.0
 * <p>
 * 添加前缀、后缀
 * 支持任意大小的整数或小数
 * 千位分隔符
 * API 简单
 */

public class NumberAnimTextViewActivity extends BaseActivity {


    @BindView(R.id.tv_one)
    NumberAnimTextView tvOne;
    @BindView(R.id.tv_two)
    NumberAnimTextView tvTwo;
    @BindView(R.id.tv_three)
    NumberAnimTextView tvThree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number_anim);
        ButterKnife.bind(this);
    }

    public void start(View view) {
        tvOne.setPrefixString("¥");
        tvOne.setNumberString("99998.123456789");
// 设置前缀
//        tvOne.setPrefixString("¥");
// 设置后缀
//        tvOne.setPostfixString("%");
// 设置动画时长
//        tvOne.setDuration(2000);
// 设置数字增加范围
//        tvOne.setNumberString("19.75", "99.75");
// 禁用动画
//        tvOne.setEnableAnim(false);
//        tvTwo.setEnableAnim(true);
        tvTwo.setNumberString("1234567");

        tvThree.setPostfixString("%");
        tvThree.setNumberString("99.75");

    }
}
