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
import android.widget.GridView;
import android.widget.Toast;

import com.org.triptrip.R;
import com.org.triptrip.adapter.ServicesAdapter;
import com.org.triptrip.common.ServiceItem;
import com.org.triptrip.handler.HttpHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class ServiceMaterialFragment extends Fragment {

    List<ServiceItem> serviceItems = new ArrayList<ServiceItem>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RecyclerView experienceRecycler = (RecyclerView) inflater.inflate(R.layout.fragment_service_material, container, false);



        // Replace the code here to call web service

        new GetServiceItems(getActivity(), experienceRecycler).execute();
        Log.e("Huy test" + getActivity().getLocalClassName(), serviceItems.toString());

        return experienceRecycler;
    }

    class GetServiceItems extends AsyncTask<Void, Void, Void> {

        RecyclerView experienceRecycler;
        Activity mContext;

        public GetServiceItems(Activity mContext, RecyclerView recyclerView) {
            this.experienceRecycler = recyclerView;
            this.mContext = mContext;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Toast.makeText(getActivity(),"Json Data is downloading",Toast.LENGTH_LONG).show();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            HttpHandler sh = new HttpHandler();
            // Making a request to url and getting response
            String url = "https://api.triptrip.online/v1/items?page=0&size=10&sort=updated,desc&filterJson=[{%22key%22:%22itemType%22,%22operator%22:%22=%22,%22value%22:%22SERVICE%22}]";
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
                        serviceItems.add(new ServiceItem(
                                title,
                                ServiceItem.services[0].getImage(),
                                ServiceItem.services[0].getDateCreated(),
                                ServiceItem.services[0].getPhone(),
                                ServiceItem.services[0].getLocation(),
                                ServiceItem.services[0].getEvaluation()));
                    }

                    Log.e("Huy test" + getActivity().getLocalClassName(), serviceItems.toString());

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
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            ServicesAdapter adapter = new ServicesAdapter(serviceItems, getActivity());
            experienceRecycler.setAdapter(adapter);

            GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
            experienceRecycler.setLayoutManager(layoutManager);
        }
    }
}
