package com.deitel.qlsv;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.deitel.qlsv.database.database;
import com.deitel.qlsv.models.Student;

public class ActivityAddStudent extends AppCompatActivity {
    Button buttonAddStudent;
    EditText editTextStudentName,editTextStudentCode,editTextDateofbirth;
    RadioButton radiobuttonMale,radiobuttonFemale;
    database database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        buttonAddStudent = findViewById(R.id.buttonAddStudent);
        editTextDateofbirth = findViewById(R.id.EditTextStudentBirthday);
        editTextStudentCode = findViewById(R.id.EditTextStudentCode);
        editTextStudentName = findViewById(R.id.EditTextStudentName);

        radiobuttonFemale = findViewById(R.id.radiobuttonFeMale);
        radiobuttonMale = findViewById(R.id.radiobuttonMale);

        Intent intent = getIntent();
        int id_subject = intent.getIntExtra("id_subject",0);

        database = new database(this);
        buttonAddStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogAdd(id_subject);
            }
        });
    }

    private void DialogAdd(int id_subject) {
        Dialog dialog = new Dialog( this);
        dialog.setContentView(R.layout.dialogaddstudent);
        dialog.setCanceledOnTouchOutside(false);

        Button btnYes = dialog.findViewById(R.id.buttonYesAddStudent);
        Button btnNo = dialog.findViewById(R.id.buttonNoAddStudent);

        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextStudentName.getText().toString().trim();
                String code = editTextStudentCode.getText().toString().trim();
                String birthday = editTextDateofbirth.getText().toString().trim();
                String sex ="";
                if(radiobuttonMale.isChecked()){
                    sex="Nam";
                }
                else if(radiobuttonFemale.isChecked()){
                    sex="Nữ";
                }
                if(name.equals("")||code.equals("")||birthday.equals("")||sex.equals("")){
                    Toast.makeText(ActivityAddStudent.this,"Bạn chưa nhập đủ dữ liệu",Toast.LENGTH_SHORT).show();
                }
                else{
                    Student student = CreateStudent(id_subject);
                    database.AddStudent(student);

                    Intent intent = new Intent(ActivityAddStudent.this,ActivityStudent.class);
                    intent.putExtra("id_subject",id_subject);
                    startActivity(intent);

                    Toast.makeText(ActivityAddStudent.this,"Thêm thành công",Toast.LENGTH_SHORT).show();
                }
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
    private Student CreateStudent(int id_subject){
        String name = editTextStudentName.getText().toString().trim();
        String code = editTextStudentCode.getText().toString().trim();
        String birthday = editTextDateofbirth.getText().toString().trim();
        String sex ="";
        if(radiobuttonMale.isChecked()){
            sex="Nam";
        }
        else if(radiobuttonFemale.isChecked()){
            sex="Nữ";
        }

        Student student = new Student(name,sex,code,birthday,id_subject);
        return student;
    }
}