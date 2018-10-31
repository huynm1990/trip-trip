package com.org.triptrip.fragment;

import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.org.triptrip.adapter.ExperienceAdapter;
import com.org.triptrip.R;
import com.org.triptrip.adapter.ServicesAdapter;
import com.org.triptrip.common.Experience;
import com.org.triptrip.common.Service;


public class ServiceMaterialFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RecyclerView experienceRecycler = (RecyclerView) inflater.inflate(R.layout.fragment_service_material, container, false);

        int length = Service.services.length;
        String[] titles = new String[length];
        int[] images = new int[length];
        String[] dateCreated = new String[length];
        String[] phones = new String[length];
        String[] locations = new String[length];
        int[] evaluations = new int[length];
        for (int i = 0; i < length; i++) {
            titles[i] = Service.services[i].getTitle();
            images[i] = Service.services[i].getImage();
            dateCreated[i] = Service.services[i].getDateCreated();
            phones[i] = Service.services[i].getPhone();
            locations[i] = Service.services[i].getLocation();
            evaluations[i] = Service.services[i].getEvaluation();
        }


        ServicesAdapter adapter = new ServicesAdapter(titles, images, dateCreated, phones, locations, evaluations);
        experienceRecycler.setAdapter(adapter);

        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        experienceRecycler.setLayoutManager(layoutManager);

        return experienceRecycler;
    }
}
