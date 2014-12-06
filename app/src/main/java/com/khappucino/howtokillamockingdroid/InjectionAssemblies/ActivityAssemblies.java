package com.khappucino.howtokillamockingdroid.InjectionAssemblies;

import com.khappucino.howtokillamockingdroid.Activities.MainActivity;
import com.khappucino.howtokillamockingdroid.Services.JSONService;

/**
 * Created by spacehomunculus on 12/5/14.
 */
public class ActivityAssemblies {

    public static void inject(Object obj) {
        assert(false);
    }

    public static void inject(MainActivity activity) {
        // inject away
        activity.setJSONService(JSONService.getInstance());
    }

}
