package com.galacticcoders.whowantstobeamartiancolonist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

public class QuestionEight extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_eight);
    }

    public void onCheckboxClick(View view) {
        // Is the box now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch (view.getId()) {
            case R.id.phobos:
                if (checked) {
                    // Show validity of the answer as a toast
                    Toast.makeText(this, "Right answer!", Toast.LENGTH_SHORT).show();
                    MainActivity.correctAnswers++;
                }
                break;
            case R.id.deimos:
                if (checked) {
                    // Show validity of the answer as a toast
                    Toast.makeText(this, "Right answer!", Toast.LENGTH_SHORT).show();
                    MainActivity.correctAnswers++;
                }
                break;
            case R.id.callisto:
                if (checked) {
                    // Show validity of the answer as a toast
                    Toast.makeText(this, "Wrong answer!", Toast.LENGTH_SHORT).show();
                    MainActivity.wrongAnswers++;
                }
                break;
            case R.id.titan:
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
        Intent nextQuestion = new Intent(this, QuestionNine.class);
        startActivity(nextQuestion);

    }

    /**
     * Prevents user to go to the previous question
     */
    @Override
    public void onBackPressed() {
    }

}
