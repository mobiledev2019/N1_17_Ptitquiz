package com.example.quizapp;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.JsonReader;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

public class list_item_target extends AppCompatActivity {
    ListView listView;
    ArrayList<Target> arrayList;
    TargetAdapter targetAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_item_target);

        convert();
        targetAdapter = new TargetAdapter(this,R.layout.list_item,arrayList);
        listView.setAdapter(targetAdapter);
    }

    public void convert() {
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    URL  githubEndPoint = new URL("http://192.168.241.1:3000/districts");
                    HttpURLConnection myConnect = (HttpURLConnection) githubEndPoint.openConnection();
                    myConnect.setRequestMethod("GET");
                    myConnect.connect();

                    Log.d("Succes",String.valueOf(myConnect.getResponseCode()));
                    if(myConnect.getResponseCode() == 200) {
                        // success
                        // read by inputStreamReader
                        InputStream  responeBody = new BufferedInputStream(myConnect.getInputStream());

                        InputStreamReader responeBodyReader = new InputStreamReader(responeBody, "UTF-8");
                        // recevice json
                        JsonReader jsonReader = new JsonReader(responeBodyReader);

                       jsonReader.beginArray();
//while(jsonReader.hasNext()) {
//    jsonReader.beginObject();
//    Log.d("DeBug",jsonReader.toString());
//    jsonReader.skipValue();
//}


                    } else {
                        // false
                    }
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        listView = (ListView) findViewById(R.id.recyclerView);
        arrayList = new ArrayList<Target>();
        arrayList.add(new Target("30-04-97", "Toán rời rạc", 30, 4));
        arrayList.add(new Target("12-04-97", "Triết học", 130, 4));
        arrayList.add(new Target("30-04-98", "Giám sát mạng", 320, 4));
        arrayList.add(new Target("20-7-97", "Phân tích thiết kế hệ thống", 320, 4));
    }
    public void addCalendar(View v) {
        Intent intent = new Intent(list_item_target.this,setAlarm.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("EXIT", true);
        startActivity(intent);
        finish();
    }
}
