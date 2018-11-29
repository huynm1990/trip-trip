package com.org.triptrip.adapter;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.org.triptrip.R;
import com.org.triptrip.enums.CategoryKeywordEnum;
import com.org.triptrip.fragment.FilterFragment;

import java.util.ArrayList;
import java.util.List;

public class ServiceFilterAdapter extends RecyclerView.Adapter<ServiceFilterAdapter.ViewHolder> {

    private List<CategoryKeywordEnum> items = new ArrayList<CategoryKeywordEnum>();
    private Activity activity;
    private FilterFragment.OnFilterItemSelectedListener listener;

    public ServiceFilterAdapter(Activity activity, FilterFragment.OnFilterItemSelectedListener listener) {
        this.activity = activity;
        this.listener = listener;
        for (CategoryKeywordEnum categoryKeyword : CategoryKeywordEnum.VALUES.values()) {
            items.add(categoryKeyword);
        }
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private CardView cardView;

        public ViewHolder(CardView cardView) {
            super(cardView);
            this.cardView = cardView;
        }

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        CardView cv = (CardView) LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.card_service_filter, viewGroup, false);
        return new ViewHolder(cv);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        CardView cardView = viewHolder.cardView;
        ImageView imageView = (ImageView) cardView.findViewById(R.id.img_icon);
        Drawable drawable = cardView.getResources().getDrawable(this.items.get(position).getImage());
        imageView.setImageDrawable(drawable);

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onRecyclerViewItemSelected(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
