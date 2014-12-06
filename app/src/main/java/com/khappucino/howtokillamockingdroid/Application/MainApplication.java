package com.khappucino.howtokillamockingdroid.Application;

import android.app.Application;

import com.khappucino.howtokillamockingdroid.InversionContainer.InversionContainer;

/**
 * Created by x37y on 12/5/14.
 */
public class MainApplication extends Application {

    public void inject(Object obj) {
        InversionContainer.inject(obj);
    }
}
