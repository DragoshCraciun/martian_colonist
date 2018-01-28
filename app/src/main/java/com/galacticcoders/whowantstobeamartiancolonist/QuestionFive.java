package com.galacticcoders.whowantstobeamartiancolonist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Toast;

public class QuestionFive extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.question_five);
    }

    public void onRadioButtonClick(View view) {
        // Is the box now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which checkbox was clicked
        switch (view.getId()) {
            case R.id.marsG:
                if (checked) {
                    // Show validity of the answer as a toast
                    Toast.makeText(this, "Right answer!", Toast.LENGTH_SHORT).show();
                    MainActivity.correctAnswers++;
                }
                break;
            case R.id.earthG:
                if (checked) {
                    // Show validity of the answer as a toast
                    Toast.makeText(this, "Wrong answer!", Toast.LENGTH_SHORT).show();
                    MainActivity.wrongAnswers++;
                }
                break;
            case R.id.jupiterG:
                if (checked) {
                    // Show validity of the answer as a toast
                    Toast.makeText(this, "Wrong answer!", Toast.LENGTH_SHORT).show();
                    MainActivity.wrongAnswers++;
                }
                break;
            case R.id.venusG:
                if (checked) {
                    // Show validity of the answer as a toast
                    Toast.makeText(this, "Wrong answer!", Toast.LENGTH_SHORT).show();
                    MainActivity.wrongAnswers++;
                }
                break;
        }
    }

    // Intent to move to the next question
    public void nextQuestion(View view) {
        Intent nextQuestion = new Intent(this, QuestionSix.class);
        startActivity(nextQuestion);
    }

    /**
     * Prevents user to go to the previous question
     */
    @Override
    public void onBackPressed() {
    }

}
