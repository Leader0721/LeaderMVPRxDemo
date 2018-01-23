package com.example.android.leadermvprxdemo.activity.leiDa;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.Slide;

import com.example.android.leadermvprxdemo.R;
import com.example.android.leadermvprxdemo.activity.leiDa.adapter.CustomAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 文 件 名: LeiDaActivity
 * 创 建 人: 易冬
 * 创建日期: 2017/10/10 16:48
 * 邮   箱: onlyloveyd@gmail.com
 * 博   客: https://onlyloveyd.cn
 * 描   述：
 *
 * @author Mraz
 */
@SuppressWarnings("ALL")
public class LeiDaActivity extends AppCompatActivity {

    @BindView(R.id.rv_content)
    RecyclerView mRvContent;

    private CustomAdapter mCustomAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);
        ButterKnife.bind(this);

        Slide slide = new Slide();
        slide.setDuration(200);
        getWindow().setExitTransition(slide);

        mCustomAdapter = new CustomAdapter(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);

        mRvContent.setAdapter(mCustomAdapter);
        mRvContent.setLayoutManager(linearLayoutManager);
        mRvContent.addItemDecoration(
                new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

    }
}
