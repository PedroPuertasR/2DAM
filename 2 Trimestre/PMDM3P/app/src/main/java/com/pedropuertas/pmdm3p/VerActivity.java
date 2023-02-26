package com.pedropuertas.pmdm3p;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class VerActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnVolver;
    private TextView tvNombre;
    private TextView tvEmail;
    private TextView tvFecha;
    private TextView tvReco;
    private TextView tvProgress;
    private TextView tvRadio;
    private TextView tvSwitch;
    private ArrayList <String> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver);

        String nombre = "";
        String fecha = "";
        String email = "";
        String reco = "";
        String progress = "";
        String radio = "";
        String spinner = "";

        if(getIntent() != null){
            Intent intent = getIntent();
            lista = intent.getStringArrayListExtra("lista");

            if(lista == null){
                System.out.println("La lista está vacía.");
            }else{
                if (lista.get(0) != ""){
                    nombre = lista.get(0);
                }

                if (lista.get(1) != ""){
                    fecha = lista.get(1);
                }

                if (lista.get(2) != ""){
                    email = lista.get(2);
                }

                if(lista.get(3) != ""){
                    reco = lista.get(3);
                }

                if(lista.get(4) != ""){
                    progress = lista.get(4);
                }

                if(lista.get(5) != ""){
                    radio = lista.get(5);
                }

                if(lista.get(6) != ""){
                    spinner = lista.get(6);
                }
            }
        }

        btnVolver = (Button) findViewById(R.id.btnVolverV);
        tvNombre = (TextView) findViewById(R.id.tvNombreV);
        tvEmail = (TextView) findViewById(R.id.tvEmailV);
        tvFecha = (TextView) findViewById(R.id.tvFechaV);
        tvReco = (TextView) findViewById(R.id.tvCheck);
        tvProgress = (TextView) findViewById(R.id.tvProgress);
        tvRadio = (TextView) findViewById(R.id.tvRadio);
        tvSwitch = (TextView) findViewById(R.id.tvSwitch);

        btnVolver.setOnClickListener(this);

        tvNombre.setText(tvNombre.getText().toString() + " " + nombre);
        tvFecha.setText(tvFecha.getText().toString() + " " + fecha);
        tvEmail.setText(tvEmail.getText().toString() + " " + email);
        tvReco.setText(tvReco.getText().toString() + " " + reco);
        tvProgress.setText(tvProgress.getText().toString() + " " + progress);
        tvRadio.setText(tvRadio.getText().toString() + " " + radio);
        tvSwitch.setText(tvSwitch.getText().toString() + " " + spinner);

    }

    @Override
    public void onClick(View v) {

        Intent inte;

        if(getIntent() != null){
            inte = new Intent(VerActivity.this, MainActivity.class);
            Intent intent = getIntent();
            lista = intent.getStringArrayListExtra("lista");
            if(lista != null){
                inte.putStringArrayListExtra("lista", lista);
                Log.i("AL", "Transportando lista a otro activity.");
            }
        }else{
            inte = new Intent(VerActivity.this, MainActivity.class);
        }

        startActivity(inte);

    }
}