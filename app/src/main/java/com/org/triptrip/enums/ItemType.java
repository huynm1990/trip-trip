package com.org.triptrip.enums;

public enum ItemType {
    EXPERIENCE("EXPERIENCE"),
    TRANSLATION("TRANSLATION"),
    COLLECTIONS("COLLECTIONS"),
    SERVICE("SERVICE");

    private final String name;

    private ItemType(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
