package com.govind.krishnachander.day1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CalciActivity extends AppCompatActivity implements View.OnClickListener {
    EditText e1,e2;
    TextView t1;
    Button bplus,bminus,bmult,bdiv;
    static double n1=0,n2=0,result=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calci);

        e1=(EditText) findViewById(R.id.n1);
        e2=(EditText) findViewById(R.id.n2);

        t1=(TextView) findViewById((R.id.resultview));

        bplus=(Button) findViewById(R.id.plus);
        bminus=(Button) findViewById(R.id.minus);
        bmult=(Button) findViewById(R.id.mult);
        bdiv=(Button) findViewById(R.id.div);

        bplus.setOnClickListener(this);
        bdiv.setOnClickListener(this);
        bmult.setOnClickListener(this);
        bminus.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        n1=Double.parseDouble(e1.getText().toString());
        n2=Double.parseDouble(e2.getText().toString());
        switch (view.getId())
        {
            case R.id.plus:
                result=n1+n2;
                t1.setText("Result: "+result);
                break;
            case R.id.minus:
                result=n1-n2; t1.setText("Result: "+result);
                break;
            case R.id.mult:
                result=n1*n2;
                t1.setText("Result: "+result);
                break;
            case R.id.div:
                result=n1/n2;
                t1.setText("Result: "+result);
                break;
        }
    }
}
