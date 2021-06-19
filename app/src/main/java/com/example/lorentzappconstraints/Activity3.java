package com.example.lorentzappconstraints;

import android.content.Context;
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
        constraintLayout=findViewById(R.id.constraintactivity3);
        vibe = (Vibrator) Activity3.this.getSystemService(VIBRATOR_SERVICE);
        velocityinput = findViewById(R.id.pracvelocity);
        answerinput=findViewById(R.id.pracans);
        practiceresult=findViewById(R.id.practiceresult);
        Button refbutton2=findViewById(R.id.refreshbtn2);
        Button checkresult = (Button) findViewById(R.id.practicebtn);
        checkresult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputvelo= velocityinput.getText().toString();
                String inputans=answerinput.getText().toString();
                if(inputvelo.trim().equals("") && inputans.trim().equals(""))
                {
                    Toast.makeText(getBaseContext(),"Input velocity & answer is empty",Toast.LENGTH_LONG).show();

                }
                else if(inputvelo==null || inputvelo.trim().equals(""))
                {
                    Toast.makeText(getBaseContext(),"Input velocity is empty",Toast.LENGTH_LONG).show();
                }

                else if(inputans==null || inputans.trim().equals(""))
                {
                    Toast.makeText(getBaseContext(),"Input answer is empty",Toast.LENGTH_LONG).show();
                }


              /*  else if((!TextUtils.isDigitsOnly(inputans) ) && (!TextUtils.isDigitsOnly(inputvelo)))
                {
                    Toast.makeText(getBaseContext(), "Invalid answer,velocity input", Toast.LENGTH_LONG).show();

                }*/
                else
                {
                    practiceans=Double.parseDouble(inputans);
                    practicevelocity=Double.parseDouble(inputvelo);
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
    }
    public void checkvelo(double practiceans,double practicevelocity)
    {
        double c = (3 * Math.pow(10, 8));
        double b = 1 - Math.pow(( practicevelocity/ c), 2);
        double answer;
        answer = (1 / Math.sqrt(b));
        if(practiceans==answer)
        {
            practiceresult.setText("Your Answer is correct");
            constraintLayout.setBackgroundColor(Color.rgb(190, 230, 117));
        }
        else
        {
            practiceresult.setText("Your Answer is wrong, Check Again!\n"+" Correct answer:"+String.valueOf(answer));
            vibe.vibrate(100);
            constraintLayout.setBackgroundColor(Color.rgb(245,105,105));

        }
    }
    public void clearpage()
    {
velocityinput.getText().clear();
answerinput.getText().clear();
practiceresult.setText("Result:");
constraintLayout.setBackgroundColor(Color.rgb(231,231,231));

    }
    public void closekeyboard()
    {
        View view =this.getCurrentFocus();
        if(view!=null)
        {
            InputMethodManager imm=(InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(),0);
        }
    }
}