package com.example.a1420779.projetfinal;

import android.content.Intent;
import android.media.ImageWriter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private Button listeBrasseries;
    private Button listeBieres;
    private Button ajouterBiere;
    private ImageView vueMicrobrasserie;
    private Ecouteur ec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listeBrasseries = (Button) findViewById(R.id.button);
        listeBieres = (Button) findViewById(R.id.button2);
        ajouterBiere = (Button) findViewById(R.id.button3);
        vueMicrobrasserie = (ImageView) findViewById(R.id.imageView);
        vueMicrobrasserie.setImageResource(R.drawable.microbrasseriesquebec);


        ec = new Ecouteur();
        listeBrasseries.setOnClickListener(ec);
        listeBieres.setOnClickListener(ec);
        ajouterBiere.setOnClickListener(ec);
    }

    class Ecouteur implements Button.OnClickListener{

        @Override
        public void onClick(View v) {
            if(v.getId() == R.id.button)
            {
                Intent i = new Intent(MainActivity.this, ListeMicrobrasserieActivity.class);
                startActivity(i);
            }

        }
    }
}
