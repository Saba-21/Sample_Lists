package com.example.giorgi.sample_lists;

import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        final List<City> city = new ArrayList<>();
        TypedArray icons = getResources().obtainTypedArray(R.array.headimg);
        String[] txts = getResources().getStringArray(R.array.headname);
        for (int n = 0; n < txts.length; n++)
            city.add(new City(icons.getResourceId(n, 0), txts[n]));

        final List<Card> london = new ArrayList<>();
        TypedArray cardimgs = getResources().obtainTypedArray(R.array.londonimg);
        String[] cardtxts = getResources().getStringArray(R.array.londontxt);
        for (int n = 0; n < cardtxts.length; n++)
            london.add(new Card(cardimgs.getResourceId(n, 0), "London sights", cardtxts[n]));

        final List<Card> paris = new ArrayList<>();
        cardimgs = getResources().obtainTypedArray(R.array.parisimg);
        cardtxts = getResources().getStringArray(R.array.paristxt);
        for (int n = 0; n < cardtxts.length; n++)
            paris.add(new Card(cardimgs.getResourceId(n, 0), "Paris sights", cardtxts[n]));

        final List<Card> rome = new ArrayList<>();
        cardimgs = getResources().obtainTypedArray(R.array.romeimg);
        cardtxts = getResources().getStringArray(R.array.rometxt);
        for (int n = 0; n < cardtxts.length; n++)
            rome.add(new Card(cardimgs.getResourceId(n, 0), "Rome sights", cardtxts[n]));

        final List<Card> athens = new ArrayList<>();
        cardimgs = getResources().obtainTypedArray(R.array.athensimg);
        cardtxts = getResources().getStringArray(R.array.athenstxt);
        for (int n = 0; n < cardtxts.length; n++)
            athens.add(new Card(cardimgs.getResourceId(n, 0), "Athens sights", cardtxts[n]));

        final List<Card> berlin = new ArrayList<>();
        cardimgs = getResources().obtainTypedArray(R.array.berlinimg);
        cardtxts = getResources().getStringArray(R.array.berlintxt);
        for (int n = 0; n < cardtxts.length; n++)
            berlin.add(new Card(cardimgs.getResourceId(n, 0), "Berlin sights", cardtxts[n]));

        final List<Card> prague = new ArrayList<>();
        cardimgs = getResources().obtainTypedArray(R.array.pragueimg);
        cardtxts = getResources().getStringArray(R.array.praguetxt);
        for (int n = 0; n < cardtxts.length; n++)
            prague.add(new Card(cardimgs.getResourceId(n, 0), "Prague sights", cardtxts[n]));

        final List<Card> amsterdam = new ArrayList<>();
        cardimgs = getResources().obtainTypedArray(R.array.amsterdamimg);
        cardtxts = getResources().getStringArray(R.array.amsterdamtxt);
        for (int n = 0; n < cardtxts.length; n++)
            amsterdam.add(new Card(cardimgs.getResourceId(n, 0), "Amsterdam sights", cardtxts[n]));



        RecyclerView rv = (RecyclerView) findViewById(R.id.recV);
        rv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        RVhead ad = new RVhead(city);
        rv.setAdapter(ad);

        ad.setClick(new OnClickListener() {
            List<Card>card;
            @Override
            public void onClick(int p) {

                switch (p){
                    case 0:card=london;
                        break;
                    case 1:card=paris;
                        break;
                    case 2:card=rome;
                        break;
                    case 3:card=athens;
                        break;
                    case 4:card=berlin;
                        break;
                    case 5:card=prague;
                        break;
                    case 6:card=amsterdam;
                        break;
                }

                RecyclerView rvv = (RecyclerView) findViewById(R.id.recVV);
                rvv.setLayoutManager(new LinearLayoutManager(Main.this));
                RVbody ada = new RVbody(card);
                rvv.setAdapter(ada);
                ada.setClick(new OnClickListener() {
                    @Override
                    public void onClick(int p) {
                        Toast.makeText(Main.this, "body", Toast.LENGTH_SHORT).show();

                    }
                });
            }
        });
    }
}