package com.hanying.pictureanimation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    public void fade(View view){
        ImageView dog1 = (ImageView)findViewById(R.id.dog1);
        ImageView dog2 = (ImageView)findViewById(R.id.dog2);

        if(dog1.getAlpha() == 1) {
            dog1.animate().alpha(0f).setDuration(2000);
            dog2.animate().alpha(1f).setDuration(2000);
        }else{
            dog2.animate().alpha(0f).setDuration(2000);
            dog1.animate().alpha(1f).setDuration(2000);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
