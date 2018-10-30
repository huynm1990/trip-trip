package com.org.triptrip.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.org.triptrip.R;

/**
 * @author Huy Nguyen
 */
public class EventsAdapter extends RecyclerView.Adapter<EventsAdapter.ViewHolder> {

    private String[] dates;
    private String[] titles;
    private String[] eventTypes;
    private String[] regions;

    public EventsAdapter(String[] dates, String[] titles, String[] eventTypes, String[] regions) {
        this.dates = dates;
        this.titles = titles;
        this.eventTypes = eventTypes;
        this.regions = regions;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private CardView cardView;

        public ViewHolder(CardView cardView) {
            super(cardView);
            this.cardView = cardView;
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        CardView cv = (CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_events, parent, false);
        return new ViewHolder(cv);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder,final int position) {
        CardView cardView = viewHolder.cardView;

        TextView txtDate = (TextView) cardView.findViewById(R.id.txt_date);
        txtDate.setText(dates[position]);

        TextView txtTitle = (TextView) cardView.findViewById(R.id.txt_title);
        txtTitle.setText(titles[position]);

        TextView txtEventType = (TextView) cardView.findViewById(R.id.txt_event_type_content);
        txtEventType.setText(eventTypes[position]);

        TextView txtRegion = (TextView) cardView.findViewById(R.id.txt_region_content);
        txtRegion.setText(regions[position]);

    }

    @Override
    public int getItemCount() {
        return dates.length;
    }
}
