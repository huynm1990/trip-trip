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
import com.org.triptrip.enums.CategoryKeyword;
import com.org.triptrip.enums.ItemType;
import com.org.triptrip.listener.EndlessRecyclerViewScrollListener;
import com.org.triptrip.utils.JSONUtils;
import com.org.triptrip.webservice.BaseJSONRestClient;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

import cz.msebera.android.httpclient.Header;

/**
 * This fragment contains the main content
 *
 * @author Huy Nguyen
 */
public class ContentFragment extends Fragment {

    private int contentId;
    private int sortId;
    private int categoryId;

    public void setContentId(int contentId) {
        this.contentId = contentId;
    }

    public void setSortId(int sortId) {
        this.sortId = sortId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (contentId == R.id.navigation_events) {
            return inflater.inflate(R.layout.fragment_event_material, container, false);
        } else if (contentId == R.id.navigation_services) {
            return inflater.inflate(R.layout.fragment_service_material, container, false);
        } else if (contentId == R.id.navigation_experiences) {
            return inflater.inflate(R.layout.fragment_experience_material, container, false);
        }
        return inflater.inflate(R.layout.fragment_content, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        loadNavigationContentItem(getView());

    }

    public void loadNavigationContentItem(View view) {
        RecyclerView initRecyclerView = null;

        if (contentId == R.id.navigation_events) {
            initRecyclerView = view.findViewById(R.id.recycler_events);
        } else if (contentId == R.id.navigation_services) {
            initRecyclerView = view.findViewById(R.id.recycler_services);
        } else if (contentId == R.id.navigation_experiences) {
            initRecyclerView = view.findViewById(R.id.recycler_experiences);
        }

        final RecyclerView recyclerView = initRecyclerView;
        String url = "items?page=0&size=10&filterJson=[{%22key%22:%22itemType%22,%22operator%22:%22=%22,%22value%22:%22" + ItemType.valueOf(contentId).getName() + "%22}"
                + ",{%22key%22:%22categoryKeyword%22,%22operator%22:%22like%22,%22value%22:%22" + CategoryKeyword.valueOf(categoryId).getKeyword() + "%22}]&sort=updated";
        Log.e("JSON url", url);
        BaseJSONRestClient.get(url, null, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                List<ItemViewDTO> items = JSONUtils.parseJSONToItemViewDTO(response);
                final ItemViewAdapter adapter = new ItemViewAdapter(contentId, items, getActivity());
                recyclerView.setAdapter(adapter);
                Log.e("JSON items", items.toString());
                RecyclerView.LayoutManager layoutManager = null;
                if (contentId == R.id.navigation_events) {
                    layoutManager = new LinearLayoutManager(getActivity());
                    recyclerView.setLayoutManager(layoutManager);
                } else if (contentId == R.id.navigation_services) {
                    layoutManager = new GridLayoutManager(getActivity(), 2);
                    recyclerView.setLayoutManager(layoutManager);
                } else if (contentId == R.id.navigation_experiences) {
                    layoutManager = new GridLayoutManager(getActivity(), 2);
                    recyclerView.setLayoutManager(layoutManager);
                }

                final RecyclerView.LayoutManager lManager = layoutManager;
                EndlessRecyclerViewScrollListener scrollListener = new EndlessRecyclerViewScrollListener(lManager) {
                    @Override
                    public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                        final RecyclerView viewInner = view;
                        String url = "items?page=" + page + "&size=10&filterJson=[{%22key%22:%22itemType%22,%22operator%22:%22=%22,%22value%22:%22" + ItemType.valueOf(contentId) + "%22}"
                                + ",{%22key%22:%22categoryKeyword%22,%22operator%22:%22like%22,%22value%22:%22" + CategoryKeyword.valueOf(categoryId).getKeyword() + "%22}]&sort=updated";
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
