package com.example.quizapp;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.SystemClock;
import android.support.v4.app.AlarmManagerCompat;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.Calendar;

public class MyFirebaseMessagingService extends FirebaseMessagingService {
    private static final String TAG = "MyFirebaseMsgService";

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {

        Log.d(TAG, "FROM:" + remoteMessage.getFrom());

        //check if the message contains data
        if(remoteMessage.getData().size() > 0 ){
            Log.d(TAG, "Message data:" + remoteMessage.getData());
        }
        //check if the message contain noti

        if(remoteMessage.getNotification() != null) {
            Log.d(TAG, "Mesaage body:" + remoteMessage.getNotification().getBody());
            setAlarm();
       }
    }

    /**
     * @param
     */
    private void scheduleNotification(NotificationManager notificationManager, int delay) {

    }
    public void setAlarm(){

    }

}
