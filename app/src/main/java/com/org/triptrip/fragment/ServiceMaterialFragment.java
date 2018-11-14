package com.org.triptrip.fragment;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.org.triptrip.R;
import com.org.triptrip.adapter.ServicesAdapter;
import com.org.triptrip.common.ServiceItem;
import com.org.triptrip.handler.HttpHandler;
import com.org.triptrip.listener.EndlessRecyclerViewScrollListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class ServiceMaterialFragment extends Fragment {

    List<ServiceItem> serviceItems = new ArrayList<ServiceItem>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RecyclerView experienceRecycler = (RecyclerView) inflater.inflate(R.layout.fragment_service_material, container, false);

        final ServicesAdapter adapter = new ServicesAdapter(serviceItems, getActivity());
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        // Replace the code here to call web service

        new GetServiceItems(getActivity(), experienceRecycler, layoutManager, adapter).execute();
        Log.e("Huy test" + getActivity().getLocalClassName(), serviceItems.toString());

        return experienceRecycler;
    }

    class GetServiceItems extends AsyncTask<Void, Void, Void> {

        RecyclerView experienceRecycler;
        Activity activity;
        GridLayoutManager layoutManager;
        ServicesAdapter adapter;

        public GetServiceItems(Activity activity, RecyclerView recyclerView,
                               GridLayoutManager layoutManager,
                               ServicesAdapter adapter) {
            this.experienceRecycler = recyclerView;
            this.activity = activity;
            this.layoutManager = layoutManager;
            this.adapter = adapter;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Toast.makeText(getActivity(),"Json Data is downloading",Toast.LENGTH_LONG).show();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            serviceItems.addAll(getServiceItems(0));
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            experienceRecycler.setAdapter(this.adapter);
            experienceRecycler.setLayoutManager(this.layoutManager);
            experienceRecycler.addOnScrollListener(new EndlessRecyclerViewScrollListener(this.layoutManager) {
                @Override
                public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                    final int curSize = adapter.getItemCount();
                    final List<ServiceItem> items = new ArrayList<ServiceItem>();

                    // Replace the code here to call web service
                    // Utils.getService()
                    for (int i = 0; i < ServiceItem.services.length; i++) {
                        items.add(new ServiceItem(
                                ServiceItem.services[i].getTitle(),
                                ServiceItem.services[i].getImage(),
                                ServiceItem.services[i].getDateCreated(),
                                ServiceItem.services[i].getPhone(),
                                ServiceItem.services[i].getLocation(),
                                ServiceItem.services[i].getEvaluation()));
                    }
                    serviceItems.addAll(items);

                    view.post(new Runnable() {
                        @Override
                        public void run() {
                            adapter.notifyItemRangeInserted(curSize, serviceItems.size() - 1);
                        }
                    });
                }
            });
        }

    }

    private List<ServiceItem> getServiceItems(int page) {
        List<ServiceItem> items = new ArrayList<ServiceItem>();
        HttpHandler sh = new HttpHandler();
        // Making a request to url and getting response
        String url = "https://api.triptrip.online/v1/items?page=" + page + "&size=10&sort=updated,desc&filterJson=[{%22key%22:%22itemType%22,%22operator%22:%22=%22,%22value%22:%22SERVICE%22}]";
        String jsonStr = sh.makeServiceCall(url);

        Log.e(getActivity().getLocalClassName(), "Response from url: " + jsonStr);
        if (jsonStr != null) {
            try {
                // Getting JSON Array node
                JSONArray services = new JSONArray(jsonStr);

                // looping through All Contacts
                for (int i = 0; i < services.length(); i++) {
                    JSONObject s = services.getJSONObject(i);
                    String title = s.getString("title");
                    items.add(new ServiceItem(
                            title,
                            ServiceItem.services[0].getImage(),
                            ServiceItem.services[0].getDateCreated(),
                            ServiceItem.services[0].getPhone(),
                            ServiceItem.services[0].getLocation(),
                            ServiceItem.services[0].getEvaluation()));
                }

                Log.e("Huy test" + getActivity().getLocalClassName(), items.toString());

            } catch (final JSONException e) {
                Log.e(getActivity().getLocalClassName(), "Json parsing error: " + e.getMessage());
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getActivity().getApplicationContext(),
                                "Json parsing error: " + e.getMessage(),
                                Toast.LENGTH_LONG).show();
                    }
                });

            }

        } else {
            Log.e(getActivity().getLocalClassName(), "Couldn't get json from server.");
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(getActivity().getApplicationContext(),
                            "Couldn't get json from server. Check LogCat for possible errors!",
                            Toast.LENGTH_LONG).show();
                }
            });
        }

        return items;
    }
}
