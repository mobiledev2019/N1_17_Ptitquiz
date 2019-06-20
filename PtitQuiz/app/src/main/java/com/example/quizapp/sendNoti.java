package com.example.quizapp;

import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.iid.FirebaseInstanceId;

import java.util.Calendar;

public class sendNoti extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sendnoti);
        Button button = (Button) findViewById(R.id.buttonShowNoti);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String token = FirebaseInstanceId.getInstance().getToken();
                Log.d(TAG, "Token: " + token);

                Toast.makeText(sendNoti.this, token,Toast.LENGTH_SHORT).show();
               Intent intent = new Intent(sendNoti.this
                       , AlarmNotificationReceiver.class);

                PendingIntent pendingIntent = PendingIntent.getBroadcast(sendNoti.this,0, intent,0);
                // time to noti
                Calendar calendar = Calendar.getInstance();

                // Alarm
                calendar.set(Calendar.HOUR_OF_DAY,22);
                calendar.set(Calendar.MINUTE,07);
                AlarmManager alarmManager = (AlarmManager)getSystemService(Context.ALARM_SERVICE);

                alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);



            }
        });
    }

}
