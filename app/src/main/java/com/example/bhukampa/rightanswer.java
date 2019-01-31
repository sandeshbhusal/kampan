package com.example.bhukampa;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

public class rightanswer extends AppCompatActivity {
    MediaPlayer mp;
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
        setContentView(R.layout.activity_rightanswer);

        mp = MediaPlayer.create(getApplicationContext(), R.raw.rightanwerchime);
        mp.setLooping(false);
        mp.setVolume(100, 100);
        mp.start();

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
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        if(mp.isPlaying()) mp.stop();
    }
}
