package com.org.triptrip.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.loopj.android.http.JsonHttpResponseHandler;
import com.org.triptrip.R;
import com.org.triptrip.adapter.ServicesAdapter;
import com.org.triptrip.common.ServiceItem;
import com.org.triptrip.listener.EndlessRecyclerViewScrollListener;
import com.org.triptrip.webservice.BaseJSONRestClient;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;


public class ServiceMaterialFragment extends Fragment {

    static List<ServiceItem> serviceItems = new ArrayList<ServiceItem>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final RecyclerView experienceRecycler = (RecyclerView) inflater.inflate(R.layout.fragment_service_material, container, false);

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
                experienceRecycler.setAdapter(adapter);

                GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
                experienceRecycler.setLayoutManager(layoutManager);

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
                experienceRecycler.addOnScrollListener(scrollListener);
            }
        });

        return experienceRecycler;
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
                        ServiceItem.services[0].getEvaluation()));
            } catch (Exception ex) {

            }
        }
        return items;
    }

}
