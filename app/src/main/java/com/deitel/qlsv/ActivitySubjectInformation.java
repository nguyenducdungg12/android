package com.deitel.qlsv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class ActivitySubjectInformation extends AppCompatActivity {

    TextView edtTitle,edtCredit,edtTime,edtPlace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject_information);

        edtTitle = findViewById(R.id.txtSubjectTitle);
        edtCredit = findViewById(R.id.txtSubjectCredit);
        edtTime = findViewById(R.id.txtSubjectTime);
        edtPlace = findViewById(R.id.txtSubjectPlace);

        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        int credit = intent.getIntExtra("credit",0);
        String place = intent.getStringExtra("place");
        String time = intent.getStringExtra("time");


        edtTitle.setText(title);
        edtCredit.setText(credit+"");
        edtTime.setText(time);
        edtPlace.setText(place);
    }
}