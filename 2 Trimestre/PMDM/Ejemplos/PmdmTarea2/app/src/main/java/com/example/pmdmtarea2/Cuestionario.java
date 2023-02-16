package com.example.pmdmtarea2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import androidx.fragment.app.FragmentTransaction;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import fragments.*;




public class Cuestionario extends AppCompatActivity implements View.OnClickListener {
    private static Fragment[] fragments = guardarFragmentos();

    private ToolbarController toolbar;
    private Button botonSiguiente;
    private Bundle datos;
    private int indiceFragmento;
    private String[] respuestas;
    private ProgressBar progressBar;
    private double progresoActual;

    // crea un array Fragment con los fragment de las 8 preguntas
    private static Fragment[] guardarFragmentos(){
        Fragment[] fragments = new Fragment[8];

        fragments[0] = new Pregunta1();
        fragments[1] = new Pregunta2();
        fragments[2] = new Pregunta3();
        fragments[3] = new Pregunta4();
        fragments[4] = new Pregunta5();
        fragments[5] = new Pregunta6();
        fragments[6] = new Pregunta7();
        fragments[7] = new Pregunta8();

        return fragments;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cuestionario);

        FragmentTransaction fragmentTransaction;
        /* comprueba que savedInstanceState no sea null y contenga el indice actual, si es true obtiene el indice si no le da valor 0.
           de esa forma se recupera los valores si se cambia la orientacion de la pantalla */
        indiceFragmento = (savedInstanceState != null && savedInstanceState.containsKey("indiceActual"))?savedInstanceState.getInt("indiceActual"):0;
        /* comprueba que savedInstanceState no sea null y contenga las respuestas, si es true obtiene las respuestas si no inicializa un nuevo array String.
           de esa forma se recupera los valores si se cambia la orientacion de la pantalla */
        respuestas = (savedInstanceState != null && savedInstanceState.containsKey("respuestas"))?savedInstanceState.getStringArray("respuestas"):new String[8];
        /* comprueba que savedInstanceState no sea null y contenga el progreso actual, si es true obtiene el progreso si no le da valor 0.
           de esa forma se recupera los valores si se cambia la orientacion de la pantalla */
        progresoActual = (savedInstanceState != null && savedInstanceState.containsKey("progresoActual"))?savedInstanceState.getDouble("progresoActual"):0.0;
        // creamos la toolbar de la activity
        toolbar = new ToolbarController(this);
        // guardamos la barra de progreso
        progressBar = findViewById(R.id.progreso);
        // guardamos el boton siguiente
        botonSiguiente = findViewById(R.id.buttonSiguiente);
        // le anadimos un OnClickListener
        botonSiguiente.setOnClickListener(this);
        // obtenemos el Bundle de la activity anterior
        datos = getIntent().getExtras();
        // anadimos el primer fragmento usando un objeto FragmentTransaction
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.fragmentViewer,fragments[indiceFragmento++]);
        fragmentTransaction.commit();

    }
    @Override
    protected void onSaveInstanceState (Bundle outState) {
        // guardamos el progreso actual si se cambia la orientacion de la pantalla
        outState.putStringArray("respuestas",respuestas);
        outState.putInt("indiceActual",indiceFragmento-1);
        outState.putDouble("progresoActual",progresoActual);
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onClick(View view) {
        FragmentTransaction fragmentTransaction;
        // guardamos el fragmento actual
        FragmentController fragmentoActual = (FragmentController)fragments[indiceFragmento-1];
        // comprobamos que el fragmento actual tenga un opcion selecionada
        if(fragmentoActual.checkSelected()){
            // obtenemos la opcion selecionada en el fragmento
            respuestas[indiceFragmento-1] = fragmentoActual.getSelected();
            // si no es el ultimo fragmento
            if(indiceFragmento<fragments.length){
                // cambiamos al siguiente fragmento con un objeto fragmentTransaction
                fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragmentViewer,fragments[indiceFragmento++]);
                fragmentTransaction.commit();
                // actualizamos la barra de progreso
                progressBar();
                // si es el ultimo fragmento cambiamos el texto del boton a finalizar
                if(indiceFragmento==fragments.length)
                    botonSiguiente.setText(getResources().getString(R.string.finish));
            // si es el ultimo
            }else{
                // creamos un nuevo intent para cambiar a la clase confirmacion
                Intent confirmacion = new Intent(this,Confirmacion.class);
                // anadimos el array String con las respuestas al Bundle datos
                datos.putStringArray("respuestasPreguntas",respuestas);
                // anadimos el Bundle al intent
                confirmacion.putExtras(datos);
                // empezamos la nueva activity
                startActivity(confirmacion);
            }
        // si el fragmento no tiene ninguna opcion selecionada mostramos error
        }else{
            fragmentoActual.setError();
        }
    }
    // actualiza la barra de progreso
    private void progressBar(){
        double sumaProgreso = 100.0/7.0;
        int siguienteNumero = (int)(progresoActual+sumaProgreso);
        // crea un objeto ObjectAnimator para la barra con el progreso actual y el siguiente numero
        ObjectAnimator progressAnimator = ObjectAnimator.ofInt(progressBar,"progress",(int)progresoActual,siguienteNumero);
        // empieza la animacion
        progressAnimator.start();
        // guarda el nuevo progreso actual
        progresoActual+=sumaProgreso;
    }

}