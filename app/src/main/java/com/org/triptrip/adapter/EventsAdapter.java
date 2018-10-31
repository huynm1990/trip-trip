package com.org.triptrip.adapter;

import android.graphics.drawable.Drawable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.org.triptrip.R;

/**
 * @author Huy Nguyen
 */
public class EventsAdapter extends RecyclerView.Adapter<EventsAdapter.ViewHolder> {


    private String[] titles;
    private String[] eventTypes;
    private String[] regions;
    private String[] fromDates;
    private String[] toDates;

    public EventsAdapter(String[] titles, String[] eventTypes, String[] regions, String[] fromDates, String[] toDates) {
        this.titles = titles;
        this.eventTypes = eventTypes;
        this.regions = regions;
        this.fromDates = fromDates;
        this.toDates = toDates;
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

        TextView txtTitle = (TextView) cardView.findViewById(R.id.txt_title);
        txtTitle.setText(titles[position]);

        TextView txtEventNote = (TextView) cardView.findViewById(R.id.txt_event_note);
        txtEventNote.setText(eventTypes[position]);

        TextView txtPlace = (TextView) cardView.findViewById(R.id.txt_place);
        txtPlace.setText(regions[position]);

        TextView txtFromDate = (TextView) cardView.findViewById(R.id.txt_from_date);
        txtFromDate.setText(fromDates[position]);

        TextView txtToDate = (TextView) cardView.findViewById(R.id.txt_to_date);
        txtToDate.setText(toDates[position]);

    }

    @Override
    public int getItemCount() {
        return titles.length;
    }
}
