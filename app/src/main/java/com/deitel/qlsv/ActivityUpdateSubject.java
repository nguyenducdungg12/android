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

public class ActivityUpdateSubject extends AppCompatActivity {

    EditText edtUpdateTitle,edtUpdateCredit,edtUpdateTime,edtUpdatePlace;
    Button btnUpdatesubject;
    Spinner spinnerDayUpdate,spinerTimeUpdate;
    com.deitel.qlsv.database.database database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_subject);

        edtUpdateCredit = findViewById(R.id.EditTextUpdateSubjectCredit);
        edtUpdateTitle = findViewById(R.id.EditTextUpdateSubjectTitle);
        edtUpdatePlace = findViewById(R.id.EditTextUpdateSubjectPlace);
        btnUpdatesubject = findViewById(R.id.buttonUpdateSubject);
        spinnerDayUpdate = findViewById(R.id.spinnerDayUpdate);
        spinerTimeUpdate = findViewById(R.id.spinnerTimeUpdate);
        // lấy dữ liệu intent
        String[] itemsTime = new String[]{"7:30","8:15","9:00","10:00","10:45","11:30","13:00","13:45","14:30","15:30","16:15"};
        ArrayAdapter<String> adapterTime = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, itemsTime);

        String[] items = new String[]{"Thứ 2", "Thứ 3 ","Thứ 4","Thứ 5","Thứ 6","Thứ 7","Chủ nhật"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        spinnerDayUpdate.setAdapter(adapter);
        spinerTimeUpdate.setAdapter(adapterTime);


        Intent intent = getIntent();

        String title = intent.getStringExtra("title");
        int credit = intent.getIntExtra("credit",0);
        String place = intent.getStringExtra("place");
        String time = intent.getStringExtra("time");
        int id = intent.getIntExtra("id",0);
        String day = intent.getStringExtra("day");

        if (day != null) {
            int pos = adapter.getPosition(day);
            spinnerDayUpdate.setSelection(pos);
        }
        if(time!=null){
            int pos = adapterTime.getPosition(time);
            spinerTimeUpdate.setSelection(pos);
        }

        edtUpdateTitle.setText(title);
        edtUpdateCredit.setText(credit+"");
        edtUpdatePlace.setText(place);

          database = new database(this);

          btnUpdatesubject.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  DialogUpdate(id);
              }
          });
    }
    private void DialogUpdate(final int id){
        Dialog dialog = new Dialog(this);

        dialog.setContentView(R.layout.dialogupdatesubject);

        dialog.show();

        Button btnYes = dialog.findViewById(R.id.buttonYes);
        Button btnNo = dialog.findViewById(R.id.buttonNo);

        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String subjecttitle = edtUpdateTitle.getText().toString().trim();
                String credit = edtUpdateCredit.getText().toString().trim();
                String place = edtUpdatePlace.getText().toString().trim();
                if(subjecttitle.equals("")||credit.equals("")||place.equals("")){
                    Toast.makeText(ActivityUpdateSubject.this,"Chưa nhập đủ thông tin",Toast.LENGTH_SHORT).show();

                }else{
                    Subject subject = UpdateObject();
                    database.UpdateSubject(subject,id);
                    Intent intent = new Intent(ActivityUpdateSubject.this,ActivitySubject.class);
                    Toast.makeText(ActivityUpdateSubject.this,"Cập nhật thành công",Toast.LENGTH_SHORT).show();

                    startActivity(intent);
                    Toast.makeText(ActivityUpdateSubject.this,"Cập nhật thành công",Toast.LENGTH_SHORT).show();

                }
            }
        });
    }

        private Subject UpdateObject(){
            String subjecttitle = edtUpdateTitle.getText().toString().trim();
            int credit = Integer.parseInt(edtUpdateCredit.getText().toString().trim());
            String time = spinerTimeUpdate.getSelectedItem().toString();
            String place = edtUpdatePlace.getText().toString().trim();
            String day = spinnerDayUpdate.getSelectedItem().toString();
            Subject subject = new Subject(subjecttitle,credit,time,place,day);
            return subject;
        }
    }
