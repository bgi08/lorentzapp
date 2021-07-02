package com.example.lorentzappconstraints;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class View_Holder extends RecyclerView.ViewHolder {

    TextView name;
    TextView velo;

    View_Holder(View itemView) {
        super(itemView);
        name = (TextView) itemView.findViewById(R.id.description);
        velo=(TextView) itemView.findViewById(R.id.textView5);
    }
}