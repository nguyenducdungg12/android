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

import com.deitel.qlsv.adapter.adapterstudent;
import com.deitel.qlsv.database.database;
import com.deitel.qlsv.models.Student;

import java.util.ArrayList;

public class ActivityStudent extends AppCompatActivity {

    Toolbar toolbar;
    ListView listViewstudent;

    ArrayList<Student> ArrayListStudent;
    database database;
    adapterstudent adapterstudent;

    int id_subject = 0;
    int counter = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        toolbar = findViewById(R.id.toolbarstudent);
        listViewstudent = findViewById(R.id.listviewsstudent);

        Intent intent = getIntent();
        id_subject = intent.getIntExtra("id_subject",0);
        System.out.println(id_subject);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        database = new database(this);

        ArrayListStudent = new ArrayList<>();
        ArrayListStudent.clear();

        Cursor cursor = database.getDataStudent(id_subject);
        while(cursor.moveToNext()){
            int id_sub = cursor.getInt(5);
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            String sex = cursor.getString(2);
            String code =  cursor.getString(3);
            String birthday = cursor.getString(4);

            ArrayListStudent.add(new Student (id,name,sex,code,birthday,id_sub));
        }
        adapterstudent = new adapterstudent(ActivityStudent.this,ArrayListStudent);

        listViewstudent.setAdapter(adapterstudent);
        cursor.moveToFirst();
        cursor.close();
    }

////    Thêm icon add
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menuaddstudent,menu);
        return true;
    }
//
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        switch(item.getItemId()){
            case R.id.menuaddstudent:
                Intent intent = new Intent(ActivityStudent.this,ActivityAddStudent.class);
                intent.putExtra("id_subject",id_subject);
                startActivity(intent);
                break;
            default:
                Intent intent1 = new Intent(ActivityStudent.this,ActivitySubject.class);
                startActivity(intent1);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onBackPressed(){
        counter++;
        if(counter >=1){
            Intent intent = new Intent(this,ActivitySubject.class);
            startActivity(intent);
            finish();
        }
    }
//
    public void information(final int pos){
        Cursor cursor = database.getDataStudent(id_subject);
        while (cursor.moveToNext()){
            int id = cursor.getInt(0);

            if(id == pos){
                Intent intent = new Intent(ActivityStudent.this,ActivityInformationStudent.class);
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