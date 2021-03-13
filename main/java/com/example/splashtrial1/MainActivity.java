package com.example.splashtrial1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        videoView=findViewById(R.id.videoView);
        videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.lauda));
        videoView.start();
        SharedPreferences dataSave = getSharedPreferences("firstLog", 0);

        if(dataSave.getString("firstTime", "").toString().equals("no")){
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    startActivity(new Intent(MainActivity.this, login_activity.class));
                }
            },4000);// first run is happened
        }
        else{ //  this is the first run of application
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    startActivity(new Intent(MainActivity.this, onboard.class));
                }
            },4000);
            SharedPreferences.Editor editor = dataSave.edit();
            editor.putString("firstTime", "no");
            editor.commit();
        }

    }
}