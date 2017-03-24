package com.govind.krishnachander.day1;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.jar.Manifest;

public class FileTest extends AppCompatActivity {
    File f;
    FileInputStream fis;
    FileOutputStream fos;
    EditText fname,fdata;

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch(requestCode)
        {
            case 1002:
                if(grantResults.length>0&&grantResults[0]==PackageManager.PERMISSION_GRANTED)
                {}
                else
                {}
                return;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_test);
        fname=(EditText) findViewById(R.id.editText5);
        fdata=(EditText) findViewById(R.id.editText6);

        if(ContextCompat.checkSelfPermission(this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED)
        {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE))
            {

            }
            else {
                ActivityCompat.requestPermissions(this, new String[]{
                        android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1002);
            }
        }
        else
        {
        }

        File f1= Environment.getExternalStorageDirectory();

        f=new File(f1,"cjwa-2016");

        if(!f.exists())
        {
            f.mkdir();
            Toast.makeText(FileTest.this, "Folder Created.", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(FileTest.this, "Folder already exists.", Toast.LENGTH_SHORT).show();
        }
    }
    public void create(View v)
    {
        String f2=fname.getText().toString().trim();
        try
        {
            File f3=new File(f,f2+".txt");
            if(!f3.exists())
            {
                f3.createNewFile();
                Toast.makeText(FileTest.this, "File Created", Toast.LENGTH_SHORT).show();
            }
            else
            {
                Toast.makeText(FileTest.this, "File Exists", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            Toast.makeText(FileTest.this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public  void data(View v)
    {
        String data=fdata.getText().toString().trim();
        String name=fname.getText().toString().trim();
        try {
            fos=new FileOutputStream(f.getAbsolutePath()+File.separator+name+".txt",true);
            fos.write(data.getBytes());


        } catch (IOException e) {
            Toast.makeText(FileTest.this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }

    public void search(View v)
    {
        String name=fname.getText().toString().trim();
        fdata.setText("");
        try {
            fis=new FileInputStream(f.getAbsoluteFile()+File.separator+name+".txt");

            String filedata=""; int i;
            while((i=fis.read())!=-1)
            {
                filedata+=(char)i;
                fdata.setText(filedata);
            }
        } catch (IOException e) {
            Toast.makeText(FileTest.this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }
}
