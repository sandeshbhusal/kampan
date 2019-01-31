package com.example.bhukampa;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

public class wronganswer extends AppCompatActivity {
    MediaPlayer wrongans, a, b, c;
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
        setContentView(R.layout.activity_wronganswer);

        FrameLayout rightAnswerMedalContainer = findViewById(R.id.rightanswermedalcontainer);
        rightAnswerMedalContainer.animate().scaleX(1).setDuration(500).start();
        rightAnswerMedalContainer.animate().scaleY(1).setDuration(500).start();

        TextView sahiUttarTextContainer = findViewById(R.id.sahiuttartextcontainer);
        sahiUttarTextContainer.animate().alpha(1).setDuration(500).start();

        Button arkoButton = findViewById(R.id.arkobutton);
        arkoButton.animate().scaleX(1).setDuration(500).start();
        arkoButton.animate().scaleY(1).setDuration(500).start();

        arkoButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i = new Intent(getApplicationContext(), mainLevelSelector.class);
                startActivity(i);
            }
        });

        Button pheriButton = findViewById(R.id.pheributton);
        arkoButton.animate().scaleX(1).setDuration(500).start();
        arkoButton.animate().scaleY(1).setDuration(500).start();

        wrongans = MediaPlayer.create(getApplicationContext(), R.raw.wronganwer);
        wrongans.setLooping(false);
        wrongans.setVolume(100, 100);
        wrongans.start();

        Intent r = getIntent();
        if(r.getStringExtra("called-by").equals("jhola")){
            // PLAY JHOLA INFORMATION HERE>
            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Wake me up when september ends...
                    a = MediaPlayer.create(getApplicationContext(), R.raw.jholaadvice);
                    a.setLooping(false);
                    a.setVolume(100, 100);
                    a.start();
                }
            }, 1700);
        }
        else{
            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Wake me up when september ends...
                    b = MediaPlayer.create(getApplicationContext(), R.raw.gharbhitraadvice);
                    b.setLooping(false);
                    b.setVolume(100, 100);
                    b.start();
                }
            }, 1700);
        }

        pheriButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                // Take me home... Country roadddds...
                Intent received = getIntent();
                if(received.getStringExtra("called-by").equals("jhola")){
                    // Call the main video player with jhatpatjhola parameters.
                    Intent i = new Intent(getApplicationContext(), main.class);
                    i.putExtra("videoSource","jhola");
                    i.putExtra("timeToPlay", 13000);
                    startActivity(i);
                }
                else{
                    Intent i = new Intent(getApplicationContext(), main.class);
                    i.putExtra("videoSource","gharbhitra");
                    i.putExtra("timeToPlay", 15000);
                    startActivity(i);
                }
            }
        });
    }

    @Override
    protected  void onStop(){
        super.onStop();
        if(a != null && a.isPlaying()) a.stop();
        if(b != null && b.isPlaying()) b.stop();
        if(wrongans!= null && wrongans.isPlaying()) wrongans.stop();
    }
}
