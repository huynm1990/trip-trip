package com.org.triptrip.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.org.triptrip.R;
import com.org.triptrip.adapter.ServicesAdapter;
import com.org.triptrip.common.ServiceItem;

import java.util.ArrayList;
import java.util.List;


public class ServiceMaterialFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RecyclerView experienceRecycler = (RecyclerView) inflater.inflate(R.layout.fragment_service_material, container, false);

        List<ServiceItem> services = new ArrayList<ServiceItem>();

        // Replace the code here to call web service
        // Utils.getService()
        for (int i = 0; i < ServiceItem.services.length; i++) {
            services.add(new ServiceItem(
                    ServiceItem.services[i].getTitle(),
                    ServiceItem.services[i].getImage(),
                    ServiceItem.services[i].getDateCreated(),
                    ServiceItem.services[i].getPhone(),
                    ServiceItem.services[i].getLocation(),
                    ServiceItem.services[i].getEvaluation()));
        }
        
        ServicesAdapter adapter = new ServicesAdapter(services, getActivity());
        experienceRecycler.setAdapter(adapter);

        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        experienceRecycler.setLayoutManager(layoutManager);

        return experienceRecycler;
    }
}
