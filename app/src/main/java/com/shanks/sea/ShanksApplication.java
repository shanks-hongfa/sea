package com.shanks.sea;

import android.app.Application;

/**
 * Created by shanksYao on 9/15/15.
 */
public class ShanksApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ////
        RouterInit.init();
    }
}
