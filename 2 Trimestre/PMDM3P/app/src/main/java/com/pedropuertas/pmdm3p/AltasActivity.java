package com.pedropuertas.pmdm3p;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
        botonVolver = (Button) findViewById(R.id.btnCancelar);
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

                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                boolean valido = true;

                if(nombre.equalsIgnoreCase("")){
                    Toast.makeText(AltasActivity.this, "Escriba un nombre", Toast.LENGTH_SHORT).show();
                    valido = false;
                    Log.w("NOM", "No se ha introducido un nombre en el formulario");
                }

                if(!email.contains("@")){
                    Toast.makeText(AltasActivity.this, "Escriba un email válido", Toast.LENGTH_SHORT).show();
                    valido = false;
                    Log.w("EMA", "No se ha introducido un email válido en el formulario");
                }

                try{
                    sdf.parse(fecha);
                }catch (ParseException e){
                    valido = false;
                    Toast.makeText(AltasActivity.this, "Indique una fecha válida", Toast.LENGTH_SHORT).show();
                    Log.w("NOM", "No se ha introducido una fecha válida en el formulario");

                }

                if (valido) {
                    if(getIntent() != null){
                        Intent intent = getIntent();
                        lista = intent.getStringArrayListExtra("lista");

                        if(lista != null){
                            lista.set(0, nombre);
                            lista.set(1, email);
                            lista.set(2, fecha);

                            inte = new Intent(AltasActivity.this, MainActivity.class);
                            inte.putStringArrayListExtra("lista", lista);
                        }else{
                            lista = new ArrayList<String>();

                            lista.add(nombre);
                            lista.add(email);
                            lista.add(fecha);
                            lista.add("");
                            lista.add("");
                            lista.add("");
                            lista.add("");

                            inte = new Intent(AltasActivity.this, MainActivity.class);

                            inte.putStringArrayListExtra("lista", lista);
                            Log.i("AL", "Transportando lista a otro activity.");
                        }

                        startActivity(inte);
                    }else{

                        lista = new ArrayList<String>();

                        lista.add(nombre);
                        lista.add(email);
                        lista.add(fecha);
                        lista.add("");
                        lista.add("");
                        lista.add("");
                        lista.add("");

                        inte = new Intent(AltasActivity.this, MainActivity.class);

                        inte.putStringArrayListExtra("lista", lista);
                        Log.i("AL", "Transportando lista a otro activity.");

                        startActivity(inte);
                    }
                }else{
                    Log.e("CON", "No se han cumplido las condiciones para guardar la información");
                }
            }
        });

        botonVolver.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {

        Intent inte;

        if(v.getId() == R.id.btnCancelar){
            if(getIntent() != null){
                inte = new Intent(AltasActivity.this, MainActivity.class);
                Intent intent = getIntent();
                lista = intent.getStringArrayListExtra("lista");
                if(lista != null){
                    inte.putStringArrayListExtra("lista", lista);
                    Log.i("AL", "Transportando lista a otro activity.");
                }
            }else{
                inte = new Intent(AltasActivity.this, MainActivity.class);
            }

            startActivity(inte);
        }

    }
}