package com.example.android.leadermvprxdemo.activity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.android.leadermvprxdemo.R;
import com.example.android.leadermvprxdemo.adapter.MainAdapter;
import com.example.pub.common.BaseActivity;
import com.example.pub.utils.app.Utils;
import com.example.pub.utils.view.ScreenUtils;
import com.example.pub.utils.view.SecurityCodeUtils;
import com.example.pub.utils.view.SnackbarUtils;
import com.example.pub.utils.view.ToastUtils;
import com.example.pub.utils.view.ViewAnimationUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends BaseActivity implements AdapterView.OnItemClickListener {
    @BindView(R.id.lv_content)
    ListView lvContent;
    @BindView(R.id.iv_content)
    ImageView ivContent;
    private MainAdapter mainAdapter;
    private List<String> listString = new ArrayList<>();
    private int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        listString.add((index++) + "属性最多的带有图片的吐司验证");
        listString.add((index++) + "带有图片的长吐司验证");
        listString.add((index++) + "带有图片的短吐司验证");
        listString.add((index++) + "SnackBar");
        listString.add((index++) + "验证码图片验证");
        listString.add((index++) + "视图动画验证");
        listString.add((index++) + "视图动画验证");
        listString.add((index++) + "视图动画验证");
        listString.add((index++) + "视图动画验证");
        listString.add((index++) + "设置透明状态栏");
        listString.add((index++) + "设置透明状态栏");
        listString.add((index++) + "设置透明状态栏");
        listString.add((index++) + "设置透明状态栏");
        initView();
    }


    private void initView() {
        mainAdapter = new MainAdapter(this, listString);
        lvContent.setAdapter(mainAdapter);
        lvContent.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position) {
            case 0:
                ToastUtils.showWithPic("这个是带有图片的", R.mipmap.ic_launcher, R.color.white, 3000, Gravity.BOTTOM, 0, 0, R.drawable.bg_btn_ok_nomal);
                break;
            case 1:
                ToastUtils.showWithPicLong("长吐司验证，带有图片的", R.mipmap.ic_launcher);
                break;
            case 2:
                ToastUtils.showWithPicShort("短吐司验证，带有图片的", R.mipmap.ic_launcher);
                break;
            case 3:
                SnackbarUtils.showLong(view, "dddddddddd", Utils.getApp().getColor(R.color.red), Utils.getApp().getColor(R.color.black));
                break;
            case 4:
                Bitmap bitmap = SecurityCodeUtils.getInstance().createBitmap();
                ivContent.setImageBitmap(bitmap);
                ToastUtils.showShort(SecurityCodeUtils.getInstance().getCode());
                break;
            case 5:
                ViewAnimationUtils.shake(ivContent);
                break;
            case 6://在执行动画的过程中是否禁止点击
                ViewAnimationUtils.shake(ivContent, false);
                break;
            case 7:
                ViewAnimationUtils.goneViewByAlpha(ivContent);
                break;
            case 8:
                ViewAnimationUtils.visibleViewByAlpha(ivContent);
                break;
            case 9:
                ScreenUtils.setTransparentStatusBar(this);
                break;
            case 10:
                ScreenUtils.setStatusBarColor(this, R.color.red);
                break;
            case 11:
                ScreenUtils.setTransparentStatusBar(this);
                break;
            case 12:
                ScreenUtils.setTransparentStatusBar(this);
                break;
        }
    }
}
