package com.example.android.leadermvprxdemo.activity.toggleButton;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.android.leadermvprxdemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ToggleButtonActivity extends AppCompatActivity {

    @BindView(R.id.switch_button)
    SwitchButton mSwitchButton;
    @BindView(R.id.tv)
    TextView mTv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_togglebutton);
        ButterKnife.bind(this);
        mSwitchButton.setOnCheckedChangeListener(new SwitchButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(SwitchButton buttonView, boolean isChecked) {
                mTv.setText(isChecked ? "开" : "关");
            }
        });
    }
}
