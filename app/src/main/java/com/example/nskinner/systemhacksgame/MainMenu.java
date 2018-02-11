package com.example.nskinner.systemhacksgame;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainMenu extends AppCompatActivity {
    public static final int REQUEST_CODE_ANSWER1 = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*
        class song extends Activity {
            MediaPlayer mediaPlayer;

            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main_menu);
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.yoursong);

                mediaPlayer.start();

            }

            @Override
            protected void onPause() {
                super.onPause();
                mediaPlayer.stop();
                mediaPlayer.release();

            }
        }
        */
        setContentView(R.layout.activity_main_menu);
        setUp1on1();
    }
    private void setUp1on1(){
        ImageButton startBtn = findViewById(R.id.startbtn1);
        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Launch the Game
                int score = 0;
                int questionNumber = 1;
                Intent intent = GameStart.makeIntent(MainMenu.this, score,questionNumber);
                intent.putExtra("score", score);
                intent.putExtra("questionNumber", questionNumber);
                startActivityForResult(intent, REQUEST_CODE_ANSWER1);
            }
        });
    }
    public static Intent makeIntent(Context context){
        Intent intent = new Intent(context, MainMenu.class);
        return intent;
    }

}
