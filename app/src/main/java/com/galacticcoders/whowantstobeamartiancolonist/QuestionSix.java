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

public class QuestionSix extends AppCompatActivity {

    // boolean for correct answer.
    public boolean correctAnswer = false;
    // boolean for checking if at least one answer has been selected
    boolean selectAnswer = false;
    // boolean for validating answer.
    boolean checkAnswer = false;

    // booleans for wrong answer disclosure
    boolean venusAU = false;
    boolean jupiterAU = false;
    boolean saturnAU = false;

    // boolean for AU info toast
    boolean infoAU = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.question_six);
    }

    public void onAnswerClick(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        RadioGroup rg_1 = (RadioGroup) findViewById(R.id.rg_1);
        RadioGroup rg_2 = (RadioGroup) findViewById(R.id.rg_2);

        // Check which checkbox was clicked
        switch (view.getId()) {
            case R.id.marsAU:
                if (checked) {
                    // Toast for displaying one time info abut AU
                    if (!infoAU) {
                        Toast.makeText(this, R.string.AuFeedback, Toast.LENGTH_LONG).show();
                        infoAU = true;
                    }
                    // Toast for final answer confirmation.
                    Toast.makeText(this, R.string.FinalAnswer, Toast.LENGTH_SHORT).show();
                    selectAnswer = true;
                    correctAnswer = true;
                    venusAU = false;
                    jupiterAU = false;
                    saturnAU = false;
                    rg_2.clearCheck();
                }
                break;
            case R.id.venusAU:
                if (checked) {
                    // Toast for displaying one time info abut AU
                    if (!infoAU) {
                        Toast.makeText(this, R.string.AuFeedback, Toast.LENGTH_LONG).show();
                        infoAU = true;
                    }
                    // Toast for final answer confirmation.
                    Toast.makeText(this, R.string.FinalAnswer, Toast.LENGTH_SHORT).show();
                    selectAnswer = true;
                    venusAU = true;
                    correctAnswer = false;
                    jupiterAU = false;
                    saturnAU = false;
                    rg_2.clearCheck();
                }
                break;
            case R.id.jupiterAU:
                if (checked) {
                    // Toast for displaying one time info abut AU
                    if (!infoAU) {
                        Toast.makeText(this, R.string.AuFeedback, Toast.LENGTH_LONG).show();
                        infoAU = true;
                    }
                    // Toast for final answer confirmation.
                    Toast.makeText(this, R.string.FinalAnswer, Toast.LENGTH_SHORT).show();
                    selectAnswer = true;
                    jupiterAU = true;
                    correctAnswer = false;
                    venusAU = false;
                    saturnAU = false;
                    rg_1.clearCheck();
                }
                break;
            case R.id.saturnAU:
                if (checked) {
                    // Toast for displaying one time info abut AU
                    if (!infoAU) {
                        Toast.makeText(this, R.string.AuFeedback, Toast.LENGTH_LONG).show();
                        infoAU = true;
                    }
                    // Toast for final answer confirmation.
                    Toast.makeText(this, R.string.FinalAnswer, Toast.LENGTH_SHORT).show();
                    selectAnswer = true;
                    saturnAU = true;
                    correctAnswer = false;
                    venusAU = false;
                    jupiterAU = false;
                    rg_1.clearCheck();
                }
                break;
        }
    }

    // Intent to move to the next question
    public void nextQuestion(View view) {

        if (selectAnswer) {
            if (checkAnswer) {
                Intent results = new Intent(this, QuestionSeven.class);
                startActivity(results);
            } else {
                checkAnswer = true;

                // Change the name of the button from validate to next question
                Button nextQuestion = findViewById(R.id.next_question);
                nextQuestion.setText(R.string.next_question);

                // Disable the buttons
                Button btnMarsAU = (Button) findViewById(R.id.marsAU);
                btnMarsAU.setEnabled(false);
                Button btnVenusAU = (Button) findViewById(R.id.venusAU);
                btnVenusAU.setEnabled(false);
                Button btnJupiterAU = (Button) findViewById(R.id.jupiterAU);
                btnJupiterAU.setEnabled(false);
                Button btnSaturnAU = (Button) findViewById(R.id.saturnAU);
                btnSaturnAU.setEnabled(false);

                // Add 1 to correctAnswers if the user answer is correct
                if (correctAnswer) {
                    MainActivity.correctAnswers++;

                    // Make background of correct answer to flash
                    btnMarsAU.setBackground(getResources().getDrawable(R.drawable.a_valid_user_l_bg));
                    AnimationDrawable flashUserMarsAU= (AnimationDrawable) btnMarsAU.getBackground();
                    flashUserMarsAU.start();

                    // Toast message to congratulate
                    Toast.makeText(this, R.string.CorrectAnswer, Toast.LENGTH_LONG).show();

                } else {
                    // Make background of correct answer to flash
                    btnMarsAU.setBackground(getResources().getDrawable(R.drawable.a_valid_l_bg));
                    AnimationDrawable flashMarsAU = (AnimationDrawable) btnMarsAU.getBackground();
                    flashMarsAU.start();

                    // Toast message for feedback
                    Toast.makeText(this, R.string.IncorrectAnswer, Toast.LENGTH_SHORT).show();

                // Feedback for wrong answer disclosure.
                } if (venusAU) {
                    Toast.makeText(this, R.string.venusAuFeedback, Toast.LENGTH_LONG).show();
                } if (jupiterAU) {
                    Toast.makeText(this, R.string.jupiterAuFeedback, Toast.LENGTH_LONG).show();
                } if (saturnAU) {
                    Toast.makeText(this, R.string.saturnAuFeedback, Toast.LENGTH_LONG).show();
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
