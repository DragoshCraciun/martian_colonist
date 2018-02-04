package com.galacticcoders.whowantstobeamartiancolonist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.Toast;

public class QuestionThree extends AppCompatActivity {

    public boolean rightAnswer1 = false;
    public boolean rightAnswer2 = false;

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
                    rightAnswer1 = true;
                }
                break;
            case R.id.carbon_dioxide:
                if (checked) {
                    // Show validity of the answer as a toast
                    Toast.makeText(this, R.string.FinalAnswer, Toast.LENGTH_SHORT).show();
                    rightAnswer2 = true;
                }
                break;
            case R.id.methane:
                if (checked) {
                    // Show validity of the answer as a toast
                    Toast.makeText(this, R.string.FinalAnswer, Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.ammonia:
                if (checked) {
                    // Show validity of the answer as a toast
                    Toast.makeText(this, R.string.FinalAnswer, Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    // Intent to move to the next question
    public void nextQuestion(View view) {
        // Add 1 to correctAnswers if the user answer is correct
        if (rightAnswer1 && rightAnswer2) {
            MainActivity.correctAnswers++;
        }
        Intent nextQuestion = new Intent(this, QuestionFour.class);
        startActivity(nextQuestion);

    }

    /**
     * Prevents user to go to the previous question
     */
    @Override
    public void onBackPressed() {
    }

}
