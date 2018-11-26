package com.org.triptrip.enums;

import com.org.triptrip.R;
import com.org.triptrip.common.Item;

import java.util.HashMap;
import java.util.Map;

/**
 * Service Filter Item
 * @author Huy Nguyen
 */
public class CategoryKeyword extends Item {

    private int id;
    String keyword;
    int image;

    public static final Map<Integer, CategoryKeyword> VALUES = new HashMap<Integer, CategoryKeyword>();

    private static CategoryKeyword DISCUSSION = create(0, "HOTEL", R.drawable.ic_hotel_36dp);
    private static CategoryKeyword CUISINE = create(1, "CUISINE", R.drawable.ic_restaurant_36dp);
    private static CategoryKeyword ATTRACTION = create(2, "ATTRACTION", R.drawable.ic_location_on_36dp);
    private static CategoryKeyword TICKET = create(3, "TICKET", R.drawable.triptrip_logo);
    private static CategoryKeyword HOTEL = create(4, "DISCUSSION", R.drawable.triptrip_logo);
    private static CategoryKeyword VISA = create(5, "VISA", R.drawable.triptrip_logo);
    private static CategoryKeyword VEHICLE = create(6, "VEHICLE", R.drawable.ic_local_taxi_36dp);
    private static CategoryKeyword SIM = create(7, "SIM", R.drawable.ic_sim_card_36dp);
    private static CategoryKeyword GIFT = create(7, "GIFT", R.drawable.ic_card_giftcard_36dp);
    private static CategoryKeyword OTHERS = create(7, "OTHERS", R.drawable.triptrip_logo);



    public CategoryKeyword(int id, String keyword, int image) {
        this.id = id;
        this.keyword = keyword;
        this.image = image;
    }

    private static CategoryKeyword create(int id, String name, int img) {
        CategoryKeyword catKeyword = new CategoryKeyword(id, name, img);
        VALUES.put(id, catKeyword);
        return catKeyword;
    }

    public int getId() {
        return id;
    }

    public String getKeyword() {
        return keyword;
    }

    public int getImage() {
        return image;
    }

    public static CategoryKeyword valueOf(int id) {
        return VALUES.get(id);
    }
}
