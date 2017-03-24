package com.govind.krishnachander.day1;

import android.Manifest;
import android.app.ListActivity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;



public class MenuActivity extends ListActivity{

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch(requestCode)
        {
            case 1002:
                if(grantResults.length>0&&grantResults[0]== PackageManager.PERMISSION_GRANTED)
                {}
                else
                {}
                return;
        }
    }

    String menu[]={"FirstActivity","CounterActivity","CalciActivity","ProgressBarTest","SeekBarTest",
            "RadioButtonTest","ConvTemp","AutoCompleteActivity","SpinnerFromXML",
            "SpinnerFromJava","SwitchTest","OptionMenuTest","PopUpTest",
            "ContextTest","BillingTest","MediaPlayerTest",
            "DBTest","FileTest","CameraTest","AccelerometerTest"
            ,"SensorListTest","ProximityTest","BluetoothTest","MapsActivity"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,menu);
        setListAdapter(adapter);
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE)!= PackageManager.PERMISSION_GRANTED)
        {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_PHONE_STATE))
            {

            }
            else {
                ActivityCompat.requestPermissions(this, new String[]{
                        Manifest.permission.READ_PHONE_STATE}, 1002);
            }
        }
        else
        {
        }



    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        try {
           String s="com.govind.krishnachander.day1."+menu[position];
            Class c=Class.forName(s);
            Intent i=new Intent(this,c);
            startActivity(i);
        } catch (Exception e) {
        }

    }
}
