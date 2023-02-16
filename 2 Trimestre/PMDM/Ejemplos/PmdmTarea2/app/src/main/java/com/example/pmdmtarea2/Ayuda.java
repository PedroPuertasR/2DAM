package com.example.pmdmtarea2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Ayuda extends AppCompatActivity implements View.OnClickListener {
    private ToolbarController toolbar;
    private Button botonVolver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ayuda);
        // creamos la toolbar de la activity sin menu
        toolbar = new ToolbarController(this, ToolbarController.Visibilidad.INVISIBLE);
        // guardamos el boton volver de la activity ayuda
        botonVolver = findViewById(R.id.botonVolverAyuda);
        // le anadimos un OnClickListener
        botonVolver.setOnClickListener(this);
    }
    // sobrescribimos el metodo onClick para que finalize la actividad cuando pulsamos en el boton volver
    @Override
    public void onClick(View view) {
        finish();
    }
}