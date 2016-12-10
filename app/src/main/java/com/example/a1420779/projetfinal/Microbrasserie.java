package com.example.a1420779.projetfinal;

/**
 * Created by 1420779 on 2016-11-28.
 */
public class Microbrasserie {

    private String nom;
    private String region;
    private String adresse;
    private int idImage;
    private String website;

    public Microbrasserie(String nom, String region, String adresse,String website, int idImage){
        this.setNom(nom);
        this.setRegion(region);
        this.setAdresse(adresse);
        this.setIdImage(idImage);
        this.setWebsite(website);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getIdImage() {
        return idImage;
    }

    public void setIdImage(int idImage) {
        this.idImage = idImage;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}
