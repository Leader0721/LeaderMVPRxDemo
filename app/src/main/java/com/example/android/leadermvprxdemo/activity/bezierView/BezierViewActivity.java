package com.example.android.leadermvprxdemo.activity.bezierView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.android.leadermvprxdemo.R;
import com.example.android.leadermvprxdemo.activity.bezierView.shoppingcart.ShoppingCartActivity;
import com.example.android.leadermvprxdemo.activity.bezierView.starview.StarViewActivity;
import com.example.pub.common.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Android on 2018/1/22.
 */

public class BezierViewActivity extends BaseActivity {
    //    https://www.jianshu.com/p/d43f19b384d8
    //    https://www.jianshu.com/p/f0d47b6c1e94
    @BindView(R.id.bt_main_wave)
    Button btMainWave;
    @BindView(R.id.bt_main_shop)
    Button btMainShop;
    @BindView(R.id.bt_main_test)
    Button btMainTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bezierview);
        ButterKnife.bind(this);
    }

    //    findViewById(R.id.bt_main_wave).setOnClickListener(new View.OnClickListener() {
//        @Override
//        public void onClick(View v) {
//            startActivity(new Intent(MainActivity.this, TestActivity.class));
//        }
//    });
//
//    findViewById(R.id.bt_main_shop).setOnClickListener(new View.OnClickListener() {
//        @Override
//        public void onClick(View v) {
//            startActivity(new Intent(MainActivity.this, ShoppingCartActivity.class));
//        }
//    });
//
//    findViewById(R.id.bt_main_test).setOnClickListener(new View.OnClickListener() {
//        @Override
//        public void onClick(View v) {
//            startActivity(new Intent(MainActivity.this, StarViewActivity.class));
//        }
//    });
    @OnClick({R.id.bt_main_wave, R.id.bt_main_shop, R.id.bt_main_test})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_main_wave:
                openActivity(StarViewActivity.class, null);
                break;
            case R.id.bt_main_shop:
                openActivity(ShoppingCartActivity.class, null);
                break;
            case R.id.bt_main_test:
                openActivity(TestActivity.class, null);
                break;
        }
    }
}
