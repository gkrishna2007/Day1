package com.govind.krishnachander.day1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.govind.krishnachander.day1.R;

public class CounterActivity extends AppCompatActivity implements View.OnClickListener{

    Button i,d,r;

    TextView res;
    static int count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter);

        i=(Button)findViewById(R.id.inc);
        d=(Button) findViewById(R.id.dec);
        r=(Button) findViewById(R.id.RES);
        res=(TextView) findViewById(R.id.resultview);
        i.setOnClickListener(this);
        d.setOnClickListener(this);
        r.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.inc:
                count++;
                res.setText("Count: " +count);
                break;
            case R.id.dec:
                count--;
                res.setText("Count: " +count);
                break;
            case R.id.RES:
                count = 0;
                res.setText("Count: " +count);
                break;
        }
    }
}
