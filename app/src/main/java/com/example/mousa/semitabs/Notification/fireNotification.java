package com.example.mousa.semitabs.Notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

import com.example.mousa.semitabs.MainActivity;
import com.example.mousa.semitabs.R;
import com.example.mousa.semitabs.UI.Start;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import org.json.JSONException;
import org.json.JSONObject;

public class fireNotification extends FirebaseMessagingService {
    public static boolean serviceIsrun=false;
    String type="";

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        if (serviceIsrun) {
            if (remoteMessage.getData().size() > 0) {
                type = "json";
                sendNotification(remoteMessage.getData().toString());

            }
            if (remoteMessage.getNotification() != null) {
                type = "message";
                sendNotification(remoteMessage.getNotification().getBody());
            }
            super.onMessageReceived(remoteMessage);
        }
    }
    private void sendNotification(String MessageBody) {
        String id, message = "", title = "";
        if (type.equals("json")) {

            try {
                JSONObject jsonObject = new JSONObject(MessageBody);
                id = jsonObject.getString("id");
                message = jsonObject.getString("message");
                title = jsonObject.getString("title");
            } catch (JSONException e) {
                e.printStackTrace();
            }

        } else if (type.equals("message")) {
            message = MessageBody;

        }

        Intent intent = new Intent(this,MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_ONE_SHOT);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setContentTitle(title);
        builder.setContentText(message);
        builder.setSmallIcon(R.drawable.logopp);
        builder.setAutoCancel(true);
        builder.setContentIntent(pendingIntent);
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0, builder.build());


    }

}
