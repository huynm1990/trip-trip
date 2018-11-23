package com.org.triptrip.webservice;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

public class BaseJSONRestClient {

    //https://api.triptrip.online/v1/items?page=0&size=10&sort=updated,desc&filterJson=[{%22key%22:%22itemType%22,%22operator%22:%22=%22,%22value%22:%22SERVICE%22},{%22key%22:%22categoryKeyword%22,%22operator%22:%22=%22,%22value%22:%HOTEL%22},{%22key%22:%22priority%22,%22operator%22:%22=%22,%22value%22:%LATEST%22}]
    private static final String BASE_URL = "https://api.triptrip.online/v1/";

    private static AsyncHttpClient client = new AsyncHttpClient();

    public static void get(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        client.get(getAbsoluteUrl(url), params, responseHandler);
    }

    public static void post(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        client.post(getAbsoluteUrl(url), params, responseHandler);
    }

    private static String getAbsoluteUrl(String relativeUrl) {
        return BASE_URL + relativeUrl;
    }
}
