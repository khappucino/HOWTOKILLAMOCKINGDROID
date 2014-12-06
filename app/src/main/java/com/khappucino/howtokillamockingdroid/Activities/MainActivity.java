package com.khappucino.howtokillamockingdroid.Activities;

import android.app.Activity;
import android.os.Bundle;

import com.example.x37y.mocky.R;
import com.khappucino.howtokillamockingdroid.Application.MainApplication;
import com.khappucino.howtokillamockingdroid.Services.JSONService;


public class MainActivity extends Activity {

    private JSONService jsonService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((MainApplication)this.getApplication()).inject(this);

        setContentView(R.layout.activity_main);
    }

    public void setJSONService(JSONService jsonService) {
        this.jsonService = jsonService;
    }

}
