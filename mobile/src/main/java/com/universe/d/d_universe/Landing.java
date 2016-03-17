package com.universe.d.d_universe;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.transition.Explode;
import android.view.View;
import android.view.Window;

import butterknife.Bind;
import butterknife.ButterKnife;

public class Landing extends AppCompatActivity {

    @Bind(R.id.fab) FloatingActionButton fab;
    @Bind(R.id.toolbar) Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //-- set window transitions
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        setContentView(R.layout.activity_landing);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // check the build version before applying the transition
        if(Build.VERSION.SDK_INT == Build.VERSION_CODES.LOLLIPOP){
            getWindow().setEnterTransition(new Explode());
            getWindow().setExitTransition(new Explode());
        }

        // set the timing for the page to be displayed
        new View(this).postDelayed(new Runnable() {

            @Override
            public void run() {
                Intent intent = new Intent(getBaseContext(), UniversalActivity.class);
                startActivity(intent);
            }
        }, 5000);
    }

}
