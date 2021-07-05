package com.deitel.qlsv;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.widget.Toast;

import com.deitel.qlsv.adapter.VPAdapter;
import com.deitel.qlsv.database.database;
import com.google.android.material.tabs.TabLayout;

public class ActivitySubjectStudent extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    database database;
    String MSSV;
    int count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject_student);
        tabLayout = findViewById(R.id.idTabLayout);
        viewPager = findViewById(R.id.idViewPager);
        tabLayout.setupWithViewPager(viewPager);
        Intent intent = getIntent();
        MSSV = intent.getStringExtra("MSSV");
        database = new database(this);
        VPAdapter vpAdapter = new VPAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        vpAdapter.addFragment(new FragmentSubjectStudent(), "MÔN HỌC ");
        vpAdapter.addFragment(new FragmentScoreBoard(), "ĐIỂM SỐ ");
        vpAdapter.addFragment(new FragmentTimetable(),"THỜI KHÓA BIỂU");
        Bundle bundle = new Bundle();
        Cursor cursor = database.getDataStudentthroughMSSV(MSSV);
        FragmentStudentInformation fragobj = new FragmentStudentInformation();
        while (cursor.moveToNext()) {
            String name = cursor.getString(1);
            String sex = cursor.getString(2);
            String code = cursor.getString(3);
            String birthday = cursor.getString(4);
            bundle.putString("name", name);
            bundle.putString("sex", sex);
            bundle.putString("code", code);
            bundle.putString("birthday", birthday);
            fragobj.setArguments(bundle);
        }
        vpAdapter.addFragment(fragobj, "HỒ SƠ");
        viewPager.setAdapter(vpAdapter);
    }
    public void onBackPressed(){
        count++;
        if(count==1){
            Toast.makeText(getApplicationContext(), " Nhấn lần để thoát ứng dụng ", Toast.LENGTH_SHORT).show();
        }
        else if(count >1){
            Intent intent1= new Intent(Intent.ACTION_MAIN);
            intent1.addCategory(Intent.CATEGORY_HOME);
            startActivity(intent1);
        }
    }
}
