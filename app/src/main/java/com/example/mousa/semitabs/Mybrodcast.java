package com.example.mousa.semitabs;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Matrix;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

/**
 * Created by Mousa on 3/1/2018.
 */

public class Mybrodcast extends BroadcastReceiver {
    public static int flog=0;
   public static NetworkInfo ni;

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("app", "Network connectivity change");
        if (intent.getExtras() != null) {
            NetworkInfo ni = (NetworkInfo) intent.getExtras().get(ConnectivityManager.EXTRA_NETWORK_INFO);
            if (ni != null && ni.getState() == NetworkInfo.State.CONNECTED) {
                Log.i("app", "Network " + ni.getTypeName() + " connected");
                flog=1;

            } else if (intent.getBooleanExtra(ConnectivityManager.EXTRA_NO_CONNECTIVITY, Boolean.FALSE)) {
                Log.d("app", "There's no network connectivity");
                flog=2;



            }

        }
    }
}
