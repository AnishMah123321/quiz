package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;

public class QuizActivity extends AppCompatActivity {

    private Button submitButton;
    private int score;
    private RadioGroup numOneRadionGroup;
    private RadioGroup numTwoRadionGroup;
    private RadioGroup numThreeRadionGroup;
    private RadioGroup numFourRadionGroup;

    private RadioGroup numFiveRadionGroup;
    private RadioGroup numSixRadionGroup;

    private EditText editText;
    private EditText editText1;
    private CheckBox  OneCheckbox ;
    private CheckBox  TwoCheckbox;
    private CheckBox  ThreeCheckbox;
    private CheckBox FourCheckbox;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        submitButton = findViewById(R.id.submit_button);
        editText = findViewById(R.id.edit_text);
        editText1 = findViewById(R.id.id);
        OneCheckbox = findViewById(R.id.one_checkbox);
        TwoCheckbox = findViewById(R.id.two_checkbox);
        ThreeCheckbox = findViewById(R.id.three_checkbox);
        FourCheckbox = findViewById(R.id.four_checkbox);

        numOneRadionGroup = findViewById(R.id.num_one_radio_group);
        numTwoRadionGroup = findViewById(R.id.num_two_radio_group);
        numThreeRadionGroup = findViewById(R.id.num_three_radio_group);
        numFourRadionGroup = findViewById(R.id.num_four_radio_group);
        numFiveRadionGroup = findViewById(R.id.num_five_radio_group);


        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                score = 0;

                if(numOneRadionGroup.getCheckedRadioButtonId() == R.id.transition){
                    score += 1;
                }

                if(numTwoRadionGroup.getCheckedRadioButtonId() == R.id.mainact){
                    score += 1;
                }
                if(numThreeRadionGroup.getCheckedRadioButtonId() == R.id.number){
                    score += 1;
                }
                if(numFourRadionGroup.getCheckedRadioButtonId() == R.id.fournumber){
                    score += 1;
                }

                if(numFiveRadionGroup.getCheckedRadioButtonId() == R.id.listener){
                    score += 1;
                }

                String userAnswer = editText.getText().toString();
                if(userAnswer.equalsIgnoreCase("Twitch")){
                    score += 1;
                }
                String userAnswers = editText1.getText().toString();
                if(userAnswers.equalsIgnoreCase("Valve")){
                    score += 1;
                }

                if(OneCheckbox.isChecked() && TwoCheckbox.isChecked() && !ThreeCheckbox.isChecked() && FourCheckbox.isChecked()){
                    score += 1;
                }

            Intent intent = new Intent(QuizActivity.this, ScoreActivity.class);
            intent.putExtra("SCORE", score+"/8");
            startActivity(intent);

            }
        });


    }
}




