package com.org.triptrip.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.org.triptrip.activity.ServiceDetailActivity;
import com.org.triptrip.R;
import com.org.triptrip.adapter.ServicesAdapter;
import com.org.triptrip.common.Service;

import java.util.ArrayList;
import java.util.List;


public class ServiceMaterialFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RecyclerView experienceRecycler = (RecyclerView) inflater.inflate(R.layout.fragment_service_material, container, false);

        List<Service> services = new ArrayList<Service>();

        // Replace the code here to call web service
        // Utils.getService()
        for (int i = 0; i < Service.services.length; i++) {
            services.add(new Service(
                    Service.services[i].getTitle(),
                    Service.services[i].getImage(),
                    Service.services[i].getDateCreated(),
                    Service.services[i].getPhone(),
                    Service.services[i].getLocation(),
                    Service.services[i].getEvaluation()));
        }
        
        ServicesAdapter adapter = new ServicesAdapter(services, new ServicesAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Service item) {
                Intent myIntent = new Intent(getActivity(), ServiceDetailActivity.class);
                getActivity().startActivity(myIntent);
            }
        });
        experienceRecycler.setAdapter(adapter);

        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        experienceRecycler.setLayoutManager(layoutManager);

        return experienceRecycler;
    }
}
