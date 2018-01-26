package com.example.android.leadermvprxdemo.activity.androidExcelPanelView;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.android.leadermvprxdemo.R;

import java.util.Arrays;
import java.util.List;
/**
 * @Description:
 * @Prject:
 * @Package: com.example.android.leadermvprxdemo.activity.androidExcelPanelView
 * @author: Leader
 * @date: 2018/1/26   10:26
 * @Copyright: 个人版权所有
 * @Company:bc
 * @version: 1.0.0
 *
 * https://github.com/zhouchaoyuan/excelPanel
 */
public class ExcelPanelActivity extends AppCompatActivity {

    private ViewPager pager;
    private TabLayout tabLayout;
    private List<ExcelFragment> list = Arrays.asList(new ExcelFragment(), new ExcelFragment(),
            new ExcelFragment(), new ExcelFragment(), new ExcelFragment());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_excelpanel);
        pager = (ViewPager) findViewById(R.id.pager);
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        pager.setAdapter(new ExcelPagerAdapter(getSupportFragmentManager()));
        tabLayout.setupWithViewPager(pager);
        tabLayout.setTabTextColors(Color.WHITE, Color.WHITE);
    }

    class ExcelPagerAdapter extends FragmentStatePagerAdapter {

        public ExcelPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return list.get(position);
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return "Item:" + position;
        }
    }
}
