package com.example.jack.allergyanalyzer;

import android.app.IntentService;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by Jack on 11/29/2017.
 */

public class PersistentDataService extends Service  {


    String cName = null;
    String cEmail = null;
    boolean cGend;
    ArrayList<String> cAllergies = null;


    private final IBinder mBinder = new LocalBinder();

    public class LocalBinder extends Binder {
        PersistentDataService getService() {
            return PersistentDataService.this;
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId)
    {
        cName = intent.getStringExtra("name");
        cEmail = intent.getStringExtra("email");
        cGend = intent.getBooleanExtra("gender",true);
        cAllergies = intent.getStringArrayListExtra("allergies");


        Log.e("     in On Start", cName);
        Log.e("     in On Start", cAllergies.get(0));

        return START_REDELIVER_INTENT;
    }

}
