package com.example.android.leadermvprxdemo.activity.shineTextView;

import android.animation.Animator;
import android.os.Bundle;
import android.view.View;

import com.example.android.leadermvprxdemo.R;
import com.example.android.leadermvprxdemo.activity.shineTextView.lib.Shimmer;
import com.example.android.leadermvprxdemo.activity.shineTextView.lib.ShimmerTextView;
import com.example.pub.common.BaseActivity;

/**
 * @Description:闪光的字体
 * @Prject:
 * @Package: com.example.android.leadermvprxdemo.activity.shineTextView
 * @author: Leader
 * @date: 2018/1/22   14:58
 * @Copyright: 个人版权所有
 * @Company:bc
 * @version: 1.0.0
 */

public class ShimmerActivity extends BaseActivity {
    //可以通过gradle调用compile 'com.romainpiel.shimmer:library:1.4.0@aar'
    ShimmerTextView tv;
    Shimmer shimmer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shimmer);

        tv = (ShimmerTextView) findViewById(R.id.shimmer_tv);
    }

    public void toggleAnimation(View target) {
        if (shimmer != null && shimmer.isAnimating()) {
            shimmer.cancel();
        } else {
            shimmer = new Shimmer();
            shimmer.setRepeatCount(5)
                    .setDuration(5000)
                    .setStartDelay(300)
                    .setDirection(Shimmer.ANIMATION_DIRECTION_RTL)
                    .setAnimatorListener(new Animator.AnimatorListener() {
                        @Override
                        public void onAnimationStart(Animator animation) {

                        }

                        @Override
                        public void onAnimationEnd(Animator animation) {

                        }

                        @Override
                        public void onAnimationCancel(Animator animation) {

                        }

                        @Override
                        public void onAnimationRepeat(Animator animation) {

                        }
                    });

            shimmer.start(tv);
        }
    }
}
