package com.org.triptrip.enums;

import java.util.HashMap;
import java.util.Map;

public class Priority {

    private static final Map<Integer, Priority> VALUES = new HashMap<Integer, Priority>();

    public static Priority LATEST = create(0, "LATEST");
    public static Priority RELEVANT = create(1, "RELEVANT");
    public static Priority FAVOURITE = create(2, "FAVOURITE");
    public static Priority LOWEST_FIRST = create(3, "LOWEST_FIRST");
    public static Priority HIGHEST_FIRST = create(4, "HIGHEST_FIRST");

    private int id;
    private String name;

    private Priority(int id, String name) {
        this.id = id;
        this.name = name;
    }

    private static Priority create(int id, String name) {
        Priority priority = new Priority(id, name);
        VALUES.put(id, priority);
        return priority;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public static Priority valueOf(Integer id) {
        return VALUES.get(id);
    }
}
