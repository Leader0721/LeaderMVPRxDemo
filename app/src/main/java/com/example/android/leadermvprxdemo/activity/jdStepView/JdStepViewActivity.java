package com.example.android.leadermvprxdemo.activity.jdStepView;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.android.leadermvprxdemo.R;
import com.example.android.leadermvprxdemo.activity.jdStepView.fragment.DrawCanvasFragment;
import com.example.android.leadermvprxdemo.activity.jdStepView.fragment.HorizontalStepviewFragment;
import com.example.android.leadermvprxdemo.activity.jdStepView.fragment.VerticalStepViewFrowardFragment;
import com.example.android.leadermvprxdemo.activity.jdStepView.fragment.VerticalStepViewReverseFragment;
import com.example.android.leadermvprxdemo.activity.jdStepView.fragment.VerticalStepViewSnapshotFragment;
import com.example.pub.common.BaseActivity;


/**
 * @Description:仿京东物流配送流程图
 * @Prject:
 * @Package: com.example.android.leadermvprxdemo.activity.jdStepView
 * @author: Leader
 * @date: 2018/1/24   9:38
 * @Copyright: 个人版权所有
 * @Company:bc
 * @version: 1.0.0
 */
public class JdStepViewActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jdstepview);

        VerticalStepViewReverseFragment mVerticalStepViewFragment = new VerticalStepViewReverseFragment();
        getFragmentManager().beginTransaction().replace(R.id.container, mVerticalStepViewFragment).commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_stepview, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        VerticalStepViewReverseFragment mVerticalStepViewFragment;
        DrawCanvasFragment mDrawCanvasFragment;
        HorizontalStepviewFragment mHorizontalStepviewFragment;
        VerticalStepViewSnapshotFragment mVerticalStepViewSnapshotFragment;
        VerticalStepViewFrowardFragment mVerticalStepViewReverseFragment;
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        int itemId = item.getItemId();
        switch (itemId) {
            case R.id.action_horizontal_stepview:
                mHorizontalStepviewFragment = new HorizontalStepviewFragment();
                fragmentTransaction.replace(R.id.container, mHorizontalStepviewFragment).commit();
                break;
            case R.id.action_drawcanvas:
                mDrawCanvasFragment = new DrawCanvasFragment();
                fragmentTransaction.replace(R.id.container, mDrawCanvasFragment).commit();
                break;
            case R.id.action_vertical_reverse:
                mVerticalStepViewFragment = new VerticalStepViewReverseFragment();
                fragmentTransaction.replace(R.id.container, mVerticalStepViewFragment).commit();
                break;
            case R.id.action_vertical_forward:
                mVerticalStepViewReverseFragment = new VerticalStepViewFrowardFragment();
                fragmentTransaction.replace(R.id.container, mVerticalStepViewReverseFragment).commit();
                break;
            case R.id.action_vertical_stepview_snapshot:
                mVerticalStepViewSnapshotFragment = new VerticalStepViewSnapshotFragment();
                fragmentTransaction.replace(R.id.container, mVerticalStepViewSnapshotFragment).commit();
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}