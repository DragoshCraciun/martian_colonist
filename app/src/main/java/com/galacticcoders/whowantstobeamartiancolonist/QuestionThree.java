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

public class QuestionThree extends AppCompatActivity {

    // booleans for correct answers.
    public boolean correctAnswer1 = false;
    public boolean correctAnswer2 = false;

    // boolean for checking if at least one answer has been selected
    boolean selectAnswer = false;
    // boolean for validating answer.
    boolean checkAnswer = false;

    // booleans for wrong answer disclosure
    boolean methane = false;
    boolean ammonia = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.question_three);
    }

    public void onAnswerClick(View view) {
        // Is the box now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch (view.getId()) {
            case R.id.argon:
                if (checked) {
                    // Show validity of the answer as a toast
                    Toast.makeText(this, R.string.FinalAnswer, Toast.LENGTH_SHORT).show();
                    selectAnswer = true;
                    correctAnswer1 = true;
                } else {
                    correctAnswer1 = false;
                }
                break;
            case R.id.carbon_dioxide:
                if (checked) {
                    // Show validity of the answer as a toast
                    Toast.makeText(this, R.string.FinalAnswer, Toast.LENGTH_SHORT).show();
                    selectAnswer = true;
                    correctAnswer2 = true;
                } else {
                    correctAnswer2 = false;
                }
                break;
            case R.id.methane:
                if (checked) {
                    // Show validity of the answer as a toast
                    Toast.makeText(this, R.string.FinalAnswer, Toast.LENGTH_SHORT).show();
                    selectAnswer = true;
                    methane = true;
                } else {
                    methane = false;
                }
                break;
            case R.id.ammonia:
                if (checked) {
                    // Show validity of the answer as a toast
                    Toast.makeText(this, R.string.FinalAnswer, Toast.LENGTH_SHORT).show();
                    selectAnswer = true;
                    ammonia = true;
                } else {
                    ammonia = false;
                }
                break;
        }
    }

    // Intent to move to the next question
    public void nextQuestion(View view) {

        if (selectAnswer) {
            if (checkAnswer) {
                Intent results = new Intent(this, QuestionFour.class);
                startActivity(results);
            } else {
                checkAnswer = true;

                // Change the name of the button from validate to next question
                Button nextQuestion = findViewById(R.id.next_question);
                nextQuestion.setText(R.string.next_question);

                // Disable the buttons
                Button btnArgon = (Button) findViewById(R.id.argon);
                btnArgon.setEnabled(false);
                Button btnCarbonD = (Button) findViewById(R.id.carbon_dioxide);
                btnCarbonD.setEnabled(false);
                Button btnMethane = (Button) findViewById(R.id.methane);
                btnMethane.setEnabled(false);
                Button btnAmmonia = (Button) findViewById(R.id.ammonia);
                btnAmmonia.setEnabled(false);

                // Make background of correct answers flash
                btnArgon.setBackground(getResources().getDrawable(R.drawable.a_valid_l_bg));
                AnimationDrawable flashArgon = (AnimationDrawable) btnArgon.getBackground();

                btnCarbonD.setBackground(getResources().getDrawable(R.drawable.a_valid_r_bg));
                AnimationDrawable flashCarbonD = (AnimationDrawable) btnCarbonD.getBackground();

                // Make background of user correct answers flash
                btnArgon.setBackground(getResources().getDrawable(R.drawable.a_valid_user_l_bg));
                AnimationDrawable flashUserArgon = (AnimationDrawable) btnArgon.getBackground();

                btnCarbonD.setBackground(getResources().getDrawable(R.drawable.a_valid_user_r_bg));
                AnimationDrawable flashUserCarbonD = (AnimationDrawable) btnCarbonD.getBackground();

                // Add 1 to correctAnswers if all the user answers are correct
                if (correctAnswer1 && correctAnswer2 && !methane && !ammonia) {
                    MainActivity.correctAnswers++;

                    // Make background of correct answer to flash
                    flashUserArgon.start();
                    flashUserCarbonD.start();

                    // Toast message to congratulate
                    Toast.makeText(this, R.string.CorrectAnswers, Toast.LENGTH_LONG).show();

                } else {
                    // Make background of correct answer to flash
                    if (correctAnswer1){
                        flashUserArgon.start();
                    } else {
                        flashArgon.start();
                    }
                    if (correctAnswer2){
                        flashUserCarbonD.start();
                    } else {
                        flashCarbonD.start();
                    }

                    // Toast message for feedback
                    Toast.makeText(this, R.string.IncorrectAnswers, Toast.LENGTH_LONG).show();

                // Feedback for wrong answer disclosure.
                } if (methane) {
                    Toast.makeText(this, R.string.methaneFeedback, Toast.LENGTH_LONG).show();
                } if (ammonia) {
                    Toast.makeText(this, R.string.ammoniaFeedback, Toast.LENGTH_LONG).show();
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
