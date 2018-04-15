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

        if (score <= 3) {
            correctScore.setText("Sorry! \nYou have only\n" + String.valueOf(score*10) + "% chance \nof becoming a \nMartian Colonist!");
        } else if (score >= 4 && score <= 8) {
            correctScore.setText("Congratulations! \nYou have a about\n" + String.valueOf(score*10) + "% chance \nof becoming a \nMartian Colonist!");
        } else {
            correctScore.setText("Awesome! \nYou have a good\n" + String.valueOf(score*10) + "% chance \nof becoming a \nMartian Colonist!");
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
