package com.govind.krishnachander.day1;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class DBTest extends AppCompatActivity {
    SQLiteDatabase sd;
    EditText sname,sage,sadd,sid;
    Cursor c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dbtest);

        sid=(EditText) findViewById(R.id.sid);
        sage=(EditText) findViewById(R.id.sage);
        sadd=(EditText) findViewById(R.id.sadd);
        sname=(EditText) findViewById(R.id.sname);

        sd=openOrCreateDatabase("DelhiDB",MODE_PRIVATE,null);
        sd.execSQL("create table if not exists student(sid int primary key,sname varchar no" +
                "t null,sage int not null,sadd varchar not null)");
        c=sd.rawQuery("Select * from student",null);



    }
    public void add(View v)
    {   try {


        int id = Integer.parseInt(sid.getText().toString());
        int age = Integer.parseInt(sage.getText().toString());
        String add = sadd.getText().toString();
        String name = sname.getText().toString();
        sd.execSQL("insert into student values(" + id + ",'" + name + "'," + age + ",'" + add + "')");
        Toast.makeText(DBTest.this, "DATA INSERTED", Toast.LENGTH_SHORT).show();
    }catch (Exception e){
        Toast.makeText(DBTest.this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
    }
    }
    public void first(View v)
    {
        if(c.moveToFirst())
        {   sid.setText(""+c.getInt(0));
            sname.setText(""+c.getString(1));
            sage.setText(""+c.getInt(2));
            sadd.setText(""+c.getString(3));
        }
    }
    public void previous(View v)
    {
        if(c.moveToPrevious())
        {
            sid.setText(""+c.getInt(0));
            sname.setText(""+c.getString(1));
            sage.setText(""+c.getInt(2));
            sadd.setText(""+c.getString(3));
        }

    }
    public void next(View v)
    {
        if(c.moveToNext())
        {
            sid.setText(""+c.getInt(0));
            sname.setText(""+c.getString(1));
            sage.setText(""+c.getInt(2));
            sadd.setText(""+c.getString(3));
        }
    }
    public void last(View v)
    {
        if(c.moveToLast())
        {
            sid.setText(""+c.getInt(0));
            sname.setText(""+c.getString(1));
            sage.setText(""+c.getInt(2));
            sadd.setText(""+c.getString(3));
        }
    }
    public void search(View v)
    {
        try
        {
            int id = Integer.parseInt(sid.getText().toString());

            int flag=0;

            for(int i=0;i<c.getCount();i++)
            {   c.moveToPosition(i);
                if(id==c.getInt(0)) {
                    flag=1;
                    break;
                }
            }
            if(flag==0)
            {
                Toast.makeText(DBTest.this, "Record Not Found!", Toast.LENGTH_SHORT).show();
            }
            else
            {
                sid.setText(""+c.getInt(0));
                sname.setText(""+c.getString(1));
                sage.setText(""+c.getInt(2));
                sadd.setText(""+c.getString(3));
            }

        }catch (Exception e)
        {

        }
    }
    public void delete(View v)
    {
        int id= Integer.parseInt(sid.getText().toString().trim());
        try
        {
            sd.execSQL("delete from student where sid = "+id);
            Toast.makeText(DBTest.this, "Record Deleted", Toast.LENGTH_SHORT).show();
            sid.setText("");
            sage.setText("");
            sadd.setText("");
            sname.setText("");
            c=sd.rawQuery("select * from student",null);

    }catch (Exception e)
        {
            Toast.makeText(DBTest.this, "Data not deleted.", Toast.LENGTH_SHORT).show();
        }
    }
}
