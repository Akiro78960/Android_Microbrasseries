package com.example.a1420779.projetfinal;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;

public class BeerListActivity extends FragmentActivity {
    private ViewPager viewpager;
    private SwipeAdapter adaptateur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beer_list);
        viewpager = ( ViewPager) findViewById(R.id.pager);
        adaptateur = new SwipeAdapter(getSupportFragmentManager());
        viewpager.setAdapter(adaptateur);
    }

    public class SwipeAdapter extends FragmentStatePagerAdapter {//TODO: FINISH THIS METHODE
        public SwipeAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            //changements d'un fragment à l'autre, j'utilise la méthode générée par CouleurFragment
            int couleur;
            if ( i == 0)
                couleur = Color.YELLOW;

            else if ( i == 1) {
                couleur= Color.RED;
            }
            else
            {
                couleur=Color.GREEN;
            }
            return  BeerFragment.newInstance(couleur); //méthode générée quand je crée un fichier Fragment ( CouleurFragment )


        }

        @Override
        public int getCount() {
            return 0;
        }
    }
