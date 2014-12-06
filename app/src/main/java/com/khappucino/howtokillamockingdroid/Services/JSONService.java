package com.khappucino.howtokillamockingdroid.Services;

import com.khappucino.howtokillamockingdroid.InversionContainer.InversionContainer;

import org.apache.http.client.HttpClient;

import java.util.ArrayList;

/**
 * Created by spacehomunculus on 12/5/14.
 */
public class JSONService {

    static JSONService instance;

    private HttpClient httpClient;

    public static JSONService getInstance() {
        if(instance == null) {
            instance = new JSONService();
        }
        return instance;
    }

    public JSONService() {
        InversionContainer.inject(this);
    }

    public void setHTTPClient(HttpClient httpClient) {
        this.httpClient = httpClient;
    }
}
