package com.org.triptrip.enums;

import com.org.triptrip.R;

import java.util.HashMap;
import java.util.Map;

/**
 * Priority Enum
 * @author Huy Nguyen
 */
public class PriorityEnum {

    private int id;
    private String keyword;
    private int img;
    private String title;

    public int getId() {
        return id;
    }

    public String getKeyword() {
        return keyword;
    }

    public int getImage() {
        return img;
    }

    public String getTitle() {
        return title;
    }

    public static final Map<Integer, PriorityEnum> VALUES = new HashMap<Integer, PriorityEnum>();

    public static PriorityEnum LATEST = create(0, "LATEST", R.drawable.ic_schedule_15dp, "Latest");
    public static PriorityEnum FAVOURITE = create(1, "FAVOURITE", R.drawable.ic_favorite_black_15dp, "Favorite");
    public static PriorityEnum LOWEST_FIRST = create(2, "LOWEST_FIRST",R.drawable.ic_arrow_downward_15dp, "Price down");
    public static PriorityEnum HIGHEST_FIRST = create(3, "HIGHEST_FIRST",R.drawable.ic_arrow_upward_15dp, "Price up");
    public static PriorityEnum RELEVANT = create(4, "RELEVANT",R.drawable.triptrip_logo, "Relevant");

    public PriorityEnum(int id, String keyword, int img, String title) {
        this.id = id;
        this.keyword = keyword;
        this.img = img;
        this.title = title;
    }

    private static PriorityEnum create(int id, String keyword, int img, String title) {
        PriorityEnum orderItem = new PriorityEnum(id, keyword, img, title);
        VALUES.put(id, orderItem);
        return orderItem;
    }

    public static PriorityEnum valueOf(Integer id) {
        return VALUES.get(id);
    }
}
