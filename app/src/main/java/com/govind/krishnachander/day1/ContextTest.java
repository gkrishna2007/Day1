package com.govind.krishnachander.day1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ContextTest extends AppCompatActivity {
    ListView lw;
    String menu[]={"FirstActivity","CounterActivity","CalciActivity","ProgressBarTest","SeekBarTest",
            "RadioButtonTest","ConvTemp","AutoCompleteActivity","SpinnerFromXML",
            "SpinnerFromJava","SwitchTest","OptionMenuTest","PopUpTest","ContextTest"};

    String name[]={"Shivangi","Kush","Rishabh","Veni","Somya","Poddar"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_context_test);
        lw=(ListView) findViewById(R.id.listView);

        ArrayAdapter<String> adapter= new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,name);
        lw.setAdapter(adapter);
        registerForContextMenu(lw);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Select Option");
        menu.add(0,v.getId(),0,"CALL");
        menu.add(0,v.getId(),0,"SMS");

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        Toast.makeText(ContextTest.this, ""+item.getTitle(), Toast.LENGTH_SHORT).show();
        return true;
    }
}
