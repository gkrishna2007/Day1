package com.govind.krishnachander.day1;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.RelativeLayout;
import android.widget.Spinner;

public class SpinnerFromXML extends AppCompatActivity {
    Spinner s1;
    RelativeLayout rl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_from_xml);
        s1 = (Spinner) findViewById(R.id.sp);
        rl=(RelativeLayout) findViewById(R.id.rl);
        s1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch(s1.getSelectedItem().toString())
                {
                    case "SELECT COLOR":
                    break;
                    case "RED":
                        rl.setBackgroundColor(Color.RED);
                        break;
                    case "GREEN":
                        rl.setBackgroundColor(Color.GREEN);
                        break;
                    case "YELLOW":
                        rl.setBackgroundColor(Color.YELLOW);
                        break;
                    case "BLACK":
                        rl.setBackgroundColor(Color.BLACK);
                        s1.setBackgroundColor(Color.WHITE);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }
}
