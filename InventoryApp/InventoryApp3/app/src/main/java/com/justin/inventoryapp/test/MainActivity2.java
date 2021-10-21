package com.justin.inventoryapp.test;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.justin.inventoryapp.LoginSucess;
import com.justin.inventoryapp.MainActivity;
import com.justin.inventoryapp.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {

    //a list to store all the products
    List<Product> productList;
    RecyclerView recyclerView;
    SQLiteDatabase mDatabase;
    ProductAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //getting the recyclerview from xml
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
      //  recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        mDatabase = openOrCreateDatabase(LoginSucess.DATABASE_NAME, MODE_PRIVATE, null);

        showEmployeesFromDatabase();
    }

    private void showEmployeesFromDatabase() {
        //we used rawQuery(sql, selectionargs) for fetching all the employees
        Cursor cursorproduct = mDatabase.rawQuery("SELECT * FROM Student", null);
        List<Product> productList= new ArrayList<>();

        //if the cursor has some data
        if (cursorproduct.moveToFirst()) {
            //looping through all the records
            do {
                //pushing each record in the employee list
                productList.add(new Product(
                        cursorproduct.getInt(0),
                        cursorproduct.getString(1),
                        cursorproduct.getString(2),
                        cursorproduct.getString(3)
                ));
            } while (cursorproduct.moveToNext());
        }
        if (productList.isEmpty()) {
            Toast.makeText(this, "No items Found in database", Toast.LENGTH_SHORT).show();
        }
        //closing the cursor
        cursorproduct.close();

        //creating the adapter object
        adapter = new ProductAdapter(this, R.layout.custom_list_item, productList, mDatabase);

        //adding the adapter to listview
        recyclerView.setAdapter(adapter);

        adapter.reloadInventoryFromDatabase();  //this method is in prdouctadapter
    }
}
