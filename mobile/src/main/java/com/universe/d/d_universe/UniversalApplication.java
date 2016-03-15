package com.universe.d.d_universe;

import android.app.Application;
import android.os.Build;

/**
 * Created by Who Dat on 3/15/2016.
 * This class has snippets of version checking to show Material Design features when possible
 */
public class UniversalApplication extends Application {

    //---check if we're running on Android 5.0 or higher
    public void checkVersion(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            // call some material design APIs here
        }else{
            // implement this feature without material design
        }

    }
}
