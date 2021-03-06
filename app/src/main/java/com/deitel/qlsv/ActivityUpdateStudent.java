package com.deitel.qlsv;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.deitel.qlsv.database.database;
import com.deitel.qlsv.models.Student;

public class ActivityUpdateStudent extends AppCompatActivity {

    EditText editTextUpdateName,editTextUpdateCode,editTextUpdateBirthday;
    RadioButton rdMale,rdFemale;
    Button btnUpdateStudent;
    com.deitel.qlsv.database.database database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_student);

        editTextUpdateBirthday = findViewById(R.id.EditTextStudentBirthdayUpdate);
        editTextUpdateName = findViewById(R.id.EditTextStudentNameUpdate);
        editTextUpdateCode = findViewById(R.id.EditTextStudentCodeUpdate);

        rdFemale = findViewById(R.id.radiobuttonFeMaleUpdate);
        rdMale = findViewById(R.id.radiobuttonMaleUpdate);

        btnUpdateStudent = findViewById(R.id.buttonUpdateStudent);
        database = new database(this);
        Intent intent = getIntent();

        int id = intent.getIntExtra("id",0);
        String name = intent.getStringExtra("name");
        String sex = intent.getStringExtra("sex");
        System.out.println(sex);
        String code = intent.getStringExtra("code");
        String birthday = intent.getStringExtra("birthday");


        //gán giá trị lên editext và radiobtn

        editTextUpdateName.setText(name);
        editTextUpdateCode.setText(code);
        editTextUpdateBirthday.setText(birthday);

        if(sex.equals("Nam")){
            rdMale.setChecked(true);
            rdFemale.setChecked(false);
        }
        else{
            rdMale.setChecked(false);
            rdFemale.setChecked(true);
        }
        btnUpdateStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogUpdate(id);
            }
        });
    }

    private void DialogUpdate(int id) {

        Dialog dialog = new Dialog(this);

        dialog.setContentView(R.layout.dialogupdatestudent);

        dialog.setCanceledOnTouchOutside(false);

        dialog.show();
        Button btnNo = dialog.findViewById(R.id.buttonNoUpdate);
        Button btnYes = dialog.findViewById(R.id.buttonYesupdateStudent);
        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextUpdateName.getText().toString().trim();
                String code = editTextUpdateCode.getText().toString().trim();
                String birthday = editTextUpdateBirthday.getText().toString().trim();
                if(name.equals("")||code.equals("")||birthday.equals("")){
                    Toast.makeText(ActivityUpdateStudent.this,"Bạn chưa nhập đủ dữ liệu",Toast.LENGTH_SHORT).show();
                }
                else{
                    Student student = createStudent();
                    database.UpdateStudent(student,id);
                    Intent intent = new Intent(ActivityUpdateStudent.this,ActivityAdmin.class);
                    startActivity(intent);
                    Toast.makeText(ActivityUpdateStudent.this,"Sửa thành công",Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    dialog.cancel();
            }
        });
    }
    private Student createStudent(){
        String name = editTextUpdateName.getText().toString().trim();
        String code = editTextUpdateCode.getText().toString().trim();
        String birthday = editTextUpdateBirthday.getText().toString().trim();
        String sex = "";
        if(rdFemale.isChecked()){
            sex="Nữ";
        }
        else if(rdMale.isChecked()){
            sex="Nam";
        }
        Student student = new Student(name,sex,code,birthday);
        return student;
    }
}