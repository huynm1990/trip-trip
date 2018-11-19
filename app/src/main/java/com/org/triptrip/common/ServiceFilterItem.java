package com.org.triptrip.common;

import com.org.triptrip.R;

/**
 * Service Filter Item
 * @author Huy Nguyen
 */
public class ServiceFilterItem {

    String title;
    int image;

    public static final ServiceFilterItem[] items = {
            new ServiceFilterItem("Flight", R.drawable.ic_flight_48dp),
            new ServiceFilterItem("Hotel", R.drawable.ic_hotel_48dp),
            new ServiceFilterItem("Restaurant", R.drawable.ic_restaurant_48dp),
            new ServiceFilterItem("Subway", R.drawable.ic_subway_48dp),
            new ServiceFilterItem("Restaurant", R.drawable.ic_restaurant_48dp),
            new ServiceFilterItem("Subway", R.drawable.ic_subway_48dp),
            new ServiceFilterItem("Restaurant", R.drawable.ic_restaurant_48dp),
            new ServiceFilterItem("Subway", R.drawable.ic_subway_48dp)
    };

    public ServiceFilterItem(String title, int image) {
        this.title = title;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public int getImage() {
        return image;
    }
}
