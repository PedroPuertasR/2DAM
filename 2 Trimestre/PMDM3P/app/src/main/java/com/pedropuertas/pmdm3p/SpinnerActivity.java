package com.pedropuertas.pmdm3p;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SpinnerActivity extends AppCompatActivity implements View.OnClickListener {

    private Button botonVolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        botonVolver = findViewById(R.id.btnVolverS);

        botonVolver.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        Intent inte;

        if(v.getId() == R.id.btnVolverS){
            inte = new Intent(this, MainActivity.class);
            startActivity(inte);
        }else {

        }

    }
}