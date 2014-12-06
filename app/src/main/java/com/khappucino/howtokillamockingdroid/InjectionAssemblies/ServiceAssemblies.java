package com.khappucino.howtokillamockingdroid.InjectionAssemblies;

import com.khappucino.howtokillamockingdroid.Services.JSONService;
import com.khappucino.howtokillamockingdroid.Services.QuestionDownloadTask;

import org.apache.http.client.HttpClient;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.HttpParams;

/**
 * Created by spacehomunculus on 12/5/14.
 */
public class ServiceAssemblies {

    public static void inject(Object obj) {
        assert(false);
    }

    public static void inject(JSONService jsonService) {
        HttpClient client = new DefaultHttpClient();
        ClientConnectionManager mgr = client.getConnectionManager();
        HttpParams params = client.getParams();
        client = new DefaultHttpClient(
                new ThreadSafeClientConnManager(params,
                        mgr.getSchemeRegistry()), params);
        jsonService.setHTTPClient(client);
    }

}
