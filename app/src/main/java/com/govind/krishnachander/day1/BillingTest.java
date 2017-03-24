package com.govind.krishnachander.day1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class BillingTest extends AppCompatActivity implements View.OnClickListener{
    EditText e1,e2,e3,e4;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_billing_test);

        Toast.makeText(BillingTest.this, "Enter the number of units of products you want to buy.", Toast.LENGTH_SHORT).show();
        e1=(EditText) findViewById(R.id.editText);
        e2=(EditText) findViewById(R.id.editText2);
        e3=(EditText) findViewById(R.id.editText3);
        e4=(EditText) findViewById(R.id.editText4);
        b1=(Button) findViewById(R.id.b1);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(BillingTest.this,BillingAmt.class);
                i.putExtra("a1",e1.getText().toString());
                i.putExtra("a2",e2.getText().toString());
                i.putExtra("a3",e3.getText().toString());
                i.putExtra("a4",e4.getText().toString());

                startActivity(i);
            }
        });

    }

    @Override
    public void onClick(View view) {

    }
}
