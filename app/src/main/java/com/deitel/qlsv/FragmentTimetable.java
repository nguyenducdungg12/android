package com.deitel.qlsv;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ListView;

import com.deitel.qlsv.adapter.adaptersubjectstudent;
import com.deitel.qlsv.adapter.adaptertimettable;
import com.deitel.qlsv.database.database;
import com.deitel.qlsv.models.Subject;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class FragmentTimetable extends Fragment {
    private  String MSSV;
    ArrayList<ListView> listViewTimeTable;
    private database database;
    private adaptertimettable adaptertimettables;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_timetable, container, false);
        listViewTimeTable = new ArrayList<ListView>(6);
        listViewTimeTable.add(view.findViewById(R.id.listviewSubjectStudent2));
        listViewTimeTable.add(view.findViewById(R.id.listviewSubjectStudent3));
        listViewTimeTable.add(view.findViewById(R.id.listviewSubjectStudent4));
        listViewTimeTable.add(view.findViewById(R.id.listviewSubjectStudent5));
        listViewTimeTable.add(view.findViewById(R.id.listviewSubjectStudent6));
        listViewTimeTable.add(view.findViewById(R.id.listviewSubjectStudent7));

        Intent intent = getActivity().getIntent();
        MSSV = intent.getStringExtra("MSSV");
        database = new database(getActivity());


        for(int i=0;i<=5;i++){

            Cursor cursor = database.getDataSubjectWithDay("Thứ "+(i+2),MSSV);

            ArrayList<Subject> ArrayListSubjectStudent = new ArrayList<Subject>();
            while(cursor.moveToNext()){
                String title = cursor.getString(0);
                String day = cursor.getString(1);
                String time = cursor.getString(2);
                ArrayListSubjectStudent.add(new Subject(title,day,time));
            }

            if(cursor.getCount()>0){
                    for(int j=0;j<ArrayListSubjectStudent.size()-1;j++){
                        for(int k=j+1;k<ArrayListSubjectStudent.size();k++){
                            if(Integer.parseInt(ArrayListSubjectStudent.get(j).getTime().substring(0,ArrayListSubjectStudent.get(j).getTime().indexOf(":")))==Integer.parseInt(ArrayListSubjectStudent.get(k).getTime().substring(0,ArrayListSubjectStudent.get(k).getTime().indexOf(":")))){
                                if(Integer.parseInt(ArrayListSubjectStudent.get(j).getTime().substring(ArrayListSubjectStudent.get(j).getTime().indexOf(":")+1))>Integer.parseInt(ArrayListSubjectStudent.get(k).getTime().substring(ArrayListSubjectStudent.get(k).getTime().indexOf(":")+1))){
                                    Subject temp = ArrayListSubjectStudent.get(j);
                                    ArrayListSubjectStudent.set(j,ArrayListSubjectStudent.get(k));
                                    ArrayListSubjectStudent.set(k,temp);
                                }
                            }
                            if(Integer.parseInt(ArrayListSubjectStudent.get(j).getTime().substring(0,ArrayListSubjectStudent.get(j).getTime().indexOf(":")))>Integer.parseInt(ArrayListSubjectStudent.get(k).getTime().substring(0,ArrayListSubjectStudent.get(k).getTime().indexOf(":")))){
                                Subject temp = ArrayListSubjectStudent.get(j);
                                ArrayListSubjectStudent.set(j,ArrayListSubjectStudent.get(k));
                                ArrayListSubjectStudent.set(k,temp);
                            }
                        }
                    }

                  adaptertimettables = new adaptertimettable(this,ArrayListSubjectStudent);
                  listViewTimeTable.get(i).setAdapter(adaptertimettables);
            }
            cursor.moveToFirst();
            cursor.close();
        }
        return view;
    }
}