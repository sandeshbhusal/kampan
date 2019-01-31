package com.example.bhukampa;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class bgmservice extends Service {
    MediaPlayer mp;
    public bgmservice() {
    }

    @Override
    public void onCreate(){
        mp = MediaPlayer.create(getApplicationContext(), R.raw.background);
        mp.setVolume(50, 50);
        mp.setLooping(true);
    }
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mp.start();
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        mp.stop();
    }
}
