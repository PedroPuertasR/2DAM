package com.pedropuertas.pmdm3p;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class AltasActivity extends AppCompatActivity implements View.OnClickListener {

    private Button botonVolver;
    private Button botonAceptar;

    private EditText etNombre;
    private EditText etFecha;
    private EditText etEmail;

    private ArrayList<String> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_altas);

        botonAceptar = (Button) findViewById(R.id.btnAceptar);
        botonVolver = (Button) findViewById(R.id.btnVolver);
        etNombre = (EditText) findViewById(R.id.etNombre);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etFecha = (EditText) findViewById(R.id.etFecha);

        botonAceptar.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                String nombre = etNombre.getText().toString();
                String email = etEmail.getText().toString();
                String fecha = etFecha.getText().toString();

                Intent inte;

                if(getIntent() != null){
                    Intent intent = getIntent();
                    lista = intent.getStringArrayListExtra("arraylist");

                    lista.set(0, nombre);
                    lista.set(1, email);
                    lista.set(2, fecha);

                    inte = new Intent(AltasActivity.this, MainActivity.class);

                    inte.putExtra("arraylist", lista);

                    startActivity(inte);
                }else{

                    lista = new ArrayList<String>();

                    lista.add(0, nombre);
                    lista.add(1, email);
                    lista.add(2, fecha);

                    inte = new Intent(AltasActivity.this, MainActivity.class);

                    inte.putExtra("arraylist", lista);

                    startActivity(inte);
                }
            }
        });

        botonVolver.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {

        Intent inte;

        if(v.getId() == R.id.btnVolver){
            inte = new Intent(this, MainActivity.class);
            startActivity(inte);
        }

    }
}