package com.govind.krishnachander.day1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class RadioButtonTest extends AppCompatActivity implements View.OnClickListener{
    RadioButton r1,r2,r3,r4;
    TextView t1;
    Button b1;
    RadioGroup r;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_button_test);
        r=(RadioGroup) findViewById(R.id.rg);
        r1=(RadioButton) findViewById(R.id.rb1);
        r2=(RadioButton) findViewById(R.id.rb2);
        r3=(RadioButton) findViewById(R.id.rb3);
        r4=(RadioButton) findViewById(R.id.rb4);
        t1=(TextView) findViewById(R.id.tv1);
        b1=(Button) findViewById(R.id.cl);

        View.OnClickListener listener= new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RadioButton rg=(RadioButton)view;
                t1.setText("You have Selected : "+rg.getText().toString());
            }
        };

        r1.setOnClickListener(listener);
        r2.setOnClickListener(listener);
        r3.setOnClickListener(listener);
        r4.setOnClickListener(listener);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                r.clearCheck();
                t1.setText("");
            }
        });
    }

    @Override
    public void onClick(View view) {

    }
}
