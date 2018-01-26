package com.example.android.leadermvprxdemo.activity.androidExcelView;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.android.leadermvprxdemo.R;

/**
 * @Description:原生的仿Excel表格形式的自定义视图
 * @Prject:
 * @Package: com.example.android.leadermvprxdemo.activity.androidExcelView
 * @author: Leader
 * @date: 2018/1/26   9:14
 * @Copyright: 个人版权所有
 * @Company:bc
 * @version: 1.0.0
 */

public class ExcelViewActivity extends ListActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_excelview);

        B b[] = new B[]{
                new B("SimpleTable", SimpleTableActivity.class),
                new B("StyleTable", StyleTableActivity.class),
                new B("FamilyTable", FamilyTableActivity.class),
        };
        setListAdapter(new ArrayAdapter<B>(this, android.R.layout.simple_list_item_1, android.R.id.text1, b));
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        startActivity(new Intent(this, ((B) l.getItemAtPosition(position)).class1));
    }

    private class B {
        private final String string;
        private final Class<? extends Activity> class1;

        B(String string, Class<? extends Activity> class1) {
            this.string = string;
            this.class1 = class1;
        }

        @Override
        public String toString() {
            return string;
        }
    }

}
