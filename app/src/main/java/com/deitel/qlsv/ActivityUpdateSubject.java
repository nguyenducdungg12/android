package com.deitel.qlsv;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.deitel.qlsv.database.database;
import com.deitel.qlsv.models.Subject;

public class ActivityUpdateSubject extends AppCompatActivity {

    EditText edtUpdateTitle,edtUpdateCredit,edtUpdateTime,edtUpdatePlace;
    Button btnUpdatesubject;
    com.deitel.qlsv.database.database database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_subject);

        edtUpdateCredit = findViewById(R.id.EditTextUpdateSubjectCredit);
        edtUpdateTitle = findViewById(R.id.EditTextUpdateSubjectTitle);
        edtUpdateTime = findViewById(R.id.EditTextUpdateSubjectTime);
        edtUpdatePlace = findViewById(R.id.EditTextUpdateSubjectPlace);
        btnUpdatesubject = findViewById(R.id.buttonUpdateSubject);
        // lấy dữ liệu intent

        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        int credit = intent.getIntExtra("credit",0);
        String place = intent.getStringExtra("place");
        String time = intent.getStringExtra("time");
        int id = intent.getIntExtra("id",0);

        edtUpdateTitle.setText(title);
        edtUpdateCredit.setText(credit+"");
        edtUpdateTime.setText(time);
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
                String time = edtUpdateTime.getText().toString().trim();
                String place = edtUpdatePlace.getText().toString().trim();
                if(subjecttitle.equals("")||credit.equals("")||time.equals("")||place.equals("")){
                    Toast.makeText(ActivityUpdateSubject.this,"Chưa nhập đủ thông tin",Toast.LENGTH_SHORT).show();

                }else{
                    Subject subject = UpdateObject();
                    database.UpdateSubject(subject,id);
                    Intent intent = new Intent(ActivityUpdateSubject.this,ActivitySubject.class);
                    startActivity(intent);
                    Toast.makeText(ActivityUpdateSubject.this,"Cập nhật thành công",Toast.LENGTH_SHORT).show();

                }
            }
        });
    }

        private Subject UpdateObject(){
            String subjecttitle = edtUpdateTitle.getText().toString().trim();
            int credit = Integer.parseInt(edtUpdateCredit.getText().toString().trim());
            String time = edtUpdateTime.getText().toString().trim();
            String place = edtUpdatePlace.getText().toString().trim();

            Subject subject = new Subject(subjecttitle,credit,time,place);
            return subject;
        }
    }
