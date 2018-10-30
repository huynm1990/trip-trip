package com.org.triptrip.common;

import com.org.triptrip.R;

/**
 * Experience class
 * @author Huy Nguyen
 */
public class Experience {

    private String title;
    private int image;
    private String dateCreated;

    public static final Experience[] experiences = {
            new Experience("Lengends Of Horror", R.drawable.travel_discussion,"28-Oct-2018"),
            new Experience("Haunted Corn Maze At Mann Farms", R.drawable.travel_experience,"29-Oct-2018"),
            new Experience("Cenesphere Fall Film Series", R.drawable.travel_guideline, "30-Oct-2018"),
            new Experience("Halloween Haunted At Canada's Wonderland", R.drawable.travel_services, "31-Oct-2018")
    };

    /**
     * Experience constructor
     * @param title
     * @param image
     * @param dateCreated
     */
    public Experience(String title, int image, String dateCreated) {
        this.title = title;
        this.image = image;
        this.dateCreated = dateCreated;
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
}
