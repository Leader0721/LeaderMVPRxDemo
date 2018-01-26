package com.example.android.leadermvprxdemo.activity.addDeleteView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.android.leadermvprxdemo.R;
import com.example.pub.common.BaseActivity;

import butterknife.ButterKnife;

/**
 * @Description:购物车添加减去自定义view
 * @Prject:
 * @Package: com.example.android.leadermvprxdemo.activity.addDeleteView
 * @author: Leader
 * @date: 2018/1/26   11:34
 * @Copyright: 个人版权所有
 * @Company:bc
 * @version: 1.0.0
 */

public class AddDeleteViewActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adddeleteview);
        ButterKnife.bind(this);
        AddDeleteView addSubUtils = (AddDeleteView) findViewById(R.id.add_sub_0);
        addSubUtils.setBuyMax(30)
                .setInventory(50)
                .setCurrentNumber(5)
                .setStep(5)
                .setBuyMin(2)
                .setOnWarnListener(new AddDeleteView.OnWarnListener() {
                    @Override
                    public void onWarningForInventory(int inventory) {
                        Toast.makeText(AddDeleteViewActivity.this, "当前库存:" + inventory, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onWarningForBuyMax(int max) {
                        Toast.makeText(AddDeleteViewActivity.this, "超过最大购买数:" + max, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onWarningForBuyMin(int min) {
                        Toast.makeText(AddDeleteViewActivity.this, "低于最小购买数:" + min, Toast.LENGTH_SHORT).show();
                    }
                });

    }
}

