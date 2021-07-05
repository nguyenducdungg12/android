package com.deitel.qlsv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ActivityAdmin extends AppCompatActivity {
    Button btnlistsubjectadmin,btnaddstudentadmin,btnliststudentsubject,btnlogoutadmin;
    int count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        btnlistsubjectadmin = findViewById(R.id.btnlistsubjectadmin);
        btnaddstudentadmin = findViewById(R.id.btnaddstudentadmin);
        btnliststudentsubject = findViewById(R.id.btnliststudentsubject);
        btnlogoutadmin = findViewById(R.id.btnlogoutadmin);
        btnlistsubjectadmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityAdmin.this, ActivitySubject.class);
                startActivity(intent);
            }
        });
        btnaddstudentadmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityAdmin.this, ActivityAddStudent.class);
                startActivity(intent);
            }
        });
        btnliststudentsubject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityAdmin.this, ActivityShowAllStudent.class);
                startActivity(intent);
            }
        });
        btnlogoutadmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityAdmin.this, ActivityLogin.class);
                startActivity(intent);
            }
        });
    }
    @Override
    public void onBackPressed(){
        count++;
        if(count==1){
            Toast.makeText(getApplicationContext(), " Nhấn lần để thoát ứng dụng ", Toast.LENGTH_SHORT).show();
        }
        else if(count >1){
            Intent intent = new Intent(ActivityAdmin.this,ActivityAdmin.class);
            startActivity(intent);
            Intent intent1= new Intent(Intent.ACTION_MAIN);
            intent1.addCategory(Intent.CATEGORY_HOME);
            startActivity(intent1);
        }
    }
}