package com.pedropuertas.pmdm3p;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class VerActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnVolver;
    private TextView tvNombre;
    private TextView tvEmail;
    private TextView tvFecha;
    private  TextView tvReco;
    private ArrayList<String> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver);

        String nombre = "";
        String fecha = "";
        String email = "";
        String reco = "";

        if(getIntent() != null){
            Intent intent = getIntent();
            lista = intent.getStringArrayListExtra("arraylist");

            nombre = lista.get(0);
            fecha = lista.get(1);
            email = lista.get(2);
            reco = lista.get(3);
        }

        btnVolver = (Button) findViewById(R.id.btnVolverV);
        tvNombre = (TextView) findViewById(R.id.tvNombreV);
        tvEmail = (TextView) findViewById(R.id.tvEmailV);
        tvFecha = (TextView) findViewById(R.id.tvFechaV);
        tvReco = (TextView) findViewById(R.id.tvReco);

        btnVolver.setOnClickListener(this);

        tvNombre.setText("Nombre: " + nombre);
        tvFecha.setText("Fecha: " + fecha);
        tvEmail.setText("Email: " + email);
        tvReco.setText("Recomendo: " + reco);

    }

    @Override
    public void onClick(View v) {

        Intent inte;

        if(v.getId() == R.id.btnVolverV){
            if(getIntent() != null){
                inte = new Intent(VerActivity.this, MainActivity.class);

                inte.putExtra("arraylist", lista);


            }else{
                inte = new Intent(this, MainActivity.class);
            }

            startActivity(inte);
        }else{

        }

    }
}