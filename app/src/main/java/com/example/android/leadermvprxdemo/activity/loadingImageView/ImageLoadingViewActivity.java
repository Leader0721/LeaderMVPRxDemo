package com.example.android.leadermvprxdemo.activity.loadingImageView;

import android.os.Bundle;
import android.view.View;

import com.example.android.leadermvprxdemo.R;
import com.example.android.leadermvprxdemo.activity.SmsEditText.CodeEditText;
import com.example.pub.common.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ImageLoadingViewActivity extends BaseActivity {
    @BindView(R.id.ilv_content)
    ImageLoadingView mContentImageLoadingView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loadingimageview);
        ButterKnife.bind(this);
        mContentImageLoadingView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mContentImageLoadingView.isLoading()) {
                    mContentImageLoadingView.setSelected(true);
                    mContentImageLoadingView.release();
                } else {
                    mContentImageLoadingView.setSelected(false);
                    mContentImageLoadingView.anim();
                    mContentImageLoadingView.loading();
                }
            }
        });
    }
}
