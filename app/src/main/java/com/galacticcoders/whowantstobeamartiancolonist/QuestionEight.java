package com.galacticcoders.whowantstobeamartiancolonist;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class QuestionEight extends AppCompatActivity {

    // booleans for correct answers.
    public boolean correctAnswer1 = false;
    public boolean correctAnswer2 = false;

    // boolean for checking if at least one answer has been selected
    boolean selectAnswer = false;
    // boolean for validating answer.
    boolean checkAnswer = false;

    // booleans for wrong answer disclosure
    boolean callisto = false;
    boolean titan = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.question_eight);
    }

    public void onAnswerClick(View view) {
        // Is the box now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch (view.getId()) {
            case R.id.phobos:
                if (checked) {
                    // Show validity of the answer as a toast
                    Toast.makeText(this, R.string.FinalAnswer, Toast.LENGTH_SHORT).show();
                    selectAnswer = true;
                    correctAnswer1 = true;
                } else {
                    correctAnswer1 = false;
                }
                break;
            case R.id.deimos:
                if (checked) {
                    // Show validity of the answer as a toast
                    Toast.makeText(this, R.string.FinalAnswer, Toast.LENGTH_SHORT).show();
                    selectAnswer = true;
                    correctAnswer2 = true;
                } else {
                    correctAnswer2 = false;
                }
                break;
            case R.id.callisto:
                if (checked) {
                    // Show validity of the answer as a toast
                    Toast.makeText(this, R.string.FinalAnswer, Toast.LENGTH_SHORT).show();
                    selectAnswer = true;
                    callisto = true;
                } else {
                    callisto = false;
                }
                break;
            case R.id.titan:
                if (checked) {
                    // Show validity of the answer as a toast
                    Toast.makeText(this, R.string.FinalAnswer, Toast.LENGTH_SHORT).show();
                    selectAnswer = true;
                    titan = true;
                } else {
                    titan = false;
                }
                break;
        }
    }

    // Intent to move to the next question
    public void nextQuestion(View view) {

        if (selectAnswer) {
            if (checkAnswer) {
                Intent results = new Intent(this, QuestionNine.class);
                startActivity(results);
            } else {
                checkAnswer = true;

                // Change the name of the button from validate to next question
                Button nextQuestion = findViewById(R.id.next_question);
                nextQuestion.setText(R.string.next_question);

                // Disable the buttons
                Button btnPhobos = (Button) findViewById(R.id.phobos);
                btnPhobos.setEnabled(false);
                Button btnDeimos = (Button) findViewById(R.id.deimos);
                btnDeimos.setEnabled(false);
                Button btnCallisto = (Button) findViewById(R.id.callisto);
                btnCallisto.setEnabled(false);
                Button btnTitan = (Button) findViewById(R.id.titan);
                btnTitan.setEnabled(false);

                // Make background of correct answers flash
                btnPhobos.setBackground(getResources().getDrawable(R.drawable.a_valid_l_bg));
                AnimationDrawable flashPhobos = (AnimationDrawable) btnPhobos.getBackground();

                btnDeimos.setBackground(getResources().getDrawable(R.drawable.a_valid_r_bg));
                AnimationDrawable flashDeimos = (AnimationDrawable) btnDeimos.getBackground();

                // Make background of user correct answers flash
                btnPhobos.setBackground(getResources().getDrawable(R.drawable.a_valid_user_l_bg));
                AnimationDrawable flashUserPhobos = (AnimationDrawable) btnPhobos.getBackground();

                btnDeimos.setBackground(getResources().getDrawable(R.drawable.a_valid_user_r_bg));
                AnimationDrawable flashUserDeimos = (AnimationDrawable) btnDeimos.getBackground();

                // Add 1 to correctAnswers if all the user answers are correct
                if (correctAnswer1 && correctAnswer2 && !callisto && !titan) {
                    MainActivity.correctAnswers++;

                    // Make background of correct answer to flash 
                    flashUserPhobos.start();
                    flashUserDeimos.start();

                    // Toast message to congratulate
                    Toast.makeText(this, R.string.CorrectAnswers, Toast.LENGTH_LONG).show();

                } else {
                    // Make background of correct answer to flash
                    if (correctAnswer1) {
                        flashUserPhobos.start();
                    } else {
                        flashPhobos.start();
                    }
                    if (correctAnswer2) {
                        flashUserDeimos.start();
                    } else {
                        flashDeimos.start();
                    }

                    // Toast message for feedback
                    Toast.makeText(this, R.string.IncorrectAnswers, Toast.LENGTH_LONG).show();

                }
                // Feedback for wrong answer disclosure.
                if (callisto) {
                    Toast.makeText(this, R.string.callistoFeedback, Toast.LENGTH_LONG).show();
                }
                if (titan) {
                    Toast.makeText(this, R.string.titanFeedback, Toast.LENGTH_LONG).show();
                }
            }
        } else {
            Toast.makeText(this, R.string.SelectAnswers, Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Prevents user to go to the previous question
     */
    @Override
    public void onBackPressed() {
    }

}
