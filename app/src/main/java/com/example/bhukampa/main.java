package com.example.bhukampa;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.MediaController;
import android.widget.VideoView;

public class main extends AppCompatActivity {
    MediaPlayer x;
    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);

        setContentView(R.layout.activity_main);

        // Get the video source.

        Intent intent = getIntent();
        int timeToPlay = intent.getIntExtra("timeToPlay", 0);
        final String videoSource = intent.getStringExtra("videoSource");

        VideoView v = findViewById(R.id.videoPlayer);

        // Create a function that will take us to the question scene after 'timeToPlay' Seconds.

        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // Wake me up when september ends...
                if(videoSource.equals("gharbhitra")){
                    // Show the gharbhitra wala question.
                    Intent i = new Intent(getApplicationContext(), question_insideHome.class);
                    startActivity(i);
                    overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                }
                else{
                    // show the jhatpatjhola wala question activity.
                    Intent i = new Intent(getApplicationContext(), question_jhatpatjhola.class);
                    startActivity(i);
                    overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                }
            }
        }, timeToPlay+1000);

        if(videoSource.equals("gharbhitra")){
            x = MediaPlayer.create(getApplicationContext(), R.raw.gharbhitrafirst);
            x.setLooping(false);
            x.setVolume(100, 100);
            x.start();

            Log.i("VIDEOSOURCE::", "Video source is gharBhitra" + " " + videoSource);
            Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.gharbhitra);
            v.setVideoURI(uri);
            v.requestFocus();
            v.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    mp.setLooping(true);
                    mp.start();
                }
            });
        }
        else {
            x = MediaPlayer.create(getApplicationContext(), R.raw.jholafirst);
            x.setLooping(false);
            x.setVolume(100, 100);
            x.start();

            Log.i("VIDEOSOURCE::", "Video source is Bato maa huda" + " " + videoSource);
            Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video);
            v.setVideoURI(uri);
            v.requestFocus();
            v.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    mp.setLooping(false);
                    mp.start();
                }
            });
        }
    }

    @Override
    protected  void onDestroy(){
        super.onDestroy();
        x.release();
        x.stop();
        handler.removeCallbacksAndMessages(null);
    }
}
