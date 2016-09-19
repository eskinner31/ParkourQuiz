package com.example.android.parkourquiz;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

public class QuestionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);
    }

    private boolean checkFirstResponse() {
        RadioButton firstResponse = (RadioButton) findViewById(R.id.tim_shieff);
        if(firstResponse.isChecked()) {
            return true;
        }
        return false;
    }

    private boolean checkSecondResponse() {
        CheckBox firstAnswer = (CheckBox) findViewById(R.id.parkour);
        CheckBox secondAnswer = (CheckBox) findViewById(R.id.free_running);
        CheckBox thirdAnswer = (CheckBox) findViewById(R.id.hardcore);
        CheckBox fourthAnswer = (CheckBox) findViewById(R.id.ninja);

        if(thirdAnswer.isChecked() || fourthAnswer.isChecked()) {
            return false;
        } else if(firstAnswer.isChecked() && secondAnswer.isChecked()) {
            return true;
        }
        return false;
    }

    private boolean checkThirdResponse() {
        EditText thirdResponse = (EditText) findViewById(R.id.third_response);
        String thirdResponseText = thirdResponse.getText().toString().toLowerCase();
        Log.d("Third Response", "checkThirdResponse: " + thirdResponseText);
      if(thirdResponseText.equals("urban evolution")) {
          return true;
      }
        return false;
    }

    private boolean checkFourthResponse() {
        RadioButton fourthResponse = (RadioButton) findViewById(R.id.james_bond);

      if(fourthResponse.isChecked()) {
          return true;
      }
        return false;
    }

    private boolean checkFifthRepsonse() {
        RadioButton fifthResponse = (RadioButton) findViewById(R.id.everyone);

        if (fifthResponse.isChecked()) {
            return true;
        }
        return false;
    }

    public void checkResults(View v) {



        boolean[] results = {
                checkFirstResponse(),
                checkSecondResponse(),
                checkThirdResponse(),
                checkFourthResponse(),
                checkFifthRepsonse()
        };

        boolean finalResponse = true;

        for (int i = 0; i < 4; i++) {
            if (!results[i]) {
                finalResponse = false;
            }
        }

        Log.d("first", "result is" + checkFirstResponse());
        Log.d("second", "result is:" + checkSecondResponse());
        Log.d("third", "result is:" + checkThirdResponse());
        Log.d("fourth", "result is:" + checkFourthResponse());
        Log.d("fifth", "result is:" + checkFifthRepsonse());

        if (finalResponse) {
            AlertDialog alertDialog = new AlertDialog.Builder(QuestionsActivity.this).create();
            alertDialog.setTitle("Great Job");
            alertDialog.setMessage("You've answered all questions correctly");
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            alertDialog.show();
        } else {
            AlertDialog alertDialog = new AlertDialog.Builder(QuestionsActivity.this).create();
            alertDialog.setTitle("You Don't Know Parkour");
            alertDialog.setMessage("One of your answers is incorrect!");
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            alertDialog.show();
        }


    }
}
