package com.hanying.braintrainer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    RelativeLayout innerRelativeLayout;
    Button startButton;

    TextView timeTextView;
    TextView scoreTextView;

    Button buttonAnswers[] = new Button[6];

    TextView questionTextView;
    TextView ansertTextView;

    Button pass;

    int answer;
    int answerPosition;
    int numberQ = 0;
    int correctQ = 0;
    public void startGame(View view){
        startButton.setVisibility(View.INVISIBLE);
        innerRelativeLayout.setVisibility(View.VISIBLE);
        generateQuestions();
    }
    public void generateQuestions(){
        Random rand = new Random();
        int a = rand.nextInt(101);
        int b = rand.nextInt(101);
        answer = a+b;
        int incorrectAnswer;

        answerPosition = rand.nextInt(6);
        questionTextView.setText(Integer.toString(a)+" + "+Integer.toString(b));

        for(int i = 0; i<buttonAnswers.length; i++){
            if(i == answerPosition){
                buttonAnswers[i].setText(Integer.toString(answer));
            }else{
                incorrectAnswer = rand.nextInt(301);
                while(incorrectAnswer == answer){
                    incorrectAnswer = rand.nextInt(301);
                }
                buttonAnswers[i].setText(Integer.toString(incorrectAnswer));
            }

        }
    }

    public void chooseAnswer(View view){
        Button btn = (Button)view;
        if(btn.getText().equals(Integer.toString(answer))){
            ansertTextView.setText("Correct!");
            correctQ++;

        }else{
            ansertTextView.setText("Wrong");
        }
        numberQ++;

        scoreTextView.setText(Integer.toString(correctQ)+"/"+Integer.toString(numberQ));
        generateQuestions();
    }

    public void pass(View view){
        generateQuestions();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        innerRelativeLayout = (RelativeLayout)findViewById(R.id.innerrelativeLayout);
        startButton = (Button)findViewById(R.id.startbutton);
        timeTextView = (TextView)findViewById(R.id.timetextView);
        scoreTextView = (TextView)findViewById(R.id.scoretextView);
        buttonAnswers = new Button[6];


        System.out.println(getResources());
        for(int i = 0; i< 6; i++){
            int b = i+1;
            String id = "button"+(b);
            System.out.println(id);
            buttonAnswers[i] = (Button)findViewById(getResources().getIdentifier(id,"id",getPackageName()));
        }
        questionTextView = (TextView)findViewById(R.id.questiontextView);
        ansertTextView = (TextView)findViewById(R.id.answertextView);

        pass = (Button)findViewById(R.id.passbutton);

    }
}
