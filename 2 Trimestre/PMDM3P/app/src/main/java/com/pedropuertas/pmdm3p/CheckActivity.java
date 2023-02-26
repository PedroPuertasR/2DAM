package com.pedropuertas.pmdm3p;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import java.util.ArrayList;
import java.util.HashMap;

public class CheckActivity extends AppCompatActivity implements View.OnClickListener {

    private Button botonAceptar;
    private Button botonVolver;
    private CheckBox cbReco;
    private ArrayList <String> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check);

        cbReco = findViewById(R.id.cbReco);
        botonAceptar = findViewById(R.id.btnAceptarC);
        botonVolver = findViewById(R.id.btnVolverC);

        botonAceptar.setOnClickListener(this);
        botonVolver.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String check;
        Intent inte;

        if(v.getId() == R.id.btnAceptarC){

            if(cbReco.isChecked()){
                check = "Sí";
            }else{
                check = "No";
            }

            if(getIntent() != null){
                Intent intent = getIntent();
                lista = intent.getStringArrayListExtra("lista");

                if(lista != null){
                    lista.set(3, check);

                    inte = new Intent(CheckActivity.this, MainActivity.class);
                    inte.putStringArrayListExtra("lista", lista);
                    Log.i("AL", "Transportando lista a otro activity.");
                }else{
                    lista = new ArrayList<String>();

                    lista.add("");
                    lista.add("");
                    lista.add("");
                    lista.add(check);
                    lista.add("");
                    lista.add("");
                    lista.add("");

                    inte = new Intent(CheckActivity.this, MainActivity.class);

                    inte.putStringArrayListExtra("lista", lista);
                    Log.i("AL", "Transportando lista a otro activity.");
                }

                startActivity(inte);
            }else{

                lista = new ArrayList<String>();

                lista.add("");
                lista.add("");
                lista.add("");
                lista.add(check);
                lista.add("");
                lista.add("");
                lista.add("");

                inte = new Intent(CheckActivity.this, MainActivity.class);

                inte.putStringArrayListExtra("lista", lista);
                Log.i("AL", "Transportando lista a otro activity.");

                startActivity(inte);
            }

        }else{
            if(getIntent() != null){
                inte = new Intent(CheckActivity.this, MainActivity.class);
                Intent intent = getIntent();
                lista = intent.getStringArrayListExtra("lista");
                if(lista != null){
                    inte.putStringArrayListExtra("lista", lista);
                    Log.i("AL", "Transportando lista a otro activity.");
                }
            }else{
                inte = new Intent(CheckActivity.this, MainActivity.class);
            }

            startActivity(inte);
        }
    }
}