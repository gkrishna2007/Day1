package com.govind.krishnachander.day1;

import android.content.Intent;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ProximityTest extends AppCompatActivity {
    RelativeLayout rl;
    Sensor s;
    SensorManager sm;

    SensorEventListener sel=new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent sensorEvent) {
            float x = sensorEvent.values[0];

            if (x == 0) {
                rl.setBackgroundColor(Color.RED);
            } else {
                rl.setBackgroundColor(Color.YELLOW);
            }

            TextView tv=(TextView)findViewById(R.id.textView5);
            tv.setText(""+x);
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int i) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proximity_test);
        sm=(SensorManager)getSystemService(SENSOR_SERVICE);
        s=sm.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        rl=(RelativeLayout) findViewById(R.id.rl);
        sm.registerListener(sel,s,SensorManager.SENSOR_DELAY_NORMAL);
    }
}
