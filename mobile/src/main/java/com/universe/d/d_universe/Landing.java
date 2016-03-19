package com.universe.d.d_universe;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.transition.Explode;
import android.view.View;
import android.view.Window;

import butterknife.ButterKnife;

public class Landing extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //-- set window transitions
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        setContentView(R.layout.activity_landing);
        ButterKnife.bind(this);

        // check the build version before applying the transition
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            getWindow().setEnterTransition(new Explode());
            getWindow().setExitTransition(new Explode());
        }

        showFullScreen();
        addScreenTransitionDelay(5000);
    } // end method onCreate

    @Override
    protected void onResume() {
        super.onResume();
        showFullScreen();
        addScreenTransitionDelay(5000);

    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    private void addScreenTransitionDelay(@Nullable int timeDelay){
        // set the timing for the page to be displayed
        if(timeDelay < 0){
            timeDelay = 3000;
        }
        new View(this).postDelayed(new Runnable() {

            @Override
            public void run() {
                Intent intent = new Intent(getBaseContext(), UniversalActivity.class);
                startActivity(intent);
            }
        }, timeDelay);
    }
    private void showFullScreen(){
        /**
         * this enables fullscreen for version 4.1+
         * */
        View decorView = getWindow().getDecorView();
        // Hide the status bar.
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
    }
}
