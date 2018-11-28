package com.org.triptrip.common;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

@SuppressWarnings("serial")
@Getter
@AllArgsConstructor
public class JSONUrl implements Serializable {
    private int page;
    private int size;
    private List<JSONFilter> filtersJson;
    private String sort;

    @Override
    public String toString() {

        return "page=" + page
                + "&size=" + size
                + "&filterJson=" + filtersJson.toString()
                + "&sort=" + sort;
    }

}
