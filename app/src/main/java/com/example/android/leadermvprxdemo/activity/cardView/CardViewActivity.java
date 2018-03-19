package com.example.android.leadermvprxdemo.activity.cardView;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.leadermvprxdemo.R;

import java.util.ArrayList;
import java.util.List;

public class CardViewActivity extends FragmentActivity implements CardView.OnCardClickListener {
    List<String> list;
    private TestFragment frag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardview);
        initUI();
    }

    private void initUI() {
        CardView cardView = (CardView) findViewById(R.id.cardView1);
        cardView.setOnCardClickListener(this);
        cardView.setItemSpace(Utils.convertDpToPixelInt(this, 20));

        MyCardAdapter adapter = new MyCardAdapter(this);
        adapter.addAll(initData());
        cardView.setAdapter(adapter);

        FragmentManager manager = getSupportFragmentManager();
        frag = new TestFragment();
        manager.beginTransaction().add(R.id.contentView, frag).commit();
    }

    @Override
    public void onCardClick(final View view, final int position) {
        Toast.makeText(CardViewActivity.this, position + "", Toast.LENGTH_SHORT).show();
        Bundle bundle = new Bundle();
        bundle.putString("text", list.get(position % list.size()));
        frag.show(view, bundle);
    }


    private List<String> initData() {
        list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        list.add("f");
        list.add("g");
        return list;
    }

    public class MyCardAdapter extends CardAdapter<String> {

        public MyCardAdapter(Context context) {
            super(context);
        }

        @Override
        public int getCount() {
            return Integer.MAX_VALUE;
        }

        @Override
        protected View getCardView(int position,
                                   View convertView, ViewGroup parent) {
            if (convertView == null) {
                LayoutInflater inflater = LayoutInflater.from(CardViewActivity.this);
                convertView = inflater.inflate(R.layout.item_layout, parent, false);
            }
            TextView tv = (TextView) convertView.findViewById(R.id.textView1);
            String text = getItem(position % list.size());
            tv.setText(text);
            return convertView;
        }
    }

}
