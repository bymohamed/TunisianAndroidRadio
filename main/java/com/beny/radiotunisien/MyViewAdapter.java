package com.beny.radiotunisien;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

public class MyViewAdapter extends RecyclerView.Adapter<MyViewHolder> {
    Context c;
    Radio[] radios ;


    public MyViewAdapter (Context cc , Radio[] r){
        this.c=cc;
        this.radios=r;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(c).inflate(R.layout.listview_layout, viewGroup,false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder myViewHolder, final int i) {
        String name = radios[i].name;
        String picurl = radios[i].img_link;
        myViewHolder.radioName.setText(name);
        Picasso.get().load(picurl).into(myViewHolder.radioImg);

        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inte = new Intent(c,RadioDetails.class);
                inte.putExtra("radio",radios[i]);
                c.startActivity(inte);
            }
        });
    }


    @Override
    public int getItemCount() {
        return radios.length;
    }

}
