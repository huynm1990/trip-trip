package com.org.triptrip.common;

import com.org.triptrip.R;

/**
 * @author Huy Nguyen
 */
public class ServiceItem extends Item {

    private String title;
    private int image;
    private String dateCreated;
    private String phone;
    private String location;
    private int evaluation;

    public static final ServiceItem[] services = {
            new ServiceItem("Lengends Of Horror", R.drawable.travel_discussion,"28-Oct-2018", "0903999888", "Ha Noi", 10),
            new ServiceItem("Haunted Corn Maze At Mann Farms", R.drawable.travel_experience,"29-Oct-2018", "0903999777", "Hai Phong", 10),
            new ServiceItem("Cenesphere Fall Film Series", R.drawable.travel_guideline, "30-Oct-2018", "0903999666", "Da Nang", 10),
            new ServiceItem("Halloween Haunted At Canada's Wonderland", R.drawable.travel_services, "31-Oct-2018", "0903999555", "Ho Chi Minh", 10)
    };

    /**
     * Service constructor
     * @param title
     * @param image
     * @param dateCreated
     * @param phone
     * @param location
     * @param evaluation
     */
    public ServiceItem(String title, int image, String dateCreated, String phone, String location, int evaluation) {
        this.title = title;
        this.image = image;
        this.dateCreated = dateCreated;
        this.phone = phone;
        this.location = location;
        this.evaluation = evaluation;
    }

    /**
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @return image
     */
    public int getImage() {
        return image;
    }

    /**
     * @return dateCreated
     */
    public String getDateCreated() {
        return dateCreated;
    }

    /**
     * @return phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @return location
     */
    public String getLocation() {
        return location;
    }

    /**
     * @return evalution
     */
    public int getEvaluation() {
        return evaluation;
    }
}
