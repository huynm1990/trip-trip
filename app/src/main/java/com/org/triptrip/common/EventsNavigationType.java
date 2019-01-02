package com.org.triptrip.common;

import android.app.Activity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.org.triptrip.R;

import java.util.List;

/**
 * Events Navigation Type
 * @author Huy Nguyen
 */
public class EventsNavigationType extends NavigationType {

    /**
     * EventsNavigationType constructor
     * @param id
     * @param name
     * @param layoutId
     */
    public EventsNavigationType(int id, String name, int layoutId) {
        super(id, name, layoutId);
    }

    @Override
    public void loadContent(CardView cardView, List<ItemViewDTO> items, int position) {
        TextView txtTitle = (TextView) cardView.findViewById(R.id.txt_title);
        txtTitle.setText(items.get(position).getTitle());

        TextView txtEventNote = (TextView) cardView.findViewById(R.id.txt_event_note);
        txtEventNote.setText("Halloween");

        TextView txtPlace = (TextView) cardView.findViewById(R.id.txt_place);
        txtPlace.setText("Canada");

        TextView txtFromDate = (TextView) cardView.findViewById(R.id.txt_from_date);
        txtFromDate.setText("27-Nov-2018");

        TextView txtToDate = (TextView) cardView.findViewById(R.id.txt_to_date);
        txtToDate.setText("30-Nov-2018");

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                //onItemClick(events.get(position));
            }
        });
    }

    @Override
    public RecyclerView.LayoutManager getLayoutManager(Activity activity) {
        return new LinearLayoutManager(activity);
    }
}
