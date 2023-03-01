package com.example.pmdm_final;

import androidx.fragment.app.FragmentActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

public class Activity_Principal extends FragmentActivity implements Fragment_Lista.Callbacks {

    private boolean dosFragmentos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_activity_principal_listado);

        //Se comprueba que exista el framelayout framelayout_contenedor_entrada. Si existe estaremos usando activity_dospaneles.xml, sino estaremos usando activity_listado.xml
        if (findViewById(R.id.framelayout_contenedor_detalle) != null) {
            // Entra aqu� solo en dise�os para pantallas grandes (es decir, si usamos res/values-large o res/values-sw600dp). Estaremos usando activity_dospaneles.xml
            dosFragmentos = true;
        }
    }

    @Override
    public void onEntradaSelecionada(String id) {
        if (dosFragmentos) {
            Bundle arguments = new Bundle();
            arguments.putString(Fragment_Detalle.ARG_ID_ENTRADA_SELECIONADA, id);
            Fragment_Detalle fragment = new Fragment_Detalle();
            fragment.setArguments(arguments);
            getSupportFragmentManager().beginTransaction().replace(R.id.framelayout_contenedor_detalle, fragment).commit();

        } else {
            Intent detailIntent = new Intent(this, Activity_Detalle.class);
            detailIntent.putExtra(Fragment_Detalle.ARG_ID_ENTRADA_SELECIONADA, id);
            startActivity(detailIntent);
        }
    }
}