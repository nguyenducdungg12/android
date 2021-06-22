package com.deitel.qlsv;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.deitel.qlsv.adapter.adaptersubject;
import com.deitel.qlsv.database.database;
import com.deitel.qlsv.models.Subject;

import java.util.ArrayList;

public class ActivitySubject extends AppCompatActivity {
    Toolbar toolbar;
    ListView listViewSubject;
    ArrayList<Subject> ArrayListSubject;
    com.deitel.qlsv.database.database database;
    com.deitel.qlsv.adapter.adaptersubject adaptersubjects;
    int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject);
        toolbar = findViewById(R.id.toolbarSubject);
        listViewSubject = findViewById(R.id.listviewSubject);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        database = new database(this);

        ArrayListSubject = new ArrayList<>();

        Cursor cursor = database.getDataSubject();

        while(cursor.moveToNext()){
            int id = cursor.getInt(0);
            String title = cursor.getString(1);
            int credit = cursor.getInt(2);
            String time = cursor.getString(3);
            String place = cursor.getString(4);
            ArrayListSubject.add(new Subject(id,title,credit,time,place));
        }
        adaptersubjects = new adaptersubject(ActivitySubject.this,ArrayListSubject);
        listViewSubject.setAdapter(adaptersubjects);
        cursor.moveToFirst();
        cursor.close();
        listViewSubject.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ActivitySubject.this,ActivityStudent.class);
                int id_subject = ArrayListSubject.get(position).getId();
                intent.putExtra("id_subject",id_subject);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menuadd,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menuadd:
                Intent intent1 = new Intent(ActivitySubject.this,ActivityAddSubject.class);
                startActivity(intent1);
                break;
            default:
                Intent intent = new Intent(ActivitySubject.this,ActivityAdmin.class);
                startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
    public void onBackPressed(){
        count++;
        if(count>=1){
            Intent intent = new Intent(ActivitySubject.this, ActivityAdmin.class);
            startActivity(intent);
            finish();
        }
    }
    public void update(final int pos){
        Cursor cursor = database.getDataSubject();

        while(cursor.moveToNext()){
            int id = cursor.getInt(0);

            if(id==pos){
                Intent intent = new Intent(ActivitySubject.this,ActivityUpdateSubject.class);
                intent.putExtra("id",id);
                String title = cursor.getString(1);
                int credit = cursor.getInt(2);
                String time = cursor.getString(3);
                String place = cursor.getString(4);

                intent.putExtra("title",title);
                intent.putExtra("credit",credit);
                intent.putExtra("time",time);
                intent.putExtra("place",place);

                startActivity(intent);
            }
        }
    }

    public void delete(final int pos){
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialogdelete);

        dialog.setCanceledOnTouchOutside(false);

        Button btnYes = dialog.findViewById(R.id.buttonYesDeleteSubject);
        Button btnNo = dialog.findViewById(R.id.buttonNoDeleteSubject);


        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                database.DeleteSubject(pos);
                database.DeleteSubjectStudent(pos);
                Intent intent = new Intent (ActivitySubject.this,ActivitySubject.class);
                startActivity(intent);
            }
        });
        btnNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });
        dialog.show();
    }
    public void information (final int pos){
        Cursor cursor = database.getDataSubject();
        while(cursor.moveToNext()){
            int id = cursor.getInt(0);
            if(id==pos){
                Intent intent = new Intent(ActivitySubject.this,ActivitySubjectInformation.class);

                intent.putExtra("id",id);
                String title = cursor.getString(1);
                int credit = cursor.getInt(2);
                String time = cursor.getString(3);
                String place = cursor.getString(4);

                intent.putExtra("title",title);
                intent.putExtra("credit",credit);
                intent.putExtra("time",time);
                intent.putExtra("place",place);

                startActivity(intent);
            }
        }
    }
}