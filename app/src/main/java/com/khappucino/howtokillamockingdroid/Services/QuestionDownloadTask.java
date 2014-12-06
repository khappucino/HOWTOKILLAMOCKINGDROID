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
 * Created by spacehomunculus on 12/6/14.
 */

public class QuestionDownloadTask extends AsyncTask<Void, Void, Void> {

    private QuestionObservable observable;
    private HttpClient httpClient;
    private ArrayList<String> data;

    public QuestionDownloadTask(HttpClient httpClient) {
        observable = new QuestionObservable();
        this.httpClient = httpClient;
    }


    public QuestionObservable getObservable() {
        return observable;
    }

    @Override
    protected Void doInBackground(Void... params) {

        // Prepare a request object
        HttpGet httpget = new HttpGet("");

        // Execute the request
        HttpResponse response;
        try {
            response = httpClient.execute(httpget);

            // Get hold of the response entity
            HttpEntity entity = response.getEntity();
            // If the response does not enclose an entity, there is no need
            // to worry about connection release

            if (entity != null) {

                // A Simple JSON Response Read
                InputStream instream = entity.getContent();
                //String result= convertStreamToString(instream);
                // now you have the string representation of the HTML request
                instream.close();

                data = null;
            }


        } catch (Exception e) {}
        return null;
    }

    @Override
    protected void onPostExecute(Void params) {
        // update observable
    }
}