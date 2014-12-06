package com.khappucino.howtokillamockingdroid;

import android.content.Intent;
import android.test.ActivityUnitTestCase;

import com.khappucino.howtokillamockingdroid.Activities.MainActivity;
import com.khappucino.howtokillamockingdroid.Application.MainApplication;
import com.khappucino.howtokillamockingdroid.Services.JSONService;
import com.khappucino.howtokillamockingdroid.Services.ObservableTypes.QuestionObservable;
import com.khappucino.howtokillamockingdroid.Services.QuestionDownloadTask;

import static org.mockito.Mockito.*;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */



public class ApplicationTest extends ActivityUnitTestCase<MainActivity> {

    public ApplicationTest() {
        super(MainActivity.class);
    }

    private QuestionObservable testObservable;

    // CREATE YOUR MOCK APPLICATION CLASS
    private class Mocky extends MainApplication {
        public void inject(Object obj) {
            // inject main activity stuff
            if(obj.getClass().equals(MainActivity.class)) {

                // create mock jsonservice that we are going to return
                JSONService mockJSONService = mock(JSONService.class);

                QuestionDownloadTask questionDownloadTask = mock(QuestionDownloadTask.class);
                testObservable = new QuestionObservable();
                when(questionDownloadTask.getObservable()).thenReturn(testObservable);

                when(mockJSONService.getQuestions()).thenReturn(questionDownloadTask);

                // inject our jsonservice into the activity magically
                MainActivity mainActivity = (MainActivity)obj;
                mainActivity.setJSONService(mockJSONService);

            }
        }
    }


    @Override
    protected void setUp() throws Exception {

        super.setUp();

        System.setProperty( "dexmaker.dexcache", getInstrumentation().getTargetContext().getCacheDir().getPath() );

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
        activity.doStuff();
        // MAKE SURE MOCK WORKED
        // Lets go ahead and trigger the testObservable notify to act like we just downloaded something
        testObservable.triggerChange();
        assertTrue(activity.success == true);


    }

}