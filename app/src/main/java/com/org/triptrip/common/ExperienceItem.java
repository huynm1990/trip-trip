package com.org.triptrip.common;

import com.org.triptrip.R;

/**
 * Experience class
 * @author Huy Nguyen
 */
public class ExperienceItem extends Item {

    private String title;
    private int image;
    private String dateCreated;

    public static final ExperienceItem[] experiences = {
            new ExperienceItem("Lengends Of Horror", R.drawable.travel_discussion,"28-Oct-2018"),
            new ExperienceItem("Haunted Corn Maze At Mann Farms", R.drawable.travel_experience,"29-Oct-2018"),
            new ExperienceItem("Cenesphere Fall Film Series", R.drawable.travel_guideline, "30-Oct-2018"),
            new ExperienceItem("Halloween Haunted At Canada's Wonderland", R.drawable.travel_services, "31-Oct-2018")
    };

    /**
     * Experience constructor
     * @param title
     * @param image
     * @param dateCreated
     */
    public ExperienceItem(String title, int image, String dateCreated) {
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
