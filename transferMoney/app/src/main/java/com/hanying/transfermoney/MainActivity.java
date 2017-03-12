package com.hanying.transfermoney;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void btnClick(View view){
        EditText dollar = (EditText)findViewById(R.id.money);
        TextView yuan = (TextView)findViewById(R.id.yuanMoney);
        double dollarAmount = Double.parseDouble(dollar.getText().toString());
        double yuanAmount = dollarAmount * 6.88;
        yuan.setText(Double.toString(yuanAmount));
        Toast.makeText(getApplicationContext(),"￥"+Double.toString(yuanAmount), Toast.LENGTH_LONG).show();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
