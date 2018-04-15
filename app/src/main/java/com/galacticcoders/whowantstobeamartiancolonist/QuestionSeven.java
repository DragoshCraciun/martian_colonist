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

        // giving toast feedback and changing button to move to next question
        if (inputAnswer) {
            if (checkAnswer) {
                Intent results = new Intent(this, QuestionEight.class);
                startActivity(results);
            } else {
                checkAnswer = true;

                Button nextQuestion = findViewById(R.id.next_question);
                nextQuestion.setText(R.string.next_question);

                // Add 1 to correctAnswers if all user answers are correct
                if (correctAnswer1 && correctAnswer2 && correctAnswer3 && correctAnswer4) {
                    MainActivity.correctAnswers++;

                    // Make background of correct answer to flash
                    EditText validAnswerMars = findViewById(R.id.marsGod);
                    validAnswerMars.setBackground(getResources().getDrawable(R.drawable.a_valid_user_l_bg));
                    AnimationDrawable flashMars = (AnimationDrawable) validAnswerMars.getBackground();
                    flashMars.start();

                    EditText validAnswerVenus = findViewById(R.id.venusGod);
                    validAnswerVenus.setBackground(getResources().getDrawable(R.drawable.a_valid_user_r_bg));
                    AnimationDrawable flashVenus = (AnimationDrawable) validAnswerVenus.getBackground();
                    flashVenus.start();

                    EditText validAnswerJupiter = findViewById(R.id.jupiterGod);
                    validAnswerJupiter.setBackground(getResources().getDrawable(R.drawable.a_valid_user_l_bg));
                    AnimationDrawable flashJupiter = (AnimationDrawable) validAnswerJupiter.getBackground();
                    flashJupiter.start();

                    EditText validAnswerNeptune = findViewById(R.id.neptuneGod);
                    validAnswerNeptune.setBackground(getResources().getDrawable(R.drawable.a_valid_user_r_bg));
                    AnimationDrawable flashNeptune = (AnimationDrawable) validAnswerNeptune.getBackground();
                    flashNeptune.start();

                    // Toast message to congratulate
                    Toast.makeText(this, R.string.CorrectAnswers, Toast.LENGTH_LONG).show();

                    // Validate individual answers (no points received)
                } else {

                    // Toast message for feedback
                    Toast.makeText(this, R.string.IncorrectAnswers, Toast.LENGTH_LONG).show();

                    if (correctAnswer1) {
                        // Make background of correct answer to flash
                        EditText validAnswerMars = findViewById(R.id.marsGod);
                        validAnswerMars.setBackground(getResources().getDrawable(R.drawable.a_valid_user_l_bg));
                        AnimationDrawable flashMars = (AnimationDrawable) validAnswerMars.getBackground();
                        flashMars.start();
                    } else {
                        // Feedback for wrong answer disclosure.
                        Toast.makeText(this, R.string.marsGodFeedback, Toast.LENGTH_LONG).show();
                    }
                    if (correctAnswer2) {
                        // Make background of correct answer to flash
                        EditText validAnswerVenus = findViewById(R.id.venusGod);
                        validAnswerVenus.setBackground(getResources().getDrawable(R.drawable.a_valid_user_r_bg));
                        AnimationDrawable flashVenus = (AnimationDrawable) validAnswerVenus.getBackground();
                        flashVenus.start();
                    } else {
                        // Feedback for wrong answer disclosure.
                        Toast.makeText(this, R.string.venusGodFeedback, Toast.LENGTH_LONG).show();
                    }
                    if (correctAnswer3) {
                        // Make background of correct answer to flash
                        EditText validAnswerJupiter = findViewById(R.id.jupiterGod);
                        validAnswerJupiter.setBackground(getResources().getDrawable(R.drawable.a_valid_user_l_bg));
                        AnimationDrawable flashJupiter= (AnimationDrawable) validAnswerJupiter.getBackground();
                        flashJupiter.start();
                    } else {
                        // Feedback for wrong answer disclosure.
                        Toast.makeText(this, R.string.jupiterGodFeedback, Toast.LENGTH_LONG).show();
                    }
                    if (correctAnswer4) {
                        // Make background of correct answer to flash
                        EditText validAnswerNeptune = findViewById(R.id.neptuneGod);
                        validAnswerNeptune.setBackground(getResources().getDrawable(R.drawable.a_valid_user_r_bg));
                        AnimationDrawable flashNeptune = (AnimationDrawable) validAnswerNeptune.getBackground();
                        flashNeptune.start();
                    } else {
                        // Feedback for wrong answer disclosure.
                        Toast.makeText(this, R.string.neptuneGodFeedback, Toast.LENGTH_LONG).show();
                    }
                }
            }

          // give feedback for no input
        } if (mars.length() == 0 && venus.length() == 0 && jupiter.length() == 0 && neptune.length() == 0) {
            Toast.makeText(this, R.string.WriteAnswers, Toast.LENGTH_SHORT).show();

        } else {
            // validating answers
            if (mars.getText().toString().trim().equals(getString(R.string.mars_ares))) {
                inputAnswer = true;
                correctAnswer1 = true;
            } else {
                inputAnswer = true;
            }

            if (venus.getText().toString().trim().equals(getString(R.string.venus_aphrodite))) {
                inputAnswer = true;
                correctAnswer2 = true;
            } else {
                inputAnswer = true;
            }

            if (jupiter.getText().toString().trim().equals(getString(R.string.jupiter_zeus))) {
                inputAnswer = true;
                correctAnswer3 = true;
            } else {
                inputAnswer = true;
            }

            if (neptune.getText().toString().trim().equals(getString(R.string.neptune_poseidon))) {
                inputAnswer = true;
                correctAnswer4 = true;
            } else {
                inputAnswer = true;
            }

        }
    }

        /**
         * Prevents user to go to the previous question
         */
        @Override
        public void onBackPressed () {
        }

    }
