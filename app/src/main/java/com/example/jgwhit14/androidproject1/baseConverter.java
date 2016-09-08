package com.example.jgwhit14.androidproject1;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class baseConverter extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_converter);

        View submit = findViewById(R.id.submitButton);
        View reset = findViewById(R.id.resetButton);
        // Anonymous Inner Class
        submit.setOnClickListener(new View.OnClickListener()  {
            @Override
            public void onClick(View view) {

                TextView numberToConvert = (TextView) findViewById(R.id.numberToConvert);
                TextView inputBase = (TextView) findViewById(R.id.inputBase);
                TextView outputBase = (TextView) findViewById(R.id.outputBase);
                TextView answerView = (TextView) findViewById(R.id.answer);


                if(numberToConvert.getText().toString().length() <= 0)
                    answerView.setText(R.string.noNumberToConvert);
                else if(inputBase.getText().toString().length() <= 0)
                    answerView.setText(R.string.noInputBase);
                else if(outputBase.getText().toString().length() <= 0)
                    answerView.setText(R.string.noOutputBase);
                else{
                    try {
                        String output = Integer.toString(Integer.parseInt(numberToConvert.getText().toString(),
                                Integer.valueOf(inputBase.getText().toString())),
                                Integer.valueOf(outputBase.getText().toString()));
                        numberToConvert.setBackgroundColor(getResources().getColor(R.color.white));
                        numberToConvert.setHint(R.string.enterNumber);
                        answerView.setText(output);
                    } catch (NumberFormatException e) {
                        numberToConvert.setText("");
                        numberToConvert.setHint(R.string.error);
                        numberToConvert.setBackgroundColor(getResources().getColor(R.color.red));
                        numberToConvert.setFocusableInTouchMode(true);
                        numberToConvert.requestFocus();


                    }

                }
            }
        });

        reset.setOnClickListener(new View.OnClickListener(){
            @Override
           public void onClick(View view){

                TextView numberToConvert = (TextView) findViewById(R.id.numberToConvert);
                TextView inputBase = (TextView) findViewById(R.id.inputBase);
                TextView outputBase = (TextView) findViewById(R.id.outputBase);
                TextView answerView = (TextView) findViewById(R.id.answer);

                numberToConvert.setText("");
                inputBase.setText("");
                outputBase.setText("");
                answerView.setText("");
                numberToConvert.setBackgroundColor(Color.WHITE);
                numberToConvert.setHint(R.string.enterNumber);
                numberToConvert.setFocusableInTouchMode(true);
                numberToConvert.requestFocus();
           }
        });
    }
}
