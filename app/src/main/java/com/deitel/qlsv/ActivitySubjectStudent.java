package com.deitel.qlsv;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.deitel.qlsv.adapter.adaptersubject;
import com.deitel.qlsv.adapter.adaptersubjectstudent;
import com.deitel.qlsv.database.database;
import com.deitel.qlsv.models.Student;
import com.deitel.qlsv.models.Subject;

import java.util.ArrayList;

public class ActivitySubjectStudent extends AppCompatActivity {
    Toolbar toolbar;
    ListView listViewSubjectStudent;
    ArrayList<Subject> ArrayListSubjectStudent;
    database database;
    adaptersubjectstudent adaptersubjectstudent;
    String MSSV="";
    int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject_student);
        toolbar = findViewById(R.id.toolbarSubjectStudent);
        listViewSubjectStudent = findViewById(R.id.listviewSubjectStudent);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Intent intent = getIntent();
        MSSV = intent.getStringExtra("MSSV");
        System.out.println(MSSV);
        database = new database(this);

        ArrayListSubjectStudent = new ArrayList<>();

        Cursor cursor = database.getDataSubjectStudent(MSSV);

        while(cursor.moveToNext()){
            int id = cursor.getInt(0);
            String title = cursor.getString(1);
            int credit = cursor.getInt(2);
            String time = cursor.getString(3);
            String place = cursor.getString(4);
            ArrayListSubjectStudent.add(new Subject(id,title,credit,time,place));
        }

        adaptersubjectstudent = new adaptersubjectstudent(ActivitySubjectStudent.this,ArrayListSubjectStudent);
        listViewSubjectStudent.setAdapter(adaptersubjectstudent);
        cursor.moveToFirst();
        cursor.close();

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menustudent,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menustudent:
                Cursor cursor = database.getDataStudentthroughMSSV(MSSV);
                Intent intent1 = new Intent(ActivitySubjectStudent.this,ActivityInformationStudent.class);
                while(cursor.moveToNext()){
                    String name = cursor.getString(1);
                    String sex = cursor.getString(2);
                    String code = cursor.getString(3);
                    String birthday = cursor.getString(4);

                    intent1.putExtra("name",name);
                    intent1.putExtra("sex",sex);
                    intent1.putExtra("code",code);
                    intent1.putExtra("birthday",birthday);
                    startActivity(intent1);
                }
                break;
            default:
                Intent intent = new Intent(ActivitySubjectStudent.this,ActivityLogin.class);
                startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
    public void onBackPressed(){
        count++;
        if(count>=1){
            Intent intent = new Intent(ActivitySubjectStudent.this,ActivityLogin.class);
            startActivity(intent);
            finish();
        }
    }
    public void information (final int pos){
        Cursor cursor = database.getDataSubject();
        while(cursor.moveToNext()){
            int id = cursor.getInt(0);
            if(id==pos){
                Intent intent = new Intent(ActivitySubjectStudent.this,ActivitySubjectInformation.class);

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