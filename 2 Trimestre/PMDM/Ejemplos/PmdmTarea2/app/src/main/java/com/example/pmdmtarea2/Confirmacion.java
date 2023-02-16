package com.example.pmdmtarea2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Confirmacion extends AppCompatActivity implements View.OnClickListener {
    private ToolbarController toolbar;
    private TextView[] textosRespuestas;
    private TextView edadResultado,provinciaResultado,generoResultado;
    private Bundle datos;
    private Button botonVolver,botonFinalizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.confirmacion);

        // creamos la toolbar de la activity
        toolbar = new ToolbarController(this);
        // obtenemos el Bundle de la activity anterior
        datos = getIntent().getExtras();
        // obtenemos todos los textView de las respuestas y los guardamos en el array
        textosRespuestas = getTextViewRespuestas();
        // guardamos el textView de edad
        edadResultado = findViewById(R.id.edadResultado);
        // guardamos el textView de provincia
        provinciaResultado = findViewById(R.id.provinciaResultado);
        // guardamos el textView de genero
        generoResultado = findViewById(R.id.generoResultado);
        // guardamos el boton volver de la activity
        botonVolver = findViewById(R.id.botonVolverConfirm);
        // guardamos el boton finalizar de la activity
        botonFinalizar = findViewById(R.id.botonFinalizar);
        // le anadimos un OnClickListener al boton volver
        botonVolver.setOnClickListener(this);
        // le anadimos un OnClickListener al boton finalizar
        botonFinalizar.setOnClickListener(this);
        // metemos los datos personales
        setResultadosDatos();
        // metemos las respuestas de las preguntas
        setRespuestas();
    }
    // coloca los datos personales en su textView
    private void setResultadosDatos(){
        // cambia el valor del textView de la edad al valor en el Bundle
        edadResultado.setText(String.valueOf(datos.getInt("edad")));
        // cambia el valor del textView del genero al valor en el Bundle
        generoResultado.setText(datos.getString("genero"));
        // cambia el valor del textView de la provincia al valor en el Bundle
        provinciaResultado.setText(datos.getString("provincia"));
    }
    // coloca las respuestas de las preguntas en su textView
    private void setRespuestas(){
        // array String con las respuestas
        String[] respuestas = datos.getStringArray("respuestasPreguntas");
        // recorremos el array de TextView
        for(int i=0;i<textosRespuestas.length;i++){
            // si es el 4 textView hacemos join al array de String obtenido de la repuesta con split con el caracter #
            if(i==3){
                textosRespuestas[i].setText(String.join(",",respuestas[i].split("#")));
            }else{
                // anadimos la respuesta a su textView
                textosRespuestas[i].setText(respuestas[i]);
            }
        }
    }
    // obtiene el array de TextView de las respuestas
    private TextView[] getTextViewRespuestas(){
        // obtenemos los  recursos de los TextView de las respuestas
        TypedArray typedArray = getResources().obtainTypedArray(R.array.respuestasConfirmacion);
        // creamos un array de TextView
        TextView[] respuestas = new TextView[typedArray.length()];
        // guardamos los TextView en el array
        for(int i=0; i<typedArray.length(); i++){
            respuestas[i] = findViewById(typedArray.getResourceId(i,0));
        }
        // limpiamos el typedArray
        typedArray.recycle();
        // devolvemos el array de TextView
        return respuestas;
    }

    @Override
    public void onClick(View view) {
        // si es boton clicado es el botonVolver
        if(view.getId() == botonVolver.getId()){
            // creamos un nuevo intent para cambiar a la clase Bienvenida
            Intent startAgain = new Intent(this,Bienvenida.class);
            // anadimos la flag FLAG_ACTIVITY_CLEAR_TOP para cerrar todas las actividades anteriores
            startAgain.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            // empezamos la nueva activity
            startActivity(startAgain);
        // si el boton clicado es el boton finalizar cerramos la app
        }else{
            this.finishAffinity();
        }
    }
}