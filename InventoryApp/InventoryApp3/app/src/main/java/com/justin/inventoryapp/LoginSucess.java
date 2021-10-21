package com.justin.inventoryapp;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.justin.inventoryapp.test.MainActivity2;


public class LoginSucess extends AppCompatActivity {
    EditText item_name, event_detail, daily_weight;
    Button bt_save,viewdata;
    public static final String DATABASE_NAME = "StudentDatabases.db";
    SQLiteDatabase mDatabase;

    final int SEND_SMS_PERMISSION_REQUEST_CODE=1;
    Button mButtonSend;
    Spinner select;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_sucess);
        mButtonSend=(Button)findViewById(R.id.button);
        item_name = (EditText) findViewById(R.id.itemname);
        event_detail = (EditText) findViewById(R.id.eventdetail);
        daily_weight = (EditText) findViewById(R.id.dailyweight);


        bt_save = (Button) findViewById(R.id.btn_save);






        viewdata = (Button) findViewById(R.id.viewdata);

        bt_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Get the Enter data
                String itemname = item_name.getText().toString().trim();
                String eventdetail = event_detail.getText().toString().trim();
                String dailyweight = daily_weight.getText().toString();



                if (itemname.isEmpty() || eventdetail.isEmpty() || dailyweight.isEmpty()) {

                    Toast.makeText(LoginSucess.this, "Fil the form", Toast.LENGTH_SHORT).show();

                } else {

                    String insertSQL = "INSERT INTO Student \n" +
                            "(ItemName, EventDetail, DailyWeight)\n" +
                            "VALUES \n" +
                            "(?, ?, ?);";

                    //using the same method execsql for inserting values
                    //this time it has two parameters
                    //first is the sql string and second is the parameters that is to be binded with the query
                    mDatabase.execSQL(insertSQL, new String[]{itemname, eventdetail, dailyweight});

                    Toast.makeText(LoginSucess.this, "Great! Data Saved", Toast.LENGTH_SHORT).show();
                }


            }
        });

        mDatabase = openOrCreateDatabase(DATABASE_NAME, MODE_PRIVATE, null);
        createInventoryTable();

        viewdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(LoginSucess.this, MainActivity2.class);
                startActivity(intent);
            }
        });


        select=findViewById(R.id.text_message);
        ArrayAdapter<String> myadapter=new ArrayAdapter<String>(LoginSucess.this,android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.itemselected));
        myadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        select.setAdapter(myadapter);
        mButtonSend.setEnabled(true);

        if(checkPermissions(Manifest.permission.SEND_SMS)){
            mButtonSend.setEnabled(true);
        } else{
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS},SEND_SMS_PERMISSION_REQUEST_CODE);

        }
    }
    private boolean checkPermissions(String permission){
        int permissionCheck= ContextCompat.checkSelfPermission(this, permission);
        return (permissionCheck== PackageManager.PERMISSION_GRANTED);

    }
    public void onRequestPermissionResult(int requestCode, String permission[],int [] grantResults){
        switch (requestCode){
            case SEND_SMS_PERMISSION_REQUEST_CODE:{
                if(grantResults.length>0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    mButtonSend.setEnabled(true);
                }
                return;
            }
        }

    } public void send(View view){
        String phoneNumber=((EditText)findViewById(R.id.txt_no)).getText().toString();



        String msg=select.getSelectedItem().toString();


        if(phoneNumber==null || phoneNumber.length()==0||msg==null|| msg.length()==0){
            return;
        }
        if (checkPermissions(Manifest.permission.SEND_SMS)) {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phoneNumber, null, msg, null, null);
            Toast.makeText(LoginSucess.this, "Your Message has been sent ", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(LoginSucess.this,"No permission", Toast.LENGTH_SHORT).show();
        }












        //FindById (Button and Edittxt)



        //Onclick Btn



    }

    private void createInventoryTable() {
        mDatabase.execSQL("CREATE TABLE IF NOT EXISTS Student " +
                "(\n" +
                "    id INTEGER NOT NULL CONSTRAINT employees_pk PRIMARY KEY AUTOINCREMENT,\n" +
                "    ItemName varchar(200) NOT NULL,\n" +
                "    EventDetail varchar(200) NOT NULL,\n" +
                "    DailyWeight varchar(200) NOT NULL\n" +

                ");"

        );
    }
}