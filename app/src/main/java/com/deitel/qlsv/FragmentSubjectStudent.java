package com.deitel.qlsv;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.deitel.qlsv.adapter.adaptersubjectstudent;
import com.deitel.qlsv.database.database;
import com.deitel.qlsv.models.Subject;

import java.util.ArrayList;


public class FragmentSubjectStudent extends Fragment {
    ListView listViewSubjectStudent;
    ArrayList<Subject> ArrayListSubjectStudent;
    com.deitel.qlsv.database.database database;
    com.deitel.qlsv.adapter.adaptersubjectstudent adaptersubjectstudent;
    String MSSV="";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_subject_student, container, false);
        listViewSubjectStudent = view.findViewById(R.id.listviewSubjectStudent);
        Intent intent = getActivity().getIntent();
        MSSV = intent.getStringExtra("MSSV");
        System.out.println(MSSV);
        database = new database(getActivity());

        ArrayListSubjectStudent = new ArrayList<>();

        Cursor cursor = database.getDataSubjectStudent(MSSV);

        while(cursor.moveToNext()){
            int id = cursor.getInt(0);
            String title = cursor.getString(1);
            int credit = cursor.getInt(2);
            String time = cursor.getString(3);
            String place = cursor.getString(4);
            String day = cursor.getString(5);
            ArrayListSubjectStudent.add(new Subject(id,title,credit,time,place,day));
        }

        adaptersubjectstudent = new adaptersubjectstudent(this,ArrayListSubjectStudent);
        listViewSubjectStudent.setAdapter(adaptersubjectstudent);
        cursor.moveToFirst();
        cursor.close();
        return view;
    }
    public void information (final int pos){
        Cursor cursor = database.getDataSubject();
        while(cursor.moveToNext()){
            int id = cursor.getInt(0);
            if(id==pos){
                Intent intent = new Intent(getActivity(),ActivitySubjectInformation.class);

                intent.putExtra("id",id);
                String title = cursor.getString(1);
                int credit = cursor.getInt(2);
                String time = cursor.getString(3);
                String place = cursor.getString(4);
                String day = cursor.getString(5);

                intent.putExtra("title",title);
                intent.putExtra("credit",credit);
                intent.putExtra("time",time);
                intent.putExtra("place",place);
                intent.putExtra("day",day);

                startActivity(intent);
            }
        }
    }
}