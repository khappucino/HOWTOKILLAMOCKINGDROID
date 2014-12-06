package com.khappucino.howtokillamockingdroid.InjectionAssemblies;

import com.khappucino.howtokillamockingdroid.Services.JSONService;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;

/**
 * Created by spacehomunculus on 12/5/14.
 */
public class ServiceAssemblies {

    public static void inject(Object obj) {
        assert(false);
    }

    public static void inject(JSONService jsonService) {
        jsonService.setHTTPClient(new DefaultHttpClient());
    }
}
