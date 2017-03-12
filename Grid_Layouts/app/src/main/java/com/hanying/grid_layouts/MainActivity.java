package com.hanying.grid_layouts;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mplayer;

    public void bottonTapped(View view){
        int id = view.getId();

        String ourId = "";

        ourId = view.getResources().getResourceEntryName(id);

        Log.i("Button name: ", ourId);

        int resourceId = getResources().getIdentifier(ourId,"raw","com.hanying.grid_layouts");

        setPlayer(resourceId);
        play();

    }

    public void setPlayer(int resourceId){
 
        if(mplayer != null) {
            mplayer.reset();
        }
        mplayer = MediaPlayer.create(this,resourceId);

    }

    public void play(){
        mplayer.start();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
