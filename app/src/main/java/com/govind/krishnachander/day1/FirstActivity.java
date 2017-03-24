package com.govind.krishnachander.day1;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by Krishna Chander on 26-06-2016.
 */
public class FirstActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first);
        TextView tv=(TextView)findViewById(R.id.MarqueeText);
        TextView tv1=(TextView)findViewById(R.id.mywiget);
        tv.setSelected(true);
        tv1.setSelected(true);

    }
}
