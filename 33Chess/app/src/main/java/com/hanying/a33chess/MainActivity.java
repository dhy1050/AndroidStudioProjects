package com.hanying.a33chess;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int player = 0;
    int[] playField = {2,2,2,2,2,2,2,2,2};
    boolean isPlayActive = true;


    int[][] winWays = {{0,1,2}, {3,4,5}, {6,7,8}, {0,3,6}, {1,4,7}, {2,5,8}, {0,4,8}, {2,4,6}};




    public void dropIn(View view){
        ImageView counter = (ImageView) view;

        LinearLayout linearLayout = (LinearLayout)findViewById(R.id.linearV);
        TextView gameText = (TextView)findViewById(R.id.gameText);

        System.out.println(counter.getTag());

        int counterPosition = Integer.parseInt(counter.getTag().toString());

        if(isPlayActive == true) {
            if (playField[counterPosition] == 2) {
                counter.setTranslationY(-1000f);
                if (player == 0) {
                    counter.setImageResource(R.drawable.yellow);
                    playField[counterPosition] = 0;
                    player = 1;
                } else {
                    counter.setImageResource(R.drawable.red);
                    player = 0;
                    playField[counterPosition] = 1;
                }

                counter.animate().translationYBy(1000f).rotation(360).setDuration(300);

                //check the winner is set or not
                for(int[] winPosition : winWays){
                    if(playField[winPosition[0]] == playField[winPosition[1]]
                            && playField[winPosition[1]] == playField[winPosition[2]]
                            && playField[winPosition[0]] != 2) {
                        isPlayActive = false;
                        if (player == 0)
                            gameText.setText("Red win!!");
                        else
                            gameText.setText("Yellow win!!");

                        linearLayout.setVisibility(view.VISIBLE);
                    }
                }

                int count = 0;
                for(int checkPosition : playField){
                    if(checkPosition != 2)
                        count++;
                }
                if (count == 9){
                    isPlayActive = false;
                    gameText.setText("It is a draw!!");
                    linearLayout.setVisibility(view.VISIBLE);
                }

            }

        }
    }

    public void playAgain(View view){

        LinearLayout linearLayout = (LinearLayout)findViewById(R.id.linearV);
        linearLayout.setVisibility(view.INVISIBLE);
        isPlayActive = true;

        for(int i = 0; i < playField.length; i++) {
            playField[i] = 2;
        }
        GridLayout gridLayout = (GridLayout) findViewById(R.id.gird);

        for(int i = 0; i < gridLayout.getChildCount(); i++){
            ((ImageView)gridLayout.getChildAt(i)).setImageResource(0);
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
