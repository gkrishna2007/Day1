package com.govind.krishnachander.day1;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class BillingAmt extends AppCompatActivity {
int a1,a2,a3,a4;
    TextView t1,t2,t3,t4,t5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_billing_amt);

        Bundle b=getIntent().getExtras();

        if(b.getString("a1").isEmpty())
        {
            a1=0;
        }
        else
        {
            a1= Integer.parseInt(b.getString("a1"));

        }
        if(b.getString("a2").isEmpty())
        {
            a2=0;
        }
        else         a2= Integer.parseInt(b.getString("a1"));


        if(b.getString("a3").isEmpty())
        {
            a3=0;
        }
        else         a3= Integer.parseInt(b.getString("a3"));


        if(b.getString("a4").isEmpty())
        {
            a4=0;
        }
        else           a4= Integer.parseInt(b.getString("a4"));




        t1=(TextView)findViewById(R.id.t1);
        t1.setTextColor(Color.BLACK);
        t1=(TextView)findViewById(R.id.t1);

        t1.setText("Snickers:\t"+a1+"* 35Rs. =\t"+(a1*35)+"\n\nToblerone:\t"+a2+"* 90Rs. =\t"+(a2*90)+"\n\nTemptations" +
                ":\t"+a3+"* 95Rs. =\t"+(a3*95)+"\n\nBournville:\t"+a4+"* 80Rs. =\t"+(a4*80)+"\n\n\n\nTotal:Rs. "+(a1*35+a2*90+a3*95+a4*80));

    }
}
