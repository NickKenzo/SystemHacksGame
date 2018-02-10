package com.example.nskinner.systemhacksgame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainMenu extends AppCompatActivity {

    public static final int REQUEST_CODE_ANSWER1 = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        setUp1on1();
    }
    private void setUp1on1(){
        Button startBtn = findViewById(R.id.startbtn1);
        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Launch the Game
                Intent intent = GameStart.makeIntent(MainMenu.this);
                startActivityForResult(intent, REQUEST_CODE_ANSWER1);
            }
        });
    }

   /* protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch(requestCode){
            case(REQUEST_CODE_ANSWER1):
                if(resultCode == RESULT_OK){
                    //Get Message
                    String answer1 = data.getStringExtra("answer1");
                    String answer2 = data.getStringExtra("answer2");
                    if(answer1.toUpperCase().equals(answer2.toUpperCase())) {
                        Intent intent = QuestionRight.makeIntent(MainMenu.this);
                        startActivity(intent);
                    }
                    else{
                        Intent intent = QuestionWrong.makeIntent(MainMenu.this);
                        startActivity(intent);
                    }

                }else{
                    Log.i("SystemHacksGame", "Missing Input.");
                }

        }
    }
    */
}
