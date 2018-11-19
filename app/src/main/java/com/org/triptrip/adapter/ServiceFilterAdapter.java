package com.org.triptrip.adapter;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.org.triptrip.R;
import com.org.triptrip.common.ServiceFilterItem;

import java.util.ArrayList;
import java.util.List;

public class ServiceFilterAdapter extends RecyclerView.Adapter<ServiceFilterAdapter.ViewHolder> {

    private List<ServiceFilterItem> items = new ArrayList<ServiceFilterItem>();
    private Activity activity;

    public ServiceFilterAdapter(List<ServiceFilterItem> items, Activity activity) {
        this.items = items;
        this.activity = activity;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private CardView cardView;

        public ViewHolder(CardView cardView) {
            super(cardView);
            this.cardView = cardView;
        }

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        CardView cv = (CardView) LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.card_service_filter, viewGroup, false);
        return new ViewHolder(cv);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        CardView cardView = viewHolder.cardView;

        ImageView imageView = (ImageView) cardView.findViewById(R.id.img_icon);
        Drawable drawable = cardView.getResources().getDrawable(this.items.get(position).getImage());
        imageView.setImageDrawable(drawable);

    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
