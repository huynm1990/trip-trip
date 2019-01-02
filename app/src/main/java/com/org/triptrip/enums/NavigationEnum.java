package com.org.triptrip.enums;

import com.org.triptrip.R;
import com.org.triptrip.common.EventsNavigationType;
import com.org.triptrip.common.ExperiencesNavigationType;
import com.org.triptrip.common.NavigationType;
import com.org.triptrip.common.ServicesNavigationType;

import java.util.HashMap;
import java.util.Map;

/**
 * Navigation Enum
 * @author Huy Nguyen
 */
public class NavigationEnum {

    private int id;
    private NavigationType navigationType;

    /**
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * @return navigationType
     */
    public NavigationType getNavigationType() {
        return navigationType;
    }

    public static final Map<Integer, NavigationEnum> VALUES = new HashMap<Integer, NavigationEnum>();

    public static NavigationEnum EVENTS = create(R.id.navigation_events , new EventsNavigationType(R.id.navigation_events, "EVENTS", R.layout.card_events));
    public static NavigationEnum SERVICE = create(R.id.navigation_services , new ServicesNavigationType(R.id.navigation_services, "SERVICE", R.layout.card_services));
    public static NavigationEnum EXPERIENCE = create(R.id.navigation_experiences , new ExperiencesNavigationType(R.id.navigation_experiences, "SERVICE", R.layout.card_experience));
    public static NavigationEnum TRANSLATION = create(0 , new ServicesNavigationType(0, "TRANSLATION", 0));
    public static NavigationEnum COLLECTIONS = create(1 ,new ServicesNavigationType(0, "TRANSLATION", 1));


    /**
     * NavigationEnum constructor
     * @param id
     * @param navigationType
     */
    private NavigationEnum(int id, NavigationType navigationType) {
        this.id = id;
        this.navigationType = navigationType;
    }

    /**
     * Create new NavigationEnum
     * @param id
     * @param navigationType
     * @return NavigationEnum object
     */
    private static NavigationEnum create(int id, NavigationType navigationType) {
        NavigationEnum navEnum = new NavigationEnum(id, navigationType);
        VALUES.put(id, navEnum);
        return navEnum;
    }

    /**
     * Return NavigationEnum at position (id)
     * @param id
     * @return NavigationEnum object
     */
    public static NavigationEnum valueOf(Integer id) {
        return VALUES.get(id);
    }

}
