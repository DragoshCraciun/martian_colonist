package com.galacticcoders.whowantstobeamartiancolonist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class QuestionTen extends AppCompatActivity {

    public boolean rightAnswer = false;

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
                    Toast.makeText(this, "Is this your final answer?", Toast.LENGTH_SHORT).show();
                    rightAnswer = true;
                    rg_2.clearCheck();
                }
                break;
            case R.id.venusYear:
                if (checked) {
                    // Show validity of the answer as a toast
                    Toast.makeText(this, "Is this your final answer?", Toast.LENGTH_SHORT).show();
                    rg_2.clearCheck();
                }
                break;
            case R.id.jupiterYear:
                if (checked) {
                    // Show validity of the answer as a toast
                    Toast.makeText(this, "Is this your final answer?", Toast.LENGTH_SHORT).show();
                    rg_1.clearCheck();
                }
                break;
            case R.id.mercuryYear:
                if (checked) {
                    // Show validity of the answer as a toast
                    Toast.makeText(this, "Is this your final answer?", Toast.LENGTH_SHORT).show();
                    rg_1.clearCheck();
                }
                break;
        }
    }

    // Intent to move to the next question
    public void nextQuestion(View view) {
        // Add 1 to correctAnswers if the user answer is correct
        if (rightAnswer) {
            MainActivity.correctAnswers++;
        }
        Intent results = new Intent(this, ResultActivity.class);
        startActivity(results);
    }

    /**
     * Prevents user to go to the previous question
     */
    @Override
    public void onBackPressed() {
    }

}
