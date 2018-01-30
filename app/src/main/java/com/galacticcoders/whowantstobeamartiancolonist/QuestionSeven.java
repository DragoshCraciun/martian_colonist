package com.galacticcoders.whowantstobeamartiancolonist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class QuestionSeven extends AppCompatActivity {

    public boolean rightAnswer = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.question_seven);
    }

    public void onAnswerClick(View view) {

        // Getting string for user input of Mars God.
        String ares = "MARS";
        EditText marsGod = (EditText) findViewById(R.id.marsGod);
        String marsGodAnswer = marsGod.getText().toString();
        marsGodAnswer = marsGodAnswer.toUpperCase();

        // Getting string for user input of Mars God.
        String aphrodite = "VENUS";
        EditText venusGod = (EditText) findViewById(R.id.venusGod);
        String venusGodAnswer = marsGod.getText().toString();
        venusGodAnswer = venusGodAnswer.toUpperCase();

        // Getting string for user input of Mars God.
        String zeus = "JUPITER";
        EditText jupiterGod = (EditText) findViewById(R.id.jupiterGod);
        String jupiterGodAnswer = jupiterGod.getText().toString();
        jupiterGodAnswer = jupiterGodAnswer.toUpperCase();

        // Getting string for user input of Mars God.
        String gaia = "NEPTUNE";
        EditText earthGod = (EditText) findViewById(R.id.earthGod);
        String earthGodAnswer = earthGod.getText().toString();
        earthGodAnswer = earthGodAnswer.toUpperCase();


        // Check which the user input

        if (ares.equals(marsGodAnswer)) {
            // Show validity of the answer as a toast
            Toast.makeText(this, "Is this your final answer?", Toast.LENGTH_SHORT).show();
            rightAnswer = true;
        } else {
            // Show validity of the answer as a toast
            Toast.makeText(this, "Is this your final answer?", Toast.LENGTH_SHORT).show();
        }

        if (aphrodite.equals(venusGodAnswer)) {
            // Show validity of the answer as a toast
            Toast.makeText(this, "Is this your final answer?", Toast.LENGTH_SHORT).show();
            rightAnswer = true;
        } else {
            // Show validity of the answer as a toast
            Toast.makeText(this, "Is this your final answer?", Toast.LENGTH_SHORT).show();
        }

        if (zeus.equals(jupiterGodAnswer)) {
            // Show validity of the answer as a toast
            Toast.makeText(this, "Is this your final answer?", Toast.LENGTH_SHORT).show();
            rightAnswer = true;
        } else {
            // Show validity of the answer as a toast
            Toast.makeText(this, "Is this your final answer?", Toast.LENGTH_SHORT).show();
        }

        if (gaia.equals(earthGodAnswer)) {
            // Show validity of the answer as a toast
            Toast.makeText(this, "Is this your final answer?", Toast.LENGTH_SHORT).show();
            rightAnswer = true;
        } else {
            // Show validity of the answer as a toast
            Toast.makeText(this, "Is this your final answer?", Toast.LENGTH_SHORT).show();
        }

    }

    // Intent to move to the next question
    public void nextQuestion(View view) {
        // Add 1 to correctAnswers if the user answer is correct
        if (rightAnswer) {
            MainActivity.correctAnswers++;
        }
        Intent nextQuestion = new Intent(this, QuestionEight.class);
        startActivity(nextQuestion);

    }

    /**
     * Prevents user to go to the previous question
     */
    @Override
    public void onBackPressed() {
    }

}
