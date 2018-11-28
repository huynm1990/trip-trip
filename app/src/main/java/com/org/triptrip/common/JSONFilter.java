package com.org.triptrip.common;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;

@SuppressWarnings("serial")
@Getter
@AllArgsConstructor
public class JSONFilter  implements Serializable {
    private String key;
    private String operator;
    private String value;

    @Override
    public String toString() {
        return "{\"key\":\"" + key + "\", "
                + "\"operator\":\"" + operator + "\", "
                + "\"value\":\"" + value + "\"}";
    }
}
