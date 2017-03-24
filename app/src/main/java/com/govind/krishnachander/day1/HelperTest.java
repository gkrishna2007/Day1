package com.govind.krishnachander.day1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class HelperTest extends AppCompatActivity {
TextView t1,t2,t3,t4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helper_test);
        TextHelperClass help= new TextHelperClass();
        t1=(TextView) findViewById(R.id.textView6);

        t2=(TextView) findViewById(R.id.textView7);

        t3=(TextView) findViewById(R.id.textView8);

        t4=(TextView) findViewById(R.id.textView9);

        t1.setText(help.retText(1));
        t2.setText(help.retText(2));
        t3.setText(help.retText(3));
        t4.setText(help.retText(4));

    }
}

class TextHelperClass{
    String retText(int i) {
        switch (i) {
            case 1:
                return "TEXTBOX 1 ,TEXT SENT BY HELPER CLASS.";


            case 2:
                return "TEXTBOX 2 ,TEXT SENT BY HELPER CLASS.";

            case 3:
                return "TEXTBOX 3 ,TEXT SENT BY HELPER CLASS.";

            case 4:
                return "TEXTBOX 4 ,TEXT SENT BY HELPER CLASS.";

        }
return "";}
}