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
import com.deitel.qlsv.adapter.adapterallstudent;
import com.deitel.qlsv.database.database;
import com.deitel.qlsv.models.Student;

import java.util.ArrayList;

public class ActivityShowAllStudent extends AppCompatActivity {
    Toolbar toolbar;
    ListView listviewsstudentAll;

    ArrayList<Student> ArrayListStudent;
    database database;
    adapterallstudent adapterallstudent;
    int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_all_student);
        toolbar = findViewById(R.id.toolbarAllstudent);
        listviewsstudentAll = findViewById(R.id.listviewsstudentAll);
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
        adapterallstudent = new adapterallstudent(ActivityShowAllStudent.this,ArrayListStudent);
        listviewsstudentAll.setAdapter(adapterallstudent);
        cursor.moveToFirst();
        cursor.close();
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        switch(item.getItemId()){
            default:
                Intent intent1 = new Intent(ActivityShowAllStudent.this, ActivityAdmin.class);
                startActivity(intent1);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    public void onBackPressed(){
        count++;
        if(count>=1){
            Intent intent = new Intent(ActivityShowAllStudent.this, ActivityAdmin.class);
            startActivity(intent);
            finish();
        }
    }
    public void information(final int pos){
        Cursor cursor = database.getDataAllStudent();
        while (cursor.moveToNext()){
            int id = cursor.getInt(0);

            if(id == pos){
                Intent intent = new Intent(ActivityShowAllStudent.this,ActivityInformationStudent.class);
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
    public void update(final int id_student){
        Cursor cursor = database.getDataAllStudent();
        while(cursor.moveToNext()){
            int id = cursor.getInt(0);

            if(id == id_student){
                Intent intent = new Intent(ActivityShowAllStudent.this,ActivityUpdateStudent.class);
                intent.putExtra("id",id_student);

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
        cursor.close();
    }
    public void delete(final int id_student){

        Dialog dialog = new Dialog(this);

        dialog.setContentView(R.layout.dialogdeletestudent);

        dialog.setCanceledOnTouchOutside(false);

        dialog.show();


        Button btnYes =dialog.findViewById(R.id.buttonYesDeleteStudent);
        Button btnNo = dialog.findViewById(R.id.buttonNoDeleteStudent);
        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                database.DeleteStudentSubject(id_student);
                database.DeleteStudent(id_student);
                Intent intent = new Intent(ActivityShowAllStudent.this,ActivityShowAllStudent.class);
                startActivity(intent);
                Toast.makeText(ActivityShowAllStudent.this,"Xóa Sinh viên thành công",Toast.LENGTH_SHORT).show();
            }
        });
        btnNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });

    }
}
