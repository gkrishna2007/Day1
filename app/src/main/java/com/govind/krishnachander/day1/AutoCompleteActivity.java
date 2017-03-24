package com.govind.krishnachander.day1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;

public class AutoCompleteActivity extends AppCompatActivity {
    AutoCompleteTextView actv;
    MultiAutoCompleteTextView mactv;
    String country[]={"INDIA","INDONESIA","IRAN","IRAQ","CHINA","CHILE","ARGENTINA","AFGHANISTAN"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_complete);

        actv=(AutoCompleteTextView) findViewById(R.id.actv);

        mactv=(MultiAutoCompleteTextView) findViewById(R.id.mactv);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,country);

        actv.setAdapter(adapter);
        mactv.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
        mactv.setAdapter(adapter);
    }
}
