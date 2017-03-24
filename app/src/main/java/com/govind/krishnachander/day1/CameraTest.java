package com.govind.krishnachander.day1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class CameraTest extends AppCompatActivity {
Button takepic;ImageView iv;
SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera_test);
        sp=getSharedPreferences("mypref",MODE_PRIVATE);
        takepic=(Button) findViewById(R.id.takepic);
        iv=(ImageView) findViewById(R.id.photo);

        takepic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MediaStore.ACTION_IMAGE_CAPTURE_SECURE);
                startActivityForResult(i,10);
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bundle b=data.getExtras();
        if(requestCode==10&&resultCode==RESULT_OK)
        {
            Bitmap bmp=(Bitmap) b.get("data");

            iv.setImageBitmap(bmp);
        }

    }
}
