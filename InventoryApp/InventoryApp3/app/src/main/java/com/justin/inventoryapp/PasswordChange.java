package com.justin.inventoryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PasswordChange extends AppCompatActivity {
   EditText etPass1,etPass2;
   Button btnLogin,btnReset;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_change);
        etPass1=findViewById(R.id.etNewPassword0);
        etPass2=findViewById(R.id.etNewPassword1);
        btnLogin=findViewById(R.id.btnGotoLogin);
        btnReset=findViewById(R.id.btnResetPassword);
        Intent intent=getIntent();
        String userName=intent.getStringExtra("userName");
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PasswordChange.this,MainActivity.class));
                finish();
            }
        });
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pass1=etPass1.getText().toString();
                String pass2=etPass2.getText().toString();
                if (pass1.equals(pass2)){
                    DatabaseHelper db=new DatabaseHelper(PasswordChange.this);
                    if (db.updatePassword(userName,pass1)){
                        Toast.makeText(PasswordChange.this,"Password has been change you can now login",Toast.LENGTH_LONG).show();
                    }else {
                        Toast.makeText(PasswordChange.this,"Password is not change",Toast.LENGTH_LONG).show();

                    }
                }
                else {
                    Toast.makeText(PasswordChange.this, "Please Enter Same Password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}