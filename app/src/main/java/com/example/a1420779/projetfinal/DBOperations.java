package com.example.a1420779.projetfinal;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.HashMap;
import java.util.Vector;

/**
 * Created by 1420779 on 2016-11-28.
 */
public class DBOperations {

    private DBMicrobrasseries dbMicrobrasserie;
    private SQLiteDatabase db;
    private DBBiere dbBiere;

    public DBOperations(Context c){
        dbMicrobrasserie = new DBMicrobrasseries(c);
        dbBiere = new DBBiere(c);

    }

    public Vector<String> listeMicrobrasserie() {
        ouvrirBDmicrobrasserie();
        Vector<String> v = new Vector<String>();
        Cursor c = db.rawQuery("Select nom from microbrasserie", null);
        while(c.moveToNext()) {
            v.add(c.getString(0));
        }
        fermerBDmicrobrasserie();
        return v;
    }

    public Vector<Integer> listeLogoMicrobrasserie() {
        ouvrirBDmicrobrasserie();
        Vector<Integer> v = new Vector<Integer>();
        Cursor c = db.rawQuery("Select idimage from microbrasserie", null);
        while(c.moveToNext()) {
            v.add(c.getInt(0));
        }
        fermerBDmicrobrasserie();
        return v;
    }

    public Vector<String> listeOrigineMicrobrasserie() {
        ouvrirBDmicrobrasserie();
        Vector<String> v = new Vector<String>();
        Cursor c = db.rawQuery("Select region from microbrasserie", null);
        while(c.moveToNext()) {
            v.add(c.getString(0));
        }
        fermerBDmicrobrasserie();
        return v;
    }

    public HashMap<String, Object> fillMicrobrasserie(int id) {
        ouvrirBDmicrobrasserie();
        HashMap<String, Object> hm = new HashMap<>();
        Cursor c = db.rawQuery("Select nom from microbrasserie where id = ?", new String[]{(id+"")});
        while(c.moveToNext()) {
            hm.put("Nom", c.getString(0));
        }
        c = db.rawQuery("Select adresse from microbrasserie where id = ?", new String[]{(id+"")});
        while(c.moveToNext()) {
            hm.put("Adresse", c.getString(0));
        }
        c = db.rawQuery("Select idimage from microbrasserie where id = ?", new String[]{(id+"")});
        while(c.moveToNext()) {
            hm.put("Idimage", c.getInt(0));
        }
        c = db.rawQuery("Select website from microbrasserie where id = ?", new String[]{(id+"")});
        while(c.moveToNext()) {
            hm.put("Website", c.getString(0));
        }
        c = db.rawQuery("Select region from microbrasserie where id = ?", new String[]{(id+"")});
        while(c.moveToNext()) {
            hm.put("Region", c.getString(0));
        }
        fermerBDmicrobrasserie();
        return hm;
    }

    public Vector<HashMap> fillBeer() {
        Vector<HashMap> v = new Vector<HashMap>();
        ouvrirBDBiere();
        int i = 0;
        Cursor c = db.rawQuery("Select nom from biere",null);
        while(c.moveToNext()) {
            v.add(new HashMap());
            v.elementAt(i).put("Nom", c.getString(0));
            i++;
        }
        i=0;
        c = db.rawQuery("Select microbrasserie from biere",null);
        while(c.moveToNext()) {
            v.elementAt(i).put("Microbrasserie", c.getString(0));
            i++;
        }
        i=0;
        c = db.rawQuery("Select type from biere",null);
        while(c.moveToNext()) {
            v.elementAt(i).put("Type", c.getString(0));
            i++;
        }
        i=0;
        c = db.rawQuery("Select commentaire from biere",null);
        while(c.moveToNext()) {
            v.elementAt(i).put("Commentaire", c.getString(0));
            i++;
        }
        i=0;
        c = db.rawQuery("Select pourcentageAlcool from biere",null);
        while(c.moveToNext()) {
            v.elementAt(i).put("PourcentageAlcool", c.getFloat(0));
            i++;
        }
        i=0;
        c = db.rawQuery("Select note from biere",null);
        while(c.moveToNext()) {
            v.elementAt(i).put("Note", c.getString(0));
            i++;
        }
        fermerBDBiere();
        return v;
    }

    public void ouvrirBDmicrobrasserie(){
        db = getDbMicrobrasserie().getWritableDatabase();
    }

    public void fermerBDmicrobrasserie(){
        getDbMicrobrasserie().close();
    }

    public void ouvrirBDBiere(){
        db = getDbBiere().getWritableDatabase();
    }

    public void fermerBDBiere(){
        getDbBiere().close();
    }

    protected DBMicrobrasseries getDbMicrobrasserie() {
        return dbMicrobrasserie;
    }

    protected DBBiere getDbBiere() {
        return dbBiere;
    }

    public SQLiteDatabase getDb() {
        return db;
    }
}
