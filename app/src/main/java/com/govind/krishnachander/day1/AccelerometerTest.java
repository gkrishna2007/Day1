package com.govind.krishnachander.day1;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class AccelerometerTest extends AppCompatActivity {
    Sensor s;
    SensorManager sm;
    TextView t1;
    SensorEventListener sel=new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent sensorEvent) {
            float x=sensorEvent.values[0];
            float y=sensorEvent.values[1];
            float z=sensorEvent.values[2];
            t1.setText("AZIMUTH: "+x+"\nPITCH: "+y+"\nROLL: "+z);
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int i) {

        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accelerometer_test);
        sm=(SensorManager)getSystemService(SENSOR_SERVICE);
        t1=(TextView) findViewById(R.id.textView4);
        s=sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sm.registerListener(sel,s,SensorManager.SENSOR_DELAY_NORMAL);

    }
}
