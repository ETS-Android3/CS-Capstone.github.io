package com.justin.inventoryapp.test;

import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.justin.inventoryapp.R;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;




public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    int custom_list_item;
    SQLiteDatabase mDatabase;


    //this context we will use to inflate the layout
    private Context mCtx;

    //we are storing all the products in a list
    private List<Product> productList;

    //getting the context and product list with constructor
    public ProductAdapter(Context mCtx, int custom_list_item, List<Product> productList, SQLiteDatabase mDatabase) {
        this.mCtx = mCtx;
        this.custom_list_item = custom_list_item;
        this.mDatabase = mDatabase;
        this.productList = productList;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.custom_list_item, null);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        //getting the product of the specified position
        final Product product = productList.get(position);

        //binding the data with the viewholder views
        holder.textViewItemName.setText(product.getItemname());
        holder.textVieweventdetail.setText(product.getEventdetail());
        holder.textViewdailyweight.setText(product.getDailyweight());


        holder.editbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateInventory(product);
            }
        });

        holder.deletebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(mCtx);
                builder.setTitle("Are you sure?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String sql = "DELETE FROM Student WHERE id = ?";
                        mDatabase.execSQL(sql, new Integer[]{product.getId()});
                        Snackbar.make(view, "Deleted" + product.getItemname(), Snackbar.LENGTH_SHORT).show();
                        Toast.makeText(mCtx, "Deleted successfully!", Toast.LENGTH_SHORT).show();

                        reloadInventoryFromDatabase(); //Reload List
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });


    }
    void reloadInventoryFromDatabase() {
        Cursor cursorproduct1 = mDatabase.rawQuery("SELECT * FROM Student", null);
        if (cursorproduct1.moveToFirst()) {
            productList.clear();
            do {
                productList.add(new Product(
                        cursorproduct1.getInt(0),
                        cursorproduct1.getString(1),
                        cursorproduct1.getString(2),
                        cursorproduct1.getString(3)));
            } while (cursorproduct1.moveToNext());
        }
        cursorproduct1.close();
        notifyDataSetChanged();
    }
    private void updateInventory(final Product product) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(mCtx);

        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.dialog_update_inventory, null);
        builder.setView(view);


        final EditText editTextName = view.findViewById(R.id.editTextItemName);
        final EditText  edittextevent = view.findViewById(R.id.editEvent);
        final EditText edittextdaily= view.findViewById(R.id.editdaily);




        editTextName.setText(product.getItemname());
        edittextevent.setText(product.getEventdetail());
        edittextdaily.setText(product.getDailyweight());

        final AlertDialog dialog = builder.create();
        dialog.show();

        // CREATE METHOD FOR EDIT THE FORM
        view.findViewById(R.id.buttonUpdateInventory).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String itemname = editTextName.getText().toString().trim();
                String eventdetail = edittextevent.getText().toString().trim();
                String dailyweight = edittextdaily.getText().toString().trim();



                if (itemname.isEmpty()) {
                    editTextName.setError("Name can't be blank");
                    editTextName.requestFocus();
                    return;
                }

                if (eventdetail.isEmpty()) {
                    edittextevent.setError("Event can't be blank");
                    edittextevent.requestFocus();
                    return;
                }//ItemName, EventDetail, DailyWeight

                String sql = "UPDATE Student \n" +
                        "SET ItemName = ?, \n" +
                        "EventDetail = ?,\n"+
                        "DailyWeight = ?\n"+
                        "WHERE id = ?;\n";

                mDatabase.execSQL(sql, new String[]{itemname, eventdetail, dailyweight, String.valueOf(product.getId())});
                Toast.makeText(mCtx, "Student Updated", Toast.LENGTH_SHORT).show();

                dialog.dismiss();
            }
        });
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }


    class ProductViewHolder extends RecyclerView.ViewHolder {

        TextView textViewItemName, textVieweventdetail, textViewdailyweight;
        ImageView editbtn, deletebtn;

        public ProductViewHolder(View itemView) {
            super(itemView);

            textViewItemName = itemView.findViewById(R.id.textViewitemName);
            textVieweventdetail = itemView.findViewById(R.id.textViewevent);
            textViewdailyweight = itemView.findViewById(R.id.textViewdaily);


            deletebtn = itemView.findViewById(R.id.buttonDeleteStudent);
            editbtn = itemView.findViewById(R.id.buttonEditstudent);
        }
    }
}
