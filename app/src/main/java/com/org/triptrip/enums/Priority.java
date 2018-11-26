package com.org.triptrip.enums;

import com.org.triptrip.R;
import com.org.triptrip.common.Item;

import java.util.HashMap;
import java.util.Map;

public class Priority extends Item {

    private int id;
    private String keyword;
    private int img;
    private String title;

    public static final Map<Integer, Priority> VALUES = new HashMap<Integer, Priority>();

    public static Priority LATEST = create(0, "LATEST", R.drawable.ic_schedule_15dp, "Latest");
    public static Priority FAVOURITE = create(1, "FAVOURITE", R.drawable.ic_favorite_black_15dp, "Favorite");
    public static Priority LOWEST_FIRST = create(2, "LOWEST_FIRST",R.drawable.ic_arrow_downward_15dp, "Price down");
    public static Priority HIGHEST_FIRST = create(3, "HIGHEST_FIRST",R.drawable.ic_arrow_upward_15dp, "Price up");
    public static Priority RELEVANT = create(4, "RELEVANT",R.drawable.triptrip_logo, "Relevant");

    public Priority(int id, String keyword, int img, String title) {
        this.keyword = keyword;
        this.img = img;
        this.title = title;
    }

    private static Priority create(int id, String keyword, int img, String title) {
        Priority orderItem = new Priority(id, keyword, img, title);
        VALUES.put(id, orderItem);
        return orderItem;
    }

    public int getId() {
        return id;
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

    public static Priority valueOf(Integer id) {
        return VALUES.get(id);
    }
}
