package com.example.projetpizzeria;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class FragmentMenu extends Fragment {
    private Button button_Nap, button_Roy,button_4Fro,button_Tira,button_Pann,button_Mont,button_Hawa,button_Racl, button_reset, buttonPizzaperso;
    public static MainActivity mact;
    public String nompizza;

    public void onClick(View v){
        Log.i("message",String.valueOf(v.getId()));
        ChoixCommande command;
        if (v.getId()==R.id.button_Perso){
            pizza_perso frag= new pizza_perso();
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment, frag);
            transaction.commit();
        }


        if (v.getId()== R.id.button_Nap){
            mact.nbNapolit++;
            button_Nap.setText("Napolitaine : "+mact.nbNapolit);
            mact.txtNap = String.valueOf(button_Nap.getText());
            command = new FragmentMenu.ChoixCommande();
            command.execute(mact.numtable+"Napolitaine");
            nompizza="Napolitaine";

        }
        if (v.getId()==  R.id.button_Hawa){
            mact.nbHawa++;
            button_Hawa.setText("Hawai : "+mact.nbHawa);
            mact.txtHawa = (String) button_Hawa.getText();
            command = new FragmentMenu.ChoixCommande();
            command.execute(mact.numtable+"Hawaienne");
            nompizza="Hawaienne";
        }
        if (v.getId()==  R.id.button_Roy){
            mact.nbRoya++;
            button_Roy.setText("Royale : "+mact.nbRoya);
            mact.txtRoya = (String) button_Roy.getText();
            command = new FragmentMenu.ChoixCommande();
            command.execute(mact.numtable+"Royale");
            nompizza="Royale";
        }
        if (v.getId()==  R.id.button_4Fro){
            mact.nb4Fro++;
            button_4Fro.setText("Quatres Fromage : "+mact.nb4Fro);
            mact.txt4Fro = (String) button_4Fro.getText();
            command = new FragmentMenu.ChoixCommande();
            command.execute(mact.numtable+"Quatres Fromage");
            nompizza="Quatres Fromage";
        }
        if (v.getId()==  R.id.button_Tira){
            mact.nbTira++;
            button_Tira.setText("Tiramisu : "+mact.nbTira);
            mact.txtTira = (String) button_Tira.getText();
            command = new FragmentMenu.ChoixCommande();
            command.execute(mact.numtable+"Tiramisu");
            nompizza="Tiramisu";
        }
        if (v.getId()==  R.id.button_Pann){
            mact.nbPann++;
            button_Pann.setText("Panna Cota : "+mact.nbPann);
            mact.txtPann = (String) button_Pann.getText();
            command = new FragmentMenu.ChoixCommande();
            command.execute(mact.numtable+"Panna Cota");
            nompizza="Panna Cota";
        }
        if (v.getId()==  R.id.button_Mont){
            mact.nbMont++;
            button_Mont.setText("Montagnard : "+mact.nbMont);
            mact.txtMont = (String) button_Mont.getText();
            command = new FragmentMenu.ChoixCommande();
            command.execute(mact.numtable+"Montagnarde");
            nompizza="Montagnarde";
        }
        if (v.getId()==  R.id.button_Racl){
            mact.nbRacl++;
            button_Racl.setText("Raclettes : "+mact.nbRacl);
            mact.txtRacl = (String) button_Racl.getText();
            command = new FragmentMenu.ChoixCommande();
            command.execute(mact.numtable+"Raclettes");
            nompizza="Raclettes";
        }
        if (v.getId()==  R.id.button_reset){
            mact.nbNapolit =0;
            mact.nbHawa =0;
            mact.nbRoya =0;
            mact.nb4Fro =0;
            mact.nbTira =0;
            mact.nbPann =0;
            mact.nbMont =0;
            mact.nbRacl =0;

            mact.txtNap="Napolitaine";
            mact.txtRoya="Royale";
            mact.txt4Fro="Quatre Fromage";
            mact.txtTira="Tiramisu";
            mact.txtPann="Panna Cota";
            mact.txtMont="Montagnard";
            mact.txtHawa="Hawaï";
            mact.txtRacl="Raclette";

            button_Nap.setText(mact.txtNap);
            button_Hawa.setText(mact.txtHawa);
            button_Roy.setText(mact.txtRoya);
            button_4Fro.setText(mact.txt4Fro);
            button_Tira.setText(mact.txtTira);
            button_Pann.setText(mact.txtPann);
            button_Mont.setText(mact.txtMont);
            button_Racl.setText(mact.txtRacl);

            button_reset.setText(getString(R.string.Reinitialiser));

        }
    }


    public FragmentMenu() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

            View v = inflater.inflate(R.layout.fragment_menu, container, false);
        mact = (MainActivity) getActivity();

        button_Nap= v.findViewById(R.id.button_Nap);
        button_Roy= v.findViewById(R.id.button_Roy);
        button_4Fro= v.findViewById(R.id.button_4Fro);
        button_Tira= v.findViewById(R.id.button_Tira);
        button_Pann= v.findViewById(R.id.button_Pann);
        button_Mont= v.findViewById(R.id.button_Mont);
        button_Hawa= v.findViewById(R.id.button_Hawa);
        button_Racl= v.findViewById(R.id.button_Racl);
        button_reset= v.findViewById(R.id.button_reset);
        buttonPizzaperso=v.findViewById(R.id.button_Perso);

        button_Nap.setOnClickListener(this::onClick);
        button_Hawa.setOnClickListener(this::onClick);
        button_Roy.setOnClickListener(this::onClick);
        button_4Fro.setOnClickListener(this::onClick);
        button_Tira.setOnClickListener(this::onClick);
        button_Pann.setOnClickListener(this::onClick);
        button_Mont.setOnClickListener(this::onClick);
        button_Racl.setOnClickListener(this::onClick);
        button_reset.setOnClickListener(this::onClick);
        buttonPizzaperso.setOnClickListener(this::onClick);

        button_Nap.setText(mact.txtNap);
        button_Hawa.setText(mact.txtHawa);
        button_Roy.setText(mact.txtRoya);
        button_4Fro.setText(mact.txt4Fro);
        button_Tira.setText(mact.txtTira);
        button_Pann.setText(mact.txtPann);
        button_Mont.setText(mact.txtMont);
        button_Racl.setText(mact.txtRacl);
        buttonPizzaperso.setText(mact.txtPerso);
        if(savedInstanceState!= null){
            mact.txtPerso = savedInstanceState.getString(mact.CLE_PERSO);
        }
        // Inflate the layout for this fragment
        button_reset.setText(getString(R.string.Reinitialiser));

        return v;
    }

    public static class ChoixCommande extends AsyncTask<String, String, String> {
        Socket socket;
        PrintWriter writer;
        String CommandePrete="";
        String msgServ;
        @Override
        protected String doInBackground(String... strings) {
            try {
                socket = new Socket("chadok.info", 9874);
                writer = new PrintWriter(socket.getOutputStream(), true);
                writer.println(strings[0]);
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                msgServ=reader.readLine();
                mact.txtTable.setText(msgServ);
                while(CommandePrete.equals("")){
                    CommandePrete=reader.readLine();
                }
                mact.txtTable.setText(CommandePrete);
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}