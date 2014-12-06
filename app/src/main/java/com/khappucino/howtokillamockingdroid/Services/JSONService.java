package com.khappucino.howtokillamockingdroid.Services;

import android.os.AsyncTask;

import com.khappucino.howtokillamockingdroid.InversionContainer.InversionContainer;
import com.khappucino.howtokillamockingdroid.Services.ObservableTypes.QuestionObservable;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;

import java.io.InputStream;
import java.net.URL;
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

    public QuestionDownloadTask getQuestions() {
        return new QuestionDownloadTask(httpClient);
    }




}
