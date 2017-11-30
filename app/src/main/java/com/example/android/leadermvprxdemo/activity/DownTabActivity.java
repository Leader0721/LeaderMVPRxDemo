package com.example.android.leadermvprxdemo.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.example.android.leadermvprxdemo.R;
import com.example.pub.common.BaseActivity;
import com.example.pub.view.drowdownmenu.DropDownMenu;
import com.example.pub.view.drowdownmenu.TabEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Android on 2017/11/22.
 */

public class DownTabActivity extends BaseActivity {
    @BindView(R.id.dropDownMenu)
    DropDownMenu mDropDownMenu;
    //tab类型
    private int[] types = new int[]{DropDownMenu.TYPE_LIST_CITY, DropDownMenu.TYPE_LIST_CITY};
    private ListView mListView;
    private List<TabEntity> mTabList;
    private List<TabEntity> mLeftList;
    private List<TabEntity> mRightList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawdownmenu_default);
        ButterKnife.bind(this);
        initData();
        initView();
    }

    private void initData() {
        mTabList = new ArrayList<>();
        mTabList.add(new TabEntity("银行类型", 0));
        mTabList.add(new TabEntity("全部状态", 1));
        mLeftList = new ArrayList<>();
        mLeftList.add(new TabEntity("银行类型", -1));
        for (int i = 0; i < 30; i++) {
            TabEntity entity = new TabEntity();
            entity.setName("第" + i + "个");
            entity.setTypeStr(i + "滴滴滴");
            mLeftList.add(entity);
        }

        mRightList = new ArrayList<>();
        mRightList.add(new TabEntity("全部状态", -1));
        mRightList.add(new TabEntity("待审核", 1));
        mRightList.add(new TabEntity("已通过", 2));
        mRightList.add(new TabEntity("已拒绝", 3));

    }

    private void initView() {
        View contentView = getLayoutInflater().inflate(R.layout.activity_downmenu, null);
        mListView = (ListView) contentView.findViewById(R.id.lv_content);
        mDropDownMenu.setDropDownMenu(mTabList, initViewData(), contentView);
        //该监听回调只监听默认类型，如果是自定义view请自行设置，参照demo
        mDropDownMenu.addMenuSelectListener(new DropDownMenu.OnDefultMenuSelectListener() {
            @Override
            public void onSelectDefaultMenu(int index, int pos, TabEntity clickstr) {
                //index:点击的tab索引，pos：单项菜单中点击的位置索引，clickstr：点击位置的字符串
                Toast.makeText(getBaseContext(), index + "---" + clickstr.getName() + "---" + clickstr.getType(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * 设置类型和数据源：
     * DropDownMenu.KEY对应类型（DropDownMenu中的常量，参考上述核心源码）
     * DropDownMenu.VALUE对应数据源：key不是TYPE_CUSTOM则传递string[],key是TYPE_CUSTOM类型则传递对应view
     */
    private List<HashMap<String, Object>> initViewData() {
        List<HashMap<String, Object>> viewDatas = new ArrayList<>();
        HashMap<String, Object> map;
        for (int i = 0; i < mTabList.size(); i++) {
            map = new HashMap<String, Object>();
            map.put(DropDownMenu.KEY, types[i]);
            switch (types[i]) {
                case DropDownMenu.TYPE_LIST_CITY:
                    if (i == 0) {
                        map.put(DropDownMenu.VALUE, mLeftList);
                        //默认选中项
                        map.put(DropDownMenu.SELECT_POSITION, 0);
                    } else {
                        map.put(DropDownMenu.VALUE, mRightList);
                        map.put(DropDownMenu.SELECT_POSITION, 0);
                    }
                    break;
                default:
                    //如果是自定义的就用这个
                    //map.put(DropDownMenu.VALUE, getCustomView());
                    break;
            }
            viewDatas.add(map);
        }
        return viewDatas;
    }
}
