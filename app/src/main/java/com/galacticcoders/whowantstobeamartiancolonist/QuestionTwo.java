package com.galacticcoders.whowantstobeamartiancolonist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

public class QuestionTwo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_two);
    }

    public void onRadioButtonClick(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.mars:
                if (checked) {
                    // Show validity of the answer as a toast
                    Toast.makeText(this, "Right answer!", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.venus:
                if (checked) {
                    // Show validity of the answer as a toast
                    Toast.makeText(this, "Wrong answer!", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.mercury:
                if (checked) {
                    // Show validity of the answer as a toast
                    Toast.makeText(this, "Wrong answer!", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.jupiter:
                if (checked) {
                    // Show validity of the answer as a toast
                    Toast.makeText(this, "Wrong answer!", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
