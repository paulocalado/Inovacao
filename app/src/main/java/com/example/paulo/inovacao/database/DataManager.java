package com.example.paulo.inovacao.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.paulo.inovacao.database.Script;

/**
 * Created by Paulo on 05/12/2015.
 */
public class DataManager extends SQLiteOpenHelper {

    public DataManager(Context context) {
        super(context, "INOVACAO", null, 1);

    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Script.getCreateDiarista());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
