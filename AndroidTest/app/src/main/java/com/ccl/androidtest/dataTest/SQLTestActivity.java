package com.ccl.androidtest.dataTest;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ccl.androidtest.R;
import com.ccl.androidtest.util.BaseActivity;

/**
 * Created by CCL on 2016/12/8.
 */

public class SQLTestActivity extends BaseActivity {

    private MyDataBaseHelper dbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqltest);
        dbHelper = new MyDataBaseHelper(this, "BookStore.db", null, 2);
        Button createDataBase = (Button) findViewById(R.id.create_database);
        createDataBase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelper.getWritableDatabase();
            }
        });

        Button addData = (Button) findViewById(R.id.add_data);
        addData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.beginTransaction();
                try {
                    ContentValues values = new ContentValues();

                    values.put("name", "The Da Vinci Code");
                    values.put("author", "Dan Brown");
                    values.put("pages", 454);
                    values.put("price", 19.96);
                    db.insert("Book", null, values);

                    values.put("name", "The Da Lost Symbol");
                    values.put("author", "Dan Brown");
                    values.put("pages", 510);
                    values.put("price", 19.95);
                    db.insert("Book", null, values);
                    db.setTransactionSuccessful();
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    db.endTransaction();
                }

            }
        });

        Button updateButton = (Button) findViewById(R.id.update_data);

        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.beginTransaction();
                try {
                    ContentValues values = new ContentValues();
                    values.put("price", 10.99);
                    db.update("Book", values, "name=?", new String[]{"The DaVinic Code"});
                    db.setTransactionSuccessful();
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    db.endTransaction();
                }
            }
        });


        Button deleteButton = (Button) findViewById(R.id.delete_data);

        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.beginTransaction();
                try {
                    db.delete("Book", "pages > ?", new String[]{"500"});
                    db.setTransactionSuccessful();
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    db.endTransaction();
                }
            }
        });

        Button queryButton = (Button) findViewById(R.id.query_data);
        queryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.beginTransaction();
                try {
                    Cursor cursor = db.query("Book", null, null, null, null, null, null);
                    if (cursor.moveToFirst()) {
                        do {
                            String name = cursor.getString(cursor.getColumnIndex("name"));
                            String author = cursor.getString(cursor.getColumnIndex("author"));
                            int pages = cursor.getInt(cursor.getColumnIndex("pages"));
                            double price = cursor.getDouble(cursor.getColumnIndex("price"));
                        } while (cursor.moveToNext());
                    }
                    cursor.close();
                    db.setTransactionSuccessful();
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    db.endTransaction();
                }
            }
        });


    }

    public static void actionStart(Context context) {
        Intent itent = new Intent(context, SQLTestActivity.class);
        context.startActivity(itent);
    }
}
