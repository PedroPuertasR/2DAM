package com.example.pmdmtarea2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class Bienvenida extends AppCompatActivity implements OnClickListener{
    private ToolbarController toolbar;
    private Button botonEmpezar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bienvenida);
        // creamos la toolbar de la activity
        toolbar = new ToolbarController(this);
        // guardamos el boton empezar de la activity bienvenida
        botonEmpezar = findViewById(R.id.botonStart);
        // le anadimos un OnClickListener
        botonEmpezar.setOnClickListener(this);

    }
    // sobrescribimos el metodo para anadir funcionalidad al boton empezar
    @Override
    public void onClick(View view) {
        // creamos un nuevo objeto intent para cambiar a la clase datos
        Intent datos = new Intent(this,Datos.class);
        // empezamos la nueva activity
        startActivity(datos);
    }


}