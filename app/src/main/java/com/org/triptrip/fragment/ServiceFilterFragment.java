package com.org.triptrip.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.org.triptrip.R;
import com.org.triptrip.adapter.OrderSpinnerAdapter;
import com.org.triptrip.adapter.ServiceFilterAdapter;
import com.org.triptrip.common.OrderItem;
import com.org.triptrip.common.ServiceFilterItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Service Filter Fragment
 * @author Huy Nguyen
 */
public class ServiceFilterFragment extends Fragment {


    private int filterId;

    public ServiceFilterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_service_filter, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        View view = getView();
        // Load filter content
        RecyclerView serviceFilterRecycler = (RecyclerView) view.findViewById(R.id.service_filter_recycler);

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

        // Load spinner
        Spinner spin = (Spinner) view.findViewById(R.id.spinner_order);
        List<OrderItem> spinnerItems = new ArrayList<OrderItem>();
        for (int i = 0; i < OrderItem.items.length; i++) {
            spinnerItems.add(new OrderItem(OrderItem.items[i].getKeyword(), OrderItem.items[i].getImage(), OrderItem.items[i].getTitle()));
        }

        OrderSpinnerAdapter orderSpinnerAdapter = new OrderSpinnerAdapter(getActivity().getApplicationContext(), spinnerItems);
        spin.setAdapter(orderSpinnerAdapter);
    }

    public void setFilterId(int filterId) {
        this.filterId = filterId;
    }
}
