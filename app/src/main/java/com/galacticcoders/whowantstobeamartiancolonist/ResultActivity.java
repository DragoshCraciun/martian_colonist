package com.galacticcoders.whowantstobeamartiancolonist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        displayCorrectScore(MainActivity.correctAnswers);
        displayWrongScore(MainActivity.wrongAnswers);
    }

    // Display correct answers score
    public void displayCorrectScore(int score) {
        TextView correctScore = (TextView) findViewById(R.id.correct_answers_score);
        correctScore.setText("Correct Score: " + String.valueOf(score));
    }

    // Display wrong answers score
    public void displayWrongScore(int score) {
        TextView wrongScore = (TextView) findViewById(R.id.wrong_answers_score);
        wrongScore.setText("Wrong Score: " + String.valueOf(score));
    }

    public void next(View view) {
        Intent nextQuestion = new Intent(this, QuestionOne.class);
        startActivity(nextQuestion);
    }

    /**
     * Prevents user to go to the previous question
     */
    @Override
    public void onBackPressed() {
    }

}
