package com.hanying.myfirstandroidapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void clickFunction(View view){
        EditText yourName = (EditText) findViewById(R.id.yourName);
        EditText yourPW = (EditText)findViewById(R.id.yourPW);
        Log.i("Your name",yourName.getText().toString());
        Log.i("Your password",yourPW.getText().toString());
        Toast.makeText(getApplicationContext(),"hello "+yourName.getText().toString(), Toast.LENGTH_LONG).show();

    }
    public void clickImage (View view){
        ImageView myDog = (ImageView)findViewById(R.id.myImage);
        myDog.setImageResource(R.drawable.dog02);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
