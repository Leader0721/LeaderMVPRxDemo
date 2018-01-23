package com.example.android.leadermvprxdemo.activity.leiDa.activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.transition.Slide;

import com.example.android.leadermvprxdemo.R;
import com.example.android.leadermvprxdemo.activity.leiDa.adapter.CustomViewPagerAdapter;
import com.example.android.leadermvprxdemo.activity.leiDa.view.CustomDotIndicator;
import com.example.android.leadermvprxdemo.activity.leiDa.view.CustomRectangleIndicator;
import com.example.android.leadermvprxdemo.activity.leiDa.view.CustomTriangleIndicator;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 文 件 名: IndicatorActivity
 * 创 建 人: 易冬
 * 创建日期: 2017/10/10 16:48
 * 邮   箱: onlyloveyd@gmail.com
 * 博   客: https://onlyloveyd.cn
 * 描   述：
 *
 * @author Mraz
 */
@SuppressWarnings("ALL")
public class IndicatorActivity extends AppCompatActivity {

    @BindView(R.id.customDotIndicator)
    CustomDotIndicator mCustomDotIndicator;
    @BindView(R.id.vp)
    ViewPager mVp;
    @BindView(R.id.customRectIndicator)
    CustomRectangleIndicator mCustomRectIndicator;
    @BindView(R.id.customTriangleIndicator)
    CustomTriangleIndicator mCustomTriangleIndicator;

    private final List<String> mTitles = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dot_indicator);
        ButterKnife.bind(this);

        Slide slide = new Slide();
        slide.setDuration(200);
        getWindow().setEnterTransition(slide);


        mTitles.add("体育");
        mTitles.add("军事");
        mTitles.add("娱乐");
        mTitles.add("娱乐");
        mTitles.add("娱乐");
        mTitles.add("娱乐");
        mTitles.add("娱乐");
        mTitles.add("娱乐");
        mTitles.add("娱乐");
        mTitles.add("人文");

        CustomViewPagerAdapter customViewPagerAdapter = new CustomViewPagerAdapter(
                getSupportFragmentManager(), mTitles);
        mVp.setAdapter(customViewPagerAdapter);
        mCustomDotIndicator.setViewPager(mVp);
        mCustomRectIndicator.setViewPager(mVp);
        mCustomTriangleIndicator.setViewPager(mVp);
    }
}
