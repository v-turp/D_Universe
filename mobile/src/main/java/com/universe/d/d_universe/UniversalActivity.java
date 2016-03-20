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
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;

import butterknife.Bind;
import butterknife.ButterKnife;

public class UniversalActivity extends AppCompatActivity {

    @Bind(R.id.fab) FloatingActionButton fab;
    @Bind(R.id.toolbar) Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //-- set window transitions
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        setIncomingTransition();
        setContentView(R.layout.activity_universal);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        // check the build version before applying the transition
        if(Build.VERSION.SDK_INT == Build.VERSION_CODES.LOLLIPOP){
            getWindow().setEnterTransition(new Explode());
            getWindow().setExitTransition(new Explode());
        }

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), Landing.class);
                startActivity(intent);
            }
        });
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
}
