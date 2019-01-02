package com.org.triptrip.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.org.triptrip.R;
import com.org.triptrip.enums.PriorityEnum;

import java.util.ArrayList;
import java.util.List;

/**
 * Order Spinner Adapter
 * @author Huy Nguyen
 */
public class OrderSpinnerAdapter extends BaseAdapter {

    Context context;
    LayoutInflater inflter;
    List<PriorityEnum> items = new ArrayList<PriorityEnum>();

    public OrderSpinnerAdapter(Context applicationContext) {
        this.context = applicationContext;
        inflter = (LayoutInflater.from(applicationContext));
        for (PriorityEnum orderItem: PriorityEnum.VALUES.values()) {
            this.items.add(orderItem);
        }
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
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
