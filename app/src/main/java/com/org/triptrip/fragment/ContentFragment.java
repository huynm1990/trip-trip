package com.org.triptrip.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.loopj.android.http.JsonHttpResponseHandler;
import com.org.triptrip.R;
import com.org.triptrip.adapter.EventsAdapter;
import com.org.triptrip.adapter.ExperienceAdapter;
import com.org.triptrip.adapter.ServicesAdapter;
import com.org.triptrip.common.EventItem;
import com.org.triptrip.common.ExperienceItem;
import com.org.triptrip.common.ServiceItem;
import com.org.triptrip.listener.EndlessRecyclerViewScrollListener;
import com.org.triptrip.webservice.BaseJSONRestClient;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;

/**
 * This fragment contains the main content
 *
 * @author Huy Nguyen
 */
public class ContentFragment extends Fragment {

    private int contentId;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (contentId == R.id.navigation_events) {
            return inflater.inflate(R.layout.fragment_event_material, container, false);
        } else if (contentId == R.id.navigation_services) {
            return inflater.inflate(R.layout.fragment_service_material, container, false);
        } else if (contentId == R.id.navigation_experiences) {
            return inflater.inflate(R.layout.fragment_experience_material, container, false);
        }
        return inflater.inflate(R.layout.fragment_content, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        View view = getView();
        if (contentId == R.id.navigation_events) {
            RecyclerView eventRecycler = view.findViewById(R.id.recycler_events);
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
        } else if (contentId == R.id.navigation_services) {
            final RecyclerView serviceRecycler = (RecyclerView) view.findViewById(R.id.recycler_services);
            String url = "items?page=" + 0 + "&size=10&sort=updated,desc&filterJson=[{%22key%22:%22itemType%22,%22operator%22:%22=%22,%22value%22:%22SERVICE%22}]";
            BaseJSONRestClient.get(url, null, new JsonHttpResponseHandler() {
                @Override
                public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                    // If the response is JSONObject instead of expected JSONArray
                }

                @Override
                public void onSuccess(int statusCode, Header[] headers, JSONArray jsonItems) {
                    List<ServiceItem> itemFirstTime = getItems(jsonItems);
                    Log.e("onJSON size", Integer.toString(itemFirstTime.size()));
                    final ServicesAdapter adapter = new ServicesAdapter(itemFirstTime, getActivity());
                    serviceRecycler.setAdapter(adapter);

                    GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
                    serviceRecycler.setLayoutManager(layoutManager);

                    EndlessRecyclerViewScrollListener scrollListener = new EndlessRecyclerViewScrollListener(layoutManager) {
                        @Override
                        public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                            final RecyclerView viewInner = view;
                            String url = "items?page=" + 1 + "&size=10&sort=updated,desc&filterJson=[{%22key%22:%22itemType%22,%22operator%22:%22=%22,%22value%22:%22SERVICE%22}]";
                            BaseJSONRestClient.get(url, null, new JsonHttpResponseHandler() {
                                @Override
                                public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                                    // If the response is JSONObject instead of expected JSONArray
                                }

                                @Override
                                public void onSuccess(int statusCode, Header[] headers, JSONArray jsonItems) {
                                    final int curSize = adapter.getItemCount();
                                    final List<ServiceItem> items = adapter.getServices();
                                    items.addAll(getItems(jsonItems));
                                    Log.e("onScroll size", Integer.toString(items.size()));
                                    viewInner.post(new Runnable() {
                                        @Override
                                        public void run() {
                                            adapter.notifyItemRangeInserted(curSize, items.size() - 1);
                                        }
                                    });
                                }
                            });

                        }
                    };
                    serviceRecycler.addOnScrollListener(scrollListener);
                }
            });
        } else if (contentId == R.id.navigation_experiences) {
            RecyclerView experienceRecycler = view.findViewById(R.id.recycler_experiences);
            List<ExperienceItem> experiences = new ArrayList<ExperienceItem>();
            for (int i = 0; i < ExperienceItem.experiences.length; i++) {
                experiences.add(new ExperienceItem(
                        ExperienceItem.experiences[i].getTitle(),
                        ExperienceItem.experiences[i].getImage(),
                        ExperienceItem.experiences[i].getDateCreated()
                ));
            }


            ExperienceAdapter adapter = new ExperienceAdapter(experiences, getActivity());
            experienceRecycler.setAdapter(adapter);

            GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
            experienceRecycler.setLayoutManager(layoutManager);
        }

    }

    public void setContentId(int contentId) {
        this.contentId = contentId;
    }

    public List<ServiceItem> getItems(JSONArray jsonItems) {
        List<ServiceItem> items = new ArrayList<ServiceItem>();
        for (int i = 0; i < jsonItems.length(); i++) {
            try {
                JSONObject s = jsonItems.getJSONObject(i);
                String title = s.getString("title");
                items.add(new ServiceItem(
                        title,
                        ServiceItem.services[0].getImage(),
                        ServiceItem.services[0].getDateCreated(),
                        ServiceItem.services[0].getPhone(),
                        ServiceItem.services[0].getLocation(),
                        ServiceItem.services[0].getRating()));
            } catch (Exception ex) {

            }
        }
        return items;
    }
}
