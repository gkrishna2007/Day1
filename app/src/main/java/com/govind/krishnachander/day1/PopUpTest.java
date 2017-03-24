package com.govind.krishnachander.day1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class PopUpTest extends AppCompatActivity {
    PopupMenu pm;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_up_test);

        b1=(Button)findViewById(R.id.b1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pm=new PopupMenu(PopUpTest.this,b1);
                pm.getMenuInflater().inflate(R.menu.option_menu_test,pm.getMenu());
                pm.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(PopUpTest.this,item.getTitle(), Toast.LENGTH_SHORT).show();
                        return true;

                    }
                });
                pm.show();
            }
        });


    }
}
