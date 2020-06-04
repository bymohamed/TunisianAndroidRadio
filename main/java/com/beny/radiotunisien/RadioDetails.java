package com.beny.radiotunisien;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class RadioDetails extends Activity {
    ImageView logo;
    TextView radioName;
    public static MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.radiopage);
        Intent intent = getIntent();
        Radio thisRadio = (Radio) ((Intent) intent).getSerializableExtra("radio");

        logo=(ImageView) findViewById(R.id.logo);
        String picurl = thisRadio.img_link;
        Picasso.get().load(picurl).into(logo);

        radioName = (TextView) findViewById(R.id.radioName);
        radioName.setText(thisRadio.name);

        mp = MediaPlayer.create(this, Uri.parse(thisRadio.url));
        RadioDetails.mp.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.start();
            }
        });
        startService(new Intent(this,BackgroundService.class));



    }

    public void onClickPause(View v){
        mp.pause();
        stopService(new Intent(this,BackgroundService.class));
        //Intent goback = new Intent(this,MainActivity.class);
        //startActivity(goback);
        finish();
    }

    public void onClickPlay(View v){
        startService(new Intent(this,BackgroundService.class));
    }



}
