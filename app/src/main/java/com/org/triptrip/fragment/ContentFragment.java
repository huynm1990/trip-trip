package com.org.triptrip.fragment;

import android.os.Bundle;
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
import com.org.triptrip.adapter.ItemViewAdapter;
import com.org.triptrip.common.ItemViewDTO;
import com.org.triptrip.common.JSONFilter;
import com.org.triptrip.common.JSONUrl;
import com.org.triptrip.enums.NavigationEnum;
import com.org.triptrip.listener.EndlessRecyclerViewScrollListener;
import com.org.triptrip.utils.JSONUtils;
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

    private int navigationId;
    private int categoryId;
    private int sortId;

    public void setNavigationId(int navigationId) {
        this.navigationId = navigationId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public void setSortId(int sortId) {
        this.sortId = sortId;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_content, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        loadNavigationContentItem(getView());

    }

    public void loadNavigationContentItem(View view) {
        final RecyclerView recyclerView = view.findViewById(R.id.recycler_content);
        List<JSONFilter> filters = new ArrayList<JSONFilter>();
        filters.add(new JSONFilter("itemType", "=", NavigationEnum.valueOf(navigationId).getNavigationType().getName()));
        JSONUrl jsonURL = new JSONUrl(0, 10, filters, "updated");
        String url = jsonURL.toString();
        Log.i("JSON URL: ", url);
        BaseJSONRestClient.get(url, null, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                List<ItemViewDTO> items = JSONUtils.parseJSONToItemViewDTO(response);
                final ItemViewAdapter adapter = new ItemViewAdapter(navigationId, items, getActivity());
                recyclerView.setAdapter(adapter);
                Log.e("JSON items", items.toString());
                final RecyclerView.LayoutManager layoutManager = NavigationEnum.valueOf(navigationId).getNavigationType().getLayoutManager(getActivity());
                recyclerView.setLayoutManager(layoutManager);

                EndlessRecyclerViewScrollListener scrollListener = new EndlessRecyclerViewScrollListener(layoutManager) {
                    @Override
                    public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                        final RecyclerView viewInner = view;
                        List<JSONFilter> filters = new ArrayList<JSONFilter>();
                        filters.add(new JSONFilter("itemType", "=", NavigationEnum.valueOf(navigationId).getNavigationType().getName()));
                        JSONUrl jsonURL = new JSONUrl(page, 10, filters, "updated");
                        String url = jsonURL.toString();
                        Log.i("JSON URL: ", url);
                        BaseJSONRestClient.get(url, null, new JsonHttpResponseHandler() {
                            @Override
                            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                                // If the response is JSONObject instead of expected JSONArray
                            }

                            @Override
                            public void onSuccess(int statusCode, Header[] headers, JSONArray jsonItems) {
                                final int curSize = adapter.getItemCount();
                                final List<ItemViewDTO> items = adapter.getItems();
                                items.addAll(JSONUtils.parseJSONToItemViewDTO(jsonItems));
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

                recyclerView.addOnScrollListener(scrollListener);
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);
            }
        });

    }

}
