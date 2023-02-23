package com.pedropuertas.pmdm3p;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class ProgressActivity extends AppCompatActivity implements View.OnClickListener {

    private Button botonVolver;
    private Button botonGuardar;
    private ProgressBar pgBarra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);

        String completado = "";

        botonVolver = (Button) findViewById(R.id.btnVolverP);
        botonGuardar = (Button) findViewById(R.id.btnGuardar);
        pgBarra = (ProgressBar) findViewById(R.id.pbBarra);

        botonVolver.setOnClickListener(this);
        botonGuardar.setOnClickListener(this);

        if(pgBarra.getProgress() == 100){
            completado = "Sí";
        }else{
            completado = "No";
        }
    }

    @Override
    public void onClick(View v) {

        Intent inte;

        if(v.getId() == R.id.btnVolverP){
            inte = new Intent(this, MainActivity.class);
            startActivity(inte);
        }else{

        }

    }
}