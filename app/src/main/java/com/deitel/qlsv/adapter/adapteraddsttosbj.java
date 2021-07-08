package com.deitel.qlsv.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import com.deitel.qlsv.ActivityAddStudenttoSubject;
import com.deitel.qlsv.R;
import com.deitel.qlsv.models.Student;

import java.util.ArrayList;


public class adapteraddsttosbj extends BaseAdapter {

    private ActivityAddStudenttoSubject context;
    private ArrayList<Student> ArrayListStudent;

    public adapteraddsttosbj(ActivityAddStudenttoSubject context, ArrayList<Student> arrayListStudent) {
        this.context = context;
        ArrayListStudent = arrayListStudent;
    }

    @Override
    public int getCount() {
        return ArrayListStudent.size();
    }

    @Override
    public Object getItem(int position) {
        return ArrayListStudent.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.liststudentsubject,null);

        TextView txtName = convertView.findViewById(R.id.TextViewSubjects);
        TextView txtCode = convertView.findViewById(R.id.TextViewStudentCode);

        ImageButton imageInformation = (ImageButton)convertView.findViewById(R.id.studentsubjectinformation);

        Student student = ArrayListStudent.get(position);

        txtName.setText(student.getStudent_name());
        txtCode.setText(student.getStudent_code());

        int id = student.getId_student();
        imageInformation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.information(id);
            }
        });
        return convertView;
    }
}

