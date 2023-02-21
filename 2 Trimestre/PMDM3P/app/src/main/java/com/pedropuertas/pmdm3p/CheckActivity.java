package com.pedropuertas.pmdm3p;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import java.util.ArrayList;
import java.util.HashMap;

public class CheckActivity extends AppCompatActivity implements View.OnClickListener {

    private Button botonAceptar;
    private Button botonVolver;
    private CheckBox cbReco;
    private ArrayList <String> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check);

        cbReco = findViewById(R.id.cbReco);
        botonAceptar = findViewById(R.id.btnAceptarC);
        botonVolver = findViewById(R.id.btnVolverC);

        botonAceptar.setOnClickListener(this);
        botonVolver.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String check;
        Intent inte;

        if(v.getId() == R.id.btnAceptarC){

            if(cbReco.isChecked()){
                check = "Sí";
            }else{
                check = "No";
            }

            if(getIntent() != null){
                Intent intent = getIntent();
                lista = intent.getStringArrayListExtra("lista");

                if (lista != null){
                    if(lista.get(3) != null){
                        lista.set(3, check);
                    }else{
                        lista.add(3, check);
                    }
                }

            }else{
                lista = new ArrayList<String>();
                lista.add(3, check);
            }

            inte = new Intent(CheckActivity.this, MainActivity.class);
            inte.putStringArrayListExtra("lista", lista);

            startActivity(inte);
        }else{
            inte = new Intent(this, MainActivity.class);
            startActivity(inte);
        }
    }
}