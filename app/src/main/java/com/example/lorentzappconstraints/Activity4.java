package com.example.lorentzappconstraints;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextClock;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.text.DecimalFormat;
import java.util.Calendar;

public class Activity4 extends AppCompatActivity {
    TextView value;
    TextClock tClock;
    ConstraintLayout spilayout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4);
        spilayout=findViewById(R.id.spilayout);


        value = findViewById(R.id.calval);
        tClock =  findViewById(R.id.textClock1);


        final Handler handler = new Handler();
        final int delay = 1000;

        handler.postDelayed(new Runnable() {
            public void run() {
                Calendar cal = Calendar.getInstance();
                int currentHour = cal.get(Calendar.HOUR);
                int currentMinutes = cal.get(Calendar.MINUTE);
                int currentSeconds = cal.get(Calendar.SECOND);
                spicalculate(currentHour, currentMinutes, currentSeconds);
                handler.postDelayed(this, delay);
            }
        }, delay);
      /*  Timer timer=new Timer();
        Mytimer1 myTimer=new Mytimer1();
        timer.schedule(myTimer,100,1500);*/
    }


  /*  public class Mytimer1 extends TimerTask {

        @Override
        public void run() {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Random random= new Random();
                    spilayout.setBackgroundColor(Color.rgb(random.nextInt(255),random.nextInt(255),random.nextInt(255)));

                }
            });
        }
    }*/
    public void spicalculate(int hour,int min,int sec)
    { int fact=1;
        for (int i=1;i<=hour;i++)
        {
            fact=fact*i;
        }
        double spivalue = fact /((Math.pow(min,3)+sec));
        DecimalFormat precision =new DecimalFormat("0.00000000000");
        value.setText("The spi value is:\n"+
                precision.format(spivalue));

    }

}



