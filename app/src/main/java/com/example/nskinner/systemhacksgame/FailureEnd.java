package com.example.nskinner.systemhacksgame;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FailureEnd extends AppCompatActivity {

    private static final int REQUEST_CODE_NEXTQUESTION = 500;
    private int gameScore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_failure_end);
        extractData();
        displayScore();
        setUpReplayButton();
    }
    private void displayScore() {
        TextView questionDisplay = findViewById(R.id.failureMessage);
        questionDisplay.setGravity(Gravity.CENTER);
        String endText = "Sorry! You Are Only " + gameScore * 10 + "% Compatible.";
        questionDisplay.setText(endText);
    }

    private void extractData() {
        Intent intent = getIntent();
        gameScore = intent.getIntExtra("gameScore", 0);
    }
    public void setUpReplayButton(){
        Button replay = findViewById(R.id.replaybtn);
        replay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Launch the Game
                Intent intent = MainMenu.makeIntent(FailureEnd.this);
                startActivityForResult(intent, REQUEST_CODE_NEXTQUESTION);
            }
        });
    }
    public static Intent makeIntent(Context context, int gameScore, int questionNumber){
        Intent intent = new Intent(context, FailureEnd.class);
        intent.putExtra("gameScore", gameScore);
        intent.putExtra("questionNumber", questionNumber);
        return intent;
    }
}
