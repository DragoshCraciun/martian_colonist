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

public class QuestionTwo extends AppCompatActivity {

    // boolean for correct answer.
    public boolean correctAnswer = false;
    // boolean for checking if at least one answer has been selected
    boolean selectAnswer = false;
    // boolean for validating answer.
    boolean checkAnswer = false;

    // booleans for wrong answer disclosure
    boolean venus = false;
    boolean mercury = false;
    boolean jupiter = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.question_two);
    }

    public void onAnswerClick(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // RadioGroup objects for clearCheck()
        RadioGroup rg_1 = (RadioGroup) findViewById(R.id.rg_1);
        RadioGroup rg_2 = (RadioGroup) findViewById(R.id.rg_2);

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.mars:
                if (checked) {
                    // Show validity of the answer as a toast
                    Toast.makeText(this, R.string.FinalAnswer, Toast.LENGTH_SHORT).show();
                    selectAnswer = true;
                    correctAnswer = true;
                    venus = false;
                    mercury = false;
                    jupiter = false;
                    rg_2.clearCheck();
                }
                break;
            case R.id.venus:
                if (checked) {
                    // Show validity of the answer as a toast
                    Toast.makeText(this, R.string.FinalAnswer, Toast.LENGTH_SHORT).show();
                    selectAnswer = true;
                    venus = true;
                    correctAnswer = false;
                    mercury = false;
                    jupiter = false;
                    rg_2.clearCheck();
                }
                break;
            case R.id.mercury:
                if (checked) {
                    // Show validity of the answer as a toast
                    Toast.makeText(this, R.string.FinalAnswer, Toast.LENGTH_SHORT).show();
                    selectAnswer = true;
                    mercury = true;
                    correctAnswer = false;
                    venus = false;
                    jupiter = false;
                    rg_1.clearCheck();
                }
                break;
            case R.id.jupiter:
                if (checked) {
                    // Show validity of the answer as a toast
                    Toast.makeText(this, R.string.FinalAnswer, Toast.LENGTH_SHORT).show();
                    selectAnswer = true;
                    jupiter = true;
                    correctAnswer = false;
                    venus = false;
                    mercury = false;
                    rg_1.clearCheck();
                }
                break;
        }
    }

    // Intent to move to the next question
    public void nextQuestion(View view) {

        if (selectAnswer) {
            if (checkAnswer) {
                Intent results = new Intent(this, QuestionThree.class);
                startActivity(results);
            } else {
                checkAnswer = true;

                // Change the name of the button from validate to next question
                Button nextQuestion = findViewById(R.id.next_question);
                nextQuestion.setText(R.string.next_question);

                // Disable the buttons
                Button btnMars = (Button) findViewById(R.id.mars);
                btnMars.setEnabled(false);
                Button btnVenus = (Button) findViewById(R.id.venus);
                btnVenus.setEnabled(false);
                Button btnMercury = (Button) findViewById(R.id.mercury);
                btnMercury.setEnabled(false);
                Button btnJupiter = (Button) findViewById(R.id.jupiter);
                btnJupiter.setEnabled(false);

                // Add 1 to correctAnswers if the user answer is correct
                if (correctAnswer) {
                    MainActivity.correctAnswers++;

                    // Make background of correct answer to flash
                    btnMars.setBackground(getResources().getDrawable(R.drawable.a_valid_user_l_bg));
                    AnimationDrawable flashUserMars = (AnimationDrawable) btnMars.getBackground();
                    flashUserMars.start();

                    // Toast message to congratulate
                    Toast.makeText(this, R.string.CorrectAnswer, Toast.LENGTH_LONG).show();

                } else {
                    // Make background of correct answer to flash
                    btnMars.setBackground(getResources().getDrawable(R.drawable.a_valid_l_bg));
                    AnimationDrawable flashMars = (AnimationDrawable) btnMars.getBackground();
                    flashMars.start();

                    // Toast message for feedback
                    Toast.makeText(this, R.string.IncorrectAnswer, Toast.LENGTH_SHORT).show();

                // Feedback for wrong answer disclosure.
                } if (venus) {
                Toast.makeText(this, R.string.venusFeedback, Toast.LENGTH_LONG).show();
                } if (mercury) {
                    Toast.makeText(this, R.string.mercuryFeedback, Toast.LENGTH_LONG).show();
                } if (jupiter) {
                    Toast.makeText(this, R.string.jupiterFeedback, Toast.LENGTH_LONG).show();
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
