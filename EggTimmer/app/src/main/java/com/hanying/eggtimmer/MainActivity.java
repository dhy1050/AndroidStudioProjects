package com.hanying.eggtimmer;

import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView timeText;
    Button button;
    SeekBar seekBar;

    CountDownTimer countTimer;
    Boolean countDownIsActive = false;

    public void resetTimer(){
        Log.i("second left",Integer.toString(seekBar.getProgress()));
        if(seekBar.getProgress() == 0) {
            timeText.setText("0:00");

            countTimer.cancel();



        }else{
            countTimer.cancel();
        }
        seekBar.setEnabled(true);
        button.setText("Go!");
        countDownIsActive = false;

    }

    public void timeControl(View view){
        if(countDownIsActive == false){
            countDownIsActive = true;
            seekBar.setEnabled(false);
            button.setText("Pause");

            countTimer = new CountDownTimer(seekBar.getProgress()*1000+100,1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    seekBar.setProgress((int)millisUntilFinished/1000);
                    updateTime((int)(millisUntilFinished/1000));
                }

                @Override
                public void onFinish() {
                    seekBar.setProgress(0);
                    MediaPlayer myplayer = MediaPlayer.create(getApplicationContext(),R.raw.airhorn);
                    myplayer.start();
                    resetTimer();
                }
            }.start();
        }else{
            resetTimer();
        }

    }

    public void updateTime(int progress){

        int min = progress/60;

        int second = progress - min*60;

        String secondString;

        if(second <= 9){
            secondString = "0"+Integer.toString(second);
        }else{
            secondString = Integer.toString(second);
        }
        timeText.setText(Integer.toString(min)+":"+secondString);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timeText = (TextView)findViewById(R.id.timeView);
        button = (Button)findViewById(R.id.button);
        seekBar = (SeekBar)findViewById(R.id.seekBar);

        seekBar.setMax(600);
        seekBar.setProgress(30);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                updateTime(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
