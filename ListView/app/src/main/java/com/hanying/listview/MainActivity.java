package com.hanying.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


import java.util.ArrayList;

import static java.util.Arrays.asList;

public class MainActivity extends AppCompatActivity {

    Toast toastShow = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView myList = (ListView)findViewById(R.id.myList);


        final ArrayList<String> myFriends = new ArrayList<String>(asList("John","White","Alix","Akali","Nidallee"));

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,myFriends);

        myList.setAdapter(arrayAdapter);

        showToast(myList,myFriends);


    }

    public void showToast(ListView myList, final ArrayList<String> myFriends){
        myList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                try{
                    if(toastShow !=null)
                        if(toastShow.getView().isShown()) {
                            toastShow.cancel();
                        }
                    toastShow = Toast.makeText(getApplicationContext(),"hello " + myFriends.get(position),Toast.LENGTH_LONG);
                    toastShow.show();

                }catch (Exception e){
                    Log.i("get Erorr","error");
                }

            }
        });
    }
}
