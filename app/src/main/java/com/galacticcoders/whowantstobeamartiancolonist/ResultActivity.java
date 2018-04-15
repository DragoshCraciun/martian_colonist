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

        // Concatenating strings
        String lowScore = getResources().getString(R.string.lowScore);
        String averageScore = getResources().getString(R.string.averageScore);
        String highScore = getResources().getString(R.string.highScore);
        String bestScore = getResources().getString(R.string.bestScore);
        String martianColonist = getResources().getString(R.string.martianColonist);

        // String for low score result
        String lowScoreResult = lowScore;
        lowScoreResult += String.valueOf(score*10);
        lowScoreResult += martianColonist;

        // String for average score result
        String averageScoreResult = averageScore;
        averageScoreResult += String.valueOf(score*10);
        averageScoreResult += martianColonist;

        // String for high score result
        String highScoreResult = highScore;
        highScoreResult += String.valueOf(score*10);
        highScoreResult += martianColonist;

        // String for best score result
        String bestScoreResult = bestScore;
        bestScoreResult += String.valueOf(score*10);
        bestScoreResult += martianColonist;

        // Display score based on level
        if (score <= 0) {
            correctScore.setText(lowScoreResult);
        } else if (score >= 2 && score <= 4) {
            correctScore.setText(averageScoreResult);
        } else if (score >= 5 && score <= 8) {
            correctScore.setText(highScoreResult);
        } else {
            correctScore.setText(bestScoreResult);
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
