package com.khappucino.howtokillamockingdroid.InversionContainer;

import com.khappucino.howtokillamockingdroid.Activities.MainActivity;
import com.khappucino.howtokillamockingdroid.InjectionAssemblies.ActivityAssemblies;
import com.khappucino.howtokillamockingdroid.InjectionAssemblies.ServiceAssemblies;
import com.khappucino.howtokillamockingdroid.Services.JSONService;

/**
 * Created by spacehomunculus on 12/5/14.
 */
public class InversionContainer {

    public static void inject(Object obj) {

        // MainActivity
        if(obj.getClass().equals(MainActivity.class)) {
            ActivityAssemblies.inject((MainActivity) obj);
        }


        // JSONService
        else if(obj.getClass().equals(JSONService.class)) {
            ServiceAssemblies.inject((JSONService) obj);
        }


    }

}
