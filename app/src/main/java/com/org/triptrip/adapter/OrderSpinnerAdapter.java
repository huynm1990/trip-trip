package com.org.triptrip.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.org.triptrip.R;
import com.org.triptrip.enums.Priority;

import java.util.ArrayList;
import java.util.List;

public class OrderSpinnerAdapter extends BaseAdapter {

    Context context;
    LayoutInflater inflter;
    List<Priority> items = new ArrayList<Priority>();

    public OrderSpinnerAdapter(Context applicationContext) {
        this.context = applicationContext;
        inflter = (LayoutInflater.from(applicationContext));
        for (Priority orderItem: Priority.VALUES.values()) {
            this.items.add(orderItem);
        }
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.spinner_order_layout, null);
        ImageView icon = (ImageView) view.findViewById(R.id.imageView);
        TextView names = (TextView) view.findViewById(R.id.textView);
        icon.setImageResource(items.get(i).getImage());
        names.setText(items.get(i).getTitle());
        return view;
    }
}
