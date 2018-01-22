package com.galacticcoders.whowantstobeamartiancolonist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

public class QuestionOne extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_one);
    }

    public void onRadioButtonClick(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.hydrogen:
                if (checked) {
                    // Show validity of the answer as a toast
                    Toast.makeText(this, "Right answer!", Toast.LENGTH_SHORT).show();
                    Intent nextQuestion = new Intent(this, QuestionTwo.class);
                    startActivity(nextQuestion);
                }
                break;
            case R.id.helium:
                if (checked) {
                    // Show validity of the answer as a toast
                    Toast.makeText(this, "Wrong answer!", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.nitrogen:
                if (checked) {
                    // Show validity of the answer as a toast
                    Toast.makeText(this, "Wrong answer!", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.oxygen:
                if (checked) {
                    // Show validity of the answer as a toast
                    Toast.makeText(this, "Wrong answer!", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
