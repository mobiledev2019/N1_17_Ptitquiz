package com.example.quizapp;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Calendar;

public class Login extends AppCompatActivity {
    Button login;
    EditText idUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login = (Button) findViewById(R.id.btnLogin);
        idUser = (EditText) findViewById(R.id.idUser);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(idUser.getText() != null && !idUser.getText().equals("")) {
                    startActivity(new Intent(Login.this, MainActivity.class));
                    Intent intent = new Intent(Login.this
                            , AlarmNotificationReceiver.class);

                    PendingIntent pendingIntent = PendingIntent.getBroadcast(Login.this,0, intent,0);
                    Calendar calendar = Calendar.getInstance();
                    // Alarm
                    //  calendar.set(Calendar.DATE, 6);
                    calendar.set(Calendar.HOUR_OF_DAY,20);
                    calendar.set(Calendar.MINUTE,29);
                    AlarmManager alarmManager = (AlarmManager)getSystemService(Context.ALARM_SERVICE);

                    alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
                }
            }
        });
    }
}
