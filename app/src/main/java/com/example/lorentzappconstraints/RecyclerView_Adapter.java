package com.example.lorentzappconstraints;

import android.app.Application;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Collections;
import java.util.List;

public class RecyclerView_Adapter extends RecyclerView.Adapter<View_Holder> {

    List<Data> list = Collections.emptyList();
 /*   List<Data> list1=Collections.emptyList();*/
    Context context;

    public RecyclerView_Adapter(List<Data> data, Application application) {
        this.list = data;
        this.context = application;
    }

    @NonNull
    @Override
    public View_Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Inflate the layout, initialize the View Holder
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout, parent, false);
        View_Holder holder = new View_Holder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull View_Holder holder, int position) {

        //Use the provided View Holder on the onCreateViewHolder method to populate the current row on the RecyclerView

       holder.name.setText("Ans:"+list.get(position).str);
        holder.velo.setText("Velocity:"+list.get(position).str1);
    }

    @Override
    public int getItemCount() {

        return list.size();
    }
}