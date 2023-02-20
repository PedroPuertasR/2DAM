package com.pedropuertas.pmdm3p;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button botonAlta;
    private Button botonSalir;
    private Button botonVer;
    private Button botonSpinner;
    private Button botonCheck;
    private Button botonRadio;
    private Button botonProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botonAlta = findViewById(R.id.btnAlta);
        botonSalir = findViewById(R.id.btnSalir);
        botonVer = findViewById(R.id.btnVer);
        botonSpinner = findViewById(R.id.btnSpinner);
        botonProgress = findViewById(R.id.btnProgress);
        botonCheck = findViewById(R.id.btnCheck);
        botonRadio = findViewById(R.id.btnRadio);

        botonAlta.setOnClickListener(this);
        botonSalir.setOnClickListener(this);
        botonVer.setOnClickListener(this);
        botonCheck.setOnClickListener(this);
        botonProgress.setOnClickListener(this);
        botonRadio.setOnClickListener(this);
        botonSpinner.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        Intent inte;

        if (view.getId() == R.id.btnAlta){
            inte = new Intent(this,AltasActivity.class);
            startActivity(inte);
        }else if(view.getId() == R.id.btnVer){
            inte = new Intent(this,VerActivity.class);
            startActivity(inte);
        }else if(view.getId() == R.id.btnCheck){
            inte = new Intent(this,CheckActivity.class);
            startActivity(inte);
        }else if(view.getId() == R.id.btnRadio){
            inte = new Intent(this,RadioActivity.class);
            startActivity(inte);
        }else if(view.getId() == R.id.btnSpinner){
            inte = new Intent(this,SpinnerActivity.class);
            startActivity(inte);
        }else if(view.getId() == R.id.btnProgress){
            inte = new Intent(this,ProgressActivity.class);
            startActivity(inte);
        }
        else{
            finish();
        }

    }
}