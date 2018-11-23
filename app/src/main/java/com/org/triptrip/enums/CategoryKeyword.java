package com.org.triptrip.enums;

public enum CategoryKeyword {
    DISCUSSION("DISCUSSION"),
    CUISINE("CUISINE"),
    ATTRACTION("ATTRACTION"),
    TICKET("TICKET"),
    HOTEL("HOTEL"),
    VISA("VISA"),
    VEHICLE("VEHICLE"),
    SIM("SIM"),
    GIFT("GIFT"),
    OTHERS("OTHERS");

    private final String name;

    private CategoryKeyword(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
