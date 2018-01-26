package com.example.android.leadermvprxdemo.activity.androidExcelView;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;

import com.example.android.leadermvprxdemo.R;
import com.example.android.leadermvprxdemo.activity.androidExcelView.adapters.SampleTableAdapter;
import com.example.android.leadermvprxdemo.activity.androidExcelView.lib.TableFixHeaders;

public class StyleTableActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_excel);

		TableFixHeaders tableFixHeaders = (TableFixHeaders) findViewById(R.id.table);
		tableFixHeaders.setAdapter(new MyAdapter(this));
	}

	public class MyAdapter extends SampleTableAdapter {

		private final int width;
		private final int height;

		public MyAdapter(Context context) {
			super(context);

			Resources resources = context.getResources();

			width = resources.getDimensionPixelSize(R.dimen.v100);
			height = resources.getDimensionPixelSize(R.dimen.v40);
		}

		@Override
		public int getRowCount() {
			return 10;
		}

		@Override
		public int getColumnCount() {
			return 6;
		}

		@Override
		public int getWidth(int column) {
			return width;
		}

		@Override
		public int getHeight(int row) {
			return height;
		}

		@Override
		public String getCellString(int row, int column) {
			return "Lorem (" + row + ", " + column + ")";
		}

		@Override
		public int getLayoutResource(int row, int column) {
			final int layoutResource;
			switch (getItemViewType(row, column)) {
				case 0:
					layoutResource = R.layout.item_table1_header;
				break;
				case 1:
					layoutResource = R.layout.item_table1;
				break;
				default:
					throw new RuntimeException("wtf?");
			}
			return layoutResource;
		}

		@Override
		public int getItemViewType(int row, int column) {
			if (row < 0) {
				return 0;
			} else {
				return 1;
			}
		}

		@Override
		public int getViewTypeCount() {
			return 2;
		}
	}
}
