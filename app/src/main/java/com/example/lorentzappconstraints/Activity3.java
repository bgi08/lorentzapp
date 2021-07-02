package com.example.lorentzappconstraints;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class Activity3 extends AppCompatActivity {
    double practicevelocity;
    double practiceans;
    TextView practiceresult;
    ConstraintLayout constraintLayout;
    Vibrator vibe;
    EditText velocityinput;
    EditText answerinput;
    int count = 1;

    int i=0,j=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
        constraintLayout = findViewById(R.id.constraintactivity3);
        vibe = (Vibrator) Activity3.this.getSystemService(VIBRATOR_SERVICE);
        velocityinput = findViewById(R.id.pracvelocity);
        answerinput = findViewById(R.id.pracans);
        practiceresult = findViewById(R.id.practiceresult);
        Button refbutton2 = findViewById(R.id.refreshbtn2);
        Button checkresult =  findViewById(R.id.practicebtn);
        Button historybtn= findViewById(R.id.historybtn);

        checkresult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputvelo = velocityinput.getText().toString();
                String inputans = answerinput.getText().toString();
                if (inputvelo.trim().equals("") && inputans.trim().equals("")) {
                    Toast.makeText(getBaseContext(), "Input velocity & answer is empty", Toast.LENGTH_LONG).show();

                } else if (inputvelo.trim().equals("")) {
                    Toast.makeText(getBaseContext(), "Input velocity is empty", Toast.LENGTH_LONG).show();
                } else if (inputans.trim().equals("")) {
                    Toast.makeText(getBaseContext(), "Input answer is empty", Toast.LENGTH_LONG).show();
                }


                    else {
                    practiceans = Double.parseDouble(inputans);
                    practicevelocity = Double.parseDouble(inputvelo);
                    checkvelo(practiceans, practicevelocity);

                }
                closekeyboard();

            }
        });
        refbutton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearpage();
            }
        });
       historybtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
             history();
           }
       });

    }

    public void checkvelo(double practiceans, double practicevelocity) {
        double c = (3 * Math.pow(10, 8));
        double b = 1 - Math.pow((practicevelocity / c), 2);
        double answer;
        answer = (1 / Math.sqrt(b));
        history.givenvelo[i]=practicevelocity;
        if (practiceans == answer) {
            practiceresult.setText("Your Answer is correct");
            constraintLayout.setBackgroundColor(Color.rgb(190, 230, 117));
           /* history.correctans[i]=answer;
            history.cc+=1;*/
            i+=1;
            count=1;
        }
        else {
            practiceresult.setText("Attempt:" + count + "\nYour Answer is wrong, Check Again!\n");
            vibe.vibrate(100);
            constraintLayout.setBackgroundColor(Color.rgb(245, 105, 105));
            history.wrongans[j]=practiceans;
            history.wc+=1;
          /*  history.wrongans=practiceans;*/
            j+=1;
            count+=1;
            velocityinput.setFocusable(false);
            if (count >= 4) {
                velocityinput.setFocusableInTouchMode(true);
                velocityinput.setFocusable(true);
                velocityinput.setEnabled(true);
                practiceresult.setText(String.format("You have tried 3 times, Correct answer:%s", answer));
                count=1;

            }
        }
   i+=1; }

    public void clearpage() {
        velocityinput.getText().clear();
        answerinput.getText().clear();
        practiceresult.setText("Result:");
        constraintLayout.setBackgroundColor(Color.rgb(231, 231, 231));
        velocityinput.setFocusableInTouchMode(true);
        velocityinput.setFocusable(true);
        velocityinput.setEnabled(true);
        count=1;

    }

    public void closekeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
    public void history()
    {
    Intent historyin=new Intent(this,Activity6.class);
    startActivity(historyin);
    overridePendingTransition(R.anim.slideinright,R.anim.slideoutleft);

    }
}
