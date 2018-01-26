package com.example.android.leadermvprxdemo.activity.swipMenuListView.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.android.leadermvprxdemo.R;
import com.example.android.leadermvprxdemo.activity.swipMenuListView.data.RecAdapter;

/**
 * @Description:博客详解文章http://blog.csdn.net/qian520ao/article/details/77587904
 * @Prject:
 * @Package: com.example.android.leadermvprxdemo.activity.swipMenuListView.ui
 * @author: Leader
 * @date: 2018/1/25   17:18
 * @Copyright: 个人版权所有
 * @Company:bc
 * @version: 1.0.0
 * <p>
 * 兼容超强的BaseRecyclerViewAdapterHelper
 */

public class SwipMenuListViewActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipmenu_recycler);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rec_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        RecAdapter adapter = new RecAdapter();
        recyclerView.setAdapter(adapter);
    }
}
