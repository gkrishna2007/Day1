package com.govind.krishnachander.day1;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BluetoothTest extends AppCompatActivity {
BluetoothAdapter ba;
    BluetoothDevice bd;
    ListView lv;
    Switch sw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bluetooth_test);
        ba = BluetoothAdapter.getDefaultAdapter();
        lv = (ListView) findViewById(R.id.listView3);
        sw = (Switch) findViewById(R.id.s1);
        if(ba.isEnabled())
        {
            sw.setChecked(true);
        }
        else
        {
            sw.setChecked(false);
        }

        if (ba == null) {
            Toast.makeText(BluetoothTest.this, "OLD PHONE", Toast.LENGTH_SHORT).show();
        }
        else {
            sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    if (b) {
                        if (!ba.isEnabled()) {

                            Intent i = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                            startActivity(i);
                            Toast.makeText(BluetoothTest.this, "TURNING ON" + ba.getState(), Toast.LENGTH_SHORT).show();
                        } else {
                            ba.disable();
                            Toast.makeText(BluetoothTest.this, "OFF" + ba.getState(), Toast.LENGTH_SHORT).show();
                        }


                    }

                }
            });
        }
        Set<BluetoothDevice> s = ba.getBondedDevices();
        List<String> l = new ArrayList<String>();
        for (BluetoothDevice s1 : s) {
            l.add(s1.getName() + "||" + s1.getAddress());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, l);
        lv.setAdapter(adapter);

    }
}
