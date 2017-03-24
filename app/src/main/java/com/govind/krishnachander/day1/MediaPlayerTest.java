package com.govind.krishnachander.day1;

import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;


import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.ArrayList;



public class MediaPlayerTest extends AppCompatActivity implements View.OnClickListener,SeekBar.OnSeekBarChangeListener {
    MediaPlayer mp;
    SeekBar sb;
    TextView tdu,rtdu;
    Thread progress,rem;
    ImageButton play;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_player);
        sb = (SeekBar) findViewById(R.id.seekBar);
        tdu = (TextView) findViewById(R.id.tdu);
        rtdu=(TextView) findViewById(R.id.rtdu) ;
        play = (ImageButton) findViewById(R.id.play);
        mp = MediaPlayer.create(this, R.raw.sochnsake);
        tdu.setText(ConvertToDuration(mp.getDuration()));

        sb.setMax(mp.getDuration());
        sb.setOnSeekBarChangeListener(this);
        play.setOnClickListener(this);
        tdu.setText(ConvertToDuration(mp.getDuration()));



        progress = new Thread() {
            @Override
            public void run() {
                while(mp.getDuration()!=mp.getCurrentPosition())
                {
                    sb.setProgress(mp.getCurrentPosition());

                }
            }
        };progress.start();

    }

    String ConvertToDuration(long l)
    {   String duration="";
        long l1=l/1000;
        duration+=l1/60+":"+l1%60;
        return duration;
    }

    @Override
    public void onClick(View view) {
        if(!mp.isPlaying())
        {
            mp.start();
            play.setImageResource(android.R.drawable.ic_media_pause);
        }
        else
        {
            mp.pause();
            play.setImageResource(android.R.drawable.ic_media_play);
        }
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        if(b)
        {
            mp.seekTo(i);

        }
        long a=mp.getDuration()-mp.getCurrentPosition();

        rtdu.setText(ConvertToDuration(a));
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
