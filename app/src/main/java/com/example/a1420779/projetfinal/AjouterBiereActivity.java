package com.example.a1420779.projetfinal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class AjouterBiereActivity extends AppCompatActivity {

    private Spinner sNomMicrobrasserie;
    private EditText nomBiere;
    private EditText type;
    private Spinner spourcentageAlcool;
    private EditText commentaire;
    private TextView lblNote;
    private RatingBar rbNote;
    private Button btnQuitter;
    private Button btnSauvegarder;
    private DBOperations dbo;
    private String nomMicrobrasserie;
    private TextView lblPourcentageAlcool;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ////////////INIT////////////
        setContentView(R.layout.activity_ajouter_biere);
        sNomMicrobrasserie = (Spinner)findViewById(R.id.spinner);
        nomBiere = (EditText) findViewById(R.id.editText);
        type = (EditText) findViewById(R.id.editText2);
        spourcentageAlcool = (Spinner) findViewById(R.id.spinner2);
        commentaire = (EditText) findViewById(R.id.editText3);
        lblNote = (TextView) findViewById(R.id.textView9);
        rbNote = (RatingBar) findViewById(R.id.ratingBar);
        btnQuitter = (Button) findViewById(R.id.button8);
        btnSauvegarder = (Button) findViewById(R.id.button9);
        nomMicrobrasserie = getIntent().getExtras().getString("nomMicrobrasserie");
        lblPourcentageAlcool = (TextView) findViewById(R.id.textView10);
        dbo = new DBOperations(this);

        ///////REMPLIR CHAMPS//////////
        fillListeMicrobrasserie();
        nomBiere.setHint("Nom");
        type.setHint("Type");
        lblPourcentageAlcool.setText("Pourcentage d'Alcool : ");
        lblPourcentageAlcool.setClickable(false);
        fillListePourcentageAlcool();
        commentaire.setHint("Commentaire");
        lblNote.setText("Votre Note :");
        btnQuitter.setText("Quitter");
        btnSauvegarder.setText("Sauvegarder");
        btnQuitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    btnSauvegarder.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            dbo.ouvrirBDBiere();
            dbo.getDbBiere().ajouterBiere(new Biere(nomBiere.getText().toString(), sNomMicrobrasserie.getSelectedItem().toString(), type.getText().toString(), commentaire.getText().toString(), Float.parseFloat(spourcentageAlcool.getSelectedItem().toString()), rbNote.getNumStars()), dbo.getDb());
            dbo.fermerBDBiere();
            Toast.makeText(getApplicationContext(),"Biere Enregistrée", Toast.LENGTH_SHORT).show();
            finish();
        }
    });

    }

    protected void fillListePourcentageAlcool(){
        List<String> listePourcentages = new ArrayList<String>();

        for (float i=0; i<=70; i+=0.5){
            listePourcentages.add(""+i);
        }
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, listePourcentages);
        spourcentageAlcool.setAdapter(dataAdapter);

    }

    protected void fillListeMicrobrasserie(){
        dbo.ouvrirBDmicrobrasserie();
        List<String> listeMicrobrasserie = new ArrayList<String>();
        if(nomMicrobrasserie.equals("")){
            Vector<String> v = dbo.listeMicrobrasserie();
            for(int i=0; i<v.size(); i++){
                listeMicrobrasserie.add(v.get(i));
            }
            sNomMicrobrasserie.setClickable(true);
        }
        else{
            listeMicrobrasserie.add(nomMicrobrasserie);
            sNomMicrobrasserie.setClickable(false);
        }
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, listeMicrobrasserie);
        sNomMicrobrasserie.setAdapter(dataAdapter);
    }
}
