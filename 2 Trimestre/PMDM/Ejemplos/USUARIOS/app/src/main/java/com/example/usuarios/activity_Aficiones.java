package com.example.usuarios;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class activity_Aficiones extends AppCompatActivity {

    CheckBox c1, c2,c3,c4,c5;

    private List<String> aficionesSeleccionadas = new ArrayList<>();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aficiones);

        c1 = (CheckBox) findViewById(R.id.c1);
        c2 = (CheckBox) findViewById(R.id.c2);
        c3 = (CheckBox) findViewById(R.id.c3);
        c4 = (CheckBox) findViewById(R.id.c4);
        c5 = (CheckBox) findViewById(R.id.c5);

        Button botonGuardar = findViewById(R.id.btnGuardarAficiones);
        botonGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // obtener los valores seleccionados y agregarlos a la lista
                aficionesSeleccionadas.clear();
                if (c1.isChecked()) {
                    aficionesSeleccionadas.add(c1.getText().toString());
                }
                if (c2.isChecked()) {
                    aficionesSeleccionadas.add(c2.getText().toString());
                }
                if (c3.isChecked()) {
                    aficionesSeleccionadas.add(c3.getText().toString());
                }
                if (c4.isChecked()) {
                    aficionesSeleccionadas.add(c4.getText().toString());
                }
                if (c5.isChecked()) {
                    aficionesSeleccionadas.add(c5.getText().toString());
                }

                Intent intent = new Intent(activity_Aficiones.this, activity_VerDatos.class);
                intent.putStringArrayListExtra("aficionesSeleccionadas", new ArrayList<>(aficionesSeleccionadas));
                startActivity(intent);
            }
        });

    }

    public void volver(View view) {
        Intent intent = new Intent(activity_Aficiones.this, MainActivity.class);
        startActivity(intent);
    }
}



