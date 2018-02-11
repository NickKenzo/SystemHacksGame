package com.example.nskinner.systemhacksgame;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.example.nskinner.systemhacksgame.QuestionWrong.REQUEST_CODE_NEXTQUESTION;

public class SuccessEnd extends AppCompatActivity {
    private int gameScore;
    public static final int REQUEST_CODE_NEXTQUESTION = 400;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success_end);
        extractData();
        displayScore();
        setUpReplayButton();
    }

    private void displayScore() {
        TextView questionDisplay = findViewById(R.id.compatabilityScore);
        questionDisplay.setGravity(Gravity.CENTER);
        String endText = "Congratulations! You Are " + gameScore * 10 + "% Compatible!";
        questionDisplay.setText(endText);
    }

    private void extractData() {
        Intent intent = getIntent();
        gameScore = intent.getIntExtra("gameScore", 0);
    }
    public void setUpReplayButton(){
        Button replay = findViewById(R.id.replayButton);
        replay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Launch the Game
                Intent intent = MainMenu.makeIntent(SuccessEnd.this);
                startActivityForResult(intent, REQUEST_CODE_NEXTQUESTION);
            }
        });
    }
    public static Intent makeIntent(Context context, int gameScore, int questionNumber){
        Intent intent = new Intent(context, SuccessEnd.class);
        intent.putExtra("gameScore", gameScore);
        intent.putExtra("questionNumber", questionNumber);
        return intent;
    }
}
