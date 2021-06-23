package com.deitel.qlsv;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.deitel.qlsv.database.database;
import com.deitel.qlsv.models.Student;

public class ActivityScore extends AppCompatActivity {
    EditText editscore;
    Button btnaddscore;
    database database;
    TextView txtStudentScore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        editscore = findViewById(R.id.EditTextScore);
        btnaddscore = findViewById(R.id.buttonAddScore);
        txtStudentScore = findViewById(R.id.txtStudentScore);
        database = new database(this);
        Intent intent = getIntent();
        int id_subjects = intent.getIntExtra("id_subjects",0);
        int id_student = intent.getIntExtra("id_student",0);
        Cursor cursor=database.getScoreStudent(id_student,id_subjects);
        while(cursor.moveToNext()) {
            txtStudentScore.setText(cursor.getFloat(2)+"");
        }
        btnaddscore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp = editscore.getText().toString().trim();
                float score =Float.parseFloat(temp);
                if(temp.equals("")){
                    Toast.makeText(ActivityScore.this,"Chưa nhập đủ thông tin",Toast.LENGTH_SHORT).show();
                }
                else{
                    database.AddScoreStudenttoSubject(id_student,id_subjects,score);
                    Intent intent = new Intent(ActivityScore.this, ActivityStudent.class);
                    intent.putExtra("id_subject",id_subjects);
                    startActivity(intent);
                    Toast.makeText(ActivityScore.this,"Đã thêm điểm",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}