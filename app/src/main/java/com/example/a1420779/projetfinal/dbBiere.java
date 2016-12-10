package com.example.a1420779.projetfinal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by 1420779 on 2016-12-08.
 */
public class dbBiere extends SQLiteOpenHelper {

    public dbBiere(Context context){
        super(context, "DB", null, 1);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {//TODO : finish


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
