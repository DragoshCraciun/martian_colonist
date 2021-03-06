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

public class QuestionFour extends AppCompatActivity {

    // boolean for correct answer.
    public boolean correctAnswer = false;
    // boolean for checking if at least one answer has been selected
    boolean selectAnswer = false;
    // boolean for validating answer.
    boolean checkAnswer = false;

    // booleans for wrong answer disclosure
    boolean venusAtm = false;
    boolean earthAtm = false;
    boolean titanAtm = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.question_four);
    }

    public void onAnswerClick(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // RadioGroup objects for clearCheck()
        RadioGroup rg_1 = (RadioGroup) findViewById(R.id.rg_1);
        RadioGroup rg_2 = (RadioGroup) findViewById(R.id.rg_2);

        // Check which checkbox was clicked
        switch (view.getId()) {
            case R.id.marsAtm:
                if (checked) {
                    // Show validity of the answer as a toast
                    Toast.makeText(this, R.string.FinalAnswer, Toast.LENGTH_SHORT).show();
                    selectAnswer = true;
                    correctAnswer = true;
                    venusAtm = false;
                    earthAtm = false;
                    titanAtm = false;
                    rg_2.clearCheck();
                }
                break;
            case R.id.venusAtm:
                if (checked) {
                    // Show validity of the answer as a toast
                    Toast.makeText(this, R.string.FinalAnswer, Toast.LENGTH_SHORT).show();
                    selectAnswer = true;
                    venusAtm = true;
                    correctAnswer = false;
                    earthAtm = false;
                    titanAtm = false;
                    rg_2.clearCheck();
                }
                break;
            case R.id.earthAtm:
                if (checked) {
                    // Show validity of the answer as a toast
                    Toast.makeText(this, R.string.FinalAnswer, Toast.LENGTH_SHORT).show();
                    selectAnswer = true;
                    earthAtm = true;
                    correctAnswer = false;
                    venusAtm = false;
                    titanAtm = false;
                    rg_1.clearCheck();
                }
                break;
            case R.id.titanAtm:
                if (checked) {
                    // Show validity of the answer as a toast
                    Toast.makeText(this, R.string.FinalAnswer, Toast.LENGTH_SHORT).show();
                    selectAnswer = true;
                    titanAtm = true;
                    correctAnswer = false;
                    venusAtm = false;
                    earthAtm = false;
                    rg_1.clearCheck();
                }
                break;
        }
    }

    // Intent to move to the next question
    public void nextQuestion(View view) {

        if (selectAnswer) {
            if (checkAnswer) {
                Intent results = new Intent(this, QuestionFive.class);
                startActivity(results);
            } else {
                checkAnswer = true;

                // Change the name of the button from validate to next question
                Button nextQuestion = findViewById(R.id.next_question);
                nextQuestion.setText(R.string.next_question);

                // Disable the buttons
                Button btnMarsAtm = (Button) findViewById(R.id.marsAtm);
                btnMarsAtm.setEnabled(false);
                Button btnVenusAtm = (Button) findViewById(R.id.venusAtm);
                btnVenusAtm.setEnabled(false);
                Button btnEarthAtm = (Button) findViewById(R.id.earthAtm);
                btnEarthAtm.setEnabled(false);
                Button btnTitanAtm = (Button) findViewById(R.id.titanAtm);
                btnTitanAtm.setEnabled(false);

                // Add 1 to correctAnswers if the user answer is correct
                if (correctAnswer) {
                    MainActivity.correctAnswers++;

                    // Make background of correct answer to flash
                    btnMarsAtm.setBackground(getResources().getDrawable(R.drawable.a_valid_user_l_bg));
                    AnimationDrawable falshUserMarsAtm = (AnimationDrawable) btnMarsAtm.getBackground();
                    falshUserMarsAtm.start();

                    // Toast message to congratulate
                    Toast.makeText(this, R.string.CorrectAnswer, Toast.LENGTH_LONG).show();

                } else {
                    // Make background of correct answer to flash
                    btnMarsAtm.setBackground(getResources().getDrawable(R.drawable.a_valid_l_bg));
                    AnimationDrawable flashMarsAtn = (AnimationDrawable) btnMarsAtm.getBackground();
                    flashMarsAtn.start();

                    // Toast message for feedback
                    Toast.makeText(this, R.string.IncorrectAnswer, Toast.LENGTH_SHORT).show();

                // Feedback for wrong answer disclosure.
                } if (venusAtm) {
                    Toast.makeText(this, R.string.venusAtmFeedback, Toast.LENGTH_LONG).show();
                } if (earthAtm) {
                    Toast.makeText(this, R.string.earthAtmFeedback, Toast.LENGTH_LONG).show();
                } if (titanAtm) {
                    Toast.makeText(this, R.string.titanAtmFeedback, Toast.LENGTH_LONG).show();
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
