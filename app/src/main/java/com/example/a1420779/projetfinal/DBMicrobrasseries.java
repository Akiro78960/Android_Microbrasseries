package com.example.a1420779.projetfinal;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by 1420779 on 2016-11-28.
 */
public class DBMicrobrasseries  extends SQLiteOpenHelper{

    public DBMicrobrasseries(Context context){
        super(context, "DB", null, 1);
    };

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE microbrasserie(" +
                "id INTEGER primary key autoincrement," +
                "nom STRING," +
                "region STRING," +
                "adresse STRING," +
                "website STRING," +
                "idimage INTEGER);"
        );
        ajouterMicrobrasserie(new Microbrasserie("StBock", "Montreal", "1749 Rue Saint-Denis, Montréal, H2X 3K4","http://www.saintbock.com/", R.drawable.stbock), db);
        ajouterMicrobrasserie(new Microbrasserie("Bedondaine & bedons ronds", "Montérégie", "255, rue Ostiguy, Chambly, J3L 2Z7", "http://www.bedondaine.com/accueil/", R.drawable.bedondaine),db);
        ajouterMicrobrasserie(new Microbrasserie("Microbrasserie Pit Caribou", "Gaspésie - Îles-de-la-madeleine", "Anse-à-Beaufils (Percé), G0C 1G0", "http://www.pitcaribou.com/", R.drawable.pitcaribou), db);
        ajouterMicrobrasserie(new Microbrasserie("L'amere a boire", "Montréal", "2049, rue Saint-Denis, Montréal, H2X 3K8", "http://www.amereaboire.com/", R.drawable.img_amereaboire_logo), db);
        ajouterMicrobrasserie(new Microbrasserie("Unibroue", "Montérégie", "80, rue des Carrières, Chambly, J3L 2H6", "http://www.unibroue.com/", R.drawable.unibroue), db);
        ajouterMicrobrasserie(new Microbrasserie("Microbrasserie du Lievre", "Laurentides", "110, boulevard Albany-Paquette, Mont-Laurier, J9L 1J1", "http://www.microdulievre.com/", R.drawable.lievre), db);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void ajouterMicrobrasserie(Microbrasserie m, SQLiteDatabase db){
        ContentValues cv = new ContentValues();
        cv.put("nom", m.getNom());
        cv.put("region", m.getRegion());
        cv.put("adresse", m.getAdresse());
        cv.put("website", m.getWebsite());
        cv.put("idimage", m.getIdImage());
        db.insert("microbrasserie", null, cv);
    }
}
