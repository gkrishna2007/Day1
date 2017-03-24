package com.govind.krishnachander.day1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;

public class SeekBarTest extends AppCompatActivity implements View.OnClickListener {
    SeekBar sb;
    TextView tv;
    ProgressBar pb;
    RatingBar rb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seek_bar_test);

        sb=(SeekBar) findViewById(R.id.sb);
        tv=(TextView) findViewById(R.id.pview);
        pb=(ProgressBar) findViewById(R.id.pb);
        rb=(RatingBar) findViewById(R.id.ratingBar);
        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                tv.setText("Progress: "+i);
                pb.setProgress(i);
                rb.setRating(i/20);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    @Override
    public void onClick(View view) {

    }
}
