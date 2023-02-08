package com.example.projetpizzeria;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;

import android.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class pizza_perso extends Fragment {
    public final static String CLE_DONNEES = "CLE_DONNEES";
    public String numpizza;
    public String ingredients="";
    public MainActivity mact;
    public Button btn_valid;

    public pizza_perso() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_pizza_perso, container, false);
        mact = (MainActivity) getActivity();
        ingredients=(String.valueOf(mact.numtable));
        btn_valid= v.findViewById(R.id.buttonValid);

        btn_valid.setOnClickListener(this::onClick);

        return v;
    }

    private void onClick(View v) {
        FragmentMenu.ChoixCommande command = new FragmentMenu.ChoixCommande();
        if(v.getId()==R.id.buttonValid){
            command.execute(ingredients);
            mact.nbperso++;
            mact.txtPerso="Pizza Personnalisé : "+ mact.nbperso;
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment, mact.frag);
            transaction.commit();

        }
        if(v.getId()==R.id.buttonJambCuit){
            ingredients=(ingredients+" + jamboncuit");
        }
        if(v.getId()==R.id.buttonJambCru){
            ingredients=(ingredients+" + jamboncru");
        }
        if(v.getId()==R.id.buttonMozza){
            ingredients=(ingredients+" + mozzarella");
        }
        if(v.getId()==R.id.buttonArtich){
            ingredients=(ingredients+" + artichauts");
        }
        if(v.getId()==R.id.buttonAnch){
            ingredients=(ingredients+" + anchois");
        }
        if(v.getId()==R.id.buttonOliv){
            ingredients=(ingredients+" + olives");
        }
        if(v.getId()==R.id.buttonCapr){
            ingredients=(ingredients+" + capres");
        }
        if(v.getId()==R.id.buttonGorg){
            ingredients=(ingredients+" + gorgonzola");
        }



    }
}