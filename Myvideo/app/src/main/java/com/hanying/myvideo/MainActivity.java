package com.hanying.myvideo;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.MediaController;
import android.widget.SeekBar;
import android.widget.VideoView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mediaPlay;
    AudioManager audioManager;
    SeekBar pointBar;
    SeekBar volumeBar;

    public void play(View view){
        mediaPlay.start();
    }

    public void pause(View view){
        mediaPlay.pause();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlay = MediaPlayer.create(this, R.raw.kidlaugh);

        pointBar = (SeekBar)findViewById(R.id.pointBar);

        volumeBar = (SeekBar)findViewById(R.id.volumeBar);


        VideoView myVideo = (VideoView) findViewById(R.id.myvideo);

        myVideo.setVideoPath("android.resource://" + getPackageName() + "/"+ R.raw.myself);

        MediaController control = new MediaController(this);

        control.setAnchorView(myVideo);

        myVideo.setMediaController(control);


        audioManager = (AudioManager)getSystemService(Context.AUDIO_SERVICE);

        int maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int curVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);

        volumeBar.setMax(maxVolume);
        volumeBar.setProgress(curVolume);

        volumeBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.i("SeekBar value", Integer.toString(progress));
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC,progress,0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        pointBar = (SeekBar)findViewById(R.id.pointBar);

        pointBar.setMax(mediaPlay.getDuration());

        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                pointBar.setProgress(mediaPlay.getCurrentPosition());
            }
        },0,1000);

        pointBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mediaPlay.seekTo(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
//        myVideo.start();
    }
}
