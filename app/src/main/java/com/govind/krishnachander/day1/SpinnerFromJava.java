package com.govind.krishnachander.day1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class SpinnerFromJava extends AppCompatActivity {
    Spinner s1;
    String country[]={"SELECT OPTION","INDIA","INDONESIA","CHINA","JAPAN","NORTH KOREA"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_from_java);
        s1=(Spinner) findViewById(R.id.s1);

        ArrayAdapter<String> adapter= new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,country);
        s1.setAdapter(adapter);
        s1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==0)
                {}
                else
                {
                Toast.makeText(SpinnerFromJava.this, "You have Selected "+s1.getSelectedItem(), Toast.LENGTH_SHORT).show();
            }}

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }
}
