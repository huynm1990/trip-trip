package com.org.triptrip.common;

/**
 * @author Huy Nguyen
 */
public class Event {

    private String title;
    private String eventType;
    private String region;
    private String fromDate;
    private String toDate;

    public static final Event[] events = {
            new Event("Lengends Of Horror", "Festival", "Toronto", "01-Oct-2018", "05-Oct-2018"),
            new Event("Haunted Corn Maze At Mann Farms", "Halloween", "Vancouver", "07-Nov-2018", "10-Nov-2018"),
            new Event("Cenesphere Fall Film Series", "Entertaiment", "Toronto", "12-Nov-2018", "16-Nov-2018"),
            new Event("Halloween Haunted At Canada's Wonderland", "Music", "Vancouver", "01-Dec-2018", "03-Dec-2018")
    };

    /**
     * Event constructor
     *
     * @param title title
     * @param eventType event type
     * @param region region
     * @param fromDate from date
     * @param toDate to date
     */
    public Event(String title, String eventType, String region, String fromDate, String toDate) {
        this.title = title;
        this.eventType = eventType;
        this.region = region;
        this.fromDate = fromDate;
        this.toDate = toDate;
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
     * @return from date
     */
    public String getFromDate() {
        return fromDate;
    }

    /**
     * @return to date
     */
    public String getToDate() {
        return toDate;
    }
}
