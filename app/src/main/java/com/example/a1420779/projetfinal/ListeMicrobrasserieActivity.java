package com.example.a1420779.projetfinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

public class ListeMicrobrasserieActivity extends AppCompatActivity {

    ListView liste;
    DBOperations dbo = new DBOperations(this);
    List<HashMap<String, ?>> fillMaps = new ArrayList<HashMap<String, ?>>();
    HashMap<String, String> map;
    String[] from = {"image", "nom", "region"};
    int[] to = {R.id.imageView3, R.id.textView, R.id.textView2};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_microbrasserie);
        liste = (ListView) findViewById(R.id.listView);
        fillList();
        SimpleAdapter sa = new SimpleAdapter(this, fillMaps, R.layout.listlayout, from, to);
        liste.setAdapter(sa);
        liste.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(ListeMicrobrasserieActivity.this, MicrobrasserieActivity.class);
                i.putExtra("id", position+1);
                startActivity(i);
            }
        });

    }

    protected void fillList(){
        dbo.ouvrirBDmicrobrasserie();
        Vector<Integer> vImages = dbo.listeLogoMicrobrasserie();
        Vector<String> vNom = dbo.listeMicrobrasserie();
        Vector<String> vRegion = dbo.listeOrigineMicrobrasserie();
        dbo.fermerBDmicrobrasserie();
        for(int i=0; i<vImages.size(); i++){
            map = new HashMap<String, String>();
            map.put("image", vImages.get(i)+"");
            map.put("nom", vNom.get(i));
            map.put("region", vRegion.get(i));
            fillMaps.add(map);
        }
    }


}
