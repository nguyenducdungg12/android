package com.deitel.qlsv.adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import com.deitel.qlsv.FragmentSubjectStudent;
import com.deitel.qlsv.FragmentTimetable;
import com.deitel.qlsv.R;
import com.deitel.qlsv.models.Subject;

import java.util.ArrayList;

public class adaptertimettable extends BaseAdapter {
    private FragmentTimetable context;
    private ArrayList<Subject> ArrayListSubject;

    public adaptertimettable(FragmentTimetable context, ArrayList<Subject> arrayListSubject) {
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
        convertView = inflater.inflate(R.layout.listsubjecttable, null);


        TextView TextViewSubjectTitle = (TextView)convertView.findViewById(R.id.TextViewIdSubject);
        TextView TextTimeSubjectTable = (TextView)convertView.findViewById(R.id.TextTimeSubjectTable);

        Subject subject = ArrayListSubject.get(position);
        TextViewSubjectTitle.setText(subject.getSubject_title()+"");
        TextTimeSubjectTable.setText(subject.getTime());
        ArrayList<String> randomColor = new ArrayList<>();
        randomColor.add("#F1AF00");
        randomColor.add("#5BBD2B");
        randomColor.add("#FF3399");
        randomColor.add("#66FFFF");
        int temp = (int)(Math.random() * ((3 - 0) + 1));
        convertView.setBackgroundColor(Color.parseColor(randomColor.get(temp)));
        return convertView;
    }
}
