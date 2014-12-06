package com.example.x37y.mocky;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends Activity {

    public boolean didStubWork = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Object jsonService = ((MainApplication)this.getApplication()).getService();

        if(jsonService != null) {
            didStubWork = true;
        }
    }

}
