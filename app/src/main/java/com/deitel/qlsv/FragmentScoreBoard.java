package com.deitel.qlsv;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.deitel.qlsv.adapter.adapterscoreboard;
import com.deitel.qlsv.adapter.adaptersubjectstudent;
import com.deitel.qlsv.database.database;
import com.deitel.qlsv.models.Subject;
import com.deitel.qlsv.models.SubjectStudent;

import java.util.ArrayList;


public class FragmentScoreBoard extends Fragment {
    ListView listviewSubjectStudentScore;
    ArrayList<SubjectStudent> ArrayListSubjectStudent;
    com.deitel.qlsv.database.database database;
    adapterscoreboard adapterscoreboard;
    String MSSV;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_score_board, container, false);
        listviewSubjectStudentScore = view.findViewById(R.id.listviewSubjectStudentScore);
        Intent intent = getActivity().getIntent();
        MSSV = intent.getStringExtra("MSSV");

        database = new database(getActivity());

        ArrayListSubjectStudent = new ArrayList<>();

        Cursor cursor = database.getAllScoreStudent(MSSV);
        while(cursor.moveToNext()){
            int id_student = cursor.getInt(0);
            int id_subject = cursor.getInt(1);
            float score = cursor.getInt(2);
            ArrayListSubjectStudent.add(new SubjectStudent(id_student,id_subject,score));
        }

        adapterscoreboard = new adapterscoreboard(this,ArrayListSubjectStudent);
        listviewSubjectStudentScore.setAdapter(adapterscoreboard);
        cursor.moveToFirst();
        cursor.close();
        return view;
    }
}