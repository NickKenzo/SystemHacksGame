package com.example.nskinner.systemhacksgame;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class QuestionRight extends AppCompatActivity {
    private int gameScore;
    private int questionNumber;
    private static final int REQUEST_CODE_NEXTQUESTION = 200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_right);
        extractData();
        setUpNextButton();
    }
    private void extractData() {
        Intent intent = getIntent();
        gameScore = intent.getIntExtra("gameScore", 0);
        questionNumber = intent.getIntExtra("questionNumber", 0);
    }
    public void setUpNextButton(){
        Button next = findViewById(R.id.nextQuestionBtn1);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Launch the Game
                Intent intent = GameStart.makeIntent(QuestionRight.this, gameScore, questionNumber);
                startActivityForResult(intent, REQUEST_CODE_NEXTQUESTION);
            }
        });
    }
    public static Intent makeIntent(Context context, int gameScore, int questionNumber){
        Intent intent = new Intent(context, QuestionRight.class);
        intent.putExtra("gameScore", gameScore);
        intent.putExtra("questionNumber", questionNumber);
        return intent;
    }
}
