package com.example.bhukampa;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;

public class question_jhatpatjhola extends AppCompatActivity {
    Handler handler, handlerb, handlerc;
    MediaPlayer a, b, c, question;
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

        setContentView(R.layout.activity_question_jhatpatjhola);
        Animation anim = new AlphaAnimation(0, 1);
        anim.setDuration(1000);

        final Button r, w1, w2;
        r = findViewById(R.id.correctAnswer);
        w1 = findViewById(R.id.wronganswer1);
        w2 = findViewById(R.id.wronganswer2);

        question = MediaPlayer.create(getApplicationContext(), R.raw.jholaquestion);
        question.setLooping(false);
        question.setVolume(100, 100);
        question.start();


        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // Wake me up when september ends...
                a = MediaPlayer.create(getApplicationContext(), R.raw.football);
                a.setLooping(false);
                a.setVolume(100, 100);
                a.start();
                w2.animate().scaleX(1).setDuration(500).start();
                w2.animate().scaleY(1).setDuration(500).start();
            }
        }, 4000);

        handlerb = new Handler();
        handlerb.postDelayed(new Runnable() {
            @Override
            public void run() {
                // Wake me up when september ends...
                b = MediaPlayer.create(getApplicationContext(), R.raw.torchlight);
                b.setLooping(false);
                b.setVolume(100, 100);
                b.start();
                r.animate().scaleX(1).setDuration(500).start();
                r.animate().scaleY(1).setDuration(500).start();
            }
        }, 6000);

        handlerc = new Handler();
        handlerc.postDelayed(new Runnable() {
            @Override
            public void run() {
                // Wake me up when september ends...
                c = MediaPlayer.create(getApplicationContext(), R.raw.kucho);
                c.setLooping(false);
                c.setVolume(100, 100);
                c.start();

                w1.animate().scaleX(1).setDuration(500).start();
                w1.animate().scaleY(1).setDuration(500).start();
            }
        }, 8000);

        r.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), rightanswer.class);
                startActivity(i);
            }
        });
        View.OnClickListener wrong = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), wronganswer.class);
                i.putExtra("called-by", "jhola");
                startActivity(i);
            }
        };
        w2.setOnClickListener(wrong);
        w1.setOnClickListener(wrong);
    }

    @Override
    public void onPause(){
        super.onPause();
        handler.removeCallbacksAndMessages(null);
        handlerb.removeCallbacksAndMessages(null);
        handlerc.removeCallbacksAndMessages(null);
        if(question != null) question.stop();
        if(a != null ) {a.stop();}
        if(b != null ) {b.stop();}
        if(c != null ) {c.stop();}

    }
}
