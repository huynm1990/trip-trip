package com.org.triptrip;

/**
 * @author Huy Nguyen
 */
public class Event {

    private String title;
    private String eventType;
    private String region;
    private String date;

    public static final Event[] events = {
            new Event("Lengends Of Horror", "Festival", "Toronto", "28-31 Oct"),
            new Event("Haunted Corn Maze At Mann Farms", "Halloween", "Vancouver", "03-05 Nov"),
            new Event("Cenesphere Fall Film Series", "Entertaiment", "Toronto", "04-06 Dec"),
            new Event("Halloween Haunted At Canada's Wonderland", "Music", "Vancouver", "07-09 Dec")
    };

    /**
     * Event constructor
     *
     * @param title title
     * @param eventType event type
     * @param region region
     * @param date date
     */
    public Event(String title, String eventType, String region, String date) {
        this.title = title;
        this.eventType = eventType;
        this.region = region;
        this.date = date;
    }

    /**
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @return eventType
     */
    public String getEventType() {
        return eventType;
    }

    /**
     * @return region
     */
    public String getRegion() {
        return region;
    }

    /**
     * @return date
     */
    public String getDate() {
        return date;
    }
}
