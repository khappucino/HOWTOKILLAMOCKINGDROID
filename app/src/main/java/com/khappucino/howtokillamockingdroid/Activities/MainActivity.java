package com.khappucino.howtokillamockingdroid.Activities;

import android.app.Activity;
import android.os.Bundle;
import com.khappucino.howtokillamockingdroid.R;
import com.khappucino.howtokillamockingdroid.Application.MainApplication;
import com.khappucino.howtokillamockingdroid.Services.JSONService;
import com.khappucino.howtokillamockingdroid.Services.QuestionDownloadTask;

import java.util.Observable;
import java.util.Observer;


public class MainActivity extends Activity implements Observer{

    private JSONService jsonService;

    public boolean success = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((MainApplication)this.getApplication()).inject(this);
        setContentView(R.layout.activity_main);
    }

    public void setJSONService(JSONService jsonService) {
        this.jsonService = jsonService;
    }

    @Override
    public void update(Observable observable, Object data) {
        success = true;
    }

    public void doStuff() {
        QuestionDownloadTask qTask = jsonService.getQuestions();
        qTask.getObservable().addObserver(this);
        //qTask.execute();
    }

}
