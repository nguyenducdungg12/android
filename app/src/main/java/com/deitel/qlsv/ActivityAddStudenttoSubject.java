package com.deitel.qlsv;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.deitel.qlsv.adapter.adapteraddsttosbj;
import com.deitel.qlsv.adapter.adapterstudent;
import com.deitel.qlsv.database.database;
import com.deitel.qlsv.models.Student;

import java.util.ArrayList;

public class ActivityAddStudenttoSubject extends AppCompatActivity {

    Toolbar toolbar;
    ListView listViewAllstudent;

    ArrayList<Student> ArrayListStudent;
    database database;
    adapteraddsttosbj adapteraddsttosbj;
    int id_subject;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_studentto_subject);

        Intent intent = getIntent();
        id_subject = intent.getIntExtra("id_subject",0);
        toolbar = findViewById(R.id.toolbarstudenttoSubject);
        listViewAllstudent = findViewById(R.id.listviewsAllstudent);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ArrayListStudent = new ArrayList<>();
        ArrayListStudent.clear();
        database = new database(this);
        Cursor cursor = database.getDataAllStudent();
        while(cursor.moveToNext()){
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            String sex = cursor.getString(2);
            String code =  cursor.getString(3);
            String birthday = cursor.getString(4);

            ArrayListStudent.add(new Student(id,name,sex,code,birthday));
        }
        adapteraddsttosbj = new adapteraddsttosbj(ActivityAddStudenttoSubject.this,ArrayListStudent);
        listViewAllstudent.setAdapter(adapteraddsttosbj);
        listViewAllstudent.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int id_student=ArrayListStudent.get(position).getId_student();
                boolean check = database.checkSubjectStudent(id_student,id_subject);

                if(check){
                    boolean value=database.AddStudentToSubject(id_student,id_subject);
                    if(value==true) {
                        Toast.makeText(ActivityAddStudenttoSubject.this, "Thêm sinh viên thành công", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(ActivityAddStudenttoSubject.this, ActivityStudent.class);
                        intent.putExtra("id_subject",id_subject);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(ActivityAddStudenttoSubject.this,"Sinh viên đã nằm trong môn học này",Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(ActivityAddStudenttoSubject.this,"Môn học đã trùng giờ ",Toast.LENGTH_SHORT).show();

                }

            }
        });
        cursor.moveToFirst();
        cursor.close();
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        switch(item.getItemId()){
            default:
                Intent intent1 = new Intent(ActivityAddStudenttoSubject.this,ActivityStudent.class);
                intent1.putExtra("id_subject",id_subject);
                startActivity(intent1);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    public void information(final int pos){
        Cursor cursor = database.getDataStudent(id_subject);
        while (cursor.moveToNext()){
            int id = cursor.getInt(0);

            if(id == pos){
                Intent intent = new Intent(ActivityAddStudenttoSubject.this,ActivityInformationStudent.class);
                intent.putExtra("id",pos);

                String name = cursor.getString(1);
                String sex = cursor.getString(2);
                String code = cursor.getString(3);
                String birthday = cursor.getString(4);

                intent.putExtra("name",name);
                intent.putExtra("sex",sex);
                intent.putExtra("code",code);
                intent.putExtra("birthday",birthday);

                startActivity(intent);
            }
        }
    }
}