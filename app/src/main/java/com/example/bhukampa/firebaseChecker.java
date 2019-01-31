package com.example.bhukampa;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.NonNull;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class firebaseChecker extends Service {
    public firebaseChecker() {
    }

    @Override
    public void onCreate(){
        DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();
        DatabaseReference mStringRef = mRootRef.child("string");
        Log.i("FIREBASE INFO:: ", "LISTENING TO DATA>>>");
        Log.i("FIREBASE", mStringRef.toString());

        mStringRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Log.i("FIREBASE INFO:: ", "GOT CHANGED DATA>>>");
                String text = dataSnapshot.getValue(String.class);

                Log.i("FIREBASE DATA: " , dataSnapshot.getValue().toString());
                if(dataSnapshot.getValue().toString().equals("emergency")){
                    // START EMERGENCY MODE>
                    Intent emergency = new Intent(getApplicationContext(), FullscreenActivity.class);
                    startActivity(emergency);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.i("FIREBASE INFO:: ", "CANCELLING REQUEST FOR UPDATE>>>");
            }

        });
    }
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        return Service.START_STICKY;
    }

    @Override
    public void onDestroy() {
    }
}
