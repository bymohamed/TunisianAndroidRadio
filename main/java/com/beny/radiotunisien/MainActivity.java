package com.beny.radiotunisien;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView radios;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radios = (RecyclerView) findViewById(R.id.listradio);
        DatabaseAccess db = DatabaseAccess.getInstance(getApplicationContext());
        db.open();

        List<Radio> radio_table = db.getList();

        //converting list to array
        Radio[] radios_array = new Radio[radio_table.size()];
        radios_array = radio_table.toArray(radios_array);

        //setting adapter
        radios.setLayoutManager(new LinearLayoutManager(this));
        MyViewAdapter va = new MyViewAdapter(this,radios_array);
        radios.setAdapter(va);


    }


}
