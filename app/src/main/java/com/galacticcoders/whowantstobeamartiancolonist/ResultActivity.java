package com.galacticcoders.whowantstobeamartiancolonist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_result);

        displayCorrectScore(MainActivity.correctAnswers);
    }

    // Display correct answers score
    public void displayCorrectScore(int score) {

        TextView correctScore = (TextView) findViewById(R.id.correct_answers_score);

        if (score <= 0) {
            correctScore.setText("I am sorry kiddo! \nYou are not ready yet. \nless then " + String.valueOf(score*10) + "% chance \nof becoming \n Martian Colonist!");
        } else if (score >= 2 && score <= 4) {
            correctScore.setText("Almost there! \nYou have to try a bit harder. \nonly " + String.valueOf(score*10) + "% chance \nof becoming \nMartian Colonist!");
        } else if (score >= 5 && score <= 8) {
            correctScore.setText("Congratulations, major! \nYou are almost there. \nabout " + String.valueOf(score*10) + "% chance \nof becoming \nMartian Colonist!");
        } else {
            correctScore.setText("You are Awesome! \nSpace travel is in your dna. \na good " + String.valueOf(score*10) + "% chance \nof becoming \nMartian Colonist!");
        }
    }

    public void next(View view) {
        Intent nextQuestion = new Intent(this, MainActivity.class);
        startActivity(nextQuestion);
        MainActivity.correctAnswers = 0;
    }

    /**
     * Prevents user to go to the previous question
     */
    @Override
    public void onBackPressed() {
    }

}
