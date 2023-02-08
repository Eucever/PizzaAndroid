package com.example.projetpizzeria;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;


import static java.lang.Integer.parseInt;


public class MainActivity extends AppCompatActivity {
    public TextView txtTable;
    public String numtable;
    public Fragment frag;

    public final static String CLE_NAPOLIT = "CLE_NAPOLIT";
    public final static String CLE_ROYA = "CLE_ROYA";
    public final static String CLE_4FROMA = "CLE_4FROMA";
    public final static String CLE_TIRAM = "CLE_TIRAM";
    public final static String CLE_PANNA = "CLE_PANNA";
    public final static String CLE_MONTAG = "CLE_MONTAG";
    public final static String CLE_HAWAI = "CLE_HAWAI";
    public final static String CLE_RACLET = "CLE_RACLET";
    public final static String CLE_PERSO = "CLE_PERSO";

    public final static String CLE_NAPOLIT_INT = "CLE_NAPOLIT_INT";
    public final static String CLE_ROYA_INT = "CLE_ROYA_INT";
    public final static String CLE_4FROMA_INT = "CLE_4FROMA_INT";
    public final static String CLE_TIRAM_INT = "CLE_TIRAM_INT";
    public final static String CLE_PANNA_INT = "CLE_PANNA_INT";
    public final static String CLE_MONTAG_INT = "CLE_MONTAG_INT";
    public final static String CLE_HAWAI_INT = "CLE_HAWAI_INT";
    public final static String CLE_RACLET_INT = "CLE_RACLET_INT";
    public final static String CLE_PERSO_INT = "CLE_PERSO_INT";


    public String txtNap="Napolitaine";
    public String txtRoya="Royale";
    public String txt4Fro="Quatre Fromage";
    public String txtTira="Tiramisu";
    public String txtPann="Panna Cota";
    public String txtMont="Montagnard";
    public String txtHawa="Hawaï";
    public String txtRacl="Raclette";
    public String txtPerso="Pizza Personnalisé";

    public int nbNapolit=0;
    public int nbRoya=0;
    public int nb4Fro=0;
    public int nbTira=0;
    public int nbPann=0;
    public int nbMont=0;
    public int nbHawa=0;
    public int nbRacl=0;
    public int nbperso=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtTable = findViewById(R.id.texttable);
        frag = new FragmentMenu();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.add(R.id.fragment, frag);
        transaction.commit();

        if (savedInstanceState != null) {
            frag = getFragmentManager().findFragmentById(R.id.fragment);
            transaction = getFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment, frag);
            transaction.commit();

            nbNapolit = savedInstanceState.getInt(CLE_NAPOLIT_INT);
            nbRoya = savedInstanceState.getInt(CLE_ROYA_INT);
            nb4Fro = savedInstanceState.getInt(CLE_4FROMA_INT);
            nbTira = savedInstanceState.getInt(CLE_TIRAM_INT);
            nbPann = savedInstanceState.getInt(CLE_PANNA_INT);
            nbMont = savedInstanceState.getInt(CLE_MONTAG_INT);
            nbHawa = savedInstanceState.getInt(CLE_HAWAI_INT);
            nbRacl = savedInstanceState.getInt(CLE_RACLET_INT);
            nbperso = savedInstanceState.getInt(CLE_PERSO_INT);

            txtNap = savedInstanceState.getString(CLE_NAPOLIT);
            txtRoya = savedInstanceState.getString(CLE_ROYA);
            txt4Fro = savedInstanceState.getString(CLE_4FROMA);
            txtTira = savedInstanceState.getString(CLE_TIRAM);
            txtPann = savedInstanceState.getString(CLE_PANNA);
            txtMont = savedInstanceState.getString(CLE_MONTAG);
            txtHawa = savedInstanceState.getString(CLE_HAWAI);
            txtRacl = savedInstanceState.getString(CLE_RACLET);
            txtPerso = savedInstanceState.getString(CLE_PERSO);
        }

        Intent intent = getIntent();
        numtable = intent.getStringExtra(ChoixTable.CLE_DONNEES);
        if(parseInt(numtable)<9){
            numtable="0"+numtable;
        }else if(parseInt(numtable)>99){
            numtable="99";
        }
        txtTable.setText("Commande de la table n°"+ numtable);
        Log.i("On Create","On Create : Main");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("On Stop","On stop : Main");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("On Start","On Start : Main");
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(CLE_NAPOLIT, txtNap);
        outState.putString(CLE_ROYA, txtRoya);
        outState.putString(CLE_4FROMA, txt4Fro);
        outState.putString(CLE_TIRAM, txtTira);
        outState.putString(CLE_PANNA, txtPann);
        outState.putString(CLE_MONTAG, txtMont);
        outState.putString(CLE_HAWAI, txtHawa);
        outState.putString(CLE_RACLET, txtRacl);
        outState.putString(CLE_PERSO, txtPerso);

        outState.putInt(CLE_NAPOLIT_INT, nbNapolit);
        outState.putInt(CLE_HAWAI_INT, nbHawa);
        outState.putInt(CLE_ROYA_INT, nbRoya);
        outState.putInt(CLE_4FROMA_INT, nb4Fro);
        outState.putInt(CLE_TIRAM_INT, nbTira);
        outState.putInt(CLE_PANNA_INT, nbPann);
        outState.putInt(CLE_MONTAG_INT, nbMont);
        outState.putInt(CLE_RACLET_INT, nbRacl);
        outState.putInt(CLE_PERSO_INT, nbperso);
    }




}