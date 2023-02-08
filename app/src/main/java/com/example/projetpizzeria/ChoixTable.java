package com.example.projetpizzeria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class ChoixTable extends AppCompatActivity {
    public final static String CLE_DONNEES = "CLE_DONNEES";
    private Button button_valider;
    private EditText textediter;

    public String numTable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choix_table);

        button_valider = findViewById(R.id.button_valider);
        textediter = findViewById(R.id.editTextChoix);

        button_valider.setOnClickListener(this::onClick);
        Log.i("On Create","On Create : Choix");
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.i("On Stop","On stop : Choix");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("On Start","On Start : Choix");
    }

    private void onClick(View v) {
        numTable = String.valueOf(textediter.getText());
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(CLE_DONNEES, numTable);
        startActivity(intent);

    }
}