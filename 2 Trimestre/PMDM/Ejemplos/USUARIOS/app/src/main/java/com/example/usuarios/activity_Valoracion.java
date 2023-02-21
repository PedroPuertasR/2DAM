package com.example.usuarios;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class activity_Valoracion extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    Spinner spinner;
    private Button btnEnviar;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_valoracion);

        spinner = (Spinner) findViewById(R.id.spinner);
        btnEnviar = (Button) findViewById(R.id.btnGuardarValoracion);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.opciones, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String selectedItem = spinner.getSelectedItem().toString();
                Intent intent = new Intent(activity_Valoracion.this, activity_VerDatos.class);
                intent.putExtra("selectedItem", selectedItem);
                startActivity(intent);
            }
        });



    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        // Manejar la selección del usuario
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        // No se ha seleccionado nada
    }


    public void volver (View  view){
        Intent intent= new Intent (activity_Valoracion.this, MainActivity.class);
        startActivity(intent);
    }
}