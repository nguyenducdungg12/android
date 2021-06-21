package com.deitel.qlsv;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.deitel.qlsv.database.database;

public class ActivityLogin extends AppCompatActivity {
    Button btnlogin,btnquit;
    EditText loginmssv,loginpassword;
    database database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnlogin = findViewById(R.id.btnlogin);
        btnquit=findViewById(R.id.btnquit);
        loginmssv=findViewById(R.id.loginmssv);
        loginpassword=findViewById(R.id.loginpassword);
        database = new database(this);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean checkStudent= database.CheckStudentLogin(loginmssv.getText().toString());
                if(loginmssv.getText().toString().equals("admin")&&loginpassword.getText().toString().equals("admin")) {
                    Intent intent = new Intent(ActivityLogin.this, ActivitySubject.class);
                    startActivity(intent);
                }
                else if(loginmssv.getText().toString().equals("")||loginpassword.getText().toString().equals("")){
                    Toast.makeText(ActivityLogin.this,"Chưa có thông tin đăng nhập của bạn",Toast.LENGTH_SHORT).show();
                }
                else if(checkStudent==true&&loginmssv.getText().toString().equals(loginpassword.getText().toString())){
                    Intent intent = new Intent(ActivityLogin.this, ActivitySubjectStudent.class);
                    intent.putExtra("MSSV",loginmssv.getText().toString());
                    startActivity(intent);
                }
                else{
                    Toast.makeText(ActivityLogin.this,"Bạn nhập sai mật khẩu hoặc mssv",Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnquit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogExit();
            }
        });
    }
    private void DialogExit() {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialogexit);
//       Click ra ngoài là tắt dialog
        dialog.setCanceledOnTouchOutside(false);
        Button btnYes = dialog.findViewById(R.id.buttonYes);
        Button btnNo = dialog.findViewById(R.id.buttonNo);
        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityLogin.this,ActivityLogin.class);
                startActivity(intent);
                Intent intent1= new Intent(Intent.ACTION_MAIN);
                intent1.addCategory(Intent.CATEGORY_HOME);
                startActivity(intent1);
            }
        });
        btnNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });
        dialog.show();
    }
}