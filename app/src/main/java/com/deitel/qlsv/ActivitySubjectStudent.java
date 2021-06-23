package com.deitel.qlsv;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;

import com.deitel.qlsv.adapter.VPAdapter;
import com.deitel.qlsv.database.database;
import com.google.android.material.tabs.TabLayout;

public class ActivitySubjectStudent extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    database database;
    String MSSV;

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
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 0) {

                }
                if (position == 1) {

                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
