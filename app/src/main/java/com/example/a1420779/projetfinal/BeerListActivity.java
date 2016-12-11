package com.example.a1420779.projetfinal;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;

import java.util.HashMap;
import java.util.Vector;

public class BeerListActivity extends FragmentActivity {
    private ViewPager viewpager;
    private SwipeAdapter adaptateur;
    private DBOperations dbo;
    private Vector<HashMap> v;
    private int taille;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beer_list);
        dbo = new DBOperations(this);
        v = dbo.fillBeer();
        taille = v.size();
        viewpager = (ViewPager) findViewById(R.id.pager);
        adaptateur = new SwipeAdapter(getSupportFragmentManager());
        viewpager.setAdapter(adaptateur);
    }

    public class SwipeAdapter extends FragmentStatePagerAdapter {

        public SwipeAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            //changements d'un fragment à l'autre, j'utilise la méthode générée par CouleurFragment

            return BeerFragment.newInstance((String)v.elementAt(i).get("Nom"), (String)v.elementAt(i).get("Microbrasserie"), (String)v.elementAt(i).get("Type"), (String)v.elementAt(i).get("Commentaire"), (float)v.elementAt(i).get("PourcentageAlcool"), (float)v.elementAt(i).get("note")); //méthode générée quand je crée un fichier Fragment


        }

        @Override
        public int getCount() {
            return taille;
        }
    }
}
