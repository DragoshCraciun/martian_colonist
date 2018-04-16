package com.galacticcoders.whowantstobeamartiancolonist;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class QuestionSeven extends AppCompatActivity {

    // booleans for correct answers.
    public boolean correctAnswer1 = false;
    public boolean correctAnswer2 = false;
    public boolean correctAnswer3 = false;
    public boolean correctAnswer4 = false;

    // boolean for checking if there user gave input
    boolean inputAnswer = false;
    // boolean for validating answer.
    boolean checkAnswer = false;

    // variables storing the user input
    private EditText mars;
    private EditText venus;
    private EditText jupiter;
    private EditText neptune;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.question_seven);

        //Initialize user text input
        mars = (EditText) findViewById(R.id.marsGod);
        venus = (EditText) findViewById(R.id.venusGod);
        jupiter = (EditText) findViewById(R.id.jupiterGod);
        neptune = (EditText) findViewById(R.id.neptuneGod);
    }

    // Feedback for final answer
    public void onAnswerClick(View view) {
        Toast.makeText(this, R.string.FinalAnswer, Toast.LENGTH_SHORT).show();
    }


    // Intent to move to the next question
    public void nextQuestion(View view) {

        // Give feedback for no input
        if (mars.length() == 0 && venus.length() == 0 && jupiter.length() == 0 && neptune.length() == 0) {
            Toast.makeText(this, R.string.WriteAnswers, Toast.LENGTH_SHORT).show();

        } else if (checkAnswer) {
            // Move to next question
            Intent results = new Intent(this, QuestionEight.class);
            startActivity(results);

        } else {
            checkAnswer = true;

            // validate answers
            if (mars.getText().toString().trim().equals(getString(R.string.mars_ares)))
                correctAnswer1 = true;
            if (venus.getText().toString().trim().equals(getString(R.string.venus_aphrodite)))
                correctAnswer2 = true;
            if (jupiter.getText().toString().trim().equals(getString(R.string.jupiter_zeus)))
                correctAnswer3 = true;
            if (neptune.getText().toString().trim().equals(getString(R.string.neptune_poseidon)))
                correctAnswer4 = true;

            // Change the name of the button from validate to next question
            Button nextQuestion = findViewById(R.id.next_question);
            nextQuestion.setText(R.string.next_question);

            // Disable the buttons
            EditText textMarsGod = (EditText) findViewById(R.id.marsGod);
            textMarsGod.setEnabled(false);
            EditText textVenusGod = (EditText) findViewById(R.id.venusGod);
            textVenusGod.setEnabled(false);
            EditText textJupiterGod = (EditText) findViewById(R.id.jupiterGod);
            textJupiterGod.setEnabled(false);
            EditText textNeptuneGod = (EditText) findViewById(R.id.neptuneGod);
            textNeptuneGod.setEnabled(false);

            // Make background of correct answers flash
            textMarsGod.setBackground(getResources().getDrawable(R.drawable.a_valid_user_l_bg));
            AnimationDrawable flashMars = (AnimationDrawable) textMarsGod.getBackground();

            textVenusGod.setBackground(getResources().getDrawable(R.drawable.a_valid_user_r_bg));
            AnimationDrawable flashVenus = (AnimationDrawable) textVenusGod.getBackground();

            textJupiterGod.setBackground(getResources().getDrawable(R.drawable.a_valid_user_l_bg));
            AnimationDrawable flashJupiter = (AnimationDrawable) textJupiterGod.getBackground();

            textNeptuneGod.setBackground(getResources().getDrawable(R.drawable.a_valid_user_r_bg));
            AnimationDrawable flashNeptune = (AnimationDrawable) textNeptuneGod.getBackground();

            // Add 1 to correctAnswers if all user answers are correct
            if (correctAnswer1 && correctAnswer2 && correctAnswer3 && correctAnswer4) {
                MainActivity.correctAnswers++;

                // Flash correct answers
                flashMars.start();
                flashVenus.start();
                flashJupiter.start();
                flashNeptune.start();

                // Toast message to congratulate
                Toast.makeText(this, R.string.CorrectAnswers, Toast.LENGTH_LONG).show();

                // Validate individual answers (no points received)
            } else {

                // Toast message for feedback
                Toast.makeText(this, R.string.IncorrectAnswers, Toast.LENGTH_LONG).show();

                if (correctAnswer1) {
                    // Make background of correct answer to flash
                    flashMars.start();
                } else {
                    // Feedback for wrong answer disclosure.
                    Toast.makeText(this, R.string.marsGodFeedback, Toast.LENGTH_LONG).show();
                }
                if (correctAnswer2) {
                    // Make background of correct answer to flash
                    flashVenus.start();
                } else {
                    // Feedback for wrong answer disclosure.
                    Toast.makeText(this, R.string.venusGodFeedback, Toast.LENGTH_LONG).show();
                }
                if (correctAnswer3) {
                    // Make background of correct answer to flash
                    flashJupiter.start();
                } else {
                    // Feedback for wrong answer disclosure.
                    Toast.makeText(this, R.string.jupiterGodFeedback, Toast.LENGTH_LONG).show();
                }
                if (correctAnswer4) {
                    // Make background of correct answer to flash
                    flashNeptune.start();
                } else {
                    // Feedback for wrong answer disclosure.
                    Toast.makeText(this, R.string.neptuneGodFeedback, Toast.LENGTH_LONG).show();
                }
            }
        }

    }

    /**
     * Prevents user to go to the previous question
     */
    @Override
    public void onBackPressed() {
    }

}
