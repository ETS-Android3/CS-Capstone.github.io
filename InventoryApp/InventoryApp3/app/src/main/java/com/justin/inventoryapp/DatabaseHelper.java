package com.justin.inventoryapp;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
        public static final String DATABASE_NAME="register.db";
        public static final String TABLE_NAME="registration";
        public static final String COL_1="ID";
        public static final String COL_2="Name";
        public static final String COL_3="Password";
        public DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, 1);
        }
// stored names and passwords.//
        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,Name TEXT,Password TEXT)");
        }
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " +TABLE_NAME);
            onCreate(db);
        }

        //find username exist in database or not in reset password
        public boolean checkUserName(String userName){
            SQLiteDatabase myDb=this.getWritableDatabase();
            Cursor cursor=myDb.rawQuery("select * from registration where Name=?",new String[]{userName});
            if (cursor.getCount()>0){
                return true;
            }
            else {
                return false;
            }
        }
        //update Password of user on forget password activity
        public boolean updatePassword(String username,String password){
            SQLiteDatabase myDb=this.getWritableDatabase();
            ContentValues contentValues=new ContentValues();
            contentValues.put("Password",password);
            long result=myDb.update("registration",contentValues,"Name=?",new String[]{username});
             if (result==-1){
                 return false;
             }
             else {
                 return true;
             }
        }
    }

