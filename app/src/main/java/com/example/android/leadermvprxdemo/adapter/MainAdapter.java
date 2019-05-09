package com.example.android.leadermvprxdemo.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.leadermvprxdemo.R;
import com.example.pub.view.adapter.BaseListAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Android on 2017/11/17.
 */

public class MainAdapter extends BaseListAdapter<String> {
    public MainAdapter(Context context, List<String> list) {
        super(context, list);
    }
    @Override
    public View bindView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.item_list_luban, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.content.setText(list.get(position));
        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.tv_content)
        TextView content;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

}
