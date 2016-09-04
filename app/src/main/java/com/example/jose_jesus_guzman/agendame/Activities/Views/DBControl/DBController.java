package com.example.jose_jesus_guzman.agendame.Activities.Views.DBControl;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by jesus on 4/09/16.
 */
public class DBController {

    DBHelper dbHelper;
    private Context context;
    private SQLiteDatabase db;

    public DBController(Context context) {
        this.context = context;
    }

    public DBController open() {
        dbHelper = new DBHelper(context);
        db = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        dbHelper.close();
    }



}
