package com.org.triptrip.enums;

import com.org.triptrip.R;

import java.util.HashMap;
import java.util.Map;

/**
 * Priority Enum
 * @author Huy Nguyen
 */
public class OrderEnum {

    private int id;
    private String keyword;
    private int img;
    private String title;

    /**
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * @return keyword
     */
    public String getKeyword() {
        return keyword;
    }

    /**
     * @return image
     */
    public int getImage() {
        return img;
    }

    /**
     * @return title
     */
    public String getTitle() {
        return title;
    }

    public static final Map<Integer, OrderEnum> VALUES = new HashMap<Integer, OrderEnum>();

    public static OrderEnum LATEST = create(0, "LATEST", R.drawable.ic_schedule_15dp, "Latest");
    public static OrderEnum FAVOURITE = create(1, "FAVOURITE", R.drawable.ic_favorite_black_15dp, "Favorite");
    public static OrderEnum LOWEST_FIRST = create(2, "LOWEST_FIRST",R.drawable.ic_arrow_downward_15dp, "Price down");
    public static OrderEnum HIGHEST_FIRST = create(3, "HIGHEST_FIRST",R.drawable.ic_arrow_upward_15dp, "Price up");
    public static OrderEnum RELEVANT = create(4, "RELEVANT",R.drawable.triptrip_logo, "Relevant");

    /**
     * PriorityEnum constructor
     * @param id
     * @param keyword
     * @param img
     * @param title
     */
    public OrderEnum(int id, String keyword, int img, String title) {
        this.id = id;
        this.keyword = keyword;
        this.img = img;
        this.title = title;
    }

    /**
     * Create new PriorityEnum
     * @param id
     * @param keyword
     * @param img
     * @param title
     * @return PriorityEnum object
     */
    private static OrderEnum create(int id, String keyword, int img, String title) {
        OrderEnum orderItem = new OrderEnum(id, keyword, img, title);
        VALUES.put(id, orderItem);
        return orderItem;
    }

    /**
     * Return PriorityEnum  at position (id)
     * @param id
     * @return PriorityEnum object
     */
    public static OrderEnum valueOf(Integer id) {
        return VALUES.get(id);
    }
}
