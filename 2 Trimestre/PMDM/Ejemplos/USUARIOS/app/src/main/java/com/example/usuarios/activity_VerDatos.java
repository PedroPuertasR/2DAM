package com.example.usuarios;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import java.util.List;

public class activity_VerDatos extends AppCompatActivity {
    TextView textView1;
    TextView textView2;
    TextView textView3;
    TextView textViewValoracion;

    private TextView textAficiones;
    private TextView textRecomendacion;
    private TextView textValoracion;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_datos);

        // Obtener los datos enviados desde activity1
        String texto1 = getIntent().getStringExtra("texto1");
        String texto2 = getIntent().getStringExtra("texto2");
        String texto3 = getIntent().getStringExtra("texto3");

        textView1 = (TextView) findViewById(R.id.txtnombre);
        textView2 = (TextView)findViewById(R.id.txtfecha);
        textView3 = (TextView) findViewById(R.id.txtemail);


        textView1.setText(texto1);
        textView2.setText(texto2);
        textView3.setText(texto3);

        ////////////////////////////////////////////////////////////////

        textViewValoracion = (TextView) findViewById(R.id.textValoracion);

        // Obtener el valor del Intent
        Intent intent = getIntent();
        String selectedItem = intent.getStringExtra("selectedItem");

        // Establecer el valor en el TextView
        textViewValoracion.setText(selectedItem);

        ////////////////////////////////////////////////////////////////

        textAficiones = findViewById(R.id.textAficiones);
        List<String> aficionesSeleccionadas = getIntent().getStringArrayListExtra("aficionesSeleccionadas");

        if (aficionesSeleccionadas != null && !aficionesSeleccionadas.isEmpty()) {
            textAficiones.setText(TextUtils.join(", ", aficionesSeleccionadas));
        } else {
            textAficiones.setText("No se han seleccionado aficiones");
        }

        ///////////////////////////////////////////////////////////////////

        textRecomendacion = findViewById(R.id.textRecomendacion);
        String seleccion = getIntent().getStringExtra("seleccion");

        if (seleccion != null && !seleccion.isEmpty()) {
            textRecomendacion.setText(seleccion);
        } else {
            textRecomendacion.setText("No se ha seleccionado ninguna opción");
        }

        ///////////////////////////////////////////////////////////////


    }

    public void volver (View view){
        Intent intent= new Intent (activity_VerDatos.this, MainActivity.class);
        startActivity(intent);
    }

}