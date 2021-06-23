package com.deitel.qlsv.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.deitel.qlsv.FragmentScoreBoard;
import com.deitel.qlsv.R;
import com.deitel.qlsv.models.Subject;
import com.deitel.qlsv.models.SubjectStudent;

import java.util.ArrayList;

public class adapterscoreboard extends BaseAdapter {
    private FragmentScoreBoard context;
    private ArrayList<SubjectStudent> ArrayListSubject;
    public adapterscoreboard(FragmentScoreBoard context, ArrayList<SubjectStudent> arrayListSubject) {
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
        convertView = inflater.inflate(R.layout.listscoresubject, null);

        TextView txtScoreSubject = (TextView)convertView.findViewById(R.id.txtScoreSubject);
        TextView TextViewIdSubject = (TextView) convertView.findViewById(R.id.TextViewIdSubject);

        SubjectStudent subjectStudent = ArrayListSubject.get(position);

        TextViewIdSubject.setText(subjectStudent.getId_subject()+"");
        txtScoreSubject.setText(subjectStudent.getStudentscore()+"");

        return convertView;
    }
}
