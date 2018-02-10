package com.example.nskinner.systemhacksgame;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class GameStart extends AppCompatActivity {
    public int score = 0;
    public static String[] questions = {"What is your favourite restaurant?",
            "What is your favourite sport?",
            "What is your favourite movie?",
            "What is your favourite TV show?",
            "What is your favourite actor?",
            "What is your favourite actress?",
            "What is your favourite food?",
            "What is your favourite subject in school?",
            "If you had to live in one city for the rest of your life, where would it be?",
            "Dogs or cats?",
            "Butts of boobs?",
            "Face or body?",
            "Showers or baths?",
            "Pineapple on pizza (yes or no)",
            "Pro choice or pro life?",
            "Are hot dogs sandwiches?",
            "Coffee or tea?",
            "Badminton or tennis?",
            "Skiing or snowboarding?",
            "Java or C++?",
            "Mac or Windows?",
            "Equality or equity?",
            "Summer or winter?",
            "Spring or fall?",
            "Would you choose to live forever?",
            "Books or movies?",
            "TV shows or movies?",
            "What is your favourite genre of movies?",
            "Who is more complicated? Men or women?",
            "Android or iOS?",
            "What is the best pizza topping?",
            "Do you wants kids?",
            "Dark chocolate or milk chocolate?",
            "How many kids do you want?"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_start);
        Random rand = new Random();
        determineQuestion(rand.nextInt(34));
        displayScore();
        setUpSubmit();
        setUpHide1();
        setUpHide2();
    }
    private void displayScore(){
        setContentView(R.layout.activity_game_start);
        TextView textView = (TextView) findViewById(R.id.scoreBox);
        textView.setText(Integer.toString(score));
    }

    private void setUpHide1() {
        Button hide1 = findViewById(R.id.hide1);
        hide1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Hide the text
                TextView textView = (TextView) findViewById(R.id.player1answer);
                textView.setTextColor(0);
            }
        });
    }
    private void setUpHide2() {
        Button hide2 = findViewById(R.id.hide2);
        hide2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Hide the text
                TextView textView = (TextView) findViewById(R.id.player2answer);
                textView.setTextColor(0);
            }
        });
    }

    public void setUpSubmit(){
        Button submitbtn = findViewById(R.id.submitbtn);
        submitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Extract data
                EditText edit1 = (EditText) findViewById(R.id.player1answer);
                EditText edit2 = (EditText) findViewById(R.id.player2answer);
                String answer1 = edit1.getText().toString();
                String answer2 = edit2.getText().toString();
                if(!(answer1.equals("")) &&  !(answer2.equals(""))) {
                    if(answer1.toUpperCase().equals(answer2.toUpperCase())){
                        score++;
                        Intent intent = QuestionRight.makeIntent(GameStart.this);
                        startActivity(intent);
                    }
                    else{
                        Intent intent = QuestionWrong.makeIntent(GameStart.this);
                        startActivity(intent);
                    }
                }
                finish();
            }
        });
    }
    public void determineQuestion(int seed){
        setContentView(R.layout.activity_game_start);
        TextView textView = (TextView) findViewById(R.id.question);
        textView.setText(questions[seed]);
    }
    public static Intent makeIntent(Context context){
        return new Intent(context, GameStart.class);
    }
}
