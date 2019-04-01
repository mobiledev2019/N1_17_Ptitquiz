package com.example.quizapp;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.widget.Button;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

public class FireBaseInstanceService extends FirebaseInstanceIdService {
    private static final String TAG = "MyFirebaseInsIDService";
    private static String NOTIFICATION_ID = "notification-id";
    @Override
    public void onTokenRefresh() {
        //get update token
        String refeshToken = FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG, "New Token: " + refeshToken);

    }

}
