package com.example.pmdmtarea2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Acerca extends AppCompatActivity implements View.OnClickListener {
    private Button botonVolver;
    private ToolbarController toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acerca);
        // guardamos el boton volver de la activity acerca
        botonVolver = findViewById(R.id.botonVolver);
        // le anadimos un OnClickListener
        botonVolver.setOnClickListener(this);
        // creamos la toolbar de la activity sin menu
        toolbar = new ToolbarController(this, ToolbarController.Visibilidad.INVISIBLE);
    }

    // sobrescribimos el metodo onClick para que finalize la actividad cuando pulsamos en el boton volver
    @Override
    public void onClick(View view) {
        finish();
    }
}