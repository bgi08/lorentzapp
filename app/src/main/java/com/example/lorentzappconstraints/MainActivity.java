package com.example.lorentzappconstraints;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class MainActivity extends AppCompatActivity {
    private Button button;

    private Button spibutton;
    ConstraintLayout mainlayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=(Button)findViewById(R.id.btnnext);
        mainlayout=findViewById(R.id.constraintmain);
        spibutton=(Button)findViewById(R.id.spibtn);
        spibutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                openactivity4();
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               openactivity5();
            }
        });

      /* *//**//* Timer timer=new Timer();
        Mytimer myTimer=new Mytimer();
        timer.schedule(myTimer,100,1500);*/

    }
    /*private class Mytimer extends TimerTask{

        @Override
        public void run() {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Random  random= new Random();
                    mainlayout.setBackgroundColor(Color.rgb(random.nextInt(255),random.nextInt(255),random.nextInt(255)));

                }
            });
        }
    }*/


    public void openactivity4()
    {
                Intent intent2= new Intent(this,Activity4.class);
        startActivity(intent2);
        overridePendingTransition(R.anim.slideinright,R.anim.slideoutleft);
    }
    public void openactivity5()
    {
        Intent intent3=new Intent(this,Activity5.class);
        startActivity(intent3);
        overridePendingTransition(R.anim.slideinright,R.anim.slideoutleft);
    }
}