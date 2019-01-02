package com.org.triptrip.common;

import android.app.Activity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;

import java.util.List;

/**
 * Navigation Type
 * @author Huy Nguyen
 */
public abstract class NavigationType {
    private int id;
    private int layoutId;
    private String name;

    public NavigationType(int id, String name, int layoutId) {
        this.id = id;
        this.layoutId = layoutId;
        this.name = name;
    }

    /**
     * @return id
     */
    public int getId() {
        return this.id;
    }

    /**
     * @return layoutId
     */
    public int getLayoutId() {
        return this.layoutId;
    }

    /**
     * @return name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Load content
     * @param cardView
     * @param items
     * @param position
     */
    public abstract void loadContent(CardView cardView, List<ItemViewDTO> items, int position);

    /**
     * Get layout manager
     * @param activity
     * @return layout manager
     */
    public abstract RecyclerView.LayoutManager getLayoutManager(Activity activity);
}
