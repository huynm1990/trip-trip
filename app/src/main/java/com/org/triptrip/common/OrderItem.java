package com.org.triptrip.common;

import com.org.triptrip.R;

public class OrderItem extends Item {

    private String keyword;
    private int img;
    private String title;

    public static final OrderItem[] items = {
            new OrderItem("favourite",R.drawable.ic_favorite_black_15dp, "Favorite"),
            new OrderItem("latest",R.drawable.ic_schedule_15dp, "Latest"),
            new OrderItem("highest_first",R.drawable.ic_arrow_downward_15dp, "Price down"),
            new OrderItem("lowest_first",R.drawable.ic_arrow_upward_15dp, "Price up")
    };

    public OrderItem(String keyword, int img, String title) {
        this.keyword = keyword;
        this.img = img;
        this.title = title;
    }

    public int getImage() {
        return img;
    }

    public String getTitle() {
        return title;
    }

    public String getKeyword() {
        return keyword;
    }
}
