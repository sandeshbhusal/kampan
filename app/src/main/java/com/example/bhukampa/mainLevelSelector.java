package com.example.bhukampa;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;

public class mainLevelSelector extends AppCompatActivity {
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

           setContentView(R.layout.activity_main_level_selector);

           LinearLayout l = findViewById(R.id.prescenebutton);
           Button b = findViewById(R.id.prescenebuttonbutton);

           b.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   Intent i = new Intent(mainLevelSelector.this, presceneselector.class);
                   startActivity(i);
               }
           });

           Button x = findViewById(R.id.jhatpatSelector);
           x.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   Intent i = new Intent(mainLevelSelector.this, jhatpatjholaorplacement.class);
                   startActivity(i);
               }
           });

           Intent bgmService = new Intent(getApplicationContext(), bgmservice.class);
           startService(bgmService);
        }
}
