package com.org.triptrip.common;

import com.org.triptrip.R;

public class OrderItem {

    private int flag;
    private String title;

    public static final OrderItem[] items = {
            new OrderItem(R.drawable.ic_arrow_downward_15dp, "Large To Small"),
            new OrderItem(R.drawable.ic_arrow_upward_15dp, "Small To Large")
    };

    public OrderItem(int flag, String title) {
        this.flag = flag;
        this.title = title;
    }

    public int getFlag() {
        return flag;
    }

    public String getTitle() {
        return title;
    }
}
