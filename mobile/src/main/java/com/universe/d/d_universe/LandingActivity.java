package com.universe.d.d_universe;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.transition.Explode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;

import butterknife.ButterKnife;

public class LandingActivity extends AppCompatActivity {

//    @Bind(R.id.fab) FloatingActionButton fab;
    FloatingActionButton iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //-- set window transitions
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        setIncomingTransition();
        setContentView(R.layout.activity_landing);
        ButterKnife.bind(this);

        // check the build version before applying the transition
        if(Build.VERSION.SDK_INT == Build.VERSION_CODES.LOLLIPOP){
            getWindow().setEnterTransition(new Explode());
            getWindow().setExitTransition(new Explode());
        }

        setFloatingActionButtonConfig(iv);

        /**
         * NOTE: Fragment Transactions...
        *If your activity allows the fragments to be removed and replaced,
        *you should add the initial fragment(s) to the activity during the activity's onCreate() method.
        */
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_universal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    void setIncomingTransition(){
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    private void setFloatingActionButtonConfig( FloatingActionButton fab){
       if(fab != null) {
           if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
               fab = (FloatingActionButton) findViewById(R.id.fab);

               fab.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View view) {
                       Intent intent = new Intent(getBaseContext(), Splash.class);
                       startActivity(intent);
                   }
               });

           }

       }
    } // end method setFloatingActionButtonConfig
}
