package com.galacticcoders.whowantstobeamartiancolonist;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class QuestionOne extends AppCompatActivity {

    // boolean for correct answer.
    public boolean correctAnswer = false;
    // boolean for checking if at least one answer has been selected
    boolean selectAnswer = false;
    // boolean for validating answer.
    boolean checkAnswer = false;

    // booleans for wrong answer disclosure
    boolean helium = false;
    boolean nitrogen = false;
    boolean oxygen = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.question_one);
    }

    public void onAnswerClick(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // RadioGroup objects for clearCheck()
        RadioGroup rg_1 = (RadioGroup) findViewById(R.id.rg_1);
        RadioGroup rg_2 = (RadioGroup) findViewById(R.id.rg_2);

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.hydrogen:
                if (checked) {
                    // Show validity of the answer as a toast
                    Toast.makeText(this, R.string.FinalAnswer, Toast.LENGTH_SHORT).show();
                    selectAnswer = true;
                    correctAnswer = true;
                    rg_2.clearCheck();
                }
                break;
            case R.id.helium:
                if (checked) {
                    // Show validity of the answer as a toast
                    Toast.makeText(this, R.string.FinalAnswer, Toast.LENGTH_SHORT).show();
                    helium = true;
                    selectAnswer = true;
                    rg_2.clearCheck();
                }
                break;
            case R.id.nitrogen:
                if (checked) {
                    // Show validity of the answer as a toast
                    Toast.makeText(this, R.string.FinalAnswer, Toast.LENGTH_SHORT).show();
                    nitrogen = true;
                    selectAnswer = true;
                    rg_1.clearCheck();
                }
                break;
            case R.id.oxygen:
                if (checked) {
                    // Show validity of the answer as a toast
                    Toast.makeText(this, R.string.FinalAnswer, Toast.LENGTH_SHORT).show();
                    oxygen = true;
                    selectAnswer = true;
                    rg_1.clearCheck();
                }
                break;
        }
    }

    // Intent to move to the next question
    public void nextQuestion(View view) {

        if (selectAnswer) {
            if (checkAnswer) {
                Intent results = new Intent(this, QuestionTwo.class);
                startActivity(results);
            } else {
                checkAnswer = true;

                Button nextQuestion = findViewById(R.id.next_question);
                nextQuestion.setText(R.string.next_question);

                // Add 1 to correctAnswers if the user answer is correct
                if (correctAnswer) {
                    MainActivity.correctAnswers++;

                    // Make background of correct answer to flash
                    Button validAnswer = findViewById(R.id.hydrogen);
                    validAnswer.setBackground(getResources().getDrawable(R.drawable.a_valid_l_bg));
                    AnimationDrawable frameAnimation = (AnimationDrawable) validAnswer.getBackground();
                    frameAnimation.start();

                    // Toast message to congratulate
                    Toast.makeText(this, R.string.CorrectAnswer, Toast.LENGTH_LONG).show();

                } else {
                    // Make background of correct answer to flash
                    Button validAnswer = findViewById(R.id.hydrogen);
                    validAnswer.setBackground(getResources().getDrawable(R.drawable.a_valid_l_bg));
                    AnimationDrawable frameAnimation = (AnimationDrawable) validAnswer.getBackground();
                    frameAnimation.start();

                    // Toast message for feedback
                    Toast.makeText(this, R.string.IncorrectAnswer, Toast.LENGTH_SHORT).show();

                // Feedback for wrong answer disclosure.
                } if (helium) {
                    Toast.makeText(this, R.string.heliumFeedback, Toast.LENGTH_LONG).show();
                } if (nitrogen) {
                    Toast.makeText(this, R.string.nitrogenFeedback, Toast.LENGTH_LONG).show();
                } if (oxygen) {
                    Toast.makeText(this, R.string.oxygenFeedback, Toast.LENGTH_LONG).show();
                }
            }
        } else {
            Toast.makeText(this, R.string.SelectAnswer, Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Prevents user to go to the previous question
     */
    @Override
    public void onBackPressed() {
    }

}
