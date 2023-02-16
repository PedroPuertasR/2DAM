package com.example.pmdmtarea2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class Datos extends AppCompatActivity implements View.OnClickListener {

    private Spinner listaProvincia;
    private ToolbarController toolbar;
    private Button botonContinuar;
    private EditText edad;
    private RadioGroup grupoBotones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.datos);

        ArrayAdapter<String> adapter;
        String[] provincias;

        // creamos la toolbar de la activity
        toolbar = new ToolbarController(this);
        //guardamos el boton de continuar
        botonContinuar = findViewById(R.id.botonDatos);
        // le anadimos un OnClickListener
        botonContinuar.setOnClickListener(this);
        // guardamos el EditText de la edad
        edad = findViewById(R.id.edadInput);
        // guardamos el RadioGroup de los generos
        grupoBotones = findViewById(R.id.botones_genero);
        // guardamos el Spinner de las provincias
        listaProvincia = findViewById(R.id.listaProvincias);
        // obtenemos el array String con las provincias
        provincias = getResources().getStringArray(R.array.provincias);
        // creamos el ArrayAdapter para el spinner
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,provincias);
        // le anadimos el adapter al spinner
        listaProvincia.setAdapter(adapter);


    }
    // sobrescribimos el metodo para anadir funcionalidad al boton continuar
    @Override
    public void onClick(View view) {
        Intent cuestionario;
        Bundle datos;
        // si edad esta vacio mostramos un error
        if(TextUtils.isEmpty(edad.getText())){
            edad.setError(getResources().getString(R.string.error_sin_texto));
        // si no hay ningun genero elegido mostramos un error
        }else if(grupoBotones.getCheckedRadioButtonId() == -1){
            ((RadioButton)grupoBotones.getChildAt(grupoBotones.getChildCount()-1)).setError(getResources().getString(R.string.error_radio_button_no_seleccionado));
        // si todos los datos estan correctos
        }else{
            // creamos un nuevo Bundle
            datos = new Bundle();
            // anadimos la edad al bundle
            datos.putInt("edad",Integer.parseInt(edad.getText().toString()));
            // anadimos el genero al bundle
            datos.putString("genero",((RadioButton)findViewById(grupoBotones.getCheckedRadioButtonId())).getText().toString());
            // anadimos la provincia al bundle
            datos.putString("provincia",listaProvincia.getSelectedItem().toString());
            // creamos un nuevo intent para cambiar a la clase cuestionario
            cuestionario = new Intent(this,Cuestionario.class);
            // anadimos el Bundle al intent
            cuestionario.putExtras(datos);
            // empezamos la nueva activity
            startActivity(cuestionario);
        }
    }
}