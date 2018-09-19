package com.example.mousa.semitabs.Notification;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class MyService extends BroadcastReceiver {
    int i=0;
    @Override
    public void onReceive(Context context, Intent intent) {
 final Bundle bundle=intent.getExtras();
 if(intent.getAction().equalsIgnoreCase("com.example.Broadcast")){
NewMessageNotification mynotify=new NewMessageNotification();
mynotify.notify(context,bundle.getString("msg"),123);
     Log.d("notifyyyyyyyyyyy",String.valueOf(i));
     i+=1;

 }
    }
}
