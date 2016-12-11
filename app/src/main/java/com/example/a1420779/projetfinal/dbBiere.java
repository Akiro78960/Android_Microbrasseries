package com.example.a1420779.projetfinal;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by 1420779 on 2016-12-08.
 */
public class DBBiere extends SQLiteOpenHelper {

    public DBBiere(Context context){
        super(context, "DB", null, 1);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {//TODO : finish
        db.execSQL("CREATE TABLE biere(" +
                "id INTEGER primary key autoincrement," +
                "nom STRING," +
                "microbrasserie STRING," +
                "type STRING," +
                "commentaire STRING," +
                "pourcentageAlcool FLOAT," +
                "note FLOAT);"
        );

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void ajouterBiere(Biere b, SQLiteDatabase db){
        ContentValues cv = new ContentValues();
        cv.put("nom", b.getNom());
        cv.put("microbrasserie", b.getMicrobrasserie());
        cv.put("type", b.getType());
        cv.put("commentaire", b.getCommentaire());
        cv.put("pourcentageAlcool", b.getPourcentageAlcool());
        cv.put("note", b.getNote());
        db.insert("biere", null, cv);
    }
}
