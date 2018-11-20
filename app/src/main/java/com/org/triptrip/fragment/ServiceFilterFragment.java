package com.org.triptrip.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.org.triptrip.R;
import com.org.triptrip.adapter.ServiceFilterAdapter;
import com.org.triptrip.common.ServiceFilterItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Service Filter Fragment
 * @author Huy Nguyen
 */
public class ServiceFilterFragment extends Fragment {


    public ServiceFilterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RecyclerView serviceFilterRecycler = (RecyclerView) inflater.inflate(R.layout.fragment_service_filter, container, false);

        List<ServiceFilterItem> items = new ArrayList<ServiceFilterItem>();

        for (int i = 0; i < ServiceFilterItem.items.length; i++) {
            items.add(new ServiceFilterItem(
                    ServiceFilterItem.items[i].getKeywork(),
                    ServiceFilterItem.items[i].getImage()
            ));

        }


        ServiceFilterAdapter adapter = new ServiceFilterAdapter(items, getActivity());
        serviceFilterRecycler.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayout.HORIZONTAL);
        serviceFilterRecycler.setLayoutManager(layoutManager);

        return serviceFilterRecycler;
    }

}
