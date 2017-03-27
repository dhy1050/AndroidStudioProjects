package com.hanying.downloadonline;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {
    ImageView imageDownload;
    TextView textDownload;

    public void doDownload (View view){
        Button btn = (Button) view;
        System.out.println(btn.getText());
        DownloadFromOnline download = new DownloadFromOnline();
        DownloadImageOnline downloadImage = new DownloadImageOnline();
        if(btn.getText().equals("get online content")){


            try {
                String result = download.execute("http://cargocollective.com/baby1/cute-baby").get();

                textDownload.setText(result);
                imageDownload.setVisibility(view.INVISIBLE);
                textDownload.setVisibility(view.VISIBLE);

//                Log.i("content",result);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }else{
            try {
//                Bitmap myMap = getBitmapFromURL("http://rcysl.com/wp-content/uploads/2017/01/Cute-Baby-Picture-Free-Download.jpg");
                Bitmap myMap = downloadImage.execute("http://rcysl.com/wp-content/uploads/2017/01/Cute-Baby-Picture-Free-Download.jpg").get();

                imageDownload.setImageBitmap(myMap);

                textDownload.setVisibility(view.INVISIBLE);
                imageDownload.setVisibility(view.VISIBLE);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

//another method to download image, but not work yet still need more research
    public Bitmap getBitmapFromURL(String src){
        try{
            java.net.URL url = new java.net.URL(src);
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            connection.setDoInput(true);
            connection.connect();

            InputStream input = connection.getInputStream();
            Bitmap myBitmap = BitmapFactory.decodeStream(input);

            return myBitmap;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public class DownloadImageOnline extends AsyncTask<String, Void, Bitmap>{

        @Override
        protected Bitmap doInBackground(String... params) {
            Bitmap mMap = null;
            URL url;

            HttpURLConnection connection = null;

            try{
                url = new URL(params[0]);
                connection = (HttpURLConnection)url.openConnection();
                connection.connect();

                InputStream input = connection.getInputStream();

                mMap = BitmapFactory.decodeStream(input);

                return mMap;

            }catch(Exception e){
                e.printStackTrace();
            }
            return null;
        }
    }
    public class DownloadFromOnline extends AsyncTask<String,Void,String>{

        @Override
        protected String doInBackground(String... urls) {
            String result = "";
            URL url;

            HttpURLConnection urlConnection = null;


                try {
                    url = new URL(urls[0]);
                    urlConnection = (HttpURLConnection) url.openConnection();

                    InputStream input = urlConnection.getInputStream();

                    InputStreamReader reader = new InputStreamReader(input);

                    int data = reader.read();
                    System.out.println(data);
                    System.out.println((char)data);


                    while(data != -1){
                        char charData = (char)data;
                        result +=charData;

                        data = reader.read();
                    }

                    return result;

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            return null;

        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageDownload = (ImageView)findViewById(R.id.imageView);
        textDownload = (TextView)findViewById(R.id.textView);
    }
}
