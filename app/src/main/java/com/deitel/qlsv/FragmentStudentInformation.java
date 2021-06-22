package com.deitel.qlsv;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.deitel.qlsv.database.database;


public class FragmentStudentInformation extends Fragment {
    TextView txtName, txtSex,txtCode,txtBirthday;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_student_information, container, false);
        txtBirthday = view.findViewById(R.id.txtStudentdateofbirth);
        txtCode = view.findViewById(R.id.txtStudentCode);
        txtSex = view.findViewById(R.id.txtStudentSex);
        txtName = view.findViewById(R.id.txtStudentName);

        String name = this.getArguments().getString("name");
        String sex = this.getArguments().getString("sex");
        String code = this.getArguments().getString("code");
        String birthday = this.getArguments().getString("birthday");

        txtName.setText(name);
        txtSex.setText(sex);
        txtCode.setText(code);
        txtBirthday.setText(birthday);
        Button btnlogout = view.findViewById(R.id.btnlogoutstudent);
        btnlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),ActivityLogin.class);
                startActivity(intent);
            }
        });
        return view;
    }
}