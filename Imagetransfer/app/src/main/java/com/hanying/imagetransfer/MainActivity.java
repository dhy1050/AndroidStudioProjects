package com.hanying.imagetransfer;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    public void transImage(View view){
        ImageView image = (ImageView)findViewById(R.id.imageView);
        image.animate().rotation(360f).setDuration(2000);
        image.animate().scaleX(1f).scaleY(1f);
        image.getLayoutParams().width = 400;
        image.getLayoutParams().height = 400;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView image = (ImageView)findViewById(R.id.imageView);

        image.setTranslationX(-1000f);
        image.animate().translationX(0).setDuration(2000);

    }
}
