package com.deitel.qlsv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActivityAdmin extends AppCompatActivity {
    Button btnlistsubjectadmin,btnaddstudentadmin,btnliststudentsubject,btnlogoutadmin;

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
}