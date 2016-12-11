package com.example.a1420779.projetfinal;

/**
 * Created by 1420779 on 2016-12-10.
 */
public class Biere {

    private String nom;
    private String microbrasserie;
    private String type;
    private String commentaire;
    private Float pourcentageAlcool;
    private float note;


    protected Biere(String nom, String microbrasserie, String type, String commentaire, float pourcentageAlcool, float note){

        this.nom=nom;
        this.microbrasserie=microbrasserie;
        this.type=type;
        this.commentaire=commentaire;
        this.pourcentageAlcool=pourcentageAlcool;
        this.note=note;
    }

    protected String getNom() {
        return nom;
    }

    protected String getMicrobrasserie() {
        return microbrasserie;
    }

    protected String getType() {
        return type;
    }

    protected String getCommentaire() {
        return commentaire;
    }

    protected Float getPourcentageAlcool() {
        return pourcentageAlcool;
    }

    protected float getNote() {
        return note;
    }


}
