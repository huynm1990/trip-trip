package com.org.triptrip.enums;

import com.org.triptrip.R;

import java.util.HashMap;
import java.util.Map;

/**
 * Service Filter Item
 * @author Huy Nguyen
 */
public class CategoryKeywordEnum {

    private int id;
    private String keyword;
    private int image;

    public int getId() {
        return id;
    }

    public String getKeyword() {
        return keyword;
    }

    public int getImage() {
        return image;
    }

    public static final Map<Integer, CategoryKeywordEnum> VALUES = new HashMap<Integer, CategoryKeywordEnum>();

    private static CategoryKeywordEnum DISCUSSION = create(0, "HOTEL", R.drawable.ic_hotel_36dp);
    private static CategoryKeywordEnum CUISINE = create(1, "CUISINE", R.drawable.ic_restaurant_36dp);
    private static CategoryKeywordEnum ATTRACTION = create(2, "ATTRACTION", R.drawable.ic_location_on_36dp);
    private static CategoryKeywordEnum VEHICLE = create(3, "VEHICLE", R.drawable.ic_local_taxi_36dp);
    private static CategoryKeywordEnum SIM = create(4, "SIM", R.drawable.ic_sim_card_36dp);
    private static CategoryKeywordEnum GIFT = create(5, "GIFT", R.drawable.ic_card_giftcard_36dp);
    private static CategoryKeywordEnum OTHERS = create(6, "OTHERS", R.drawable.triptrip_logo);
    private static CategoryKeywordEnum TICKET = create(7, "TICKET", R.drawable.triptrip_logo);
    private static CategoryKeywordEnum HOTEL = create(8, "DISCUSSION", R.drawable.triptrip_logo);
    private static CategoryKeywordEnum VISA = create(9, "VISA", R.drawable.triptrip_logo);



    public CategoryKeywordEnum(int id, String keyword, int image) {
        this.id = id;
        this.keyword = keyword;
        this.image = image;
    }

    private static CategoryKeywordEnum create(int id, String name, int img) {
        CategoryKeywordEnum catKeyword = new CategoryKeywordEnum(id, name, img);
        VALUES.put(id, catKeyword);
        return catKeyword;
    }

    public static CategoryKeywordEnum valueOf(int id) {
        return VALUES.get(id);
    }
}
