package com.khappucino.howtokillamockingdroid;

import android.content.Intent;
import android.test.ActivityUnitTestCase;

import com.khappucino.howtokillamockingdroid.Activities.MainActivity;
import com.khappucino.howtokillamockingdroid.Application.MainApplication;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */



public class ApplicationTest extends ActivityUnitTestCase<MainActivity> {

    public ApplicationTest() {
        super(MainActivity.class);
    }

    // CREATE YOUR MOCK APPLICATION CLASS
    private class Mocky extends MainApplication {
        public void inject(Object obj) {

        }
    }



    public void testStuff() {

        // INSTANTIATE MOCK
        Mocky mocky = new Mocky();
        // INJECT OUR MOCK
        setApplication(mocky);

        // START ACTIVITY
        startActivity(new Intent(getInstrumentation().getTargetContext(), MainActivity.class), null, null);

        // GRAB ACTIVITY
        MainActivity activity = getActivity();
        // MAKE SURE MOCK WORKED

    }

}