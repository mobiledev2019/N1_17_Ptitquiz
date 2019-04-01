package com.example.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnTest, btnSetAlarm,btnTarget,btnNoti;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getButton();
        btnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Exam", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, LessonActivity.class));
            }
        });
        btnNoti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "noti", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this,sendNoti.class));
            }
        });
        btnSetAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,setAlarm.class));
            }
        });
        btnTarget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,list_item_target.class));
            }
        });
    }
    public  void getButton(){
        btnTest = (Button) findViewById(R.id.btnTest);
        btnSetAlarm = (Button) findViewById(R.id.btnBook);
        btnTarget = (Button) findViewById(R.id.btnTarget);
        btnNoti = (Button) findViewById(R.id.btnNoti);

    }
}
