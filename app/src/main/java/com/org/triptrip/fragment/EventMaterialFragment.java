package com.org.triptrip.fragment;

import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.org.triptrip.adapter.EventsAdapter;
import com.org.triptrip.R;
import com.org.triptrip.common.Event;


public class EventMaterialFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RecyclerView eventRecycler = (RecyclerView) inflater.inflate(R.layout.fragment_event_material, container, false);

        String[] dates = new String[Event.events.length];
        String[] titles = new String[Event.events.length];
        String[] eventTypes = new String[Event.events.length];
        String[] regions = new String[Event.events.length];
        for (int i = 0; i < Event.events.length; i++) {
            dates[i] = Event.events[i].getDate();
            titles[i] = Event.events[i].getTitle();
            eventTypes[i] = Event.events[i].getEventType();
            regions[i] = Event.events[i].getRegion();
        }


        EventsAdapter adapter = new EventsAdapter(dates, titles, eventTypes, regions);
        eventRecycler.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        eventRecycler.setLayoutManager(layoutManager);

        return eventRecycler;
    }
}
