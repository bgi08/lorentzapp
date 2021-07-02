package com.example.lorentzappconstraints;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class Activity6 extends AppCompatActivity {
    RecyclerView recyclerView;
    List<Data> data;
    List<Data> data1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_6);
         data = fill_with_data();
  /*       data1=fill_with_data();*/
         recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        RecyclerView_Adapter adapter = new RecyclerView_Adapter(data,getApplication());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Button clearbtn=findViewById(R.id.clearbtn);
        clearbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearrecyclerview();

            }
        });
    }

    public List<Data> fill_with_data() {
        int size = history.wrongans.length;
        List<Data> data = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            String str1=String.valueOf(history.givenvelo[i]);
            if(history.wrongans[i]!=0.0)
            {String str = String.valueOf(history.wrongans[i]);
                        data.add(new Data(str,str1));
            }


        }
        /*data.add(new Data("C++"));
        data.add(new Data("Java"));
        data.add(new Data("Android"));
        data.add(new Data("Kotlin"));
        data.add(new Data("Html"));
        data.add(new Data("CSS"));
        data.add(new Data("JavaScript"));
        data.add(new Data("SQL"));
        data.add(new Data("SQL Server"));
        data.add(new Data("Data Structure"));
        data.add(new Data("Json"));
        data.add(new Data("JSP"));
        data.add(new Data("Alexa Skills"));*/
        return data;
    }
    public void clearrecyclerview()
    {
        recyclerView.setAdapter(null);
        for(int i=0;i<history.wrongans.length;i++) {
            history.wrongans[i] = 0.0;
            history.givenvelo[i]=0.0;
        }

    }

}