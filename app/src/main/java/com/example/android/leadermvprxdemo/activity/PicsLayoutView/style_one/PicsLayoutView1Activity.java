package com.example.android.leadermvprxdemo.activity.PicsLayoutView.style_one;

import android.os.Bundle;
import android.view.LayoutInflater;

import com.bumptech.glide.Glide;
import com.example.android.leadermvprxdemo.R;
import com.example.pub.common.BaseActivity;

/**
 * @Description:一种堆叠头像的点赞效果
 * @Prject:
 * @Package: com.example.android.leadermvprxdemo.activity.PicsLayoutView
 * @author: Leader
 * @date: 2018/1/25   18:59
 * @Copyright: 个人版权所有
 * @Company:bc
 * @version: 1.0.0
 */

public class PicsLayoutView1Activity extends BaseActivity {
    PileLayout pileLayout1;
    PileLayout pileLayout2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picslayoutview1);
        pileLayout1 = (PileLayout) findViewById(R.id.pile_layout1);
        pileLayout2 = (PileLayout) findViewById(R.id.pile_layout2);

        initPraises();
    }

    String[] urls = {
            "http://img2.imgtn.bdimg.com/it/u=1939271907,257307689&fm=21&gp=0.jpg",
            "http://img0.imgtn.bdimg.com/it/u=2263418180,3668836868&fm=206&gp=0.jpg",
            "http://img0.imgtn.bdimg.com/it/u=2263418180,3668836868&fm=206&gp=0.jpg",
            "http://img2.imgtn.bdimg.com/it/u=1939271907,257307689&fm=21&gp=0.jpg",
            "http://img0.imgtn.bdimg.com/it/u=2263418180,3668836868&fm=206&gp=0.jpg",
            "http://img0.imgtn.bdimg.com/it/u=2263418180,3668836868&fm=206&gp=0.jpg"
    };

    public void initPraises() {
        LayoutInflater inflater = LayoutInflater.from(this);
        for (int i = 0; i < urls.length; i++) {
            CircleImageView imageView = (CircleImageView) inflater.inflate(R.layout.item_circle_imageview, pileLayout1, false);
            Glide.with(this).load(urls[i]).into(imageView);
            pileLayout1.addView(imageView);
            RoundImageView roundImageView = (RoundImageView) inflater.inflate(R.layout.item_round_imageview, pileLayout2, false);
            Glide.with(this).load(urls[i]).into(roundImageView);
            pileLayout2.addView(roundImageView);
        }
    }
}
