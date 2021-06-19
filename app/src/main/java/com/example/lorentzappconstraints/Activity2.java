package com.example.lorentzappconstraints;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Activity2 extends AppCompatActivity {
    double velocity;
    TextView result;
    EditText input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        input= findViewById(R.id.input);
        Button calculate = (Button) findViewById(R.id.clickbtn);
        Button refreshbtn =(Button) findViewById(R.id.refreshbtn);

        result = findViewById(R.id.result);
        input.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                input.setHint("");
                return false;
            }
        });
        input.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    input.setHint("Enter velocity");
                }
            }
        });

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputvelo = input.getText().toString();

                if (inputvelo == null || inputvelo.trim().equals("") )
                {
                    Toast.makeText(getBaseContext(), "Input Field is Empty", Toast.LENGTH_LONG).show();
                }

                else if(Double.parseDouble(inputvelo) > 3 * Math.pow(10, 8))
                {
                    Toast.makeText(getBaseContext(),"Input is greater than speed of light",Toast.LENGTH_LONG).show();
                }
                else
                {
                    velocity = Double.parseDouble(inputvelo);
                    velocal(velocity);
                }
            closekeyboard();
            }
        });
        refreshbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearpage();
            }
        });
    }

    public void velocal(double velocity) {
        double c = (3 * Math.pow(10, 8));
        double b = 1 - Math.pow((velocity / c), 2);
        double answer;
        answer = (1 / Math.sqrt(b));
        result.setText("Answer: " + String.valueOf(answer));

    }
    public void clearpage()
    {
        input.getText().clear();
        result.setText("Result:");


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
