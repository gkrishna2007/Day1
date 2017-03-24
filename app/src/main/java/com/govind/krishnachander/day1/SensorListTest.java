package com.govind.krishnachander.day1;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SensorListTest extends AppCompatActivity {
    Sensor s;
    SensorManager sm;
    String data="";
    TextView tv;
    List<Sensor> l;
    int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor_list_test);
        sm=(SensorManager)getSystemService(SENSOR_SERVICE);
        tv=(TextView)findViewById(R.id.tv);
        l=sm.getSensorList(Sensor.TYPE_ALL);
        for(Sensor s1:l)
        {
          data+=s1.getName()+"||"+s1.getType()+"||"+s1.getVendor()+"\n";
            i++;
        }
        tv.setText(data);
        Toast.makeText(SensorListTest.this, ""+i, Toast.LENGTH_SHORT).show();
    }
}
