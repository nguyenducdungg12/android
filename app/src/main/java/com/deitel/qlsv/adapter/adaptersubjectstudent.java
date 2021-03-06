package com.deitel.qlsv.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import com.deitel.qlsv.ActivitySubjectStudent;
import com.deitel.qlsv.FragmentSubjectStudent;
import com.deitel.qlsv.R;
import com.deitel.qlsv.models.Subject;

import java.util.ArrayList;

public class adaptersubjectstudent extends BaseAdapter {
    private FragmentSubjectStudent context;
    private ArrayList<Subject> ArrayListSubject;

    public adaptersubjectstudent(FragmentSubjectStudent context, ArrayList<Subject> arrayListSubject) {
        this.context = context;
        ArrayListSubject = arrayListSubject;
    }

    @Override
    public int getCount() {
        return ArrayListSubject.size();
    }

    @Override
    public Object getItem(int position) {
        return ArrayListSubject.get(position);
    }

    @Override
    public long getItemId(int position) {
        return  position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context.getActivity());
        convertView = inflater.inflate(R.layout.listsubjectstudent, null);
        TextView TextViewSubjectTitle = (TextView)convertView.findViewById(R.id.TextViewSubjectStudentTitle);
        TextView TextViewCredit = (TextView)convertView.findViewById(R.id.TextViewCreditSubjectStudent);
        TextView mamh = (TextView)convertView.findViewById(R.id.mamh);
        ImageButton imageInformation = (ImageButton)convertView.findViewById(R.id.subjectstudentinformation);
        Subject subject = ArrayListSubject.get(position);
        TextViewCredit.setText(subject.getNumber_of_credit()+"");
        TextViewSubjectTitle.setText(subject.getSubject_title());
        mamh.setText(subject.getId()+"");

        int id = subject.getId();
        imageInformation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.information(id);
            }
        });
        return convertView;
    }
}
