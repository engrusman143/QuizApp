package com.example.android.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    int score = 0;
    int time = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void submitOrder(View view) {
        calculateScore();
        displayMessage(score);
        displaySolution(createOrderSummary());
        time = 1;
    }

    private String createOrderSummary(){
        String message = "Answers:";
        message += "\n" + "Q1-> 5";
        message += "\n" + "Q2-> Melania Trump";
        message += "\n" + "Q3-> Donald Trump Jr , Ivanka Trump and Eric Trump";
        message += "\n" + "Q4-> Donald Trump";
        message += "\n" + "Thank you for your time!!.";

        return message;
    }

    private int calculateScore() {

        RadioButton q1 =(RadioButton) findViewById(R.id.q1c);
        boolean solution1 = q1.isChecked();

        EditText q2 =(EditText) findViewById(R.id.q2);
        String solution2 = q2.getText().toString();

        CheckBox q31 =(CheckBox) findViewById(R.id.q3a);
        boolean solution31 = q31.isChecked();

        CheckBox q33 =(CheckBox) findViewById(R.id.q3c);
        boolean solution33 = q33.isChecked();

        CheckBox q34 =(CheckBox) findViewById(R.id.q3d);
        boolean solution34 = q34.isChecked();

        RadioButton q4 =(RadioButton) findViewById(R.id.q4c);
        boolean solution4 = q4.isChecked();


        if (solution1) {
            ++score;
        }
        if (solution2.contains("gary") || solution2.contains("Gary") || solution2.contains("GARY")) {
            ++score;
        }
        if (solution31 && solution33 && solution34) {
            ++score;
        }
        if (solution4) {
            ++score;
        }

        return score;

    }

    private void displayMessage(int score) {
        if(time == 1) {
            if(score == 0){
                Toast.makeText(this, "Your final score is..." + score +"/4" + "\nReally?...", Toast.LENGTH_SHORT).show();
            }else if(score>0 && score <=2){
                Toast.makeText(this, "Your final score is..." + score +"/4" + "\nYou aren't a big fan...", Toast.LENGTH_SHORT).show();
            }else if(score==3){
                Toast.makeText(this, "Your final score is..." + score +"/4!!" + "\nWohoho, you are a big fan of Donald Trump!!", Toast.LENGTH_SHORT).show();
            }else if(score == 4){
                Toast.makeText(this, "Your final score is..." + score +"/4!!!!!" + "\nYEEEAAHH!! \nYou are the best !", Toast.LENGTH_SHORT).show();
            }
        }
    }
    private void displaySolution(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }
}