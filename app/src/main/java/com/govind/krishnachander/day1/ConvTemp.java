package com.govind.krishnachander.day1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

/**
 * Created by Krishna Chander on 29-06-2016.
 */
public class ConvTemp extends AppCompatActivity implements View.OnClickListener {
    EditText e1,e2;
    Button b1;
    RadioButton r1,r2;
    double c,f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conv_temp);
        e1=(EditText) findViewById(R.id.e1);
        e2=(EditText) findViewById(R.id.e2);
        r1=(RadioButton) findViewById(R.id.r1);
        r2=(RadioButton) findViewById(R.id.r2);
        r1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                f=Double.parseDouble(e2.getText().toString());
                c=(f-32)/1.8;
                e1.setText(c+"C");

            }
        });
        r2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                c=Double.parseDouble(e1.getText().toString());
                f=(c*1.8)+32;
                e2.setText(f+"F");
            }
        });
    }

    @Override
    public void onClick(View view) {

    }
}