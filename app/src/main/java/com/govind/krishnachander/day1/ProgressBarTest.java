package com.govind.krishnachander.day1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class ProgressBarTest extends AppCompatActivity implements View.OnClickListener {
    ProgressBar pb;
    Button pbb;
    Thread th;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar_test);
        pb=(ProgressBar) findViewById(R.id.pb);
        pbb=(Button)findViewById(R.id.pbb);
        pbb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                th = new Thread(){
                    public void run(){
                        for(int i=0;i<=25;i++)
                        {
                            pb.setProgress(i*4);
                            try {
                                sleep(500);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                };

                th.start();
            }

        });

    }

    @Override
    public void onClick(View view) {

    }
}
