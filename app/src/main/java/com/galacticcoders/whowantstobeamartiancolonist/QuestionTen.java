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

public class QuestionTen extends AppCompatActivity {

    // boolean for correct answer.
    public boolean correctAnswer = false;
    // boolean for checking if at least one answer has been selected
    boolean selectAnswer = false;
    // boolean for validating answer.
    boolean checkAnswer = false;

    // booleans for wrong answer disclosure
    boolean venusYear = false;
    boolean jupiterYear = false;
    boolean mercuryYear = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.question_ten);
    }

    public void onAnswerClick(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // RadioGroup objects for clearCheck()
        RadioGroup rg_1 = (RadioGroup) findViewById(R.id.rg_1);
        RadioGroup rg_2 = (RadioGroup) findViewById(R.id.rg_2);

        // Check which checkbox was clicked
        switch (view.getId()) {
            case R.id.marsYear:
                if (checked) {
                    // Show validity of the answer as a toast
                    Toast.makeText(this, R.string.FinalAnswer, Toast.LENGTH_SHORT).show();
                    selectAnswer = true;
                    correctAnswer = true;
                    venusYear = false;
                    jupiterYear = false;
                    mercuryYear = false;
                    rg_2.clearCheck();
                }
                break;
            case R.id.venusYear:
                if (checked) {
                    // Show validity of the answer as a toast
                    Toast.makeText(this, R.string.FinalAnswer, Toast.LENGTH_SHORT).show();
                    selectAnswer = true;
                    venusYear = true;
                    correctAnswer = false;
                    jupiterYear = false;
                    mercuryYear = false;
                    rg_2.clearCheck();
                }
                break;
            case R.id.jupiterYear:
                if (checked) {
                    // Show validity of the answer as a toast
                    Toast.makeText(this, R.string.FinalAnswer, Toast.LENGTH_SHORT).show();
                    jupiterYear = true;
                    selectAnswer = true;
                    correctAnswer = false;
                    venusYear = false;
                    mercuryYear = false;
                    rg_1.clearCheck();
                }
                break;
            case R.id.mercuryYear:
                if (checked) {
                    // Show validity of the answer as a toast
                    Toast.makeText(this, R.string.FinalAnswer, Toast.LENGTH_SHORT).show();
                    mercuryYear = true;
                    selectAnswer = true;
                    correctAnswer = false;
                    venusYear = false;
                    jupiterYear = false;
                    rg_1.clearCheck();
                }
                break;
        }
    }

    // Intent to move to the next question
    public void nextQuestion(View view) {

        if (selectAnswer) {
            if (checkAnswer) {
                Intent results = new Intent(this, ResultActivity.class);
                startActivity(results);

            } else {
                checkAnswer = true;

                // Change the name of the button from validate to next question
                Button nextQuestion = findViewById(R.id.next_question);
                nextQuestion.setText(R.string.results);

                // Disable the buttons
                Button btnMarsYear = (Button) findViewById(R.id.marsYear);
                btnMarsYear.setEnabled(false);
                Button btnVenusYear = (Button) findViewById(R.id.venusYear);
                btnVenusYear.setEnabled(false);
                Button btnJupiterYear = (Button) findViewById(R.id.jupiterYear);
                btnJupiterYear.setEnabled(false);
                Button btnMercuryYear = (Button) findViewById(R.id.mercuryYear);
                btnMercuryYear.setEnabled(false);

                // Add 1 to correctAnswers if the user answer is correct.
                if (correctAnswer) {
                    MainActivity.correctAnswers++;

                    // Make background of correct answer to flash.
                    btnMarsYear.setBackground(getResources().getDrawable(R.drawable.a_valid_user_l_bg));
                    AnimationDrawable flashMarsUserYear = (AnimationDrawable) btnMarsYear.getBackground();
                    flashMarsUserYear.start();

                    // Toast message to congratulate
                    Toast.makeText(this, R.string.CorrectAnswer, Toast.LENGTH_SHORT).show();
                    Toast.makeText(this, R.string.quizOver, Toast.LENGTH_LONG).show();

                } else {
                    // Make background of correct answer to flash.
                    btnMarsYear.setBackground(getResources().getDrawable(R.drawable.a_valid_l_bg));
                    AnimationDrawable flashMarsYear = (AnimationDrawable) btnMarsYear.getBackground();
                    flashMarsYear.start();

                    // Toast message for feedback.
                    Toast.makeText(this, R.string.IncorrectAnswer, Toast.LENGTH_SHORT).show();

                // Feedback for wrong answer disclosure.
                } if (venusYear) {
                    Toast.makeText(this, R.string.venusYearFeedback, Toast.LENGTH_LONG).show();
                } if (jupiterYear) {
                    Toast.makeText(this, R.string.jupiterYearFeedback, Toast.LENGTH_LONG).show();
                } if (mercuryYear) {
                    Toast.makeText(this, R.string.mercuryYearFeedback, Toast.LENGTH_LONG).show();
                }

                // Toast for announcing the quiz is over.
                Toast.makeText(this, R.string.quizOver, Toast.LENGTH_LONG).show();
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
