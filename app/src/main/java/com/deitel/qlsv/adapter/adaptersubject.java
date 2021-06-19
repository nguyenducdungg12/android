package com.deitel.qlsv.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import com.deitel.qlsv.ActivitySubject;
import com.deitel.qlsv.R;
import com.deitel.qlsv.models.Subject;

import java.util.ArrayList;

public class adaptersubject extends BaseAdapter {
    private ActivitySubject context;
    private ArrayList<Subject> ArrayListSubject;

    public adaptersubject(ActivitySubject context, ArrayList<Subject> arrayListSubject) {
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
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.listsubject, null);
        TextView TextViewSubjectTitle = (TextView)convertView.findViewById(R.id.TextViewSubjectTitle);
        TextView TextViewCredit = (TextView)convertView.findViewById(R.id.TextViewCredit);
        ImageButton imageDelete = (ImageButton)convertView.findViewById(R.id.subjectdelete);
        ImageButton imageInformation = (ImageButton)convertView.findViewById(R.id.subjectinformation);
        ImageButton imageUpdate = (ImageButton)convertView.findViewById(R.id.subjectupdate);
        Subject subject = ArrayListSubject.get(position);
        Log.d("TAG", ""+subject.getNumber_of_credit());
        TextViewCredit.setText(subject.getNumber_of_credit()+"");
        TextViewSubjectTitle.setText(subject.getSubject_title());
        int id = subject.getId();
        imageInformation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    context.information(id);
            }
        });
        imageDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.delete(id);
            }
        });
        imageUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.update(id);
            }
        });
        return convertView;
    }
}
