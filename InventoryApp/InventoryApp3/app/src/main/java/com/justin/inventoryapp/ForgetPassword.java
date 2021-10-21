package com.justin.inventoryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ForgetPassword extends AppCompatActivity {
       EditText etUserName;
       Button  btnForgetPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);
        etUserName=findViewById(R.id.etUserName);
        btnForgetPassword=findViewById(R.id.btnResetPassword);
        btnForgetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               DatabaseHelper db=new DatabaseHelper(ForgetPassword.this);
               String user=etUserName.getText().toString();
               if (db.checkUserName(user)){
                 Intent intent=new Intent(getApplicationContext(),PasswordChange.class);
                 intent.putExtra("userName",user);
                 startActivity(intent);
               }
               else
               {
                   etUserName.setError("User does not exist");
//                   Toast.makeText(ForgetPassword.this,"",Toast.LENGTH_LONG).show();
               }
            }
        });
    }
}