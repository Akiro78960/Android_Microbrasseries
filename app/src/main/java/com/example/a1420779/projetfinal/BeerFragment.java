package com.example.a1420779.projetfinal;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.media.RatingCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;

public class BeerFragment extends Fragment {

    private TextView nomMicrobrasserie;
    private EditText nomBiere;
    private EditText typeBiere;
    private TextView lblPourcentageAlcool;
    private TextView pourcentageAlcool;
    private EditText commentaire;
    private TextView lblNote;
    private RatingBar rbNote;

    public BeerFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        /////////////INIT/////////////////
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment_beer, container, false);
        nomMicrobrasserie = (TextView) rootView.findViewById(R.id.textView6F);
        nomBiere = (EditText) rootView.findViewById(R.id.editTextF);
        typeBiere = (EditText) rootView.findViewById(R.id.editText2F);
        lblPourcentageAlcool = (TextView) rootView.findViewById(R.id.textView10F);
        pourcentageAlcool = (TextView) rootView.findViewById(R.id.textView7F);
        commentaire = (EditText) rootView.findViewById(R.id.editText3F);
        lblNote = (TextView) rootView.findViewById(R.id.textView9F);
        rbNote = (RatingBar) rootView.findViewById(R.id.ratingBarF);

        /////////////////CONFIG///////////////
        nomMicrobrasserie.setClickable(false);
        nomBiere.setClickable(false);
        typeBiere.setClickable(false);
        lblPourcentageAlcool.setClickable(false);
        pourcentageAlcool.setClickable(false);
        commentaire.setClickable(false);
        lblNote.setClickable(false);
        rbNote.setClickable(false);

        //////////////////FILL//////////////////
        nomMicrobrasserie.setText((String)this.getArguments().get("nomMicrobrasserie"));
        nomBiere.setText((String)this.getArguments().get("nom"));
        typeBiere.setText((String)this.getArguments().get("type"));
        lblPourcentageAlcool.setText("Pourcentage d'Alcool : ");
        pourcentageAlcool.setText(""+this.getArguments().get("pourcentageAlcool"));
        commentaire.setText((String)this.getArguments().get("commentaire"));
        lblNote.setText("Votre Note :");
        rbNote.setRating((float)this.getArguments().get("note"));

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_beer, container, false);
    }

    public static BeerFragment newInstance(String nom, String nomMicrobrasserie, String type, String commentaire, float pourcentageAlcool, float note){
        BeerFragment fragment = new BeerFragment();
        Bundle args = new Bundle();
        args.putString("nom", nom);
        args.putString("nomMicrobrasserie", nomMicrobrasserie);
        args.putString("type", type);
        args.putString("commentaire", commentaire);
        args.putFloat("pourcentageAlcool", pourcentageAlcool);
        args.putFloat("note", note);
        fragment.setArguments(args);
        return fragment;
    }

}
