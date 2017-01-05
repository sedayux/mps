package com.metroparcel.mps;

import android.app.Application;

import com.metroparcel.mps.conn.WebserviceHelper;

/**
 * Created by sedayu on 12/6/2016.
 */

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        WebserviceHelper.initialize();
    }
}
