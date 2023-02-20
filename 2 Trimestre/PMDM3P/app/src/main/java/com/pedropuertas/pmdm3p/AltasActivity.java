package com.pedropuertas.pmdm3p;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AltasActivity extends AppCompatActivity implements View.OnClickListener {

    private Button botonVolver;
    private Button botonAceptar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_altas);

        botonAceptar = findViewById(R.id.btnAceptar);
        botonVolver = findViewById(R.id.btnVolver);

        botonAceptar.setOnClickListener(this);
        botonVolver.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {

        Intent inte;

        if(v.getId() == R.id.btnVolver){
            inte = new Intent(this, MainActivity.class);
            startActivity(inte);
        }else{

        }

    }
}