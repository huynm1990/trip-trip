package com.org.triptrip.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.org.triptrip.R;
import com.org.triptrip.activity.EventDetailActivity;
import com.org.triptrip.common.EventItem;
import com.org.triptrip.common.Item;
import com.org.triptrip.listener.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Huy Nguyen
 */
public class EventsAdapter extends RecyclerView.Adapter<EventsAdapter.ViewHolder> implements OnItemClickListener {

    List<EventItem> events = new ArrayList<EventItem>();
    private Activity activity;

    public EventsAdapter(List<EventItem> events, Activity activity) {
        this.events = events;
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
    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        CardView cv = (CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_events, parent, false);
        return new ViewHolder(cv);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder,final int position) {
        CardView cardView = viewHolder.cardView;

        TextView txtTitle = (TextView) cardView.findViewById(R.id.txt_title);
        txtTitle.setText(events.get(position).getTitle());

        TextView txtEventNote = (TextView) cardView.findViewById(R.id.txt_event_note);
        txtEventNote.setText(events.get(position).getEventType());

        TextView txtPlace = (TextView) cardView.findViewById(R.id.txt_place);
        txtPlace.setText(events.get(position).getRegion());

        TextView txtFromDate = (TextView) cardView.findViewById(R.id.txt_from_date);
        txtFromDate.setText(events.get(position).getFromDate());

        TextView txtToDate = (TextView) cardView.findViewById(R.id.txt_to_date);
        txtToDate.setText(events.get(position).getToDate());

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                onItemClick(events.get(position));
            }
        });

    }

    @Override
    public int getItemCount() {
        return events.size();
    }

    @Override
    public void onItemClick(Item item) {
        Intent myIntent = new Intent(this.activity, EventDetailActivity.class);
        this.activity.startActivity(myIntent);
    }
}
