package com.pedropuertas.pmdm3p;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button botonAlta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botonAlta = findViewById(R.id.btnAlta);
        // le anadimos un OnClickListener
        botonAlta.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        Intent altas = new Intent(this,AltasActivity.class);
        startActivity(altas);

    }
}