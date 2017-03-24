package com.govind.krishnachander.day1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

public class SwitchTest extends AppCompatActivity {
    Switch s1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switch_test);
        s1=(Switch) findViewById(R.id.s1);
        s1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    Toast.makeText(SwitchTest.this, "WIFI IS ON", Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(SwitchTest.this, "WIFI IS OFF ", Toast.LENGTH_SHORT).show();
            }
        });


    }
}
