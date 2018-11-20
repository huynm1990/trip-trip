package com.org.triptrip.common;

import com.org.triptrip.R;

/**
 * Service Filter Item
 * @author Huy Nguyen
 */
public class ServiceFilterItem {

    String keywork;
    int image;

    public static final ServiceFilterItem[] items = {
            new ServiceFilterItem("cuisine", R.drawable.ic_restaurant_36dp),
            new ServiceFilterItem("attraction", R.drawable.ic_location_on_36dp),
            new ServiceFilterItem("hotel", R.drawable.ic_hotel_36dp),
            new ServiceFilterItem("vehicle", R.drawable.ic_local_taxi_36dp),
            new ServiceFilterItem("sim", R.drawable.ic_sim_card_36dp),
            new ServiceFilterItem("gift", R.drawable.ic_card_giftcard_36dp),
    };

    public ServiceFilterItem(String keywork, int image) {
        this.keywork = keywork;
        this.image = image;
    }

    public String getKeywork() {
        return keywork;
    }

    public int getImage() {
        return image;
    }
}
