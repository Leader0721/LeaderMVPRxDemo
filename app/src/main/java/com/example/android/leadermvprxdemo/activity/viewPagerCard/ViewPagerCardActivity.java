package com.example.android.leadermvprxdemo.activity.viewPagerCard;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.example.android.leadermvprxdemo.R;
import com.example.pub.common.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @Description:一个卡片滑动的效果
 * @Prject:
 * @Package: com.example.android.leadermvprxdemo.activity.viewPagerCard
 * @author: Leader
 * @date: 2018/2/1   9:04
 * @Copyright: 个人版权所有
 * @Company:bc
 * @version: 1.0.0
 */

public class ViewPagerCardActivity extends BaseActivity implements View.OnClickListener,
        CompoundButton.OnCheckedChangeListener {


    @BindView(R.id.cardTypeBtn)
    Button cardTypeBtn;
    @BindView(R.id.checkBox)
    CheckBox checkBox;
    @BindView(R.id.vp_viewPager)
    ViewPager viewPager;
    private CardPagerAdapter mCardAdapter;
    private ShadowTransformer mCardShadowTransformer;
    private CardFragmentPagerAdapter mFragmentCardAdapter;
    private ShadowTransformer mFragmentCardShadowTransformer;

    private boolean mShowingFragments = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpagercard);
        ButterKnife.bind(this);
        cardTypeBtn.setOnClickListener(this);
        checkBox.setOnCheckedChangeListener(this);
        mCardAdapter = new CardPagerAdapter();
        mCardAdapter.addCardItem(new CardItem(R.string.title_1, R.string.text_1));
        mCardAdapter.addCardItem(new CardItem(R.string.title_2, R.string.text_1));
        mCardAdapter.addCardItem(new CardItem(R.string.title_3, R.string.text_1));
        mCardAdapter.addCardItem(new CardItem(R.string.title_4, R.string.text_1));
        mFragmentCardAdapter = new CardFragmentPagerAdapter(getSupportFragmentManager(),
                dpToPixels(2, this));

        mCardShadowTransformer = new ShadowTransformer(viewPager, mCardAdapter);
        mFragmentCardShadowTransformer = new ShadowTransformer(viewPager, mFragmentCardAdapter);

        viewPager.setAdapter(mCardAdapter);
        viewPager.setPageTransformer(false, mCardShadowTransformer);
        viewPager.setOffscreenPageLimit(3);
    }

    @Override
    public void onClick(View view) {
        if (!mShowingFragments) {
            cardTypeBtn.setText("Views");
            viewPager.setAdapter(mFragmentCardAdapter);
            viewPager.setPageTransformer(false, mFragmentCardShadowTransformer);
        } else {
            cardTypeBtn.setText("Fragments");
            viewPager.setAdapter(mCardAdapter);
            viewPager.setPageTransformer(false, mCardShadowTransformer);
        }

        mShowingFragments = !mShowingFragments;
    }

    public static float dpToPixels(int dp, Context context) {
        return dp * (context.getResources().getDisplayMetrics().density);
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        mCardShadowTransformer.enableScaling(b);
        mFragmentCardShadowTransformer.enableScaling(b);
    }
}
