package com.example.x37y.mocky;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.test.ActivityUnitTestCase;
import android.test.ApplicationTestCase;
import android.test.mock.MockApplication;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */



public class ApplicationTest extends ActivityUnitTestCase<MainActivity> {

    public ApplicationTest() {
        super(MainActivity.class);
    }

    // CREATE YOUR MOCK APPLICATION CLASS
    private class Mocky extends MainApplication {
        public Object getService() {
            return new Object();
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
        assertTrue(activity.didStubWork == true);
    }

}