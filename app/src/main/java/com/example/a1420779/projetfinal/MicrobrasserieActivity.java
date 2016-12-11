package com.example.a1420779.projetfinal;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MicrobrasserieActivity extends AppCompatActivity {


    ImageView vueLogo;
    TextView txtNomMicrobrasserie;
    TextView txtAdresseMicrobrasserie;
    TextView txtWebSite;
    Button btnMap;
    Button btnBieresEveluees;
    Button btnAjouterBieres;
    Button btnQuitter;
    Microbrasserie microbrasserie;
    DBOperations dbo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_microbrasserie);

        vueLogo =(ImageView) findViewById(R.id.imageView4);
        txtNomMicrobrasserie = (TextView) findViewById(R.id.textView3);
        txtAdresseMicrobrasserie = (TextView) findViewById(R.id.textView4);
        txtWebSite  = (TextView) findViewById(R.id.textView5);
        btnMap = (Button) findViewById(R.id.button4);
        btnBieresEveluees = (Button) findViewById(R.id.button5);
        btnAjouterBieres = (Button) findViewById(R.id.button6);
        btnQuitter = (Button) findViewById(R.id.button7);
        dbo = new DBOperations(this);

        btnMap.setText("Carte");
        btnBieresEveluees.setText("Bières deja évaluées");
        btnAjouterBieres.setText("Ajouter une bière");
        btnQuitter.setText("Quitter");

        int id = this.getIntent().getExtras().getInt("id");
        //System.out.println(dbo.fillMicrobrasserie(id).get("Nom"));
        microbrasserie = new Microbrasserie((String) dbo.fillMicrobrasserie(id).get("Nom"), (String) dbo.fillMicrobrasserie(id).get("Region"),(String) dbo.fillMicrobrasserie(id).get("Adresse"), (String) dbo.fillMicrobrasserie(id).get("Website"), (int) dbo.fillMicrobrasserie(id).get("Idimage"));
        vueLogo.setImageResource(microbrasserie.getIdImage());
        txtNomMicrobrasserie.setText(microbrasserie.getNom());
        txtAdresseMicrobrasserie.setText(microbrasserie.getAdresse());
        txtWebSite.setText(microbrasserie.getWebsite());

        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri gmmIntentUri = Uri.parse("geo:0,0?q=" + microbrasserie.getAdresse());
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });

        btnAjouterBieres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MicrobrasserieActivity.this, AjouterBiereActivity.class);
                i.putExtra("nomMicrobrasserie", microbrasserie.getNom());
                startActivity(i);

            }
        });

    }
}
