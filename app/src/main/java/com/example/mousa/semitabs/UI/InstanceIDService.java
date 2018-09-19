package com.example.mousa.semitabs.UI;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

import static android.support.constraint.Constraints.TAG;

public class InstanceIDService extends FirebaseInstanceIdService {
   public static String  refreshedToken;
    @Override
    public void onTokenRefresh() {
         refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Log.d("rrrrrrrrrrreeeeeeeeee", "Refreshed token: " + refreshedToken);
    }
}
