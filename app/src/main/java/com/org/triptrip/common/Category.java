package com.org.triptrip.common;

import com.org.triptrip.R;

public class Category {
    private String name;
    private int imageResourceId;

    public static final Category[] categories = {
            new Category("Events", R.drawable.travel_guideline),
            new Category("Experiences", R.drawable.travel_experience),
            new Category("Services", R.drawable.travel_services),
            new Category("Q&A", R.drawable.travel_discussion),
    };

    private Category(String name, int imageResourceId) {
        this.name = name;
        this.imageResourceId = imageResourceId;
    }

    public String getName() {
        return name;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }
}
