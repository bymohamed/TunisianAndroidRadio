package com.beny.radiotunisien;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {

    TextView radioName ;
    ImageView radioImg;
    public MyViewHolder(@NonNull View itemView) {
        super(itemView);

        radioName = (TextView) itemView.findViewById(R.id.radioName);
        radioImg = (ImageView) itemView.findViewById(R.id.radioImg);
    }
}
