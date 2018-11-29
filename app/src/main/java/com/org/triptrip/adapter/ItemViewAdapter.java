package com.org.triptrip.adapter;

import android.app.Activity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.org.triptrip.common.ItemViewDTO;
import com.org.triptrip.enums.NavigationEnum;

import java.util.List;

public class ItemViewAdapter extends RecyclerView.Adapter<ItemViewAdapter.ViewHolder>  {

    private int navigationId;
    private List<ItemViewDTO> items;
    private Activity activity;

    public ItemViewAdapter(int navigationId, List<ItemViewDTO> items, Activity activity) {
        this.navigationId = navigationId;
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

    @Override
    public ItemViewAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        int layoutCardViewId = NavigationEnum.valueOf(this.navigationId).getNavigationType().getLayoutId();
        CardView cv = cv = (CardView) LayoutInflater.from(viewGroup.getContext())
                .inflate(layoutCardViewId, viewGroup, false);
        return new ItemViewAdapter.ViewHolder(cv);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        CardView cardView = viewHolder.cardView;
        NavigationEnum.valueOf(this.navigationId).getNavigationType().loadContent(cardView, items, position);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public List<ItemViewDTO> getItems() {
        return items;
    }
}
