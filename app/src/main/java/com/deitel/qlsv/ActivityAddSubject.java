package com.deitel.qlsv;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.deitel.qlsv.database.database;
import com.deitel.qlsv.models.Subject;

public class ActivityAddSubject extends AppCompatActivity {
    Button buttonAddSubject;
    EditText editSubjectTitle, editSubjectCredit, editSubjectTime,editSubjectPlace;
    Spinner spinnerDay,spinnerTime;

    com.deitel.qlsv.database.database database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_subject);

        buttonAddSubject = findViewById(R.id.buttonAddSubject);
        editSubjectTitle = findViewById(R.id.EditTextSubjectTitle);
//        editSubjectTime = findViewById(R.id.EditTextSubjectTime);
        editSubjectCredit = findViewById(R.id.EditTextSubjectCredit);
        editSubjectPlace = findViewById(R.id.EditTextSubjectPlace);
        spinnerDay = findViewById(R.id.spinnerDay);
        spinnerTime = findViewById(R.id.spinnerTime);

        database = new database(this);
        String[] items = new String[]{"Thứ 2", "Thứ 3 ","Thứ 4","Thứ 5","Thứ 6","Thứ 7","Chủ nhật"};
        String[] itemsTime = new String[]{"7:30","8:15","9:00","10:00","10:45","11:30","13:00","13:45","14:30","15:30","16:15"};
        ArrayAdapter<String> adapterTime = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, itemsTime);
        ArrayAdapter<String> adapterDay = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        spinnerDay.setAdapter(adapterDay);
        spinnerTime.setAdapter(adapterTime);
        buttonAddSubject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogAdd();
            }
        });

    }
    private void DialogAdd(){
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialogadd);
        dialog.setCanceledOnTouchOutside(false);

        Button btnYes = dialog.findViewById(R.id.buttonYes);
        Button btnNo = dialog.findViewById(R.id.buttonNo);
        btnYes.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String subjecttitle = editSubjectTitle.getText().toString().trim();
                String credit = editSubjectCredit.getText().toString().trim();
                String place = editSubjectPlace.getText().toString().trim();
                if(subjecttitle.equals("")||credit.equals("")||place.equals("")){
                    Toast.makeText(ActivityAddSubject.this,"Chưa nhập đủ thông tin",Toast.LENGTH_SHORT).show();

                }else{
                    Subject subjectt = CreateSubject();

                    database.AddSubjects(subjectt);
                    Intent intent = new Intent(ActivityAddSubject.this,ActivitySubject.class);
                    startActivity(intent);
                    Toast.makeText(ActivityAddSubject.this,"Thêm thành công",Toast.LENGTH_SHORT).show();
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
    };
    private Subject CreateSubject(){
        String subjecttitle = editSubjectTitle.getText().toString().trim();
        int credit = Integer.parseInt(editSubjectCredit.getText().toString().trim());
        String time = spinnerTime.getSelectedItem().toString().trim();
        String place = editSubjectPlace.getText().toString().trim();
        String day = spinnerDay.getSelectedItem().toString().trim();
        Subject subject = new Subject(subjecttitle,credit,time,place,day);
        return subject;
    }

}