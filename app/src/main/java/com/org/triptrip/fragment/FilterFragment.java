package com.org.triptrip.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
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
 * Filter Fragment
 * @author Huy Nguyen
 */
public class FilterFragment extends Fragment {

    public static interface SpinnerItemListener {
        void onSpinnerItemSelected(int id);
    }

    private SpinnerItemListener listener;

    private int filterId;

    public FilterFragment() {
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
        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                listener.onSpinnerItemSelected(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.listener = (SpinnerItemListener) getActivity();
    }

    public void setFilterId(int filterId) {
        this.filterId = filterId;
    }
}
