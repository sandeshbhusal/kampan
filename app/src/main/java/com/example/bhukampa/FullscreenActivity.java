package com.example.bhukampa;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.Image;
import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class FullscreenActivity extends AppCompatActivity {
    Button newgame, continuegame, profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);

        setContentView(R.layout.activity_fullscreen);

        MediaPlayer flute = MediaPlayer.create(getApplicationContext(), R.raw.kampan);
        flute.setLooping(true);
        flute.setVolume(10, 10);
        flute.start();


        ImageView title = findViewById(R.id.title);
        title.animate().scaleX(1).setDuration(1000).start();
        title.animate().scaleY(1).setDuration(1000).start();

        newgame = findViewById(R.id.newgameButton);
        newgame.animate().alpha(1).setDuration(2000).start();
        newgame.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    v.setBackground(getDrawable(R.drawable.rectangle_depressed));
                    Intent I = new Intent(getApplicationContext(), mainLevelSelector.class);
                    startActivity(I);
                }
                else if(event.getAction() == MotionEvent.ACTION_UP){
                    v.setBackground(getDrawable(R.drawable.rectangle));
                }
                return true;
            }
        });

        newgame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent I = new Intent(getApplicationContext(), gameActivity.class);
                startActivity(I);
            }
        });


        continuegame = findViewById(R.id.continuegameButton);
        continuegame.animate().alpha(1).setDuration(2000).start();
        continuegame.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    v.setBackground(getDrawable(R.drawable.rectangle_depressed));
                }
                else if(event.getAction() == MotionEvent.ACTION_UP){
                    v.setBackground(getDrawable(R.drawable.rectangle));
                }
                return true;
            }
        });


        profile = findViewById(R.id.profileButton);
        profile.animate().alpha(1).setDuration(2000).start();
        profile.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    v.setBackground(getDrawable(R.drawable.rectangle_depressed));
                }
                else if(event.getAction() == MotionEvent.ACTION_UP){
                    v.setBackground(getDrawable(R.drawable.rectangle));
                }
                return true;
            }
        });

        Intent firebase = new Intent(getApplicationContext(), firebaseChecker.class);
        startService(firebase);
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        stopService(new Intent(getApplicationContext(), bgmservice.class));
        stopService(new Intent(getApplicationContext(), firebaseChecker.class));
    }
}
