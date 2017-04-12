package com.example.android.a4_glorious_quiz;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitAnswers(View view) {
        int score = 0;

        // Question 1 - EditText
        EditText enterAnswer = (EditText) findViewById(R.id.herName);
        String yourAnswer = enterAnswer.getText().toString();
        String herName = "Margaret Thatcher";
        if (yourAnswer.equals(herName)) {
            score = score + 1;
        }

        // Question 2 - CheckBox
        CheckBox checkOneOne = (CheckBox) findViewById(R.id.q2check_1);
        boolean oneOne = checkOneOne.isChecked();
        CheckBox checkOneTwo = (CheckBox) findViewById(R.id.q2check_2);
        boolean oneTwo = checkOneTwo.isChecked();
        CheckBox checkOneThree = (CheckBox) findViewById(R.id.q2check_3);
        boolean oneThree = checkOneThree.isChecked();
        CheckBox checkOneFour = (CheckBox) findViewById(R.id.q2check_4);
        boolean oneFour = checkOneFour.isChecked();
        if ((oneFour)) {
            score = score + 1;
        }

        // Question 3 - RadioButton
        RadioButton checkRadioThree = (RadioButton) findViewById(R.id.q3radio_3);
        boolean RadioThreeCorrect = checkRadioThree.isChecked();
        if (RadioThreeCorrect) {
            score = score + 1;
        }

        // Question 4 - CheckBox
        CheckBox checkFourOne = (CheckBox) findViewById(R.id.q4check_1);
        boolean fourOne = checkFourOne.isChecked();
        CheckBox checkFourTwo = (CheckBox) findViewById(R.id.q4check_2);
        boolean fourTwo = checkFourTwo.isChecked();
        CheckBox checkFourThree = (CheckBox) findViewById(R.id.q4check_3);
        boolean fourThree = checkFourThree.isChecked();
        CheckBox checkFourFour = (CheckBox) findViewById(R.id.q4check_4);
        boolean fourFour = checkFourFour.isChecked();
        if ((fourOne) && (!fourTwo) && (!fourThree) && (fourFour)) {
            score = score + 1;
        }

        // Question 5 - RadioButton
        RadioButton checkRadioFive = (RadioButton) findViewById(R.id.q5radio_2);
        boolean RadioFiveCorrect = checkRadioFive.isChecked();
        if (RadioFiveCorrect) {
            score = score + 1;
        }

        declareWinner(score);
    }

    /**
     * Method to display the popup message in order to declare scores.
     */
    protected void declareWinner(int score) {

        LayoutInflater inflater = (LayoutInflater) getApplicationContext().getSystemService(LAYOUT_INFLATER_SERVICE);
        View winnerView;
        if (score <= 1) {
            winnerView = inflater.inflate(R.layout.winner_popup01, null);
        } else if (score <= 3) {
            winnerView = inflater.inflate(R.layout.winner_popup23, null);
        } else {
            winnerView = inflater.inflate(R.layout.winner_popup45, null);
        }
        final PopupWindow mPopupWindow = new PopupWindow(
                winnerView,
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );

        if (Build.VERSION.SDK_INT >= 21) {
            mPopupWindow.setElevation(6.0f);
        }

        Button resetButton = (Button) winnerView.findViewById(R.id.dismiss);
        resetButton.setOnClickListener(new View.OnClickListener() {
                                           @Override
                                           public void onClick(View view) {
                                               mPopupWindow.dismiss();
                                               resetApp(view);
                                           }
                                       }
        );

        TextView winnerScore = (TextView) winnerView.findViewById(R.id.winner_scoreview);
        String result = "You answered " + score + " of 5 questions.";
        winnerScore.setText(result);

        mPopupWindow.showAtLocation(findViewById(R.id.activity_main), Gravity.BOTTOM, 0, 0);
    }

    //resets app, set all variables and views to initial state

    public void resetApp(View view) {
        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }

}
