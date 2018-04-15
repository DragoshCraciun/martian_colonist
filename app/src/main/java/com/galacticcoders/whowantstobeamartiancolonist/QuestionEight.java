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
                }
                break;
            case R.id.deimos:
                if (checked) {
                    // Show validity of the answer as a toast
                    Toast.makeText(this, R.string.FinalAnswer, Toast.LENGTH_SHORT).show();
                    selectAnswer = true;
                    correctAnswer2 = true;
                }
                break;
            case R.id.callisto:
                if (checked) {
                    // Show validity of the answer as a toast
                    Toast.makeText(this, R.string.FinalAnswer, Toast.LENGTH_SHORT).show();
                    selectAnswer = true;
                }
                break;
            case R.id.titan:
                if (checked) {
                    // Show validity of the answer as a toast
                    Toast.makeText(this, R.string.FinalAnswer, Toast.LENGTH_SHORT).show();
                    selectAnswer = true;
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

                Button nextQuestion = findViewById(R.id.next_question);
                nextQuestion.setText(R.string.next_question);

                // Add 1 to correctAnswers if all the user answers are correct
                if (correctAnswer1 && correctAnswer2) {
                    MainActivity.correctAnswers++;

                    // Make background of correct answer to flash
                    Button validAnswer1 = findViewById(R.id.phobos);
                    validAnswer1.setBackground(getResources().getDrawable(R.drawable.a_valid_l_bg));
                    AnimationDrawable frameAnimation1 = (AnimationDrawable) validAnswer1.getBackground();
                    frameAnimation1.start();

                    Button validAnswer2 = findViewById(R.id.deimos);
                    validAnswer2.setBackground(getResources().getDrawable(R.drawable.a_valid_r_bg));
                    AnimationDrawable frameAnimation2 = (AnimationDrawable) validAnswer2.getBackground();
                    frameAnimation2.start();

                    // Toast message to congratulate
                    Toast.makeText(this, R.string.CorrectAnswers, Toast.LENGTH_LONG).show();

                } else {
                    // Make background of correct answer to flash
                    Button validAnswer1 = findViewById(R.id.phobos);
                    validAnswer1.setBackground(getResources().getDrawable(R.drawable.a_valid_l_bg));
                    AnimationDrawable frameAnimation1 = (AnimationDrawable) validAnswer1.getBackground();
                    frameAnimation1.start();

                    Button validAnswer2 = findViewById(R.id.deimos);
                    validAnswer2.setBackground(getResources().getDrawable(R.drawable.a_valid_r_bg));
                    AnimationDrawable frameAnimation2 = (AnimationDrawable) validAnswer2.getBackground();
                    frameAnimation2.start();

                    // Toast message for feedback
                    Toast.makeText(this, R.string.IncorrectAnswers, Toast.LENGTH_LONG).show();
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
