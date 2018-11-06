package com.org.triptrip.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.org.triptrip.adapter.EventsAdapter;
import com.org.triptrip.R;
import com.org.triptrip.common.EventItem;

import java.util.ArrayList;
import java.util.List;


public class EventMaterialFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RecyclerView eventRecycler = (RecyclerView) inflater.inflate(R.layout.fragment_event_material, container, false);

        List<EventItem> events = new ArrayList<EventItem>();

        for (int i = 0; i < EventItem.events.length; i++) {
            events.add(new EventItem(
                    EventItem.events[i].getTitle(),
                    EventItem.events[i].getEventType(),
                    EventItem.events[i].getRegion(),
                    EventItem.events[i].getFromDate(),
                    EventItem.events[i].getToDate()
            ));

        }


        EventsAdapter adapter = new EventsAdapter(events, getActivity());
        eventRecycler.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        eventRecycler.setLayoutManager(layoutManager);

        return eventRecycler;
    }
}
