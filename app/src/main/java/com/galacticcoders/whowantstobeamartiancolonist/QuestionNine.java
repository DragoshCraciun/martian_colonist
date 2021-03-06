package com.galacticcoders.whowantstobeamartiancolonist;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class QuestionNine extends AppCompatActivity {

    // boolean for correct answer.
    public boolean correctAnswer = false;
    // boolean for checking if at least one answer has been selected
    boolean selectAnswer = false;
    // boolean for validating answer.
    boolean checkAnswer = false;

    // booleans for wrong answer disclosure
    boolean venusTemp = false;
    boolean earthTemp = false;
    boolean mercuryTemp = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.question_nine);
    }

    public void onAnswerClick(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // RadioGroup objects for clearCheck()
        RadioGroup rg_1 = (RadioGroup) findViewById(R.id.rg_1);
        RadioGroup rg_2 = (RadioGroup) findViewById(R.id.rg_2);

        // Check which checkbox was clicked
        switch (view.getId()) {
            case R.id.marsTemp:
                if (checked) {
                    // Show validity of the answer as a toast
                    Toast.makeText(this, R.string.FinalAnswer, Toast.LENGTH_SHORT).show();
                    selectAnswer = true;
                    correctAnswer = true;
                    venusTemp = false;
                    earthTemp = false;
                    mercuryTemp = false;
                    rg_2.clearCheck();
                }
                break;
            case R.id.venusTemp:
                if (checked) {
                    // Show validity of the answer as a toast
                    Toast.makeText(this, R.string.FinalAnswer, Toast.LENGTH_SHORT).show();
                    selectAnswer = true;
                    venusTemp = true;
                    correctAnswer = false;
                    earthTemp = false;
                    mercuryTemp = false;
                    rg_2.clearCheck();
                }
                break;
            case R.id.earthTemp:
                if (checked) {
                    // Show validity of the answer as a toast
                    Toast.makeText(this, R.string.FinalAnswer, Toast.LENGTH_SHORT).show();
                    selectAnswer = true;
                    earthTemp = true;
                    correctAnswer = false;
                    venusTemp = false;
                    mercuryTemp = false;
                    rg_1.clearCheck();
                }
                break;
            case R.id.mercuryTemp:
                if (checked) {
                    // Show validity of the answer as a toast
                    Toast.makeText(this, R.string.FinalAnswer, Toast.LENGTH_SHORT).show();
                    selectAnswer = true;
                    mercuryTemp = true;
                    correctAnswer = false;
                    venusTemp = false;
                    earthTemp = false;
                    rg_1.clearCheck();
                }
                break;
        }
    }

    // Intent to move to the next question
    public void nextQuestion(View view) {

        if (selectAnswer) {
            if (checkAnswer) {
                Intent results = new Intent(this, QuestionTen.class);
                startActivity(results);
            } else {
                checkAnswer = true;

                // Change the name of the button from validate to next question
                Button nextQuestion = findViewById(R.id.next_question);
                nextQuestion.setText(R.string.next_question);

                // Disable the buttons
                Button btnMarsTemp = (Button) findViewById(R.id.marsTemp);
                btnMarsTemp.setEnabled(false);
                Button btnVenusTemp = (Button) findViewById(R.id.venusTemp);
                btnVenusTemp.setEnabled(false);
                Button btnJupiterTemp = (Button) findViewById(R.id.earthTemp);
                btnJupiterTemp.setEnabled(false);
                Button btnSaturnTemp = (Button) findViewById(R.id.mercuryTemp);
                btnSaturnTemp.setEnabled(false);

                // Add 1 to correctAnswers if the user answer is correct
                if (correctAnswer) {
                    MainActivity.correctAnswers++;

                    // Make background of correct answer to flash
                    btnMarsTemp.setBackground(getResources().getDrawable(R.drawable.a_valid_user_l_bg));
                    AnimationDrawable flashUserMarsTemp = (AnimationDrawable) btnMarsTemp.getBackground();
                    flashUserMarsTemp.start();

                    // Toast message to congratulate
                    Toast.makeText(this, R.string.CorrectAnswer, Toast.LENGTH_LONG).show();

                } else {
                    // Make background of correct answer to flash
                    btnMarsTemp.setBackground(getResources().getDrawable(R.drawable.a_valid_l_bg));
                    AnimationDrawable flashMarsTemp = (AnimationDrawable) btnMarsTemp.getBackground();
                    flashMarsTemp.start();

                    // Toast message for feedback
                    Toast.makeText(this, R.string.IncorrectAnswer, Toast.LENGTH_SHORT).show();

                    // Feedback for wrong answer disclosure.
                }
                if (venusTemp) {
                    Toast.makeText(this, R.string.venusTempFeedback, Toast.LENGTH_LONG).show();
                }
                if (earthTemp) {
                    Toast.makeText(this, R.string.earthTempFeedback, Toast.LENGTH_LONG).show();
                }
                if (mercuryTemp) {
                    Toast.makeText(this, R.string.mercuryTempFeedback, Toast.LENGTH_LONG).show();
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
