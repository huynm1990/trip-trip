package com.org.triptrip.enums;

public enum Priority {
    LATEST("LATEST"),
    RELEVANT("RELEVANT"),
    FAVOURITE("FAVOURITE"),
    LOWEST_FIRST("LOWEST_FIRST"),
    HIGHEST_FIRST("HIGHEST_FIRST");


    private final String name;

    private Priority(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
