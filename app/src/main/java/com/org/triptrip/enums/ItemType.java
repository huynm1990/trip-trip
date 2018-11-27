package com.org.triptrip.enums;

import com.org.triptrip.R;

import java.util.HashMap;
import java.util.Map;

public class ItemType {

    private int id;
    private String name;

    public static final Map<Integer, ItemType> VALUES = new HashMap<Integer, ItemType>();

    public static ItemType EVENTS = create(R.id.navigation_events ,"EVENTS");
    public static ItemType SERVICE = create(R.id.navigation_services ,"SERVICE");
    public static ItemType EXPERIENCE = create(R.id.navigation_experiences ,"EXPERIENCE");
    public static ItemType TRANSLATION = create(0 ,"TRANSLATION");
    public static ItemType COLLECTIONS = create(1 ,"COLLECTIONS");


    private ItemType(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    private static ItemType create(int id, String name) {
        ItemType itemType = new ItemType(id, name);
        VALUES.put(id, itemType);
        return itemType;
    }

    public static ItemType valueOf(Integer id) {
        return VALUES.get(id);
    }
}
