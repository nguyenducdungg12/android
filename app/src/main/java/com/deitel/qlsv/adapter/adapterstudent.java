package com.deitel.qlsv.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import com.deitel.qlsv.ActivityStudent;
import com.deitel.qlsv.R;
import com.deitel.qlsv.models.Student;

import java.util.ArrayList;


public class adapterstudent extends BaseAdapter {

    private ActivityStudent context;
    private ArrayList<Student> ArrayListStudent;

    public adapterstudent(ActivityStudent context, ArrayList<Student> arrayListStudent) {
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
        convertView = inflater.inflate(R.layout.liststudent,null);

        TextView txtName = convertView.findViewById(R.id.TextViewStudentName);
        TextView txtCode = convertView.findViewById(R.id.TextViewStudentCode);

        ImageButton imgbtnDelete = convertView.findViewById(R.id.studentdelete);
        ImageButton imgbtnupdate = convertView.findViewById(R.id.studentupdate);
        ImageButton imgInfomation = convertView.findViewById(R.id.studentinformation);

        Student student = ArrayListStudent.get(position);

        txtName.setText(student.getStudent_name());
        txtCode.setText(student.getStudent_code());

        int id = student.getId_student();

        imgbtnDelete.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.delete(id);
            }
        }));

        imgbtnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.update(id);
            }
        });

        imgInfomation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.information(id);
            }
        });

        return convertView;
    }
}
