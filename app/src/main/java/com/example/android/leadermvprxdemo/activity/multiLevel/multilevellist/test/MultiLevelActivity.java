package com.example.android.leadermvprxdemo.activity.multiLevel.multilevellist.test;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.android.leadermvprxdemo.R;
import com.example.android.leadermvprxdemo.activity.multiLevel.multilevellist.lib.adapter.MultiLevelAdapter;
import com.example.android.leadermvprxdemo.activity.multiLevel.multilevellist.lib.model.MultiLevelModel;
import com.example.android.leadermvprxdemo.activity.multiLevel.multilevellist.test.adapter.MultiLevelTestAdapter;
import com.example.android.leadermvprxdemo.activity.multiLevel.multilevellist.test.model.ClassA;
import com.example.android.leadermvprxdemo.activity.multiLevel.multilevellist.test.model.ClassB;
import com.example.android.leadermvprxdemo.activity.multiLevel.multilevellist.test.model.ClassC;
import com.example.android.leadermvprxdemo.activity.multiLevel.multilevellist.test.model.ClassD;
import com.example.pub.common.BaseActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:多层级列表展示
 * @Prject:
 * @Package: com.example.android.leadermvprxdemo.activity.multiLevel.multilevellist.test
 * @author: Leader
 * @date: 2018/1/11   9:41
 * @Copyright: 个人版权所有
 * @Company:bc
 * @version: 1.0.0
 */

public class MultiLevelActivity extends BaseActivity {
    ListView listView;
    List<ClassA> list = new ArrayList<>();
    MultiLevelTestAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multilevel);
        listView = (ListView) findViewById(R.id.listView);
        int count = 0;
        for (int i = 0; i < 3; i++) {
            ClassA classA = new ClassA(i, " A" + i);
            classA.setChildren(new ArrayList());
            list.add(classA);
            count += 1;
            Log.e("TAG 1", classA.getName());
            for (int j = 0; j < 3; j++) {
                ClassB classB = new ClassB(j, " A" + i + " B" + j);
                classA.getChildren().add(classB);
                count += 1;
                Log.e("TAG 2", classB.getLabel());
                for (int k = 0; k < 3; k++) {
                    ClassC classC = new ClassC(" A" + i + " B" + j + " C" + k);
                    classB.getChildren().add(classC);
                    count += 1;
                    Log.e("TAG 3", classC.getName());
                    for (int l = 0; l < 3; l++) {
                        ClassD classD = new ClassD(" A" + i + " B" + j + " C" + k + " D" + l
                                , "D");
                        classC.getChildren().add(classD);
                        count += 1;
                        Log.e("TAG 4", classD.getName());
                    }
                }
            }
        }
        Log.e("count", "= " + count);
        adapter = new MultiLevelTestAdapter(this, true, false
                , 1);
        adapter.setOnMultiLevelListener(new MultiLevelAdapter.OnMultiLevelListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id
                    , MultiLevelModel current, MultiLevelModel max) {
                Toast.makeText(MultiLevelActivity.this, "position = " + position + "" +
                                " , current level = " + current.getLevel() + " , outside level = "
                                + max.getLevel()
                        , Toast.LENGTH_SHORT).show();
            }
        });
        adapter.setList(list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(adapter);
    }

}
