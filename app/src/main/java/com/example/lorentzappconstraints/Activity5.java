package com.example.lorentzappconstraints;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class Activity5 extends AppCompatActivity {
    Button btn1;
    Button btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_5);

        btn1=findViewById(R.id.buttonpractice);
        btn2=findViewById(R.id.buttonnormal);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openactivity3();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openactivity2();
            }
        });
    }
    public void openactivity2()
    {
        Intent intent = new Intent(this,Activity2.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slideinright,R.anim.slideoutleft);

    }
    public void openactivity3()
    {
        Intent intent1 = new Intent(this,Activity3.class);
        startActivity(intent1);
        overridePendingTransition(R.anim.slideinright,R.anim.slideoutleft);

    }

}